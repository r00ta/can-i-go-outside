package com.r00ta.quarantine.services;

import java.io.IOException;

import com.maxmind.geoip2.exception.GeoIp2Exception;

public interface ILocalizationService {
    String getCountry(String ip) throws IOException, GeoIp2Exception;
}
