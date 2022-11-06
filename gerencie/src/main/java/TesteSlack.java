
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
    
    public static void main(String[] args) throws IOException, InterruptedException {
       
        JSONObject json = new JSONObject();
        
        json.put("text", "Suas notificações no Slack deram certo!");
        
        Slack.sendMessage(json);
        
    }
    
}
