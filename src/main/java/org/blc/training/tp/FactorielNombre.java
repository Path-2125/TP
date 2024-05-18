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
        int factorielNumber =0;
        
        //Affichage du message à l'utilisateur
        Util.out ("Bonjour, ceci est un jeu qui consiste à trouver la factoriel de votre nombre inscrit. \n"
                + " votre nombre doit être entre 1 et 10.");
        Util.out(" Veuillez inscrire votre nombre ? : ");
        
        // Récupération de la donnée inscrite au clavier
        Scanner scan = new Scanner(System.in) ;
        Answer = scan.next();
        
        int choice = Integer.valueOf(Answer); // Convertion de la réponse entrée en entier
        
        if(choice>=userChoiceMin && choice<=userChoiceMax){
           
            
            factorielNumber *= choice;
            
            /**
            if (choice == 1 ){
                factorielNumber = choice;
            }
            
            if (choice == 2 ){
                factorielNumber = choice;
            }
            
            if (choice == 3 ){
                factorielNumber = choice*2;
            }
            
            if (choice == 4 ){
                factorielNumber = choice*3*2;
            }
            
            if (choice == 5 ){
                factorielNumber = choice*4*3*2;
            }
            
            if (choice == 6 ){
                factorielNumber = choice;
            }
            
            if (choice == 7 ){
                factorielNumber = choice;
            }
            
            if (choice == 8 ){
                factorielNumber = choice;
            }
            
            if (choice == 9 ){
                factorielNumber = choice;
            }
            if (choice == 10 ){
                factorielNumber = choice;
            }
            **/
            
            
            
            
            
            Util.out("La factoriel de : "+choice+ "! = "+factorielNumber);
            
        }
        else{
            Util.out("La valeur inscrite ne correspond pas à l'intervalle de nombre choisi pour le calcul de la factoriel.\n "
                    + "Le nombre à inscrire doit être compris entre 1 et 10.");
        }
    }    
}
