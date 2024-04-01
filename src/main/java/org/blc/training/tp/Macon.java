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
public class Macon {
    
    public static void main (String [] arg){
       
        double ripeOpposite = 0.0 ;
        double ripeAdjacent = 0.0 ;
        double wireLength = 0.0 ;
        double result = 0;
        
        Util.out("Bonjour ce jeu permet définir la rectitude de deux murs en la comparant avec l’hypoténuse \n"
                + "après avoir spécifier la longueur des deux murs précédant.\n");
        
        Util.out("Veuillez inscrire la longeur du mûr opposé : ");
        Scanner scan1 = new Scanner(System.in);
        ripeOpposite = Double.valueOf(scan1.next());
        
        Util.out("Veuillez inscrire la longeur du mûr adjacent : ");
        Scanner scan2 = new Scanner(System.in);
        ripeAdjacent = Double.valueOf(scan2.next());
        
        Util.out("Veuillez inscrire la longeur du fil : ");
        Scanner scan3 = new Scanner(System.in);
        wireLength = Double.valueOf(scan3.next());
        
        
        result = Math.sqrt((ripeOpposite*ripeOpposite)+(ripeAdjacent*ripeAdjacent));        

        int roundResult = (int) Math.round(result);
                
        if(roundResult != wireLength){
            Util.out("L'hypoténuse du mûr est " + roundResult +" m, la longueur du fil ne correspond pas : " + wireLength +" m.");
            
            double ratio = wireLength/roundResult;
            
            ripeOpposite = ratio*ripeOpposite;
            ripeAdjacent = ratio*ripeAdjacent;
            
            Util.out(" Comme la longueur du fil ne correspond pas à la valeur de l'hypoténuse !\n"
                    + "voici une proposition de longueur de mûr opposé sera de : " + ripeOpposite +" m et adjacent sera de : " + ripeAdjacent +" m." );
        }
        else{
            Util.out("L'hypoténuse du mûr est " + roundResult +" m, la longueur du fil correspond : " + wireLength +" m.");
        }
      
        
    }
}
