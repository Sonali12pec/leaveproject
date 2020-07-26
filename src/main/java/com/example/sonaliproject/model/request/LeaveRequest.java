package com.example.sonaliproject.model.request;

import com.example.sonaliproject.constants.enums.LeaveStatus;
import com.example.sonaliproject.constants.enums.LeaveType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class LeaveRequest {
   @NotNull
   private String reason;
   @NotNull
   private LocalDateTime startDate;
   @NotNull
   private LocalDateTime endDate;
   @NotNull
   private Boolean isHalfDay;
   @NotNull
   private LeaveType leaveType;
   @NotNull
   private LeaveStatus leaveStatus;


}
