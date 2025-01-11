package it.epicode.S5_L5_BE.db.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imageUrl;
}
