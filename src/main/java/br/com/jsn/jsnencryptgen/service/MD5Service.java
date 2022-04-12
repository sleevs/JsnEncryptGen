package br.com.jsn.jsnencryptgen.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

@Service
public class MD5Service {


    private static final Logger logger = LogManager.getLogger(MD5Service.class);


    public String getSecurePasswordMD5(String password , String salt){

        String generatedPassword =  null ;

        try {
            logger.info("OPERATION getSecurePasswordMD5()");
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i < bytes.length ; i++){

                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100 , 16).substring(1));
            }
            return generatedPassword = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        return null ;
    }

    public String getSalt(){

        try {
            logger.info("OPERATION getSalt()");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
            byte[] salt = new byte[16];
            secureRandom.nextBytes(salt);
            return salt.toString();
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null ;
    }

}
