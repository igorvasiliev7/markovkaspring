package ua.com.markovka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.markovka.model.Call;

public interface CallRepository extends JpaRepository<Call,Long> {
}
