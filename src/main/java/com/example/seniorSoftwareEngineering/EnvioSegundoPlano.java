package com.example.seniorSoftwareEngineering;
import com.example.seniorSoftwareEngineering.model.RegistroPonto;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;


public class EnvioSegundoPlano implements Runnable{
    private String uRLSistemaLegado = "https://api.mockytonk.com/proxy/ab2198a3-cafd-49d5-8ace-baac64e72222";
    private HttpClient httpClient = HttpClientBuilder.create().build();
    @Getter @Setter private RegistroPonto registroPonto;

    @Override
    public void run() {
        try {
            HttpPost request = new HttpPost(uRLSistemaLegado);
            StringEntity params =new StringEntity("{\"employeeId\":\" " + registroPonto.getEmployeeId() + " \",\"employerId\":\"" + registroPonto.getEmployerId() + " \",\"includedAt\":\"" + registroPonto.getIncludedAt() + "\"} ");
            request.addHeader("content-type", "application/x-www-form-urlencoded");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            System.out.println("A resposta da API é " + response);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
