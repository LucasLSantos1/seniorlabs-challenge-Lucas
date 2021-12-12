package com.example.seniorSoftwareEngineering.controller;

import com.example.seniorSoftwareEngineering.EnvioSegundoPlano;
import com.example.seniorSoftwareEngineering.model.RegistroPonto;
import com.example.seniorSoftwareEngineering.service.RegistroPontoService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api-registroPonto/registroPonto")
public class RegistroPontoController {

    @Autowired
    private RegistroPontoService registroPontoService = new RegistroPontoService();

    @PostMapping
    @ResponseBody
    public String salvar(@RequestBody String registroPonto){
        try{

            if(registroPontoService.isJSONValid(registroPonto)){
                JSONObject registroPontoJSON = new JSONObject(registroPonto);
                RegistroPonto registroPontoCreated = registroPontoService.create(registroPontoJSON);
                EnvioSegundoPlano envioSegundoPlano = new EnvioSegundoPlano();
                envioSegundoPlano.setRegistroPonto(registroPontoCreated);
                Thread object = new Thread(envioSegundoPlano);
                object.start();
                String retorno = "{\"employeeId\":\" " + registroPontoCreated.getEmployeeId() + " \",\"employerId\":\"" + registroPontoCreated.getEmployerId() + " \",\"includedAt\":\"" + registroPontoCreated.getIncludedAt() + "\"} ";
                return retorno;
            }else{
                return "Entrada inválida, favor verificar os campos 'employerId'  e 'employeeId'";
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
