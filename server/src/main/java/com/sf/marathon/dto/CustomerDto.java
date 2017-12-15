package com.sf.marathon.dto;

import java.util.Date;

public class CustomerDto {
    private String packId;
    private String proId;

    private String userName;

    private Date groupTime;

    private String region;
    private String address;

    private String consignorName;
    private String consignorTel;
    private Integer numPerDay;
    private Double avgWeight;

    public String getPackId() {
        return packId;
    }

    public void setPackId(String packId) {
        this.packId = packId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getGroupTime() {
        return groupTime;
    }

    public void setGroupTime(Date groupTime) {
        this.groupTime = groupTime;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsignorName() {
        return consignorName;
    }

    public void setConsignorName(String consignorName) {
        this.consignorName = consignorName;
    }

    public String getConsignorTel() {
        return consignorTel;
    }

    public void setConsignorTel(String consignorTel) {
        this.consignorTel = consignorTel;
    }

    public Integer getNumPerDay() {
        return numPerDay;
    }

    public void setNumPerDay(Integer numPerDay) {
        this.numPerDay = numPerDay;
    }

    public Double getAvgWeight() {
        return avgWeight;
    }

    public void setAvgWeight(Double avgWeight) {
        this.avgWeight = avgWeight;
    }
}
