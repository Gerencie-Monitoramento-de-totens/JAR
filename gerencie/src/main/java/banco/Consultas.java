/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author stefanini
 */
public class Consultas {

    Connection connection = new Connection();
    JdbcTemplate con = connection.getConnection();

    public ResultSet logarTotem(String usuario,String senha) {
        Looca looca = new Looca();
        Processador processador = looca.getProcessador();
        String id = processador.getId();
        
        Statement executor = con.createStatement();
        String comando = "select * from Totem where idTotem = " + id 
            + "and usuarioTotem ="+ usuario +" and senhaTotem = " + senha  + ";";
        
        
        
        ResultSet isAvaible = executor.executeQuery(comando);
        return isAvaible;
    }

}
