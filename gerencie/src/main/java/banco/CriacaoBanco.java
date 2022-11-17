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
public class CriacaoBanco {

    Connection connection = new Connection();
    JdbcTemplate con = connection.getConnection();

    public void criarBanco() {

        con.execute(
                "create table if not exists empresa("
                + "idEmpresa int primary key auto_increment,"
                + "nomeEmpresa varchar(45),"
                + "telefone char(15),"
                + "cepEmpresa char(9),"
                + "CNPJ char(18)"
                + ");"
        );

        con.execute(
                "create table if not exists  usuario("
                + "idUsuario int primary key auto_increment,"
                + "nomeCompleto varchar(60),"
                + "nomeUser varchar(25),"
                + "CPF char(14),"
                + "email varchar(40),"
                + "senha varchar(20),"
                + "telefone char(15),"
                + "isAtivo char(1),"
                + "tipoUsu int, constraint chkTipo check(tipoUsu in (1, 2, 3)),"
                + "fkFuncionario INT,"
                + "FOREIGN KEY (fkFuncionario) REFERENCES usuario(idUsuario),"
                + "fkEmpresa INT,"
                + "FOREIGN KEY (fkEmpresa) REFERENCES empresa(idEmpresa)"
                + ");"
        );

        con.execute(
                "create table if not exists  fastFood("
                + "idFastFood int primary key auto_increment,"
                + "nomeFastFood varchar(35),"
                + "CEP char(9),"
                + "CNPJ CHAR(18),"
                + "telefone char(15),"
                + "isAtivoFastFood char(1),"
                + "fkEmpresa INT,"
                + "FOREIGN KEY (fkEmpresa) REFERENCES empresa(idEmpresa)"
                + ");"
        );

        con.execute(
                "create table if not exists  totem("
                + "idTotem int primary key auto_increment,"
                + "usuarioTotem varchar(40),"
                + "senhaTotem varchar(20),"
                + "sistemaOperacional varchar(45),"
                + "memoriaRAMTotal double,"
                + "limiteProcessador int,"
                + "limiteTemperatura int,"
                + "limiteRam int,"
                + "isAtivoTotem char(1),"
                + "FOREIGN KEY (fkFastFood) REFERENCES fastFood(idFastFood)"
                + ");"
        );

        con.execute(
                "create table if not exists comandos("
                + "idComando int primary key auto_increment,"
                + "dtHora datetime,"
                + "comandoExecutado varchar(40),"
                + "fkTotem varchar(20),"
                + "FOREIGN KEY (fkTotem) REFERENCES totem(idTotem),"
                + "fkUsuario INT,"
                + "FOREIGN KEY (fkUsuario) REFERENCES usuario(idUsuario)"
                + ");"
        );

        con.execute(
                "create table if not exists  metrica("
                + "idMetrica int primary key auto_increment,"
                + "dtInicializado datetime,"
                + "UsoRAM  double,"
                + "disponivelRAM double,"
                + "usoProcessador int,"
                + "disponivelProcessador int,"
                + "temperatura int,"
                + "fkTotem INT,"
                + "FOREIGN KEY (fkTotem) REFERENCES totem(idTotem)"
                + ");"
        );

    }

}
