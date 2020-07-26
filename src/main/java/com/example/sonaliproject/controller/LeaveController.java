package com.example.sonaliproject.controller;

import com.example.sonaliproject.aop.annotation.Logged;
import com.example.sonaliproject.aop.annotation.RequestThreadId;
import com.example.sonaliproject.model.request.LeaveRequest;
import com.example.sonaliproject.model.request.LeaveUpdateRequest;
import com.example.sonaliproject.model.response.GenericResponse;
import com.example.sonaliproject.model.response.LeaveResponse;
import com.example.sonaliproject.model.response.ResponseStatus;
import com.example.sonaliproject.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping(value = "/health")
    public String health(){
        return "200OK";
    }

    @Logged
    @RequestThreadId
    @RequestMapping( method = RequestMethod.GET)
    public GenericResponse<List<LeaveResponse>> getLeaves() {
        GenericResponse<List<LeaveResponse>> response = new GenericResponse<>();
        response.setData(leaveService.getLeaves());
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }
    @Logged
    @RequestThreadId
    @RequestMapping(value =  "/{leaveStatus}", method = RequestMethod.GET)
    public GenericResponse<List<LeaveResponse>> getLeave(@PathVariable("leaveStatus") String leaveStatus) {
        GenericResponse<List<LeaveResponse>> response = new GenericResponse<>();
        response.setData(leaveService.getLeave(leaveStatus));
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }
    @Logged
    @RequestThreadId
    @RequestMapping(method = RequestMethod.POST)
    public GenericResponse<String> createLeave(@RequestBody LeaveRequest leaveRequest) {
        GenericResponse<String> response = new GenericResponse<>();
        leaveService.createLeave(leaveRequest);
        response.setData(ResponseStatus.SUCCESS);
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }

    @Logged
    @RequestThreadId
    @RequestMapping(value =  "/{id}", method = RequestMethod.PUT)
    public GenericResponse<LeaveResponse> updateLeave(@PathVariable("id") Long id, @RequestBody LeaveUpdateRequest leaveUpdateRequest) {
        GenericResponse<LeaveResponse> response = new GenericResponse<>();
        response.setData(leaveService.updateLeave(id,leaveUpdateRequest));
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }


    @Logged
    @RequestThreadId
    @RequestMapping(value =  "/{id}", method = RequestMethod.DELETE)
    public GenericResponse<String> deleteLeave(@PathVariable("id") Long id) {
        GenericResponse<String> response = new GenericResponse<>();
        leaveService.deleteLeave(id);
        response.setData(ResponseStatus.SUCCESS);
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }


}

