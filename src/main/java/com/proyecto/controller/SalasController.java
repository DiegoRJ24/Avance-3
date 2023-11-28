package com.proyecto.controller;

import com.proyecto.domain.Salas;
import com.proyecto.service.FirebaseStorageService;
import com.proyecto.service.SalasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/salas")
public class SalasController {

    @Autowired
    private SalasService salasService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var salas = salasService.getSalass(false);
        model.addAttribute("salas", salas);
        model.addAttribute("totalSalas", salas.size());
        return "/salas/listado";
    }

    @GetMapping("/nuevo")
    public String salasNuevo(Salas salas) {
        return "/salas/modifica";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String salasGuardar(Salas salas,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            salasService.save(salas);
            salas.setImagen(
                    firebaseStorageService.cargaImagen(imagenFile, "salas", salas.getId_sala()));
                            
                            
            
        }
        salasService.save(salas);
        return "redirect:/salas/listado";
    }

    @GetMapping("/eliminar/{id_sala}")
    public String salasEliminar(Salas salas) {
        salasService.delete(salas);
        return "redirect:/salas/listado";
    }

    @GetMapping("/modificar/{id_sala}")
    public String salasModificar(Salas salas, Model model) {
        salas = salasService.getSalas(salas);
        model.addAttribute("salas", salas);
        return "/salas/modifica";
    }
}
