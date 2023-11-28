package com.proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id_producto;
    private String descripcion;
    private String detalle;
    private String categoria;
    private String tipo_de_madera;
    private double precio;
    private int existencias;
    private String imagen;
    private boolean activo;
    
    
    @ManyToOne
    @JoinColumn(name="id_sala")

    Salas salas;
    
   
    public Producto() {
    }

    public Producto(String descripcion, String imagen, boolean activo) {
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.activo = activo;
    }

    
}