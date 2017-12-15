package sf.com.marathon.contact;

public class TransferResult {
    /**
     * "errorMsg":null,"reponse":{"marketName":null,"dailyMinPackages":null,"minWeight":null,"maxWeight":null,"basePrice":null,"baseWeight":22.0,"groupLimit":null,"groupDuration":null,"useRequire":null,"beginTime":1513320692000,"endTime":1513318165000,"groupNum":null,"finish":null,"createTime":1513326014673,"finishTime":null},"success":true}
     */
    private String errorMsg;
    private String response;
    private boolean success;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
