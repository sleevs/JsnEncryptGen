package br.com.jsn.jsnencryptgen.controller;

import br.com.jsn.jsnencryptgen.service.SHAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> encryptSHA1(@PathVariable String password) {

        String sha1Response = shaService.getSHA1SecurePassword(password, shaService.getSalt());
        return ResponseEntity.ok(sha1Response);
    }


    @GetMapping("/sha_256/{password}")
    public ResponseEntity<String> encryptSHA256(@PathVariable String password) {

        String sha256Response = shaService.getSHA256SecurePassword(password, shaService.getSalt());
        return ResponseEntity.ok(sha256Response);
    }


    @GetMapping("/sha_384/{password}")
    public ResponseEntity<String> encryptSHA384(@PathVariable String password) {

        String sha384Response = shaService.getSHA384SecurePassword(password, shaService.getSalt());
        return ResponseEntity.ok(sha384Response);
    }


    @GetMapping("/sha_512/{password}")
    public ResponseEntity<String> encryptSHA512(@PathVariable String password) {

        String sha512Response = shaService.getSHA512SecurePassword(password, shaService.getSalt());
        return ResponseEntity.ok(sha512Response);
    }
}
