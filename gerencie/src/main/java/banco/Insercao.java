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

    public void inserirMetrica(Double usoCPU,Double usoDoDisco, Double emUsoRAM, Double disponivelRAM, String fkTotem) {
        // Ou passar diretamente dentro do método
        // exemplo:
        con.update("INSERT INTO metrica (usoCPU,usoDoDisco, emUsoRAM, disponivelRAM, fkTotem) VALUES (?, ?, ?, ?, ?);",
                 usoCPU,usoDoDisco, emUsoRAM, disponivelRAM, 1);
    }

    public void alterarTotem( Double memoriaRAMTotal, Double memoriaDiscoTotal, String IdTotem) {
        // Ou passar diretamente dentro do método
        // exemplo:
        con.update("INSERT INTO empresa (idEmpresa) VALUES (?);",
                1);
        
        con.update("INSERT INTO fastfood (idFastFood) VALUES ( ?);",
                1);
        
        con.update("INSERT INTO totem (idTotem,fkEmpresa, fkFastFood) VALUES (?, ?, ?);",
                 1 ,1,1);
        
        con.update("UPDATE totem set memoriaDiscoTotal = ?, memoriaRAMTotal = ? WHERE idTotem = ?;"
            ,  memoriaRAMTotal, memoriaDiscoTotal, 1);
    }

}
