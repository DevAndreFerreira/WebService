package br.com.estudo.webservice;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GeralErroDto {

    private List<String> errors = new ArrayList<String>();

}
