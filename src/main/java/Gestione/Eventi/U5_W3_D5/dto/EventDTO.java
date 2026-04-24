package Gestione.Eventi.U5_W3_D5.dto;

import java.time.LocalDate;

public record EventDTO(
        String title,
        String description,
        LocalDate date,
        String location,
        Long capacity
) {}
