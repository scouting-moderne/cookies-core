package io.moderne.scouting.cookies.error;

public class ApiException extends RuntimeException {
    private final ApiError error;
    public ApiException(ApiError error) {
        this.error = error;
    }

    public ApiError getError() {
        return error;
    }
}
