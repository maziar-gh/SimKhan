package ir.maziardev.simkhan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataToken {

    @SerializedName("access_token")
    @Expose
    private String access_token;
    @SerializedName("token_type")
    @Expose
    private String token_type;
    @SerializedName("expires_in")
    @Expose
    private Integer expires_in;
    @SerializedName("error")
    @Expose
    private String error;

    public DataToken() {
    }

    public DataToken(String access_token, String token_type, Integer expires_in, String error) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.error = error;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
