package br.com.estudo.webservice.shared;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utils {

    public String generatedUserIDd() {
        return UUID.randomUUID().toString();
    }

}
