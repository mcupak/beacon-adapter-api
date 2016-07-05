# Beacon Adapter API [![Build Status](https://travis-ci.org/mcupak/beacon-adapter-api.svg?branch=develop)](https://travis-ci.org/mcupak/beacon-adapter-api) [![GitHub license](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://raw.githubusercontent.com/mcupak/beacon-adapter-api/develop/LICENSE)

Beacon Adapter API is a component of the Java Beacon Development Kit (JBDK) which is used by developers to implement  [GA4GH's](http://genomicsandhealth.org/) beacon specification [found here](https://github.com/ga4gh/beacon-team).
It enables developers to create adapter components that can easily be swapped out of a [REST-Implementation](https://github.com/mcupak/beacon-java/tree/develop/beacon-java-rest) to configure different data sources with minimal configuration.


## Contents
The project consists of a single interface, with supporting exceptions and utility classes. The interface exposes the adapter-api that developers can use to create their own custom adapters with minimal configuration to the rest of the JBDK.

An adapter works as a bridge between the rest service layer and a data source, meaning that the service layer does not need to know any details about where the data comes from, or how its implemented. By decoupling these two components the user can effectually "swap in" any adapter to their REST implementation with zero additional configuration! 


## Implementing your own adapter
Implementing a custom adapter is easy:

1. Add this project as a dependency to your project's pom
2. Implement the BeaconAdapter
3. Add your project as a dependency to the beacon-java-rest project's pom

### See Also:
- [Beacon-Java git](https://github.com/mcupak/beacon-java/)
- [Beacon-Team git](https://github.com/ga4gh/beacon-team)
- [GA4GH](http://genomicsandhealth.org)
- [GA4GH git](https://github.com/ga4gh)