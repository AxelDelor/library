package com.axeld.library.controller;

import com.axeld.library.dto.LoanCreateRequest;
import com.axeld.library.model.Loan;
import com.axeld.library.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loan createLoan(@RequestBody LoanCreateRequest loanCreateRequest) {
        return loanService.createLoan(loanCreateRequest.bookId(), loanCreateRequest.memberId());
    }

    @PutMapping("/{bookId}/return")
    @ResponseStatus(HttpStatus.OK)
    public Loan returnBook(@PathVariable Long bookId) {
        return loanService.returnBook(bookId);
    }

}
