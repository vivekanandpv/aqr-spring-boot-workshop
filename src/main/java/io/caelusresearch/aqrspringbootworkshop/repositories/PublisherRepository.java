package io.caelusresearch.aqrspringbootworkshop.repositories;

import io.caelusresearch.aqrspringbootworkshop.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
