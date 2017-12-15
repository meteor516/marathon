package com.sf.marathon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tm_pro_market_base")
public class ProMarketBase {
    //专业市场ID
    @Id
    @Column(name = "MKT_ID")
    private String id;
    //市场外部名称
    @Column(name = "MKT_NAME_SHOW")
    private String marketName;
    //单客日均最小件量
    @Column(name = "DAILY_MIN_PACKAGES")
    private Integer dailyMinPackages;
    //重量区间（最小）
    @Column(name = "WEIGHT_MIN")
    private Double minWeight;
    //重量区间（最大）
    @Column(name = "WEIGHT_MAX")
    private Double maxWeight;
    //首重价格
    @Column(name = "BASE_PRICE")
    private Double basePrice;
    //首重重量
    @Column(name = "BASE_WEIGHT")
    private Double baseWeight;

    //成团人数
    @Column(name = "group_limit")//GROUP_LIMIT
    private Integer groupLimit;

    //有效时间
    @Column(name = "GROUP_DURATION")
    private Integer groupDuration;

    //使用要求
    @Column(name = "USE_REQUIRE")
    private String useRequire;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Integer getDailyMinPackages() {
        return dailyMinPackages;
    }

    public void setDailyMinPackages(Integer dailyMinPackages) {
        this.dailyMinPackages = dailyMinPackages;
    }

    public Double getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Double minWeight) {
        this.minWeight = minWeight;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getBaseWeight() {
        return baseWeight;
    }

    public void setBaseWeight(Double baseWeight) {
        this.baseWeight = baseWeight;
    }

    public Integer getGroupLimit() {
        return groupLimit;
    }

    public void setGroupLimit(Integer groupLimit) {
        this.groupLimit = groupLimit;
    }

    public Integer getGroupDuration() {
        return groupDuration;
    }

    public void setGroupDuration(Integer groupDuration) {
        this.groupDuration = groupDuration;
    }

    public String getUseRequire() {
        return useRequire;
    }

    public void setUseRequire(String useRequire) {
        this.useRequire = useRequire;
    }
}
