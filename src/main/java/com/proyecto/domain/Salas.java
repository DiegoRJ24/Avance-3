package com.proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "salas")
public class Salas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sala")
    private Long id_sala;  // Cambiado de int a Long
    private String descripcion;
    private String imagen;
    private String categoria;
    private String tipo_de_madera;
    private boolean activo;
    
    
    @OneToMany
    @JoinColumn(name="id_sala")
    List<Producto> productos;
    public Salas(){
    

    
    
    }
    
    
    
     // Constructor sin argumentos
    public Salas(String descripcion, String imagen, boolean activo) {
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.activo = activo;
    }
}