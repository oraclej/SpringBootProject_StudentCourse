package ir.oraclej.springbootproject_studentcourse;

public class UniversityException extends RuntimeException{
    public UniversityException() {
    }

    public UniversityException(String message) {
        super("[University Exception]" + message);
    }

    public UniversityException(String message, Throwable cause) {
        super("[University Exception]" + message, cause);
    }

    public UniversityException(Throwable cause) {
        super(cause);
    }

    public UniversityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("[University Exception]" + message, cause, enableSuppression, writableStackTrace);
    }
}
