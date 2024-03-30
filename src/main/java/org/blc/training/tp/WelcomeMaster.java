/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.blc.training.tp;

import java.util.Scanner;

/**
 *
 * @author patrick.poaty
 */
public class WelcomeMaster {
    
        // Initialisation de variable
        String nom = "";
        String prenom = "";
        String fonction = "";
        
        Util.out("Veuillez inscrire votre nom ? : ");
        Scanner scan = new Scanner(System.in); // Récupère les valeurs inscrite au clavier
        
        Answer = scan.next(); // Stockage d'info récupérée dans la variable 
        
        Util.out("Bienvenu "+ Answer);
}
