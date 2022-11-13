
import java.io.IOException;
import looca.LoocaInital;
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
    
    looca.LoocaInital looca = new LoocaInital();
    
    /**
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
       
        
        JSONObject json = new JSONObject();
        
        json.put("text", "Tudo está indo bem");
        
        Slack.sendMessage(json);    
        
        
       // if(looca.getUsoCPU() > 20.0){
            //json.put("text", "A CPU EXCEDEU O LIMITE DE USO!");
           // Slack.sendMessage(json);
            
        
    }   
    
}
