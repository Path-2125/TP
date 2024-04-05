/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.blc.training.tp;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author patrick.poaty
 */
public class TP {

    public static void main(String[] args) {

        // Retrouver un nombre de 1 à 10
        trouveLeNombreAleatoire();

    }

    public static void trouveLeNombreAleatoire() {

        String response = "y";

        while (response.matches("y")) {
            Integer inconnu = (int) (Math.random() * 10);
            out("Essayer de trouver le nombre caché compris entre 0 à 10");
            Scanner scan = new Scanner(System.in);

            //Récupère la valeur
            Integer value = -1;

            while (value != inconnu) {

                try {
                    value = scan.nextInt();
                } catch (InputMismatchException erreur) {
                    out("Valeur renseigné ne peut être convertie"
                            + "\nErreur :" + erreur.getMessage());
                    return;
                }

                // Compare si le nombre par l'utilisateur correspond à l'inconnu  
                if (value > inconnu) {
                    out("Valeur fournie trop grande !");
                } else if (value < inconnu) {
                    out("Valeur fournie est trop petite !");
                } else {
                    out("Bravo, le nombre était : " + inconnu + "!");
                }
            }
            
            response = "";
            while (!response.matches("y") && !response.matches("n")) {
                out("Voulez-vous recommencer y ou n ?");
                try {
                    response = scan.next();
                } catch (NoSuchElementException e) {
                    out("Valeur renseigné ne peut être convertie"
                            + "\nErreur :" + e.getMessage());
                    response = "";
                }
                
                response = response.toLowerCase();
            }
        }
        
        out("Merci d'avoir joyer à ce jeu. ");
    }

    
       /**
         * public static void factoriel (Integer n)4{
        
             n = 15;
        int fact = n;
        int i =0;
        out("Veuillez saisir un nombre afin de trouver sa factoriel");
        
        while(i<n){
                     
            fact = fact*(n-i);
            out("La factoriel de "+n+" = "+fact);
            i++;
            
        } return fact
          
        out("La factoriel du nombre" + n + " est "+ fact);
        
          
    }
         */    
   
    
    public static void out(String msg){
        
        System.out.println(msg);
    }
}
