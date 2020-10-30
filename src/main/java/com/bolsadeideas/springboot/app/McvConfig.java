package com.bolsadeideas.springboot.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class McvConfig  implements WebMvcConfigurer {/*
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();
        //Con la siguinte linea se guradaban las imagenes en el dico
        //registry.addResourceHandler("/uploads/**").addResourceLocations("file:/Users/uploads/");
        //Ahora con lo siguiente se guradaran en la direccion del proyecto
        log.info(resourcePath);
        registry.addResourceHandler("/uploads/**").addResourceLocations(resourcePath);
    }*/
}
