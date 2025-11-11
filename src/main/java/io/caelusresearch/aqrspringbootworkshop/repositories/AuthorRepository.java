package io.caelusresearch.aqrspringbootworkshop.repositories;

import io.caelusresearch.aqrspringbootworkshop.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
