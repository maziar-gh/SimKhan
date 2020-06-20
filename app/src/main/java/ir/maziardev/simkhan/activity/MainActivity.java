package ir.maziardev.simkhan.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import com.itparsa.circlenavigation.CircleItem;
import com.itparsa.circlenavigation.CircleNavigationView;
import com.itparsa.circlenavigation.CircleOnClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.maziardev.simkhan.Base;
import ir.maziardev.simkhan.R;
import ir.maziardev.simkhan.adapter.SimCardAdapter;
import ir.maziardev.simkhan.classes.SavePref;
import ir.maziardev.simkhan.model.DataRegister;
import ir.maziardev.simkhan.model.DataResponse;
import ir.maziardev.simkhan.model.DataToken;
import ir.maziardev.simkhan.model.SimCardListRows;
import ir.maziardev.simkhan.network.APIService;
import ir.maziardev.simkhan.network.APIUtils;
import ir.maziardev.simkhan.network.LoadData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    APIService apiService;
    private SimCardAdapter mAdapter;
    private List<SimCardListRows> simCardListRows;
    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 5;
    int firstVisibleItem, visibleItemCount, totalItemCount;

    @BindView(R.id.bottomnavigation_main)
    CircleNavigationView mCircleNavigationView;
    @BindView(R.id.recycler_main)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressBar_main)
    ProgressBar mProgressBar;

    @BindView(R.id.const_setting)
    ConstraintLayout const_setting;
    @BindView(R.id.const_profile)
    ConstraintLayout const_profile;
    @BindView(R.id.const_login)
    ConstraintLayout const_login;
    @BindView(R.id.const_register)
    ConstraintLayout const_register;
    @BindView(R.id.linear_main)
    LinearLayout linear_main;
    @BindView(R.id.frame_main)
    FrameLayout frame_main;

    @BindView(R.id.btn_reg)
    Button btn_reg;
    @BindView(R.id.edt_phone_reg)
    EditText edt_phone_reg;

    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.edt_phone_login)
    EditText edt_phone_login;
    @BindView(R.id.edt_pass_login)
    EditText edt_pass_login;
    @BindView(R.id.tv_reset_login)
    TextView tv_reset_login;
    @BindView(R.id.tv_reg_shop)
    TextView tv_reg_shop;

    SavePref save;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        save = new SavePref(this);
        bundle = savedInstanceState;
        isProfile(savedInstanceState);


        mAdapter = new SimCardAdapter(this, LoadData.simCardListRows);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mAdapter.notifyDataSetChanged();
        //mRecyclerView.invalidate();


        LinearLayoutManager mLayoutManager;
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = mRecyclerView.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();

                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if (!loading && (totalItemCount - visibleItemCount)
                        <= (firstVisibleItem + visibleThreshold)) {

                    Base.SAVE_SIMCARD_PAGE = String.valueOf(Integer.valueOf(Base.SAVE_SIMCARD_PAGE) + 1);
                    getSimData(Base.SAVE_SIMCARD_PAGE, Base.BASE_SIMCARD_LIMIT);
                    loading = true;
                }
            }
        });


        //button
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_phone_reg.getText().toString().length() < 1  || edt_phone_reg.getText().toString().length() > 11){
                    Toast.makeText(MainActivity.this, "شماره موبایل نادرست است", Toast.LENGTH_SHORT).show();
                }else if(edt_phone_reg.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "شماره موبایل خالی است", Toast.LENGTH_SHORT).show();
                }else {
                    apiService = APIUtils.getAPIService();
                    apiService.registr(edt_phone_reg.getText().toString(), "").enqueue(new Callback<DataRegister>() {
                        @Override
                        public void onResponse(Call<DataRegister> call, Response<DataRegister> response) {
                            if (response.isSuccessful()) {
                                //hideProgressView();

                                if (response.body().getMessageID().equals(0)) {
                                    save.save(Base.BASE_SAVE_LOGIN, "1");
                                    isProfile(bundle);
                                    Toast.makeText(MainActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                int statusCode = response.code();
                                Log.d(TAG, "ERROR(Response):" + statusCode);
                            }
                        }

                        @Override
                        public void onFailure(Call<DataRegister> call, Throwable t) {
                            Log.d(TAG, "ERROR(Failure):" + t.getMessage());
                        }
                    });
                }
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_phone_login.getText().toString().length() < 1  || edt_phone_login.getText().toString().length() > 11){
                    Toast.makeText(MainActivity.this, "نام کاربری یا شماره موبایل نادرست است", Toast.LENGTH_SHORT).show();
                }else if(edt_phone_login.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "نام کاربری یا شماره موبایل خالی است", Toast.LENGTH_SHORT).show();
                }else if(edt_pass_login.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "رمز عبور خالی است", Toast.LENGTH_SHORT).show();
                }else {
                    apiService = APIUtils.getAPIService();
                    apiService.token("password", edt_phone_login.getText().toString(), edt_pass_login.getText().toString())
                            .enqueue(new Callback<DataToken>() {
                                @Override
                                public void onResponse(Call<DataToken> call, Response<DataToken> response) {
                                    if (response.isSuccessful()) {
                                        save.save(Base.BASE_SAVE_LOGIN, "1");
                                        isProfile(bundle);
                                        save.save(Base.BASE_SAVE_TOKEN, response.body().getAccess_token());
                                        save.save(Base.BASE_SAVE_EXPIRES, response.body().getExpires_in());
                                        Toast.makeText(MainActivity.this, "خوش آمدید", Toast.LENGTH_SHORT).show();

                                    } else if (response.code() == 400) {
                                        Toast.makeText(MainActivity.this, "نام کاربری یا کلمه عبور اشتباه است", Toast.LENGTH_SHORT).show();
                                    } else {
                                        int statusCode = response.code();
                                        Log.d(TAG, "ERROR(Response):" + statusCode);
                                    }
                                }

                                @Override
                                public void onFailure(Call<DataToken> call, Throwable t) {
                                    Log.d(TAG, "ERROR(Failure):" + t.getMessage());
                                }
                            });
                }
            }
        });


        tv_reset_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_phone_login.getText().toString().length() < 1  && edt_phone_login.getText().toString().length() > 11){
                    Toast.makeText(MainActivity.this, "نام کاربری یا شماره موبایل نادرست است", Toast.LENGTH_SHORT).show();
                }else if(edt_phone_login.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "نام کاربری یا شماره موبایل خالی است", Toast.LENGTH_SHORT).show();
                }else {
                    apiService = APIUtils.getAPIService();
                    apiService.ResetPassword(edt_phone_login.getText().toString())
                            .enqueue(new Callback<DataRegister>() {
                                @Override
                                public void onResponse(Call<DataRegister> call, Response<DataRegister> response) {
                                    if (response.isSuccessful()) {

                                        Toast.makeText(MainActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    }else {
                                        int statusCode = response.code();
                                        Log.d(TAG, "ERROR(Response):" + statusCode);
                                    }
                                }

                                @Override
                                public void onFailure(Call<DataRegister> call, Throwable t) {
                                    Log.d(TAG, "ERROR(Failure):" + t.getMessage());
                                }
                            });
                }
            }
        });

        tv_reg_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterShopActivity.class));
            }
        });


    }

    private void isProfile(Bundle savedInstanceState) {

        String login = save.load(Base.BASE_SAVE_LOGIN, "0");
        if(login.equals("1")){

            mCircleNavigationView.requestLayout();
            mCircleNavigationView.initWithSaveInstanceState(savedInstanceState);
            mCircleNavigationView.addCircleItem(new CircleItem("پروفایل", R.drawable.ic_person));
            mCircleNavigationView.addCircleItem(new CircleItem("خانه", R.drawable.ic_home));
            mCircleNavigationView.changeCurrentItem(1);

            linear_main.setVisibility(View.VISIBLE);
            const_login.setVisibility(View.GONE);
            const_register.setVisibility(View.GONE);
            const_setting.setVisibility(View.GONE);
            const_profile.setVisibility(View.GONE);


            mCircleNavigationView.setCircleOnClickListener(new CircleOnClickListener() {
                @Override
                public void onCentreButtonClick() {
                    Toast.makeText(MainActivity.this, "add sim", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onItemClick(int itemIndex, String itemName) {

                    switch (itemIndex) {
                        case 0: //profile
                            toggleView(const_profile, true);
                            toggleView(linear_main, false);
                            break;
                        case 1: //home
                            toggleView(linear_main, true);
                            toggleView(const_profile, false);
                            break;
                    }
                }


                @Override
                public void onItemReselected(int itemIndex, String itemName) {
                    switch (itemIndex) {
                        case 0: //profile
                            toggleView(const_profile, true);
                            toggleView(linear_main, false);
                            break;
                        case 1: //home
                            toggleView(linear_main, true);
                            toggleView(const_profile, false);
                            break;
                    }
                }
            });

        }else {
            mCircleNavigationView.initWithSaveInstanceState(savedInstanceState);
            mCircleNavigationView.addCircleItem(new CircleItem("تنظیمات", R.drawable.ic_settings));
            mCircleNavigationView.addCircleItem(new CircleItem("ثبت نام", R.drawable.ic_person_add));
            mCircleNavigationView.addCircleItem(new CircleItem("ورود", R.drawable.ic_person));
            mCircleNavigationView.addCircleItem(new CircleItem("خانه", R.drawable.ic_home));
            mCircleNavigationView.changeCurrentItem(3);

            linear_main.setVisibility(View.VISIBLE);
            const_login.setVisibility(View.GONE);
            const_register.setVisibility(View.GONE);
            const_setting.setVisibility(View.GONE);
            const_profile.setVisibility(View.GONE);

            mCircleNavigationView.setCircleOnClickListener(new CircleOnClickListener() {
                @Override
                public void onCentreButtonClick() {
                    Toast.makeText(MainActivity.this, "add sim", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onItemClick(int itemIndex, String itemName) {

                    switch (itemIndex) {
                        case 0: //setting
                            toggleView(const_setting, true);
                            toggleView(const_register, false);
                            toggleView(linear_main, false);
                            toggleView(const_login, false);
                            break;
                        case 1: //register
                            toggleView(const_register, true);
                            toggleView(const_login, false);
                            toggleView(const_setting, false);
                            toggleView(linear_main, false);
                            break;
                        case 2: //login
                            toggleView(const_login, true);
                            toggleView(const_register, false);
                            toggleView(const_setting, false);
                            toggleView(linear_main, false);
                            break;
                        case 3: //home
                            toggleView(linear_main, true);
                            toggleView(const_register, false);
                            toggleView(const_setting, false);
                            toggleView(const_login, false);
                            break;

                    }
                }


                @Override
                public void onItemReselected(int itemIndex, String itemName) {
                    switch (itemIndex) {
                        case 0: //setting
                            toggleView(const_setting, true);
                            toggleView(const_register, false);
                            toggleView(linear_main, false);
                            toggleView(const_login, false);
                            break;
                        case 1: //register
                            toggleView(const_register, true);
                            toggleView(const_login, false);
                            toggleView(const_setting, false);
                            toggleView(linear_main, false);
                            break;
                        case 2: //login
                            toggleView(const_login, true);
                            toggleView(const_register, false);
                            toggleView(const_setting, false);
                            toggleView(linear_main, false);
                            break;
                        case 3: //home
                            toggleView(linear_main, true);
                            toggleView(const_register, false);
                            toggleView(const_setting, false);
                            toggleView(const_login, false);
                            break;

                    }
                }
            });
        }


    }


    private void getSimData(String page, String limit) {
        showProgressView();
        apiService = APIUtils.getAPIService();
        apiService.getResponse(Base.BASE_SIMCARD_USERNAME, Base.BASE_SIMCARD_PASSWORD, page, limit,
                "1", "2", "2",
                "0").enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.isSuccessful()) {
                    hideProgressView();

                    simCardListRows = response.body().getSimCardListRows();
                    LoadData.simCardListRows.addAll(simCardListRows);
                    mAdapter.notifyDataSetChanged();
                    //mRecyclerView.invalidate();
                } else {
                    int statusCode = response.code();
                    Log.d(TAG, "ERROR(Response):" + statusCode);
                    mAdapter.setMoreDataAvailable(false);
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.d(TAG, "ERROR(Failure):" + t.getMessage());
            }
        });
    }

    void showProgressView() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    void hideProgressView() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void toggleView(View view, boolean show) {
        Transition transition = new Slide(Gravity.BOTTOM);
        transition.setDuration(600);
        transition.addTarget(view);

        TransitionManager.beginDelayedTransition(frame_main, transition);
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
