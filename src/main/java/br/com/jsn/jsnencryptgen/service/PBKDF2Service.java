package br.com.jsn.jsnencryptgen.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LoggingException;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;



/*
 * Password-Based Key Derivation Function 1 and 2
 * are key derivation functions with a sliding computational cost, used to reduce vulnerabilities of brute-force attacks.
 * */

@Service
public class PBKDF2Service {


    private static final Logger logger = LogManager.getLogger(PBKDF2Service.class);




    public String generateStrongPasswordHash(String senha){

        try {

            logger.info("OPERATION generateStrongPasswordHash()");
            int interation = 100000;
            char[] chars = senha.toCharArray();
            byte[] salt = getSalt();

            PBEKeySpec spec = new PBEKeySpec(chars , salt , interation , 64 * 8 );

            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = skf.generateSecret(spec).getEncoded();
            return  interation + ":" + toHex(salt) + ":" + toHex(hash);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }


        return null ;
    }

    public String toHex(byte[] array){

        logger.info("OPERATION toHex()");
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);

        int paddingLength = (array.length * 2 ) - hex.length();

        if(paddingLength > 0){
            return String.format("%0" + paddingLength + "d" ,0) + hex ;
        }else{
            return  hex ;
        }


    }



    public byte[] getSalt(){

        try {
            logger.info("OPERATION getSalt()");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[16];
            secureRandom.nextBytes(salt);
            return salt ;
        } catch (NoSuchAlgorithmException e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }
        return null ;
    }
}
