package com.r00ta.quarantine.types;

public class QuarantineStatus {

    public static QuarantineStatusEnum getOpposite(QuarantineStatusEnum status){
        if (QuarantineStatusEnum.NO.equals(status)){
            return QuarantineStatusEnum.YES;
        }
        if (QuarantineStatusEnum.YES.equals(status)){
            return QuarantineStatusEnum.NO;
        }
        return status;
    }
}
