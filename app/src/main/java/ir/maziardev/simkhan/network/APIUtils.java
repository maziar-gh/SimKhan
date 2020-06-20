package ir.maziardev.simkhan.network;

public class APIUtils {

    public static final String BASE_URL = "https://www.simkhanapi.ir/";

    public static APIService getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
