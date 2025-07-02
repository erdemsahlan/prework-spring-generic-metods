package com.preworkgenericmethods.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.setBasePath("/api");
        config.setDefaultPageSize(20);
        config.setMaxPageSize(100);
        config.setReturnBodyOnCreate(true);
        config.setReturnBodyOnUpdate(true);
    }
}
// sakıncaları web tarafında bizi baya yorabilir. tek tek komut yazmamız gerekecek ilişkili tablolar için vs.
//http://localhost:8080/api/students/1 http put
//
//{
//        "firstName": "Erdem",
//        "lastName": "Şahlan",
//        "marks": "95",
//        "active": true,
//        "department": "/departments/2"
//        }