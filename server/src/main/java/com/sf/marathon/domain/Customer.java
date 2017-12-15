package com.sf.marathon.domain;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tt_group_user")
public class Customer {

    @Id
    @Column(name="id")
    private String id;
    @Column(name="group_id")
    private String groupId;
    @Column(name="user_name")
    private String userName;
    @Column(name="group_time")
    private Date groupTime;
    @Column(name="region")
    private String region;
    @Column(name="address")
    private String address;
    @Column(name="consignor_name")
    private String consignorName;
    @Column(name="consignor_tel")
    private String consignorTel;
    @Column(name="num_per_day")
    private Integer numPerDay;
    @Column(name="avg_weight")
    private Double avgWeight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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
