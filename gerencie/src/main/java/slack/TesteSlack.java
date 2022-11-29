package slack;

import banco.Consultas;
import banco.Insercao;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import org.json.JSONObject;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jvsdi
 */
public class TesteSlack {

    JSONObject json = new JSONObject();
    Insercao dados = new Insercao();
    Log logs = new Log();
    Consultas consulta = new Consultas();

    
    public void mensagemSlack(Double usoCPU, Long emUsoRAM, Long disponivelRAM, String fkTotem) throws IOException, InterruptedException {
        Map<String, Object> limites = consulta.limitesTotem(fkTotem);

        Double limiteP = new Double(limites.get("limiteProcessador").toString());
        Double limiteT = new Double(limites.get("limiteTemperatura").toString());
        Double limiteR = new Double(limites.get("limiteRam").toString());
        LocalDateTime ultimoAlerta = LocalDateTime.now();
        LocalDateTime proximoAlerta = ultimoAlerta.plusMinutes(2);
        
        
        if (Duration.between(ultimoAlerta, proximoAlerta).toMinutes() <= 0) {

            if (usoCPU > limiteP) {

                json.put("text", "Seu uso de CPU ultrapassou o limite!");

                Slack.sendMessage(json);
                logs.logCPU(logs.getLista());
                dados.novoAlerta(fkTotem);
                ultimoAlerta = LocalDateTime.now();
            }
            if (emUsoRAM > limiteR) {

                json.put("text", "Seu uso de RAM ultrapassou o limite!");

                Slack.sendMessage(json);
                logs.logCPU(logs.getLista());
                dados.novoAlerta(fkTotem);
                ultimoAlerta = LocalDateTime.now();
            }
        }

        json.put("text", "Tudo está indo bem");

        Slack.sendMessage(json);
    }
}
