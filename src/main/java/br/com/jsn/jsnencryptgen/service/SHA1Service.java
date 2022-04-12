package br.com.jsn.jsnencryptgen.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class SHA1Service {

    private static final Logger logger = LogManager.getLogger(SHA1Service.class);


    public String getSHA1SecurePassword(String senha , String salt){

        String generatedPassword = null ;

        try{
            logger.info("OPERATION getSHA1SecurePassword()");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(salt.getBytes());
            byte[] bytes = messageDigest.digest(senha.getBytes());

            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i< bytes.length ; i++){

                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100 , 16).substring(1));
            }

            return generatedPassword = sb.toString();

        }catch(NoSuchAlgorithmException e){
            logger.error(e.getMessage());

        }
        return null ;
    }


    public String getSHA256SecurePassword(String senha , String salt){

        String generatedPassword = null ;

        try{
            logger.info("OPERATION getSHA256SecurePassword()");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(salt.getBytes());
            byte[] bytes = messageDigest.digest(senha.getBytes());

            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i< bytes.length ; i++){

                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100 , 16).substring(1));
            }

            return generatedPassword = sb.toString();

        }catch(NoSuchAlgorithmException e){
            logger.error(e.getMessage());

        }
        return null ;
    }


    public String getSHA384SecurePassword(String senha , String salt){

        String generatedPassword = null ;

        try{
            logger.info("OPERATION getSHA384SecurePassword()");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-384");
            messageDigest.update(salt.getBytes());
            byte[] bytes = messageDigest.digest(senha.getBytes());

            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i< bytes.length ; i++){

                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100 , 16).substring(1));
            }

            return generatedPassword = sb.toString();

        }catch(NoSuchAlgorithmException e){
            logger.error(e.getMessage());

        }
        return null ;
    }


    public String getSHA512SecurePassword(String senha , String salt){

        String generatedPassword = null ;

        try{
            logger.info("OPERATION getSHA512SecurePassword()");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(salt.getBytes());
            byte[] bytes = messageDigest.digest(senha.getBytes());

            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i< bytes.length ; i++){

                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100 , 16).substring(1));
            }

            return generatedPassword = sb.toString();

        }catch(NoSuchAlgorithmException e){
            logger.error(e.getMessage());

        }
        return null ;
    }
    public String getSalt(){

        try {
            logger.info("OPERATION getSalt()");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[16];
            secureRandom.nextBytes(salt);
            return salt.toString();
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null ;
    }
}
