package ua.com.markovka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.markovka.model.Client;
import ua.com.markovka.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
