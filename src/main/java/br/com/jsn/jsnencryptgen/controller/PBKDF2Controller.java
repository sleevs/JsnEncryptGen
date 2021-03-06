package br.com.jsn.jsnencryptgen.controller;

import br.com.jsn.jsnencryptgen.service.PBKDF2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api_pbkdf2")
public class PBKDF2Controller {

    private PBKDF2Service pBKDF2Service;

    @Autowired
    public PBKDF2Controller(PBKDF2Service pBKDF2Service){
        this.pBKDF2Service= pBKDF2Service ;
    }

    @GetMapping("/pbkdf2/{password}")
    public ResponseEntity<String> encryptPbkdf2(@PathVariable String password) {

        String pbkdf2Response = pBKDF2Service.generateStrongPasswordHash(password);
        return ResponseEntity.ok(pbkdf2Response);
    }


}
