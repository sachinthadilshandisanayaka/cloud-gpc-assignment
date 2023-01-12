package com.addmnistration.response;

/**
 * Class for custom error codes
 *
 * @author Sachintha
 * @since 01/23
 */
public final class ResponseCode {

    private ResponseCode() {
    }

    public static final Integer SUCCESS = 1000;
    public static final Integer INVALID_INPUT = 1001;
    public static final Integer MISSING_DATA = 1002;
    public static final Integer ERROR_OPERATION = 1003;
    public static final Integer INVALID_OPERATION = 1004;
    public static final Integer CONFLICT_DATA = 1005;
    public static final Integer DUPLICATE_DATA = 1006;
}
