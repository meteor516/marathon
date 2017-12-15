package com.sf.marathon.domain;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tt_group_user")
public class Customer {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = true)
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


}
