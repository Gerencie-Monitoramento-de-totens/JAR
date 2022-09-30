/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerencie;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import java.util.List;

/**
 *
 * @author aluno
 */
public class App {

    public static void main(String[] args) {
        // https://github.com/Britooo/looca-api/blob/main/README.md
        Looca looca = new Looca();

        //sistema
        Sistema sistema = looca.getSistema();

        sistema.getPermissao();
        sistema.getFabricante();
        sistema.getArquitetura();
        sistema.getInicializado();
        sistema.getSistemaOperacional();

        System.out.println("Sistema: ");
        System.out.println(sistema);

        //memoria
        Memoria memoria = looca.getMemoria();
        
        memoria.getDisponivel();
        memoria.getTotal();
        memoria.getEmUso();
        
        
        System.out.println("Memoria: ");
        System.out.println(memoria);
        
        //Processador
        Processador processador = looca.getProcessador();
        
        processador.getFabricante();
        processador.getNome();
        processador.getId();
        processador.getIdentificador();
        processador.getMicroarquitetura();
        processador.getFrequencia();
        processador.getNumeroPacotesFisicos();
        processador.getNumeroCpusFisicas();
        processador.getNumeroCpusLogicas();
        processador.getUso();
        
        System.out.println("Processador: ");
        System.out.println(processador);

        //Temperatura
        Temperatura temperatura = looca.getTemperatura();
        
        temperatura.getTemperatura();
        
        System.out.println("Temperatura: ");
        System.out.println(temperatura);

        

    }
}
