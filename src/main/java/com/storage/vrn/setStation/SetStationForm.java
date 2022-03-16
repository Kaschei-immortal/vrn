package com.storage.vrn.setStation;

public class SetStationForm {

    private Long stationId;
    private Long idAccount;

    public SetStationForm() {

    }

    public SetStationForm(Long stationId, Long idAccount) {
        this.stationId = stationId;
        this.idAccount = idAccount;
    }

    public Long getStationId() {
        return stationId;
    }
    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public Long getIdAccount() {
        return idAccount;
    }
    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

}