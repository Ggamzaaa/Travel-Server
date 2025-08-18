package common.exception;

public class TravelException extends BaseException {
    public TravelException(ErrorCode errorCode) {
        super(errorCode);
    }
}
