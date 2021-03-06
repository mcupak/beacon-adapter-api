/*
 * The MIT License
 *
 * Copyright 2014 Patrick Magee (patrickmageee@gmail.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.dnastack.beacon.exceptions;

import com.dnastack.beacon.utils.Reason;
import lombok.Getter;
import lombok.Setter;
import org.ga4gh.beacon.BeaconAlleleRequest;
import org.ga4gh.beacon.BeaconError;

/**
 * Exception raised when there is an issue with the beacon allele request
 *
 * @patrickmagee
 */
public class BeaconAlleleRequestException extends BeaconException {

    @Getter
    @Setter
    private BeaconAlleleRequest request;

    public BeaconAlleleRequestException(String msg, Reason reason, BeaconAlleleRequest request) {
        super(reason, msg);
        this.request = request;
    }

    public BeaconAlleleRequestException(Reason reason, String msg) {
        super(reason, msg);
    }

    public BeaconAlleleRequestException(Reason reason, BeaconError error) {
        super(reason, error);
    }

}
