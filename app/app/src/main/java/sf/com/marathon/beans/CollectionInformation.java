package sf.com.marathon.beans;

import java.io.Serializable;

public class CollectionInformation implements Serializable {
    private String name;
    private double minWeight;

    private double maxWeight;
    private int countOfDayWithSending;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfDayWithSending() {
        return countOfDayWithSending;
    }

    public void setCountOfDayWithSending(int countOfDayWithSending) {
        this.countOfDayWithSending = countOfDayWithSending;
    }
}
