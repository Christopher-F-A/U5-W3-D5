package Gestione.Eventi.U5_W3_D5.controllers;

import Gestione.Eventi.U5_W3_D5.dto.EventDTO;
import Gestione.Eventi.U5_W3_D5.entities.Event;
import Gestione.Eventi.U5_W3_D5.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody EventDTO eventDTO) {
        System.out.println("Evento creato con successo: " + eventDTO.title());
        return eventService.saveEvent(eventDTO);
    }

    @GetMapping
    public List<EventDTO> getAllEvents() {
        System.out.println("Lista eventi ricevuta");
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        return ResponseEntity.ok(eventService.updateEvent(id, eventDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Evento eliminato con successo");
    }
}
