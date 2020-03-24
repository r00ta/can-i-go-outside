package com.r00ta.quarantine.services;

import com.r00ta.quarantine.types.QuarantineStatusEnum;

public interface IQuarantineService {
    QuarantineStatusEnum isInQuarantine(String ip);
}
