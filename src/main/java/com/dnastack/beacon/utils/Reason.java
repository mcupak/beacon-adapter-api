package com.dnastack.beacon.utils;

/**
 * Reason for encountered exceptions.
 *
 * @author patrickmagee on 2016-06-17.
 */
public enum Reason {

    INVALID_REQUEST("Invalid request"), CONN_ERR("Could not retrieve information from beacon"), ERROR("An error occured");

    private String msg;

    Reason(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
