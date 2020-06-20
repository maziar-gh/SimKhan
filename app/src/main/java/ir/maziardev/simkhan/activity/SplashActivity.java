package ir.maziardev.simkhan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.maziardev.simkhan.Base;
import ir.maziardev.simkhan.R;
import ir.maziardev.simkhan.model.DataResponse;
import ir.maziardev.simkhan.model.SimCardListRows;
import ir.maziardev.simkhan.network.APIService;
import ir.maziardev.simkhan.network.APIUtils;
import ir.maziardev.simkhan.network.LoadData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    APIService apiService;

    @BindView(R.id.tv_splash_version)
    TextView tv_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String version = pInfo.versionName;
            tv_version.setText("نسخه:" + version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        getSimData("1", Base.BASE_SIMCARD_LIMIT);

    }

    private void getSimData(String page, String limit) {
        apiService = APIUtils.getAPIService();
        apiService.getResponse(Base.BASE_SIMCARD_USERNAME, Base.BASE_SIMCARD_PASSWORD, page, limit,
                "1", "2", "2",
                "0").enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.isSuccessful()) {
                    LoadData.simCardListRows = response.body().getSimCardListRows();

                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                } else {
                    int statusCode = response.code();
                    Log.d(TAG, "ERROR(Response):" + statusCode);
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.d(TAG, "ERROR(Failure):" + t.getMessage());
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
