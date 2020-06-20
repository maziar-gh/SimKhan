package ir.maziardev.simkhan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataState {
    @SerializedName("StateID")
    @Expose
    private Integer StateID;
    @SerializedName("StateName")
    @Expose
    private String StateName;

    public DataState() {
    }

    public DataState(Integer stateID, String stateName) {
        StateID = stateID;
        StateName = stateName;
    }

    public Integer getStateID() {
        return StateID;
    }

    public void setStateID(Integer stateID) {
        StateID = stateID;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }
}
