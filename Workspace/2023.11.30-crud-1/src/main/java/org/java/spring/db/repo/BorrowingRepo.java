package org.java.spring.db.repo;

import org.java.spring.db.pojo.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepo extends JpaRepository<Borrowing, Integer> {

}
