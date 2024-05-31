package br.com.jsn.jsnencryptgen.dto;



public class AESDto {
    

    private String key;
    private String encrypt;
    private String decrypt;
    private String message;

    public AESDto(){}

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getDecrypt() {
        return decrypt;
    }

    public void setDecrypt(String decrypt) {
        this.decrypt = decrypt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AESDto [key=" + key + ",Message Encrypted=" + encrypt + ", Message Decrypted=" + decrypt + "]";
    }

    
}
