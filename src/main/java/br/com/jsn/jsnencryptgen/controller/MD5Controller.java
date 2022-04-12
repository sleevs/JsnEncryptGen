package br.com.jsn.jsnencryptgen.controller;


import br.com.jsn.jsnencryptgen.service.BasicMD5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/md5_api")
public class MD5Controller {


    private BasicMD5Service basicMD5Service ;

    @Autowired
    public MD5Controller (BasicMD5Service basicMD5Service){
        this.basicMD5Service = basicMD5Service;
    }


    @GetMapping("/md5/{password}")
    public String genMD5(@PathVariable String password) {
        String encrypt  =basicMD5Service.getSecurePasswordMD5(password, basicMD5Service.getSalt());


        return encrypt;
    }
}
