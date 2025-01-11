package it.epicode.S5_L5_BE.web.dto;

import it.epicode.S5_L5_BE.enums.Stato;
import lombok.Data;

@Data
public class ViaggioStatoRequest {
    private Stato stato;
}
