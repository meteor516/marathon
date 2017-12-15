package sf.com.marathon.connectivity;

public class RequestResult {

    public static final RequestResult UN_KNOWN = RequestResult.failed(-1, "未知异常!");

    private boolean isSuccess;
    private String resultAsJson;
    private int errorCode;
    private String errorMessage;

    public static RequestResult success(String resultAsJson) {
        RequestResult requestResult = new RequestResult();
        requestResult.isSuccess = true;
        requestResult.resultAsJson = resultAsJson;

        return requestResult;
    }

    public static RequestResult failed(int errorCode, String errorMessage) {
        RequestResult requestResult = new RequestResult();
        requestResult.errorCode = errorCode;
        requestResult.errorMessage = errorMessage;

        return requestResult;
    }

    private RequestResult() {
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String resultAsJson() {
        return resultAsJson;
    }

    public String errorMessage() {
        return errorMessage;
    }

    public int errorCode() {
        return errorCode;
    }
}
