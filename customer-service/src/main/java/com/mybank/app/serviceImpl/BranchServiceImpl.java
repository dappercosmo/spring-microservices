package com.mybank.app.serviceImpl;

import com.mybank.app.model.Branch;
import com.mybank.app.repository.BranchRepository;
import com.mybank.app.service.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    @Override
    public Branch addBranch(Branch branch) {
        Branch newBranch = new Branch();
        newBranch.setBranchName(branch.getBranchName());
        newBranch.setBranchAddress(branch.getBranchAddress());
        newBranch.setIfscCode(branch.getIfscCode());
        newBranch.setAccount(branch.getAccount());
        return branchRepository.save(newBranch);
    }
}
