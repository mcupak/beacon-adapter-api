package com.dnastack.beacon.adapter.api;

import com.dnastack.beacon.exceptions.BeaconException;
import org.ga4gh.beacon.Beacon;
import org.ga4gh.beacon.BeaconAlleleRequest;
import org.ga4gh.beacon.BeaconAlleleResponse;

/**
 * Beacon adapter API.
 * <p>
 * Created by patrickmagee on 2016-06-16.
 */
public interface BeaconAdapter {

    /**
     * Retrieve a Beacon allele response from the supplied datasource
     *
     * @param request beacon allele request
     * @return beacon allele response
     */
    BeaconAlleleResponse getBeaconAlleleResponse(BeaconAlleleRequest request) throws BeaconException;

    /**
     * Retrieve information about the specified beacon
     *
     * @return beacon infroamtion
     */
    Beacon getBeacon() throws BeaconException;

}
