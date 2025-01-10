package it.epicode.S5_L5_BE.db.serv;

import it.epicode.S5_L5_BE.db.pojo.Dipendente;
import it.epicode.S5_L5_BE.db.repo.DipendenteRepo;
import it.epicode.S5_L5_BE.web.dto.DipendenteRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteServ {
    @Autowired
    DipendenteRepo dr;

    public List<Dipendente> findAll(){
        return dr.findAll();
    }

    public Dipendente save(DipendenteRequest newD){
        Dipendente d = new Dipendente();
        BeanUtils.copyProperties(newD, d);

        return dr.save(d);
    }
}
