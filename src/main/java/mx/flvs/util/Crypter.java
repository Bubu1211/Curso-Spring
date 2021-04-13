package mx.flvs.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Crypter {
    
    public static void main(String[] args) {
        var pass = "skerexd";
        System.out.println("Contraseña: "+encriptarContraseña(pass));
    }
    
    public static String encriptarContraseña(String password){
        var encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
