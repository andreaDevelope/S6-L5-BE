package it.epicode.S5_L5_BE.db.serv;

import it.epicode.S5_L5_BE.db.pojo.Dipendente;
import it.epicode.S5_L5_BE.db.pojo.Viaggio;
import it.epicode.S5_L5_BE.db.repo.ViaggioRepo;
import it.epicode.S5_L5_BE.web.dto.DipendenteRequest;
import it.epicode.S5_L5_BE.web.dto.ViaggioRequest;
import it.epicode.S5_L5_BE.web.dto.ViaggioStatoRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaggioServ {
    @Autowired
    ViaggioRepo vr;

    public List<Viaggio> findAll(){
        return  vr.findAll();
    }

    public Viaggio findById(Long id){
        return vr.findById(id).get();
    }

    public Viaggio saveViaggio (ViaggioRequest newV){
        Viaggio v = new Viaggio();
        BeanUtils.copyProperties(newV, v);

        return vr.save(v);
    }

    public Viaggio update (ViaggioRequest newV, Long id){
        Viaggio v = vr.findById(id).get();
        BeanUtils.copyProperties(newV, v);
        return vr.save(v);
    }

    public Viaggio updateStato (Long id, ViaggioStatoRequest newStato){
        Viaggio v = vr.findById(id).get();
        BeanUtils.copyProperties(newStato, v);
        return vr.save(v);
    }

    public Viaggio delete (Long id){
        Viaggio v = vr.findById(id).get();
        vr.delete(v);
        return v;
    }


}
