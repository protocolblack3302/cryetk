package com.coderme.Library.Services;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.core.GenericSelector;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.io.File;

@Configuration
@Data
public class Beans {

    @Bean
    PasswordEncoder getPassword(){
        return new BCryptPasswordEncoder();
    }

    @Bean
     FileReadingMessageSource fileInboundAdapter(){
        File file = new File(DirectoryProp.directory);
        FileReadingMessageSource fileReadingMessageSource = new FileReadingMessageSource();
        fileReadingMessageSource.setDirectory(file);
        return  fileReadingMessageSource;
    }


    @Bean
    GenericSelector<File> pdfFileSelector(){
        return (source)->source.getName().endsWith(".pdf");
    }


    //we use thymeleaf view resolver if we want our dispatcher servlet to resolve view name of any thymelaf html file
    //we use classloaderTemplate resolver if we want dispatcher servlet  to resolve path for /template

    //changing default template folder path


    @Bean
    public ITemplateResolver getTemplateResolver(){
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/");
        templateResolver.setCacheable(false);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");

        return templateResolver;
    }


}
