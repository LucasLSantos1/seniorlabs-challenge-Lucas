package com.example.seniorSoftwareEngineering.service;

import com.example.seniorSoftwareEngineering.model.RegistroPonto;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class RegistroPontoService {
    public boolean isJSONValid(String jsonInString) {
        try {
            boolean hasEmployeeID = false;
            boolean hasEmployerID = false;
            JSONObject jsonRegistro = new JSONObject(jsonInString);
            if(jsonRegistro.has("employerId")){
                hasEmployerID = true;
            }
            if(jsonRegistro.has("employeeId")){
                hasEmployeeID = true;
            }
            if(hasEmployeeID != true||hasEmployerID!= true){
                return false;
            }else{
                return true;
            }
        } catch ( JSONException e) {
            return false;
        }
    }

    public LocalDateTime setIncludedAt(){
        return LocalDateTime.now();
    }

    public RegistroPonto create(JSONObject  registro) throws JSONException {
        RegistroPonto registroPonto = new RegistroPonto();
        registroPonto.setEmployeeId((int) registro.get("employeeId"));
        registroPonto.setEmployerId(((int) registro.get("employerId")));
        registroPonto.setIncludedAt(this.setIncludedAt());
        return  registroPonto;
    }

}
