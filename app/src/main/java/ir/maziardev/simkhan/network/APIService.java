package ir.maziardev.simkhan.network;

import java.util.List;

import ir.maziardev.simkhan.model.DataCity;
import ir.maziardev.simkhan.model.DataRegister;
import ir.maziardev.simkhan.model.DataResponse;
import ir.maziardev.simkhan.model.DataState;
import ir.maziardev.simkhan.model.DataToken;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST("api/simcard/GetSimCardListMainPage")
    Call<DataResponse> getResponse(@Field("username") String username,
                                   @Field("password") String password,
                                   @Field("PageNumber") String PageNumber,
                                   @Field("NumberOnPage") String NumberOnPage,
                                   @Field("IsOnlineSell") String IsOnlineSell,
                                   @Field("AllowReservation") String AllowReservation,
                                   @Field("StatuRounds") String StatuRounds,
                                   @Field("SortType") String SortType);

    @FormUrlEncoded
    @POST("api/users/Register")
    Call<DataRegister> registr(@Field("MobileNumber") String mobile,
                               @Field("ReferenceAgentCode") String agentcode);

    @FormUrlEncoded
    @POST("token")
    Call<DataToken> token(@Field("grant_type") String grant_type,
                          @Field("username") String username,
                          @Field("password") String password);

    @FormUrlEncoded
    @POST("api/users/ResetPassword")
    Call<DataRegister> ResetPassword(@Field("SimCardNumber") String SimCardNumber);

    @POST("api/Common/GetAllState")
    Call<List<DataState>> GetState();

    @FormUrlEncoded
    @POST("api/Common/GetAllCityByStateID")
    Call<List<DataCity>> GetCity(@Field("StateID") String StateID);

}
