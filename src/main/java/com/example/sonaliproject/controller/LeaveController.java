package com.example.sonaliproject.controller;

import com.example.sonaliproject.constants.enums.LeaveStatus;
import com.example.sonaliproject.model.entity.Leave;
import com.example.sonaliproject.model.response.LeaveResponse;
import com.example.sonaliproject.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resources;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@BasePathAwareController
public class LeaveController {

    private final LeaveRepository leaveRepository;

    public LeaveController(final LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

//    @RequestMapping(path="leaves/{leaveStatus}", method=RequestMethod.GET,produces="application/hal+json")
//    public ResponseEntity<List<LeaveResponse>> getAllFooFiltered(@PathVariable String leaveStatus) {
//
//        String sahil=leaveStatus;
//        LeaveStatus leaveStatus1=LeaveStatus.valueOf(sahil);
//        List<Leave> leaves=leaveRepository.findByLeaveStatus(LeaveStatus.valueOf(leaveStatus));
//        return leaves.stream().map(leave -> ResponseEntity.ok(new LeaveResponse(leave)));
//
//
//    }

}