package common.exception;

public class GlobalExceptionHandler {
    public void handle(Exception e) {
        if (e instanceof BaseException ex) {
            System.err.println("[Error] " + ex.getErrorCode().getMessage());
            return;
        }
        System.err.println("[Server Error] " + e.getMessage());
    }
}
