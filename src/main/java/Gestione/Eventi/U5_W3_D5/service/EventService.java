package Gestione.Eventi.U5_W3_D5.service;

import Gestione.Eventi.U5_W3_D5.dto.EventDTO;
import Gestione.Eventi.U5_W3_D5.entities.Event;
import Gestione.Eventi.U5_W3_D5.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event saveEvent(EventDTO dto) {
        Event event = new Event();
        event.setTitle(dto.title());
        event.setDescription(dto.description());
        event.setDate(dto.date());
        event.setLocation(dto.location());
        event.setCapacity(dto.capacity());

        System.out.println("salvataggio evento nel DB");
        return eventRepository.save(event);
    }

    public List<EventDTO> getAllEvents() {
        System.out.println("tutti gli eventi recuperati");
        return eventRepository.findAll().stream()
                .map(e -> new EventDTO(e.getTitle(), e.getDescription(), e.getDate(), e.getLocation(), e.getCapacity()))
                .toList();
    }

    public Event getById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento non trovato con ID: " + id));
    }

    public Event updateEvent(Long id, Event details) {
        Event event = getById(id);
        event.setTitle(details.getTitle());
        event.setDescription(details.getDescription());
        event.setDate(details.getDate());
        event.setLocation(details.getLocation());
        event.setCapacity(details.getCapacity());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
