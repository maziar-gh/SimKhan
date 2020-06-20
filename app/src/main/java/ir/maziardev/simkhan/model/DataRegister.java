package ir.maziardev.simkhan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataRegister {

    @SerializedName("MessageID")
    @Expose
    private Integer MessageID;
    @SerializedName("Message")
    @Expose
    private String Message;
    @SerializedName("ValueID")
    @Expose
    private Integer ValueID;
    @SerializedName("ValueText")
    @Expose
    private Object ValueText;

    public DataRegister() {
    }

    public DataRegister(Integer messageID, String message, Integer valueID, Object valueText) {
        MessageID = messageID;
        Message = message;
        ValueID = valueID;
        ValueText = valueText;
    }

    public Integer getMessageID() {
        return MessageID;
    }

    public void setMessageID(Integer messageID) {
        MessageID = messageID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Integer getValueID() {
        return ValueID;
    }

    public void setValueID(Integer valueID) {
        ValueID = valueID;
    }

    public Object getValueText() {
        return ValueText;
    }

    public void setValueText(Object valueText) {
        ValueText = valueText;
    }
}
