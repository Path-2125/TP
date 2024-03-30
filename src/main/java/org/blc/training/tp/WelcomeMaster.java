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
    
    public static void main(String[] arg){
              // Initialisation de variable
        String name = "";
        String lastName = "";
        String function = "";
        
        Util.out("Veuillez inscrire votre nom : ");
        Scanner scan1 = new Scanner(System.in); // Récupère les valeurs inscrite au clavier
        name = scan1.next(); // Stockage d'info récupérée dans la variable
        
        Util.out("Veuillez inscrire votre prénom : ");
        Scanner scan2 = new Scanner(System.in); // Récupère les valeurs inscrite au clavier
        lastName = scan2.next(); // Stockage d'info récupérée dans la variable
        
        Util.out("Veuillez inscrire votre fonction : ");
        Scanner scan3 = new Scanner(System.in); // Récupère les valeurs inscrite au clavier
        function = scan3.next(); // Stockage d'info récupérée dans la variable
        
        // Affichage de la réponse        
        Util.out("AVE le plus grand "+function+" premier du nom "+lastName+ " " +name);  
    }
}
