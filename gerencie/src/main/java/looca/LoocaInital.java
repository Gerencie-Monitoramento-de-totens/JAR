/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package looca;

import banco.Insercao;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import java.util.List;

/**
 *
 * @author aluno
 */
public class LoocaInital {

    Double usoCPU = 0.0;
    Long emUsoRAM = 00000000000L;//
    Long disponivelRAM = 00000000000L;//
    String idTotem = "";//
    Long usoDoDisco = 00000000000L;//
    Double memoriaRAMTotal = 0.0;//
    Double memoriaDiscoTotal = 0.0;//
    
    public Double getMemoriaRAMTotal() {
        return memoriaRAMTotal;
    }

    public String getIdTotem() {
        return idTotem;
    }

    public Double getUsoCPU() {
        return usoCPU;
    }

    public Long getEmUsoRAM() {
        return emUsoRAM;
    }

    public Long getDisponivelRAM() {
        return disponivelRAM;
    }

    public Long getUsoDoDisco() {
        return usoDoDisco;
    }

    public Double getMemoriaDiscoTotal() {
        return memoriaDiscoTotal;
    }
    
    

    // https://github.com/Britooo/looca-api/blob/main/README.md
    Looca looca = new Looca();

    //sistema
    Sistema sistema = looca.getSistema();
    Sistema loopSistema = looca.getSistema();
    Memoria memoria = looca.getMemoria();
    Memoria loopMemoria = looca.getMemoria();
    Processador processador = looca.getProcessador();
    Processador loopProcessador = looca.getProcessador();
    Temperatura loopTemperatura = looca.getTemperatura();

    Insercao insert = new Insercao();

    void dadosSistema() {
        sistema.getSistemaOperacional();
        //sistema.getFabricante();
        //sistema.getArquitetura();
        //sistema.getPermissao();

        System.out.println(sistema);
    }

    void loopDadosSistema() {
        loopSistema.getInicializado();
        System.out.println(loopSistema);
    }

    //memoria
    void dadosMemoria() {
        memoriaRAMTotal = Double.longBitsToDouble(memoria.getTotal());

        System.out.println(memoria);
    }

    void loopDadosMemoria() {
        emUsoRAM = loopMemoria.getEmUso();
        System.out.println(emUsoRAM);
        disponivelRAM = loopMemoria.getDisponivel();
//        disponivelRAM = Double.longBitsToDouble(loopMemoria.getDisponivel());

        System.out.println(loopMemoria);
    }

    //Processador
    void dadosProcessador() {
        //processador.getFabricante();
        //processador.getNome();
        idTotem = processador.getId();
        //processador.getIdentificador();
        //processador.getMicroarquitetura();
        //processador.getFrequencia();
        //processador.getNumeroPacotesFisicos();
        //processador.getNumeroCpusFisicas();
        //processador.getNumeroCpusLogicas();

        System.out.println(processador);
    }

    void loopDadosProcessador() {
        
        usoCPU = 
        loopProcessador.getUso();
        
        System.out.println(loopProcessador);
        
                emUsoRAM = loopMemoria.getEmUso();
        System.out.println(emUsoRAM);
        disponivelRAM = (loopMemoria.getDisponivel());

        System.out.println(loopMemoria);
    }

    //Temperatura
    void loopDadosTemperatura() {
        loopTemperatura.getTemperatura();

        System.out.println(loopTemperatura);
    }

    //grupo de disco
    void grupoDeDisco() {

        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();

//Obtendo lista de discos a partir do getter
        List<Disco> discos = grupoDeDiscos.getDiscos();

        for(int i = 0; i < discos.size(); i ++ ) {
            memoriaDiscoTotal = Double.longBitsToDouble(discos.get(i).getTamanho());
            usoDoDisco = (discos.get(i).getLeituras());
        }
    }

    public void pegarDados() {
        dadosSistema();
        dadosMemoria();
        dadosProcessador();
        grupoDeDisco();

        insert.alterarTotem( memoriaRAMTotal, memoriaDiscoTotal, idTotem);
    }

    public void loopPegarDados() {
        loopDadosSistema();
        loopDadosMemoria();
        loopDadosProcessador();
        loopDadosTemperatura();

        insert.inserirMetrica(usoCPU, usoDoDisco, emUsoRAM, disponivelRAM, idTotem);

    }
}
