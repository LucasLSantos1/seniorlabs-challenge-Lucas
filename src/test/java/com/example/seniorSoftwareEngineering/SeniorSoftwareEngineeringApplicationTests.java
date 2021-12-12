package com.example.seniorSoftwareEngineering;

import com.example.seniorSoftwareEngineering.controller.RegistroPontoController;
import com.example.seniorSoftwareEngineering.model.RegistroPonto;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SeniorSoftwareEngineeringApplicationTests {
	RegistroPontoController controllerTeste = new RegistroPontoController();
	@Test
	void contextLoads() throws JSONException {
		String registroJsonString = "{\"employeeId\":\"  123  \",\"employerId\":\" 234 \"} ";
		JSONObject registroTesteJSON = new JSONObject(controllerTeste.salvar("{employeeId"+":"+ 8717+", " +"employerId"+":"+ 134+"}" ));

		assertThat(registroTesteJSON.get("employeeId").equals("8717"));
		assertThat(registroTesteJSON.get("employeeId").equals("134"));
		assertThat(registroTesteJSON.get("includedAt")!=null);
	}

}
