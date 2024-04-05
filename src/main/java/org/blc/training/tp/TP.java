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
 *
 * Options : chance avec limitation d'essai
 *             Limiter le nombre d'essai simultanée !
 *
 * Options : Niveau difficulté 
 *             Niveau 0 - 0...10 
 *             Niveau 1 - 0...20 
 *             Niveau 2 - 0...30
 *             ...
 *
 * Options : Calculer le score de la personne Nombre pour atteindre un niveau
 *
 *
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

    public static void mainFactoriel() {
        Scanner scan = new Scanner(System.in);
        Integer value = 0;
        out("Insérer une valeur :");
        try {
            value = Integer.valueOf(scan.nextInt());
        } catch (NumberFormatException e) {
            out("Valeur de nombre attendu : " + e.getMessage());
            return;
        }
        out(value + "!=" + factoriel(value));

    }

    public static Integer factoriel(Integer n) {
        int i = 1;
        Integer value = n;
        while (i < n) {
            value = value * (n - i);
            out(i + " :" + value);
            i++;
        }
        return value;
    }

    public static void out(String msg) {

        System.out.println(msg);
    }
}
