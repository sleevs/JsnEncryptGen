package br.com.jsn.jsnencryptgen.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class Base64CodeService
{


    private static final Logger logger = LogManager.getLogger(MD5Service.class);
    public  String encodeBase64(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());

    }

    public  String decodeBase64(String input) {
        return new String(Base64.getDecoder().decode(input.getBytes()));
    }




}
