package com.example.sonaliproject.service;

import com.example.sonaliproject.model.request.LeaveRequest;
import com.example.sonaliproject.model.request.LeaveUpdateRequest;
import com.example.sonaliproject.model.response.LeaveResponse;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface LeaveService {
    List<LeaveResponse> getLeave(@NotNull String leaveStatus);

    List<LeaveResponse>getLeaves();

    LeaveResponse updateLeave(@NotNull Long id, LeaveUpdateRequest leaveUpdateRequest);

    void deleteLeave(@NotNull Long id);

    void createLeave(LeaveRequest leaveRequest);
}
