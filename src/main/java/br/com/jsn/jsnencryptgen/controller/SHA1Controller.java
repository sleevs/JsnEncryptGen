package br.com.jsn.jsnencryptgen.controller;

import br.com.jsn.jsnencryptgen.service.SHAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api_sha")
public class SHA1Controller {


    private SHAService shaService;
    @Autowired
    public SHA1Controller(SHAService shaService){
        this.shaService = shaService;
    }


    @GetMapping("/sha_160/{password}")
    public String encryptSHA1(@PathVariable String password) {

        return shaService.getSHA1SecurePassword(password, shaService.getSalt());
    }


    @GetMapping("/sha_256/{password}")
    public String encryptSHA256(@PathVariable String password) {

        return shaService.getSHA256SecurePassword(password, shaService.getSalt());
    }


    @GetMapping("/sha_384/{password}")
    public String encryptSHA384(@PathVariable String password) {

        return shaService.getSHA384SecurePassword(password, shaService.getSalt());
    }


    @GetMapping("/sha_512/{password}")
    public String encryptSHA512(@PathVariable String password) {

        return shaService.getSHA512SecurePassword(password, shaService.getSalt());
    }
}
