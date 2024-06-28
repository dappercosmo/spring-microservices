package com.mybank.app.controller;

import com.mybank.app.model.Branch;
import com.mybank.app.service.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/branch")
@AllArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping
    ResponseEntity<Branch> addBranch(@RequestBody Branch branch){
        try{
            branchService.addBranch(branch);
            return ResponseEntity.ok(branch);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
