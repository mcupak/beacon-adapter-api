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
package com.dnastack.beacon.adapter.api;

import com.dnastack.beacon.exceptions.BeaconException;
import com.dnastack.beacon.utils.AdapterConfig;
import org.ga4gh.beacon.Beacon;
import org.ga4gh.beacon.BeaconAlleleRequest;
import org.ga4gh.beacon.BeaconAlleleResponse;
import org.ga4gh.beacon.Chromosome;

import java.util.List;

/**
 * Beacon adapter API.
 * <p>
 * Created by patrickmagee on 2016-06-16.
 */
public interface BeaconAdapter {

    /**
     * Initialization method for creating and configuring this new adapter
     *
     * @param config adapter configuration
     */
    void initAdapter(AdapterConfig config);

    /**
     * Retrieve a Beacon allele response from the supplied datasource
     *
     * @param request beacon allele request
     * @return beacon allele response
     */
    BeaconAlleleResponse getBeaconAlleleResponse(BeaconAlleleRequest request) throws BeaconException;


    /**
     * Retrieve a Beacon allele response from the supplied datasource
     *
     * @param referenceName           name of the reference
     * @param start                   start position
     * @param startMin                minimum start coordinate
     * @param startMax                maximum start coordinate
     * @param end                     precise end coordinate
     * @param endMin                  minimum end coordinate
     * @param endMax                  maximum end coordinate
     * @param referenceBases          reference bases
     * @param alternateBases          alternate bases
     * @param variantType             used to denote structural variants
     * @param assemblyId              genome assembly
     * @param datasetIds              list of datasetIds
     * @param includeDatasetResponses include datasets to response object
     * @return beacon allele response
     */
    BeaconAlleleResponse getBeaconAlleleResponse(Chromosome referenceName, Long start, Integer startMin, Integer startMax, Integer end, Integer endMin, Integer endMax, String referenceBases, String alternateBases, String variantType, String assemblyId, List<String> datasetIds, BeaconAlleleRequest.IncludeDatasetResponsesEnum includeDatasetResponses) throws BeaconException;

    /**
     * Retrieve information about the specified beacon
     *
     * @return beacon information
     */
    Beacon getBeacon() throws BeaconException;


}
