package com.sf.marathon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tm_pro_market_base")
public class ProMarketBase {
    //专业市场ID
    @Id
    @Column(name = "id")
    private String id;
    //市场外部名称
    @Column(name = "MKT_NAME_SHOW")
    private String marketName;
    //单客日均最小件量
    @Column(name = "DAILY_MIN_PACKAGES")
    private int dailyMinPackages;
    //重量区间（最小）
    @Column(name = "WEIGHT_MIN")
    private double minWeight;
    //重量区间（最大）
    @Column(name = "WEIGHT_MAX")
    private double maxWeight;
    //首重价格
    @Column(name = "BASE_PRICE")
    private double basePrice;
    //首重重量
    @Column(name = "BASE_WEIGHT")
    private double baseWeight;

    //成团人数

    private int groupLimit;

    //有效时间
    private int groupDuration;

    //使用要求
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

    public int getDailyMinPackages() {
        return dailyMinPackages;
    }

    public void setDailyMinPackages(int dailyMinPackages) {
        this.dailyMinPackages = dailyMinPackages;
    }

    public double getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(double minWeight) {
        this.minWeight = minWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getBaseWeight() {
        return baseWeight;
    }

    public void setBaseWeight(double baseWeight) {
        this.baseWeight = baseWeight;
    }

    public int getGroupLimit() {
        return groupLimit;
    }

    public void setGroupLimit(int groupLimit) {
        this.groupLimit = groupLimit;
    }

    public int getGroupDuration() {
        return groupDuration;
    }

    public void setGroupDuration(int groupDuration) {
        this.groupDuration = groupDuration;
    }

    public String getUseRequire() {
        return useRequire;
    }

    public void setUseRequire(String useRequire) {
        this.useRequire = useRequire;
    }
}
