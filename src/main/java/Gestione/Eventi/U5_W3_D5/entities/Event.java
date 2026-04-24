package Gestione.Eventi.U5_W3_D5.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate date;
    private String location;
    private Long capacity;
    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;
    @OneToMany(mappedBy = "event")
    private List<Booking> bookings;
}