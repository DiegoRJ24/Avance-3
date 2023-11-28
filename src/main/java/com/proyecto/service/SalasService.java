
package com.proyecto.service;

import com.proyecto.domain.Salas;
import java.util.List;

public interface SalasService {

    // El siguiente metodo retorna una lista con las salass 
    //que estan en la tabla salas,todas o solo los activos
    public List<Salas>getSalass(boolean activos);
    
    //Aca siguen los metodos para hacer un CRUD de la tabla salas
    
     // Se obtiene un Salas, a partir del id de un salas
    public Salas getSalas(Salas salas);
    
    // Se inserta un nuevo salas si el id del salas esta vacío
    // Se actualiza un salas si el id del salas NO esta vacío
    public void save(Salas salas);
    
    // Se elimina el salas que tiene el id pasado por parámetro
    public void delete(Salas salas);
    
}
