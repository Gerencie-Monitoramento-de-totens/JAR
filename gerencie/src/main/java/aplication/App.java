/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplication;

import swing.LoginJava;
import looca.LoocaInital;

/**
 *
 * @author Rossi
 */
public class App {

    public static void main(String[] args) {
        

        //java swing
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginJava().setVisible(true);
            }
        });

        LoocaInital lc = new LoocaInital();
        lc.pegarDados();
    }
}