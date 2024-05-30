/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.blc.training.tp;

import javax.swing.Renderer;

/**
 *
 * @author patrick.poaty
 */
public class Essai {

    public static void main(String[] args) {

        //  System.out.println("Début séqquence :" + tabToString(generateStartSeqColors(3)));
        String[] colorSeqUser = {"j", "v", "b", "n"};
        String[] colorsSequence = {"j", "v", "b", "n"};

        String[] colorsSeqResult = compareColors(colorSeqUser, colorsSequence);
        out(colorsSeqResult);
        TP.out("check Sequence : "+checkSequenceUser(colorSeqUser, colorsSequence));
        
    }

    public static String[] generateStartSeqColors(int param) {

        // Validation donnée d'entrée
        if (param < 1) {
            TP.out("Error : param doit être >= à 1");
            return null;
        }

        String[] tab = new String[param];  // Initialisation du tableau avec une taille de 5

        int i = 0;
        String code = "x|";

        while (i < param) {

            tab[i] = code;
            i++;
        }

        return tab;
    }

    public static void out(String[] tabSTR) {
        int i = 0;
        while (i < tabSTR.length) {
            System.out.print(tabSTR[i] + ", ");
            i++;
        }

    }

    public static String tabToString(String[] tabSTR) {
        String str = "";
        int i = 0;
        while (i < tabSTR.length) {
            str += (tabSTR[i] + ", ");

            i++;
        }

        return str;
    }

    public static String[] compareColors(String[] colorSeqUser, String[] colorsSequence) {
        int i = 0;
        String[] r = new String[colorsSequence.length];

        //Boucle sur la 1ere valeur saisie de l utilisateur
        while (i < colorsSequence.length) {

            //Test si index actuel est identique 
            if (colorsSequence[i].matches(colorSeqUser[i])) {
                r[i] = colorsSequence[i];
            } else {
                // Boucle sur les autres positions du tableau
                int j = 0;
                while (j < colorsSequence.length) {

                    if (colorsSequence[j].matches(colorSeqUser[i])) {
                        r[i] = "1";
                        j = colorsSequence.length;//permet de pouvoir interrompre la boucle par la suite
                    } else {
                        r[i] = "x";
                    }

                    j++;
                }

            }
            i++;

        }
        return r;
    }

    public static Boolean checkSequenceUser(String[] colorSeqUser, String[] colorsSequence) {
        int i = 0;
        int r = 0;

        //Boucle sur la 1ere valeur saisie de l utilisateur
        while (i < colorsSequence.length) {

            //Test si index actuel est identique 
            if (colorsSequence[i].matches(colorSeqUser[i])) {
                r++;
            }

            i++;

        }


    return r == colorsSequence.length;
    
    }
    

}
