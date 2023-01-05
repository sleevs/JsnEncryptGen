package br.com.jsn.jsnencryptgen.controller;

import br.com.jsn.jsnencryptgen.service.Base64CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api_base64")
public class Base64CodeController {


    @Autowired
    private Base64CodeService base64CodeService;



    @GetMapping("/encode_base64/{password}")
    public String encondeBase64(@PathVariable String password){
        return base64CodeService.encodeBase64(password) ;
    }



    @GetMapping("/decode_base64/{key}")
    public String decondeBase64(@PathVariable String key){
        return base64CodeService.encodeBase64(key) ;
    }
}
