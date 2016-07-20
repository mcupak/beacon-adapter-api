package com.dnastack.beacon.exceptions;

import com.dnastack.beacon.utils.Reason;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages;
import org.ga4gh.beacon.BeaconError;

/**
 * Base Beacon exceptions
 *
 * @author patrickmagee on 2016-06-17.
 */
public class BeaconException extends Exception {

    private Reason reason;
    private BeaconError error;

    public BeaconException(Reason reason) {
        super();
        this.reason = reason;
    }

    public BeaconException(Reason reason, BeaconError error) {
        super();
        this.reason = reason;
        this.error = error;
    }

    public BeaconException(Reason reason, String msg) {
        super(msg);
        this.reason = reason;
    }

    public Reason getReason() {
        return reason;
    }

    public BeaconError getError() {
        return error;
    }

}
