package ir.maziardev.simkhan.network;

import android.util.Log;

import java.util.List;

import ir.maziardev.simkhan.Base;
import ir.maziardev.simkhan.activity.MainActivity;
import ir.maziardev.simkhan.model.DataResponse;
import ir.maziardev.simkhan.model.SimCardListRows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadData {

    private static final String TAG = LoadData.class.getSimpleName();

    public static List<SimCardListRows> simCardListRows;
    private static APIService apiService;

    public static void getSimData(String page, String limit) {
        apiService = APIUtils.getAPIService();
        apiService.getResponse(Base.BASE_SIMCARD_USERNAME, Base.BASE_SIMCARD_PASSWORD, page, limit,
                "1", "2", "2",
                "0").enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful()) {
                    simCardListRows = response.body().getSimCardListRows();
                }else {
                    int statusCode  = response.code();
                    Log.d(TAG, "ERROR(Response):" + statusCode);
                }
            }
            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.d(TAG, "ERROR(Failure):" + t.getMessage());
            }
        });
    }
}
