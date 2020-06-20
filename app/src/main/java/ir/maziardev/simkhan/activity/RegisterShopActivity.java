package ir.maziardev.simkhan.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.maziardev.simkhan.R;
import ir.maziardev.simkhan.model.DataCity;
import ir.maziardev.simkhan.model.DataState;
import ir.maziardev.simkhan.network.APIService;
import ir.maziardev.simkhan.network.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class RegisterShopActivity extends AppCompatActivity {

    private static final String TAG = RegisterShopActivity.class.getSimpleName();

    @BindView(R.id.spinner_state)
    Spinner spinner_state;
    @BindView(R.id.spinner_city)
    Spinner spinner_city;
    @BindView(R.id.switch_referer)
    Switch switch_referer;
    @BindView(R.id.edt_refer)
    EditText edt_refer;


    APIService apiService;
    List<DataState> list_state = new ArrayList<>();
    List<DataCity> list_city = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_shop);
        ButterKnife.bind(this);

        initState();

        edt_refer.setVisibility(View.GONE);
        switch_referer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    edt_refer.setVisibility(View.VISIBLE);
                else
                    edt_refer.setVisibility(View.GONE);
            }
        });

    }

    private void initState() {
        apiService = APIUtils.getAPIService();
        apiService.GetState().enqueue(new Callback<List<DataState>>() {
            @Override
            public void onResponse(Call<List<DataState>> call, Response<List<DataState>> response) {
                if (response.isSuccessful()) {

                    list_state.addAll(response.body());

                    initListState();

                } else {
                    int statusCode = response.code();
                    Log.e(TAG, "ERROR(Response):" + statusCode);
                }
            }

            @Override
            public void onFailure(Call<List<DataState>> call, Throwable t) {
                Log.e(TAG, "ERROR(Failure):" + t.getMessage());
            }
        });



    }

    private void initListState() {
        List<String> myArraySpinner = new ArrayList<>();
        for (int i = 1; i < list_state.size(); i++) {
            myArraySpinner.add(list_state.get(i).getStateName());
        }

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(RegisterShopActivity.this, android.R.layout.simple_spinner_item, myArraySpinner);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_state.setAdapter(spinnerArrayAdapter);

        AdapterView.OnItemSelectedListener countrySelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> spinner, View container,
                                       int position, long id) {
                initCity(list_state.get(position).getStateID());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        };
        spinner_state.setOnItemSelectedListener(countrySelectedListener);


    }

    private void initCity(int idState) {
        apiService = APIUtils.getAPIService();
        apiService.GetCity(String.valueOf(idState + 1)).enqueue(new Callback<List<DataCity>>() {
            @Override
            public void onResponse(Call<List<DataCity>> call, Response<List<DataCity>> response) {
                if (response.isSuccessful()) {

                    list_city.clear();
                    list_city.addAll(response.body());

                    initListCity();

                } else {
                    int statusCode = response.code();
                    Log.e(TAG, "ERROR(Response):" + statusCode);
                }
            }

            @Override
            public void onFailure(Call<List<DataCity>> call, Throwable t) {
                Log.e(TAG, "ERROR(Failure):" + t.getMessage());
            }
        });
    }

    private void initListCity() {
        List<String> myArraySpinner = new ArrayList<>();
        for (int i = 1; i < list_city.size(); i++) {
            myArraySpinner.add(list_city.get(i).getCityName());
        }

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(RegisterShopActivity.this, android.R.layout.simple_spinner_item, myArraySpinner);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_city.setAdapter(spinnerArrayAdapter);
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
