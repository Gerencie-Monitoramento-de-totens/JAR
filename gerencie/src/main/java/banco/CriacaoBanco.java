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
                + "nomeEmpresa varchar(35),"
                + "telefone char(15),"
                + "cepEmpresa varchar(20),"
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
                + "tipo int, constraint chkTipo check(tipo in (1, 2, 3)),"
                + "fkFuncionario INT,"
                + "FOREIGN KEY (fkFuncionario) REFERENCES usuario(idUsuario),"
                + "fkEmpresa INT,"
                + "FOREIGN KEY (fkEmpresa) REFERENCES empresa(idEmpresa)"
                + ");"
        );

        con.execute(
                "create table if not exists  fastfood("
                + "idFastFood int primary key auto_increment,"
                + "nomeFastFood varchar(35),"
                + "logradouro varchar(60),"
                + "bairro varchar(35),"
                + "CEP char(9),"
                + "CNPJ CHAR(18),"
                + "email varchar(45),"
                + "telefone char(15)"
                + ");"
        );

        con.execute(
                "create table if not exists  totem("
                + "idTotem int primary key auto_increment,"
                + "memoriaRAMTotal double,"
                + "memoriaDiscoTotal double,"
                + "fkEmpresa INT,"
                + "FOREIGN KEY (fkEmpresa) REFERENCES empresa(idEmpresa),"
                + "fkFastFood INT,"
                + "FOREIGN KEY (fkFastFood) REFERENCES fastFood(idfastFood)"
                + ");"
        );

        con.execute(
                "create table if not exists  metrica("
                + "idMetrica int primary key auto_increment,"
                + "tempoDeAtividade timestamp,"
                + "usoDoDisco longvarchar,"
                + "usoCPU Double,"
                + "emUsoRAM  longvarchar,"
                + "disponivelRAM longvarchar,"
                + "fkTotem INT,"
                + "FOREIGN KEY (fkTotem) REFERENCES totem(idTotem)"
                + ");"
        );

    }

}
