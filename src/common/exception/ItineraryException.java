package common.exception;

public class ItineraryException extends BaseException {
    public ItineraryException(ErrorCode errorCode) {
        super(errorCode);
    }
}
