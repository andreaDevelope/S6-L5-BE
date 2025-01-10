package it.epicode.S5_L5_BE.db.serv;

import it.epicode.S5_L5_BE.db.pojo.Prenotazione;
import it.epicode.S5_L5_BE.db.repo.PrenotazioneRepo;
import it.epicode.S5_L5_BE.web.dto.PrenotazioneRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneServ {
    @Autowired
    PrenotazioneRepo pr;

    public List<Prenotazione> findAll(){
        return pr.findAll();
    }

    public Prenotazione save (PrenotazioneRequest newP){
        Prenotazione p = new Prenotazione();
        BeanUtils.copyProperties(newP, p);


        return pr.save(p);
    }
}
