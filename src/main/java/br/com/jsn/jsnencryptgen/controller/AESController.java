package br.com.jsn.jsnencryptgen.controller;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsn.jsnencryptgen.dto.AESDto;
import br.com.jsn.jsnencryptgen.service.AESService;

@RestController
@RequestMapping("/api_aes")
public class AESController {

    @Autowired
    AESService aesService;

    @GetMapping("/aes/{message}")
    public ResponseEntity<AESDto> generateModel(@PathVariable String message) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        
        AESDto aesDto = aesService.createModel(message);
        
        return ResponseEntity.ok(aesDto);
    }


    
}
