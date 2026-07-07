package com.axeld.library.repository;

import com.axeld.library.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByMemberId(Long memberId);

    Optional<Loan> findByBookIdAndReturnDateIsNull(Long bookId);
}
