/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplication;

import banco.CriacaoBanco;
import swing.TelaLoginn;

/**
 *
 * @author Rossi
 */
public class App {

    public static void main(String[] args) {

        TelaLoginn log = new TelaLoginn();
        log.show();
        CriacaoBanco banc = new CriacaoBanco();
        
        banc.criarBanco();
       

    }
}
