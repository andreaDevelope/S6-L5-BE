package it.epicode.S5_L5_BE.web.dto;

import it.epicode.S5_L5_BE.enums.Stato;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ViaggioRequest {

    private String destinazione;

    private LocalDate data;

    private Stato stato;
}
