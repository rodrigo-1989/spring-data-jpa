package com.bolsadeideas.springboot.app;

import com.bolsadeideas.springboot.app.models.service.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner {

    @Autowired
    IUploadFileService uploadFileService;

    public static void main(String[] args) {

        SpringApplication.run(SpringBootDataJpaApplication.class, args);
    }
    ///Esto es para eliminar el directorio y recrearlo para empezar de 0
    @Override
    public void run(String... args) throws Exception {
        uploadFileService.deleteAll();
        uploadFileService.init();
    }
}
