package ua.com.markovka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.markovka.model.Call;

import java.util.List;

public interface CallRepository extends JpaRepository<Call,Long> {
    List<Call> findAllByClientId(Long id);
}
