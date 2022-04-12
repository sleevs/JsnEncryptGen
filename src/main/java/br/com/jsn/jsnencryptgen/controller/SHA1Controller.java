package br.com.jsn.jsnencryptgen.controller;

import br.com.jsn.jsnencryptgen.service.SHA1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api_sha")
public class SHA1Controller {


    private SHA1Service sha1Service;
    @Autowired
    public SHA1Controller(SHA1Service sha1Service){
        this.sha1Service = sha1Service;
    }


    @GetMapping("/sha1/{password}")
    public String encryptSHA1(@PathVariable String password) {

        return sha1Service.getSHA1SecurePassword(password, sha1Service.getSalt());
    }


    @GetMapping("/SHA256/{password}")
    public String encryptSHA256(@PathVariable String password) {

        return sha1Service.getSHA256SecurePassword(password, sha1Service.getSalt());
    }


    @GetMapping("/SHA384/{password}")
    public String encryptSHA384(@PathVariable String password) {

        return sha1Service.getSHA384SecurePassword(password, sha1Service.getSalt());
    }


    @GetMapping("/SHA512/{password}")
    public String encryptSHA512(@PathVariable String password) {

        return sha1Service.getSHA512SecurePassword(password, sha1Service.getSalt());
    }
}
