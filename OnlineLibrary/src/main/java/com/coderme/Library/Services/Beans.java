package com.coderme.Library.Services;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.File;

@Configuration
@Data
public class Beans {

    private final DirectoryProp directoryProp;

    @Bean
    PasswordEncoder getPassword(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public FileReadingMessageSource fileInboundAdapter(){
        File file = new File(directoryProp.getDirectory());
        FileReadingMessageSource fileReadingMessageSource = new FileReadingMessageSource();
        fileReadingMessageSource.setDirectory(file);
        return  fileReadingMessageSource;
    }



}
