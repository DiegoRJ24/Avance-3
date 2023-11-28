package com.proyecto.service.impl;

import com.proyecto.dao.SalasDao;
import com.proyecto.domain.Salas;
import com.proyecto.service.SalasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalasServiceImpl implements SalasService {

   //La anotacion autowired crea un unico objeto sin hacer new.
    @Autowired
    private SalasDao salasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Salas> getSalass(boolean activos) {
        var lista = salasDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Salas getSalas(Salas salas) {
        return salasDao.findById(salas.getId_sala()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Salas salas) {
        salasDao.save(salas);
    }

    @Override
    @Transactional
    public void delete(Salas salas) {
        salasDao.delete(salas);
    }
}
