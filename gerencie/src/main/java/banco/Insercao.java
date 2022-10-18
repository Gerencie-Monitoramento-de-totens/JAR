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

    public void inserirMetrica(Double processosCPU, Double emUsoRAM, Double disponivelRAM, Integer fkTotem) {
        // Ou passar diretamente dentro do método
        // exemplo:
        con.update("INSERT INTO metrica VALUES (?, ?, ?, ?, ?)",
                null, processosCPU, emUsoRAM, disponivelRAM, fkTotem);
    }

    public void alterarTotem(Double capacidadeDisco, Double usoDoDisco, Double memoriaRAMTotal, Double memoriaDiscoTotal, Integer threadsTotal, Double nucleosTotal) {
        // Ou passar diretamente dentro do método
        // exemplo:
        con.update("INSERT INTO metrica VALUES (?, ?, ?, ?, ?, ?)"
            ,capacidadeDisco, usoDoDisco, memoriaRAMTotal, memoriaDiscoTotal, threadsTotal, nucleosTotal);
    }

}
