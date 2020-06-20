package ir.maziardev.simkhan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("SimCardListRows")
    @Expose
    private List<SimCardListRows> simCardListRows = null;
    @SerializedName("TotalRecord")
    @Expose
    private Integer totalRecord;
    @SerializedName("SumTeammatePrice")
    @Expose
    private Integer sumTeammatePrice;
    @SerializedName("SumBuyPrice")
    @Expose
    private Integer sumBuyPrice;
    @SerializedName("MessageID")
    @Expose
    private Integer messageID;
    @SerializedName("MessageText")
    @Expose
    private Object messageText;

    public List<SimCardListRows> getSimCardListRows() {
        return simCardListRows;
    }

    public void setSimCardListRows(List<SimCardListRows> simCardListRows) {
        this.simCardListRows = simCardListRows;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getSumTeammatePrice() {
        return sumTeammatePrice;
    }

    public void setSumTeammatePrice(Integer sumTeammatePrice) {
        this.sumTeammatePrice = sumTeammatePrice;
    }

    public Integer getSumBuyPrice() {
        return sumBuyPrice;
    }

    public void setSumBuyPrice(Integer sumBuyPrice) {
        this.sumBuyPrice = sumBuyPrice;
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public Object getMessageText() {
        return messageText;
    }

    public void setMessageText(Object messageText) {
        this.messageText = messageText;
    }
}
