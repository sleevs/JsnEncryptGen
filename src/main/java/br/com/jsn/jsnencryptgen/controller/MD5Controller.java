package br.com.jsn.jsnencryptgen.controller;


import br.com.jsn.jsnencryptgen.service.MD5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api_md5")
public class MD5Controller {


    private MD5Service MD5Service;

    @Autowired
    public MD5Controller (MD5Service MD5Service){
        this.MD5Service = MD5Service;
    }


    @GetMapping("/md5/{password}")
    public String encryptMD5(@PathVariable String password) {
        String encrypt  = MD5Service.getSecurePasswordMD5(password, MD5Service.getSalt());


        return encrypt;
    }


}
