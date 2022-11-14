/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author stefanini
 */
public class Consultas {

    Connection connection = new Connection();
    JdbcTemplate con = connection.getConnection();

    public boolean logarTotem(String usuario, String senha) {
        try {
            Map<String, Object> registro = con.queryForMap(
                    "select * from totem where usuarioTotem = ? and senhaTotem = ?;", usuario, senha);

            return registro.size() > 1;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

    }
    
    public Map<String, Object> limitesTotem(String id) {
        try {
            Map<String, Object> registro = con.queryForMap(
                    "select limiteProcessador, limiteTemperatura,limiteRam from totem where idTotem = ?", id);

            return registro;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

}
