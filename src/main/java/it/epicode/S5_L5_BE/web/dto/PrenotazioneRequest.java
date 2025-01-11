package it.epicode.S5_L5_BE.web.dto;

import it.epicode.S5_L5_BE.db.pojo.Dipendente;
import it.epicode.S5_L5_BE.db.pojo.Viaggio;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PrenotazioneRequest {
    private LocalDate dataPrenotazione;
    private String note;
    private Long dipendenteId;
    private Long viaggioId;
}
