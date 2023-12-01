package org.java.spring.db.repo;

import java.util.List;

import org.java.spring.db.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByTitleContainingOrAuthorContainingIgnoreCase(String title, String author);
}
