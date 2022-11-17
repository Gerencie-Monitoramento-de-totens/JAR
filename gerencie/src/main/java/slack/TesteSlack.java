package slack;

import banco.Insercao;
import java.io.IOException;
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

    /**
     *
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public void mensagemSlack(Double usoCPU, Long usoDoDisco, Long emUsoRAM, Long disponivelRAM, String fkTotem) throws IOException, InterruptedException {

        if (usoCPU > 20.0) {

            json.put("text", "Seu uso de CPU ultrapassou o limite!");

            Slack.sendMessage(json);
        }

        json.put("text", "Tudo está indo bem");

        Slack.sendMessage(json);
    }
}
