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
public class FactorielNombre {
    public static void main (String[] arg){
            // Déclaration de variable
        
        int userChoiceMin = 1;
        int userChoiceMax =10;
        String Answer = "";
        
        //Affichage du message à l'utilisateur
        Util.out ("Bonjour, ceci est un jeu qui consiste à trouver la factoriel de votre nombre inscrire \n"
                + " votre nombre doit être entre 1 et 10.");
        Util.out("Veuillez inscrire votre nombre ? : ");
        
        // Récupération de la donnée inscrite au clavier
        Scanner scan = new Scanner(System.in) ;
        Answer = scan.next();
        
        int choice = Integer.valueOf(Answer); // Convertion de la réponse entrée en entier
        
        if(choice>userChoiceMin && choice<userChoiceMax){
           
            Util.out("ça marche");
        }
        else{
            Util.out("La valeur inscrite ne correspond pas à l'intervalle de nombre choisi pour le calcul de la factoriel.\n "
                    + "Le nombre à inscrire doit être compris entre 1 et 10.");
        }
    }    
}
