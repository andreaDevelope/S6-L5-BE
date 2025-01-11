package it.epicode.S5_L5_BE.db.serv;

import it.epicode.S5_L5_BE.db.pojo.Avatar;
import it.epicode.S5_L5_BE.db.pojo.Dipendente;
import it.epicode.S5_L5_BE.db.repo.AvatarRepo;
import it.epicode.S5_L5_BE.db.repo.DipendenteRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvatarServ {

    @Autowired
    private AvatarRepo avatarRepo;

    @Autowired
    private DipendenteRepo dipendenteRepo;

    public Avatar save(Avatar avatar, Long dipendenteId) {
        Dipendente dipendente = dipendenteRepo.findById(dipendenteId)
                .orElseThrow(() -> new EntityNotFoundException("Dipendente non trovato con ID: " + dipendenteId));

        Avatar savedAvatar = avatarRepo.save(avatar);

        dipendente.setAvatar(savedAvatar);
        dipendenteRepo.save(dipendente);

        return savedAvatar;
    }
}
