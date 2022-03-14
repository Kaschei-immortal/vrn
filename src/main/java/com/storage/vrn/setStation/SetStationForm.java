package com.storage.vrn.setStation;

public class SetStationForm {

    private Long stationId;
    private Integer idAccount;

    public SetStationForm() {

    }

    public SetStationForm(Long stationId, Integer idAccount) {
        this.stationId = stationId;
        this.idAccount = idAccount;
    }

    public Long getStationId() {
        return stationId;
    }
    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public Integer getIdAccount() {
        return idAccount;
    }
    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

}