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
                "create table empresa("
                + "idEmpresa int primary key auto_increment,"
                + "nomeEmpresa varchar(35),"
                + "telefone char(15),"
                + "cepEmpresa varchar(20),"
                + "CNPJ char(18)"
                + ");"
        );

        con.execute(
                "create table usuario("
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
                + "FOREIGN KEY (fkEmpresa) REFERENCES usuario(idUsuario)"
                + ");"
        );

        con.execute(
                "create table fastfood("
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
                "create table totem("
                + "idTotem int primary key auto_increment,"
                + "capacidadeDisco double,"
                + "usoDoDisco double,"
                + "memoriaRAMTotal double,"
                + "memoriaDiscoTotal double,"
                + "threadsTotal int,"
                + "nucleosTotal double,"
                + "fkEmpresa INT,"
                + "FOREIGN KEY (fkEmpresa) REFERENCES totem(idTotem),"
                + "fkFastFood INT,"
                + "FOREIGN KEY (fkFastFood) REFERENCES totem(idTotem)"
                + ");"
        );

        con.execute(
                "create table metrica("
                + "idMetrica int primary key auto_increment,"
                + "tempoDeAtividade timestamp,"
                + "processosCPU double,"
                + "emUsoRAM  double,"
                + "disponivelRAM double,"
                + "fkTotem INT,"
                + "FOREIGN KEY (fkTotem) REFERENCES metrica(idMetrica)"
                + ");"
        );

    }

}
