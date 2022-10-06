/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;

/**
 *
 * @author aluno
 */
public class LoocaInital {
    // https://github.com/Britooo/looca-api/blob/main/README.md

    Looca looca = new Looca();

    //sistema
    Sistema sistema = looca.getSistema();

    public void pegarDados() {
        dadosSistema();
        dadosMemoria();
        dadosProcessador();
        dadosTemperatura();
    }

    void dadosSistema() {
        sistema.getPermissao();
        sistema.getFabricante();
        sistema.getArquitetura();
        sistema.getInicializado();
        sistema.getSistemaOperacional();

        System.out.println("Sistema: ");
        System.out.println(sistema);
    }

    //memoria
    Memoria memoria = looca.getMemoria();

    void dadosMemoria() {

        memoria.getDisponivel();
        memoria.getTotal();
        memoria.getEmUso();

        System.out.println("Memoria: ");
        System.out.println(memoria);
    }

    //Processador
    Processador processador = looca.getProcessador();

    void dadosProcessador() {
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
    }

    //Temperatura
    Temperatura temperatura = looca.getTemperatura();

    void dadosTemperatura() {
        temperatura.getTemperatura();

        System.out.println("Temperatura: ");
        System.out.println(temperatura);
    }
}
