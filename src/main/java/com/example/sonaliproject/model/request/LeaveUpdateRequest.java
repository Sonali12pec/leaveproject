package com.example.sonaliproject.model.request;

import com.example.sonaliproject.constants.enums.LeaveStatus;
import com.example.sonaliproject.constants.enums.LeaveType;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class LeaveUpdateRequest {

    private String reason;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Boolean isHalfDay;

    private LeaveType leaveType;

    private LeaveStatus leaveStatus;


}