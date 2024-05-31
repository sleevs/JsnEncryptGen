package br.com.jsn.jsnencryptgen.service;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import br.com.jsn.jsnencryptgen.dto.AESDto;

@Service
public class AESService {


    public AESDto createModel(String message) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{

        AESDto aesDto = new AESDto();
        SecretKey key = generateKey();
        byte [] encryptValue = encrypt(message.getBytes(), key);
        byte [] decryptValue  = decrypt(encryptValue, key);
        aesDto.setEncrypt(new String(encryptValue));
        aesDto.setKey(key.getEncoded().toString());
        aesDto.setMessage(message);
        aesDto.setDecrypt(new String(decryptValue));

        return aesDto;
    }

    public SecretKey generateKey(){

        try{
            KeyGenerator key=  KeyGenerator.getInstance("AES");
            key.init(256);
            SecretKey resultKey = key.generateKey();
            return resultKey;
        }catch(Exception e){
            e.getMessage();
        }

        return null;
    }



    public byte[] encrypt(byte[] message , SecretKey key)throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{


        try{
            
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,key ,iv);
          
            return cipher.doFinal(message);
        }catch(Exception e){
            e.getMessage();
        }
        return null ;
    }


    public byte[] decrypt(byte[] message , SecretKey chave ) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException{

        IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
        SecretKeySpec secretKeySpec = new SecretKeySpec(chave.getEncoded(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec , iv);
        
        return cipher.doFinal(message);

    }

    
}
