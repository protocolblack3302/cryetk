package com.coderme.Library.Domains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Component
public class SearchObject {
    @NotBlank @Min(value=3,message = " please search a string > 3")
    private String searchString;

}
