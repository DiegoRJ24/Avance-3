package com.proyecto.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com#
    final String BucketName = "proyecto-78dd3.appspot.com";

    //Esta es la ruta básica de este proyecto proyecto
    final String rutaSuperiorStorage = "proyecto";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";

    //El nombre del archivo Json
    final String archivoJsonFile = "proyecto-78dd3-firebase-adminsdk-2wdiq-9e583be082.json";
}

