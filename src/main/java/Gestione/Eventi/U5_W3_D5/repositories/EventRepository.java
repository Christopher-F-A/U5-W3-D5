package Gestione.Eventi.U5_W3_D5.repositories;

import Gestione.Eventi.U5_W3_D5.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
