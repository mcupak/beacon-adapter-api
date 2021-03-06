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
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ga4gh.beacon.BeaconError;

/**
 * Base Beacon exceptions
 *
 * @author patrickmagee on 2016-06-17.
 */
@NoArgsConstructor
@Data
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

    public BeaconException(Reason reason, BeaconError error, String msg) {
        super(msg);
        this.reason = reason;
        this.error = error;
    }

    public BeaconException(String msg) {
        super(msg);
    }
}
