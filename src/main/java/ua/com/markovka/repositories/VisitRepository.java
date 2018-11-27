package ua.com.markovka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.markovka.model.Client;

public interface VisitRepository extends JpaRepository<Client, Long> {
}
