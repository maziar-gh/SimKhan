package ir.maziardev.simkhan.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimCardListRows {
    @SerializedName("RowNum")
    @Expose
    private String rowNum;
    @SerializedName("SimCardID")
    @Expose
    private String simCardID;
    @SerializedName("SimCardNumber")
    @Expose
    private String simCardNumber;
    @SerializedName("SimCardShowNumber")
    @Expose
    private String simCardShowNumber;
    @SerializedName("SimCardDescription")
    @Expose
    private String simCardDescription;
    @SerializedName("SimCardOperatorName")
    @Expose
    private Object simCardOperatorName;
    @SerializedName("SimCardOperatorID")
    @Expose
    private String simCardOperatorID;
    @SerializedName("SimAddDateDate")
    @Expose
    private Object simAddDateDate;
    @SerializedName("SimRefreshDate")
    @Expose
    private String simRefreshDate;
    @SerializedName("IsOnlineSell")
    @Expose
    private Boolean isOnlineSell;
    @SerializedName("AllowReservation")
    @Expose
    private Boolean allowReservation;
    @SerializedName("RoundStatus")
    @Expose
    private Boolean roundStatus;
    @SerializedName("Price")
    @Expose
    private String price;
    @SerializedName("TeammatePrice")
    @Expose
    private Object teammatePrice;
    @SerializedName("ProposedPrice")
    @Expose
    private Object proposedPrice;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("StoreInfo")
    @Expose
    private Object storeInfo;
    @SerializedName("SellerTypeID")
    @Expose
    private Integer sellerTypeID;
    @SerializedName("SellerTypeName")
    @Expose
    private String sellerTypeName;
    @SerializedName("CallInfo")
    @Expose
    private Object callInfo;
    @SerializedName("ReservedEXPDate")
    @Expose
    private Object reservedEXPDate;
    @SerializedName("SimCardWorkStatusID")
    @Expose
    private Integer simCardWorkStatusID;
    @SerializedName("SimCardOwnerID")
    @Expose
    private Integer simCardOwnerID;
    @SerializedName("SimCardTypeID")
    @Expose
    private Integer simCardTypeID;
    @SerializedName("SimCardSalePriceTypeID")
    @Expose
    private Integer simCardSalePriceTypeID;
    @SerializedName("SimCardSaleTypeID")
    @Expose
    private Integer simCardSaleTypeID;
    @SerializedName("ShowCount")
    @Expose
    private Integer showCount;
    @SerializedName("ViewCount")
    @Expose
    private Integer viewCount;
    @SerializedName("FClickCount")
    @Expose
    private Integer fClickCount;
    @SerializedName("RClickCount")
    @Expose
    private Integer rClickCount;
    @SerializedName("SimCardRoundTypeList")
    @Expose
    private Object simCardRoundTypeList;
    @SerializedName("SimCardLocationName")
    @Expose
    private String simCardLocationName;
    @SerializedName("SimCardLocationID")
    @Expose
    private Integer simCardLocationID;
    @SerializedName("StateName")
    @Expose
    private String stateName;
    @SerializedName("CityName")
    @Expose
    private String cityName;
    @SerializedName("IsADV")
    @Expose
    private Boolean isADV;
    @SerializedName("SimCardWorkStatusName")
    @Expose
    private Object simCardWorkStatusName;
    @SerializedName("SimCardTypeName")
    @Expose
    private Object simCardTypeName;
    @SerializedName("SimCardSaleTypeName")
    @Expose
    private String simCardSaleTypeName;
    @SerializedName("AllowCancelBuy")
    @Expose
    private Boolean allowCancelBuy;
    @SerializedName("ConfirmBuyEXPDate")
    @Expose
    private Object confirmBuyEXPDate;
    @SerializedName("SimCardSalePriceTypeName")
    @Expose
    private String simCardSalePriceTypeName;
    @SerializedName("ReservationPrice")
    @Expose
    private Object reservationPrice;
    @SerializedName("BuyerEndPrice")
    @Expose
    private Object buyerEndPrice;
    @SerializedName("SimCardTransactionStatusID")
    @Expose
    private Integer simCardTransactionStatusID;
    @SerializedName("SimCardTransactionStatusName")
    @Expose
    private Object simCardTransactionStatusName;
    @SerializedName("BuyPrice")
    @Expose
    private Object buyPrice;
    @SerializedName("LevelEXPDate")
    @Expose
    private Object levelEXPDate;
    @SerializedName("ADVPrice")
    @Expose
    private Integer aDVPrice;
    @SerializedName("IsADVActive")
    @Expose
    private Boolean isADVActive;
    @SerializedName("ActiveCode")
    @Expose
    private Object activeCode;
    @SerializedName("MonthOff")
    @Expose
    private Object monthOff;
    @SerializedName("UserID")
    @Expose
    private String userID;
    @SerializedName("ReservationDay")
    @Expose
    private Integer reservationDay;

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public String getSimCardID() {
        return simCardID;
    }

    public void setSimCardID(String simCardID) {
        this.simCardID = simCardID;
    }

    public String getSimCardNumber() {
        return simCardNumber;
    }

    public void setSimCardNumber(String simCardNumber) {
        this.simCardNumber = simCardNumber;
    }

    public String getSimCardShowNumber() {
        return simCardShowNumber;
    }

    public void setSimCardShowNumber(String simCardShowNumber) {
        this.simCardShowNumber = simCardShowNumber;
    }

    public String getSimCardDescription() {
        return simCardDescription;
    }

    public void setSimCardDescription(String simCardDescription) {
        this.simCardDescription = simCardDescription;
    }

    public Object getSimCardOperatorName() {
        return simCardOperatorName;
    }

    public void setSimCardOperatorName(Object simCardOperatorName) {
        this.simCardOperatorName = simCardOperatorName;
    }

    public String getSimCardOperatorID() {
        return simCardOperatorID;
    }

    public void setSimCardOperatorID(String simCardOperatorID) {
        this.simCardOperatorID = simCardOperatorID;
    }

    public Object getSimAddDateDate() {
        return simAddDateDate;
    }

    public void setSimAddDateDate(Object simAddDateDate) {
        this.simAddDateDate = simAddDateDate;
    }

    public String getSimRefreshDate() {
        return simRefreshDate;
    }

    public void setSimRefreshDate(String simRefreshDate) {
        this.simRefreshDate = simRefreshDate;
    }

    public Boolean getIsOnlineSell() {
        return isOnlineSell;
    }

    public void setIsOnlineSell(Boolean isOnlineSell) {
        this.isOnlineSell = isOnlineSell;
    }

    public Boolean getAllowReservation() {
        return allowReservation;
    }

    public void setAllowReservation(Boolean allowReservation) {
        this.allowReservation = allowReservation;
    }

    public Boolean getRoundStatus() {
        return roundStatus;
    }

    public void setRoundStatus(Boolean roundStatus) {
        this.roundStatus = roundStatus;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Object getTeammatePrice() {
        return teammatePrice;
    }

    public void setTeammatePrice(Object teammatePrice) {
        this.teammatePrice = teammatePrice;
    }

    public Object getProposedPrice() {
        return proposedPrice;
    }

    public void setProposedPrice(Object proposedPrice) {
        this.proposedPrice = proposedPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(Object storeInfo) {
        this.storeInfo = storeInfo;
    }

    public Integer getSellerTypeID() {
        return sellerTypeID;
    }

    public void setSellerTypeID(Integer sellerTypeID) {
        this.sellerTypeID = sellerTypeID;
    }

    public String getSellerTypeName() {
        return sellerTypeName;
    }

    public void setSellerTypeName(String sellerTypeName) {
        this.sellerTypeName = sellerTypeName;
    }

    public Object getCallInfo() {
        return callInfo;
    }

    public void setCallInfo(Object callInfo) {
        this.callInfo = callInfo;
    }

    public Object getReservedEXPDate() {
        return reservedEXPDate;
    }

    public void setReservedEXPDate(Object reservedEXPDate) {
        this.reservedEXPDate = reservedEXPDate;
    }

    public Integer getSimCardWorkStatusID() {
        return simCardWorkStatusID;
    }

    public void setSimCardWorkStatusID(Integer simCardWorkStatusID) {
        this.simCardWorkStatusID = simCardWorkStatusID;
    }

    public Integer getSimCardOwnerID() {
        return simCardOwnerID;
    }

    public void setSimCardOwnerID(Integer simCardOwnerID) {
        this.simCardOwnerID = simCardOwnerID;
    }

    public Integer getSimCardTypeID() {
        return simCardTypeID;
    }

    public void setSimCardTypeID(Integer simCardTypeID) {
        this.simCardTypeID = simCardTypeID;
    }

    public Integer getSimCardSalePriceTypeID() {
        return simCardSalePriceTypeID;
    }

    public void setSimCardSalePriceTypeID(Integer simCardSalePriceTypeID) {
        this.simCardSalePriceTypeID = simCardSalePriceTypeID;
    }

    public Integer getSimCardSaleTypeID() {
        return simCardSaleTypeID;
    }

    public void setSimCardSaleTypeID(Integer simCardSaleTypeID) {
        this.simCardSaleTypeID = simCardSaleTypeID;
    }

    public Integer getShowCount() {
        return showCount;
    }

    public void setShowCount(Integer showCount) {
        this.showCount = showCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getFClickCount() {
        return fClickCount;
    }

    public void setFClickCount(Integer fClickCount) {
        this.fClickCount = fClickCount;
    }

    public Integer getRClickCount() {
        return rClickCount;
    }

    public void setRClickCount(Integer rClickCount) {
        this.rClickCount = rClickCount;
    }

    public Object getSimCardRoundTypeList() {
        return simCardRoundTypeList;
    }

    public void setSimCardRoundTypeList(Object simCardRoundTypeList) {
        this.simCardRoundTypeList = simCardRoundTypeList;
    }

    public String getSimCardLocationName() {
        return simCardLocationName;
    }

    public void setSimCardLocationName(String simCardLocationName) {
        this.simCardLocationName = simCardLocationName;
    }

    public Integer getSimCardLocationID() {
        return simCardLocationID;
    }

    public void setSimCardLocationID(Integer simCardLocationID) {
        this.simCardLocationID = simCardLocationID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Boolean getIsADV() {
        return isADV;
    }

    public void setIsADV(Boolean isADV) {
        this.isADV = isADV;
    }

    public Object getSimCardWorkStatusName() {
        return simCardWorkStatusName;
    }

    public void setSimCardWorkStatusName(Object simCardWorkStatusName) {
        this.simCardWorkStatusName = simCardWorkStatusName;
    }

    public Object getSimCardTypeName() {
        return simCardTypeName;
    }

    public void setSimCardTypeName(Object simCardTypeName) {
        this.simCardTypeName = simCardTypeName;
    }

    public String getSimCardSaleTypeName() {
        return simCardSaleTypeName;
    }

    public void setSimCardSaleTypeName(String simCardSaleTypeName) {
        this.simCardSaleTypeName = simCardSaleTypeName;
    }

    public Boolean getAllowCancelBuy() {
        return allowCancelBuy;
    }

    public void setAllowCancelBuy(Boolean allowCancelBuy) {
        this.allowCancelBuy = allowCancelBuy;
    }

    public Object getConfirmBuyEXPDate() {
        return confirmBuyEXPDate;
    }

    public void setConfirmBuyEXPDate(Object confirmBuyEXPDate) {
        this.confirmBuyEXPDate = confirmBuyEXPDate;
    }

    public String getSimCardSalePriceTypeName() {
        return simCardSalePriceTypeName;
    }

    public void setSimCardSalePriceTypeName(String simCardSalePriceTypeName) {
        this.simCardSalePriceTypeName = simCardSalePriceTypeName;
    }

    public Object getReservationPrice() {
        return reservationPrice;
    }

    public void setReservationPrice(Object reservationPrice) {
        this.reservationPrice = reservationPrice;
    }

    public Object getBuyerEndPrice() {
        return buyerEndPrice;
    }

    public void setBuyerEndPrice(Object buyerEndPrice) {
        this.buyerEndPrice = buyerEndPrice;
    }

    public Integer getSimCardTransactionStatusID() {
        return simCardTransactionStatusID;
    }

    public void setSimCardTransactionStatusID(Integer simCardTransactionStatusID) {
        this.simCardTransactionStatusID = simCardTransactionStatusID;
    }

    public Object getSimCardTransactionStatusName() {
        return simCardTransactionStatusName;
    }

    public void setSimCardTransactionStatusName(Object simCardTransactionStatusName) {
        this.simCardTransactionStatusName = simCardTransactionStatusName;
    }

    public Object getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Object buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Object getLevelEXPDate() {
        return levelEXPDate;
    }

    public void setLevelEXPDate(Object levelEXPDate) {
        this.levelEXPDate = levelEXPDate;
    }

    public Integer getADVPrice() {
        return aDVPrice;
    }

    public void setADVPrice(Integer aDVPrice) {
        this.aDVPrice = aDVPrice;
    }

    public Boolean getIsADVActive() {
        return isADVActive;
    }

    public void setIsADVActive(Boolean isADVActive) {
        this.isADVActive = isADVActive;
    }

    public Object getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(Object activeCode) {
        this.activeCode = activeCode;
    }

    public Object getMonthOff() {
        return monthOff;
    }

    public void setMonthOff(Object monthOff) {
        this.monthOff = monthOff;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Integer getReservationDay() {
        return reservationDay;
    }

    public void setReservationDay(Integer reservationDay) {
        this.reservationDay = reservationDay;
    }
}
