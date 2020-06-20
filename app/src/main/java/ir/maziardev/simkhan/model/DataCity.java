package ir.maziardev.simkhan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataCity {
    @SerializedName("CityID")
    @Expose
    private Integer CityID;
    @SerializedName("CityName")
    @Expose
    private String CityName;

    public DataCity() {
    }

    public DataCity(Integer cityID, String cityName) {
        CityID = cityID;
        CityName = cityName;
    }

    public Integer getCityID() {
        return CityID;
    }

    public void setCityID(Integer cityID) {
        CityID = cityID;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }
}
