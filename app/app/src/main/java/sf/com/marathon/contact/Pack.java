package sf.com.marathon.contact;

import java.io.Serializable;
import java.util.Date;

public class Pack implements Serializable {
    private String marketName;
    private Integer dailyMinPackages;
    private Double minWeight;
    private Double maxWeight;
    private Double basePrice;
    private Double baseWeight;
    private Integer groupLimit;
    private Integer groupDuration;
    private String useRequire;

    private String beginTime;
    private String endTime;
    private Integer groupNum;
    private Byte finish;

    private String proId;
    private String packId;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

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
}
