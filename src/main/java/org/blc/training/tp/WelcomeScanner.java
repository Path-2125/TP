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
public class WelcomeScanner {
    
    
    public static void main (String [] agr){
        
        String Answer = ""; // Initialisation de variable 
        
        Util.out("Veuillez saisir votre non, s'il vous plait ? : "); // Fonction qui permet de réduire la syntaxe de la fonction d'affichage
        
        Scanner scan = new Scanner(System.in); // Récupère les valeurs inscrite au clavier
        
        Answer = scan.next(); // Stockage d'info récupérée dans la variable 
        
        Util.out("Bienvenu "+ Answer);
        
    }
    
    
}
