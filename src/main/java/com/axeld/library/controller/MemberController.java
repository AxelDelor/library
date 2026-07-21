package com.axeld.library.controller;

import com.axeld.library.model.Loan;
import com.axeld.library.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final LoanService loanService;

    @GetMapping("/{id}/loans")
    public List<Loan> getMemberLoans(@PathVariable Long id) {
        return loanService.getMemberLoans(id);
    }
}
