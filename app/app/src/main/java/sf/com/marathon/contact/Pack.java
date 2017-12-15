package sf.com.marathon.contact;

import java.io.Serializable;
import java.util.Date;

public class Pack implements Serializable {
    private String marketName;
    private int dailyMinPackages;
    private double minWeight;
    private double maxWeight;
    private double basePrice;
    private double baseWeight;
    private int groupLimit;
    private int groupDuration;
    private String useRequire;

    private Date beginTime;
    private Date endTime;
    private int groupNum;
    private byte finish;
    private Date createTime;
    private Date finishTime;

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

    public int getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(int groupNum) {
        this.groupNum = groupNum;
    }

    public byte getFinish() {
        return finish;
    }

    public void setFinish(byte finish) {
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
