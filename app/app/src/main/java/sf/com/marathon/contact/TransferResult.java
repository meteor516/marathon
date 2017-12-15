package sf.com.marathon.contact;

public class TransferResult {
    /**
     * "errorMsg":null,"reponse":{"marketName":null,"dailyMinPackages":null,"minWeight":null,"maxWeight":null,"basePrice":null,"baseWeight":22.0,"groupLimit":null,"groupDuration":null,"useRequire":null,"beginTime":1513320692000,"endTime":1513318165000,"groupNum":null,"finish":null,"createTime":1513326014673,"finishTime":null},"success":true}
     */
    private String errorMsg;
    private Object response;

    private boolean isSuccess;

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}