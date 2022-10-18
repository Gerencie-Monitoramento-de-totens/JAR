/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package looca;

import banco.Insercao;
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
    Sistema loopSistema = looca.getSistema();

    void dadosSistema() {
        sistema.getSistemaOperacional();
        sistema.getFabricante();
        sistema.getArquitetura();
        sistema.getPermissao();

        System.out.println(sistema);
    }

    void loopDadosSistema() {
        loopSistema.getInicializado();
        System.out.println(loopSistema);
    }

    //memoria
    Memoria memoria = looca.getMemoria();
    Memoria loopMemoria = looca.getMemoria();

    void dadosMemoria() {
        memoria.getTotal();

        System.out.println(memoria);
    }

    void loopDadosMemoria() {
        loopMemoria.getEmUso();
        loopMemoria.getDisponivel();

        System.out.println(loopMemoria);
    }

    //Processador
    Processador processador = looca.getProcessador();
    Processador loopProcessador = looca.getProcessador();

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

        System.out.println(processador);
    }

    void loopDadosProcessador() {
        loopProcessador.getUso();
        System.out.println(loopProcessador);
    }

    //Temperatura
    Temperatura loopTemperatura = looca.getTemperatura();

    void loopDadosTemperatura() {
        loopTemperatura.getTemperatura();

        System.out.println(loopTemperatura);
    }

    public void pegarDados() {
        dadosSistema();
        dadosMemoria();
        dadosProcessador();
    }

    public void loopPegarDados() {
        loopDadosSistema();
        loopDadosMemoria();
        loopDadosProcessador();
        loopDadosTemperatura();

    }
    
    Insercao insert = new Insercao();
    
    public void inserindoDados(Double processosCPU, Double emUsoRAM, Double disponivelRAM, Integer fkTotem, Double capacidadeDisco, Double usoDoDisco, Double memoriaRAMTotal, Double memoriaDiscoTotal, Integer threadsTotal, Double nucleosTotal){
        insert.inserirMetrica(processosCPU, emUsoRAM, disponivelRAM, fkTotem);
        insert.alterarTotem(capacidadeDisco, usoDoDisco, memoriaRAMTotal, memoriaDiscoTotal, threadsTotal, nucleosTotal);
    }
}
