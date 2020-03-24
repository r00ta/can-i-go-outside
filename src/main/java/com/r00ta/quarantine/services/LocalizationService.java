package com.r00ta.quarantine.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;

@ApplicationScoped
public class LocalizationService implements ILocalizationService {

    private DatabaseReader dbReader;

    public LocalizationService() throws IOException {
        File database = new File("/tmp/GeoLite2-Country.mmdb");
        System.out.println(database);
        dbReader = new DatabaseReader.Builder(database).build();
    }

    public String getCountry(String ip)
            throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        String country = dbReader.country(ipAddress).getCountry().getIsoCode();

        return country;
    }
}