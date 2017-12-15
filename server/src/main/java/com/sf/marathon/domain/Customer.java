package com.sf.marathon.domain;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tt_group_user")
public class Customer {
    @Id
    @Column(name = "id")
//    @GenericGenerator(name = "PKUUID", strategy = "uuid2")
//    @GeneratedValue(generator = "PKUUID")
    private String id;


    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "group_id")//这里设置JoinColum设置了外键的名字，并且orderItem是关系维护端
    private PackGroup packGroup;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "group_time")
    private Date groupTime;

    @Column(name = "region")
    private String region;

    @Column(name = "address")
    private String address;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PackGroup getPackGroup() {
        return packGroup;
    }

    public void setPackGroup(PackGroup packGroup) {
        this.packGroup = packGroup;
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
}
