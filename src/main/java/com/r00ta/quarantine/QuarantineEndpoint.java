package com.r00ta.quarantine;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.r00ta.quarantine.services.IQuarantineService;
import com.r00ta.quarantine.types.QuarantineStatus;
import com.r00ta.quarantine.types.QuarantineStatusEnum;

@Path("/")
public class QuarantineEndpoint {

    @Inject
    IQuarantineService quarantineService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/is-in-quarantine")
    public String isInQuarantine(@Context HttpHeaders headers) {
        String ipAddress = headers.getHeaderString("X-Client-IP");
        return String.valueOf(isInQuarantine(ipAddress));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/can-i-go-outside")
    public String canIGoOutside(@Context HttpHeaders headers) {
        String ipAddress = headers.getHeaderString("X-Client-IP");
        QuarantineStatusEnum result = isInQuarantine(ipAddress);
        return String.valueOf(QuarantineStatus.getOpposite(result));
    }

    private QuarantineStatusEnum isInQuarantine(String ipAddress){
        return quarantineService.isInQuarantine(ipAddress);
    }
}