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
public class PairOrImpair {
    
    public static void main(String[] arg){
       
        // Déclaration de la variable
        
       float value = 0 ;
       float restOfDivision ;
       String answer = "";
       
    Util.out("Voici un jeu qui consiste à connaître si le nombre isncrit est pair ou impair.\n"
            + "Les nombres à virgule ne sont pas admissible sinon le système crash.\n");
    Util.out("Veuillez maintenant inscire votre valuer : ");

    Scanner scan = new Scanner(System.in);
    answer = scan.next();
    value = Integer.valueOf(answer); // Convertion de la réponse entrée en entier   
    
    restOfDivision = value/2;
    
    //Permet la conversion du reste de la division en entier "c'est à dire 4.5 : il ne considérera 4 qui est un entier"
    int testRestOfDivision = (int)restOfDivision ;
    
    /**
     * Compare le resultat de la division avec la valeur convertie.
     * Si le resultat coverti égal au reste, cela signifie que le nombre inscrit est pair
     * sinon il est impair
    */
    if(restOfDivision == testRestOfDivision){
      
        Util.out("La valeur " + value +" est pair ! Le résultat de la division est : " +restOfDivision);
    }
    else{
        Util.out("La valeur " + value + " inscrite est impair! la division est non parfaite. \n"
                + "Le résultat de la division en valeur la plus proche est : " +(restOfDivision+0.5));
    }

    }
}
