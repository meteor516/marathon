package com.sf.marathon.dto;

import java.io.Serializable;
import java.util.Date;

public class PackDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String marketName;
    private Integer dailyMinPackages;
    private Double minWeight;
    private Double maxWeight;
    private Double basePrice;
    private Double baseWeight;
    private Integer groupLimit;
    private Integer groupDuration;
    private String useRequire;

    private Date beginTime;
    private Date endTime;
    private Integer groupNum;
    private Byte finish;
    private Date createTime;
    private Date finishTime;
    
    private String proId;
    private String packId;
    

    public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getPackId() {
		return packId;
	}

	public void setPackId(String packId) {
		this.packId = packId;
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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public Byte getFinish() {
        return finish;
    }

    public void setFinish(Byte finish) {
        this.finish = finish;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

}
