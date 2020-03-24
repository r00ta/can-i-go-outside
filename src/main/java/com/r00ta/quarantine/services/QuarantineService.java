package com.r00ta.quarantine.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.r00ta.quarantine.types.QuarantineStatusEnum;

@ApplicationScoped
public class QuarantineService implements IQuarantineService {

    private final Map<String, QuarantineStatusEnum> countriesInLockdown = initialize();

    @Inject
    ILocalizationService localizationService;

    public QuarantineStatusEnum isInQuarantine(String ip){
        try {
            String country = localizationService.getCountry(ip);
            if (countriesInLockdown.containsKey(country)){
                return QuarantineStatusEnum.YES;
            }
        } catch (IOException e) {
            return QuarantineStatusEnum.PROBABLY;
        } catch (GeoIp2Exception e) {
            return QuarantineStatusEnum.PROBABLY;
        }

        return QuarantineStatusEnum.PROBABLY;
    }

    private Map<String, QuarantineStatusEnum> initialize(){
        String[] lockedDown = new String[]{"IN", "GB", "AU", "IT", "DK", "IE", "ES", "DE", "PT", "CZ", "FR", "BE", "NO", "CN", "SI", "ID", "SV", "NZ", "PL", "CH"};
        Map<String, QuarantineStatusEnum> map = new HashMap<>();

        Arrays.stream(lockedDown).forEach(x -> map.put(x, QuarantineStatusEnum.YES));
        return map;
    }
}
