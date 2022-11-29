package slack;

import banco.Consultas;
import banco.Insercao;
import java.io.IOException;
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

    /**
     *
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public void mensagemSlack(Double usoCPU, Long emUsoRAM, Long disponivelRAM, String fkTotem) throws IOException, InterruptedException {
        Map<String, Object> limites = consulta.limitesTotem(fkTotem);

        Double limiteP = new Double(limites.get("limiteProcessador").toString());
        Double limiteT = new Double(limites.get("limiteTemperatura").toString());
        Double limiteR = new Double(limites.get("limiteRam").toString());

        System.out.println(limites.get("limiteProcessador"));
        System.out.println(limites.get("limiteTemperatura"));
        System.out.println(limites.get("limiteRam"));

        if (usoCPU > limiteP) {

            json.put("text", "Seu uso de CPU ultrapassou o limite!");

            Slack.sendMessage(json);
            logs.logCPU(logs.getLista());
        }
        if (emUsoRAM > limiteR) {

            json.put("text", "Seu uso de RAM ultrapassou o limite!");

            Slack.sendMessage(json);
            logs.logCPU(logs.getLista());
        }

        json.put("text", "Tudo está indo bem");

        Slack.sendMessage(json);
    }
}
