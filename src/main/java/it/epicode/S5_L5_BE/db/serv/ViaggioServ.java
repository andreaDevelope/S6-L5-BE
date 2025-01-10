package it.epicode.S5_L5_BE.db.serv;

import it.epicode.S5_L5_BE.db.pojo.Viaggio;
import it.epicode.S5_L5_BE.db.repo.ViaggioRepo;
import it.epicode.S5_L5_BE.web.dto.ViaggioRequest;
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

    public Viaggio saveViaggio (ViaggioRequest newV){
        Viaggio v = new Viaggio();
        BeanUtils.copyProperties(newV, v);

        return vr.save(v);
    }
}
