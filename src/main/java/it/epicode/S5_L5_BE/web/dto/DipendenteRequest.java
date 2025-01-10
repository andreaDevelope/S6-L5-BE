package it.epicode.S5_L5_BE.web.dto;

import lombok.Data;

@Data
public class DipendenteRequest {
    private String username;

    private String nome;

    private String cognome;

    private String email;
}
