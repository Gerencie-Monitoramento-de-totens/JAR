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
import java.io.IOException;
import java.util.List;
import slack.TesteSlack;

/**
 *
 * @author aluno
 */
public class LoocaInital {

    Double usoProcessador = 0.0;
    Long emUsoRAM = 00000000000L;//
    Long disponivelRAM = 00000000000L;//
    String idTotem = "";//
    Long memoriaRAMTotal = 0000000000L;//
    Double temperatura = 0.0;
    String sistemaOperacional = "";

    public Long getMemoriaRAMTotal() {
        return memoriaRAMTotal;
    }

    public String getIdTotem() {
        return idTotem;
    }

    public Double getUsoProcessador() {
        return usoProcessador;
    }

    public Long getEmUsoRAM() {
        return emUsoRAM;
    }

    public Long getDisponivelRAM() {
        return disponivelRAM;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public Double getTemperatura() {
        return temperatura;
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
    TesteSlack mensagem = new TesteSlack();

    void dadosSistema() {
        sistemaOperacional = sistema.getSistemaOperacional();
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
        memoriaRAMTotal = (memoria.getTotal());

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

        usoProcessador = loopProcessador.getUso();

        System.out.println(loopProcessador);


        System.out.println(loopMemoria);
    }

    //Temperatura
    void loopDadosTemperatura() {
        temperatura = loopTemperatura.getTemperatura();

        System.out.println(loopTemperatura);
    }

   

    public void pegarDados() {
        dadosSistema();
        dadosMemoria();
        dadosProcessador();

        insert.alterarTotem(sistemaOperacional ,memoriaRAMTotal, idTotem);
    }

    public void loopPegarDados() throws IOException, InterruptedException {
        loopDadosSistema();
        loopDadosMemoria();
        loopDadosProcessador();
        loopDadosTemperatura();
        
        Long utilizadoRAM = emUsoRAM / 1000000000;
        Long ramDisponivel = disponivelRAM / 1000000000;

        insert.inserirMetrica( utilizadoRAM, ramDisponivel, usoProcessador, temperatura, idTotem);
        mensagem.mensagemSlack(usoProcessador,emUsoRAM,disponivelRAM,idTotem);

        //poderiamos criar dentro do slack select do banco, porem isso consumiria coisas desnecessarias
        // ***
        // tambem poderiamos chamar esses metodos de pegar dados no slack, podendo gerar conflitos por n??o pegar os mesmos dados, supercarregar a api ou inserir dois dados iguais no banco
        //***
        // como vamos fazer: 
        //podemos chamar o slack aqui passando como argumento os mesmos dados que vamos inserir no banco
        // com isso garantimos que a cada chamada do slack as valida????es v??o ser dos dados atuais
        // ap??s isso criamos no slack uma fun????o que valida dados por dados para saber se gera ou n??o o aviso
        // enviamos o aviso
        // *** 
        // pontos a serem lembrados
        //aonde vamos fazer o select da tabela totem para saber ou n??o se est?? em aviso ser?? dentro do slack
        // ?? nos slack que vamos faer a altera????o do campo do totem de aviso e a hora (ultimo aviso)
        // fazer valida????o para saber quando foi o ultimo aviso desse totem e gerar aviso novamente se nescessario
        //o metodo de preferencia tem q ser void
        //n??o se esquecam de chamar dentro do metodo o select
        // criem um aviso pra cada limite
        //deixem somente uma classe parara conexao e uma para os avisos
        //renomeiem o pacote 
        //renomeiem as classes para melhor manutencao
        // *** brilhem meninos *** 
    }
}
