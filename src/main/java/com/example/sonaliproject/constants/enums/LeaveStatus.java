package com.example.sonaliproject.constants.enums;

import java.util.HashMap;
import java.util.Map;

public enum LeaveStatus {
    APPLIED("APPLIED"),APPROVED("APPROVED"),REJECTED("REJECTED"),AVAILED("AVAILED");

    private static final Map<String, LeaveStatus> cacheMap = new HashMap<String, LeaveStatus>();

    static {
        for (LeaveStatus leaveStatus: values()) {
            cacheMap.put(leaveStatus.status, leaveStatus);
        }
    }

    private final String status;

    LeaveStatus(String status) {
      this.status=status;
    }

    public static Boolean isValid(String leaveStatus) {
        return cacheMap.containsKey(leaveStatus);
    }

    public String  getStatus(){
        return status;
    }

}
