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
package com.dnastack.beacon.utils;

import com.dnastack.beacon.adapter.api.BeaconAdapter;
import com.dnastack.beacon.exceptions.IllegalBeaconAdapterException;
import lombok.*;

import java.util.List;

/**
 * Adapter Config class used to initialize a single adapter
 *
 * @author patmagee
 */
@Data
public class AdapterConfig {

    /**
     * The name of the adapter. This is the name that the adapter will be registered under
     */
    String name;

    /**
     * Type this AdapterConfig so that it can be used to create a new instance of the adapter class
     */
    String adapterClass;

    /**
     * List of optional configValues to pass to the adapter
     */
    List<ConfigValue> configValues;

    public static AdapterConfigBuilder builder() {
        return new AdapterConfigBuilder();
    }

    public AdapterConfig(@NonNull String name, @NonNull String clazz, @NonNull List<ConfigValue> configValues) {
        this.configValues = configValues;
        this.name = name;
        this.adapterClass = clazz;
    }


    /**
     * Convert the adapterClass string into a Class<BeaconAdapter> object which can be used to create a new instance
     * of this beacon adapter. The Actual adapter must be located in the class path.
     * @return
     */
    public Class<BeaconAdapter> convertAapterClassStringToClass() {

        try {
            Class<?> clazz = Class.forName(adapterClass);
            if (!BeaconAdapter.class.isAssignableFrom(clazz)) {
                throw new IllegalBeaconAdapterException("Supplied adapter class is not a valid subclass of BeaconAdapter");
            }

            return (Class<BeaconAdapter>) clazz;
        } catch (ClassNotFoundException e) {
            throw new IllegalBeaconAdapterException("Could not find adapterClass. Please ensure that it is available in the class path");
        }

    }

    /**
     * A builder class for the adapterConfig object
     */
    public static class AdapterConfigBuilder {

        List<ConfigValue> values;
        String name;
        String clazz;

        public AdapterConfigBuilder() {

        }

        public AdapterConfigBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public AdapterConfigBuilder setAdapterClass(String clazz) {
            this.clazz = clazz;
            return this;
        }

        public AdapterConfigBuilder addConfig(String key, String value) {
            values.add(new ConfigValue(key, value));
            return this;
        }

        public AdapterConfig build() {
            if (name == null) {
                throw new IllegalStateException("Missing required Parameters: Name");
            } else if (clazz == null) {
                throw new IllegalStateException("Missing required Parameters: AdapterClass");
            }
            return new AdapterConfig(name, clazz, values);
        }
    }


}
