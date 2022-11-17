/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Rossi
 */
public class Insercao {

    Connection connection = new Connection();
    JdbcTemplate con = connection.getConnection();

    public void inserirMetrica( Long emUsoRAM, Long disponivelRAM, Double usoProcessador,Double temperatura, String idTotem) {
        // Ou passar diretamente dentro do método
        // exemplo:
        con.update("INSERT INTO metrica ( dtInicializado, usoRAM, disponivelRAM,usoProcessador, temperatura, fkTotem) VALUES ( NOW(), ?, ?, ?,?,?);",
                  emUsoRAM, disponivelRAM, usoProcessador, temperatura, idTotem);
    }

    public void alterarTotem( Long memoriaRAMTotal, String IdTotem) {
        
        
        con.update("UPDATE totem set memoriaRAMTotal = ? WHERE idTotem = ?;"
            ,  memoriaRAMTotal, IdTotem);
    }
    
    public void reiniciarTotem( String IdTotem) {
        
        
        con.update("UPDATE totem set isAtivoTotem = 't' WHERE idTotem = ?;"
            ,  IdTotem);
    }

}
