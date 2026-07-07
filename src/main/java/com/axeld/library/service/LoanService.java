package com.axeld.library.service;

import com.axeld.library.exception.BookNotAvailableException;
import com.axeld.library.exception.LoanNotFoundException;
import com.axeld.library.model.Book;
import com.axeld.library.model.Loan;
import com.axeld.library.model.Member;
import com.axeld.library.model.State;
import com.axeld.library.repository.LoanRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookService bookService;
    private final MemberService memberService;

    public List<Loan> getMemberLoans(Long memberId) {
        memberService.getMemberById(memberId);
        return loanRepository.findByMemberId(memberId);
    }

    @Transactional
    public Loan createLoan(Long bookId, Long memberId) {
        Book book = bookService.getBookById(bookId);
        if (book.getState() != State.AVAILABLE) {
            throw new BookNotAvailableException("Le livre demandé n'est pas disponible");
        }
        Member member = memberService.getMemberById(memberId);
        book.setState(State.BORROWED);
        Loan loan = Loan.builder()
                .member(member)
                .book(book)
                .loanDate(LocalDate.now())
                .build();
        return loanRepository.save(loan);
    }

    @Transactional
    public Loan returnBook(Long bookId) {
        Loan loan = loanRepository.findByBookIdAndReturnDateIsNull(bookId).orElseThrow(() -> new LoanNotFoundException("Ce prêt n'existe pas"));
        Book book = loan.getBook();
        loan.setReturnDate(LocalDate.now());
        book.setState(State.AVAILABLE);
        return loan;
    }


}
