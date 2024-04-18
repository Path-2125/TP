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
 * Options : chance avec limitation d'essai Limiter le nombre d'essai simultanée
 * !
 *
 * Options : Niveau difficulté Niveau 0 - 0...10 Niveau 1 - 0...20 Niveau 2 -
 * 0...30 ...
 *
 * Options : Calculer le score de la personne Nombre pour atteindre un niveau
 *
 *
 */
public class TP {

    public static void main(String[] args) {

        // Retrouver un nombre de 1 à 10
        gameGuessNumber();

    }

    public static void gameGuessNumber() {

        // Déclaration de vairable
        int maxLevel = 5;
        int level = 1;
        int maxTries = 7;
        int guessValue = 0;
        int secretNumber = 0;
        int score = 0;
        int chance = maxTries;

        Scanner scan = new Scanner(System.in);

        //Récupère la valeur
        String response = "y";

        while (response.matches("y")) {
            out("\n=|==================================================================|=");
            out("Vous êtes dans un jeu de devinette d'un nombre.                       ");
            out("Vous débuterez par le niveau (1) avec (" + maxTries + ")essais possible. \n"
                    + "Si vous trouvez le bon resultat vous passerez au niveau suivant    ");
            out("ou bien vous avez le choix de débuter la partie au niveau (2)         ");
            out("=|==================================================================|=");

            /**
             * out(""); outNotOnLine("Vous voulez débuté par quel niveau ? : ");
             *
             * //Vérification de la valeur inscrite par l'utilisateur try {
             * answer = scan.nextInt(); } catch (InputMismatchException erreur)
             * { out("La valeur renseignée n'est pas un nombre" + "\nErreur :" +
             * erreur.getMessage()); return; }
             *
             * if (answer == 1) {
             */
            out("");
            out("Bienvenue au jeu de devinettes du niveau : " + level + " - Trouvez un nombre entre " + 0 + " et " + (level * 10));

            // Boucle de vérification par rappport au niveau max
            while (chance != 0) {

                // Génération de la valeur aléatoire
                secretNumber = (int) (Math.random() * (level * 10));

                boolean firstTime = true;
                // Boucle de vérification par rappport au essai de l'utilisateur
                while (chance > 0) {
                    outNotOnLine("\nDevinez le nombre ? : ");

                    //Vérification de la valeur inscrite par l'utilisateur
                    try {
                        guessValue = scan.nextInt();
                    } catch (InputMismatchException erreur) {
                        out("La valeur renseignée n'est pas un nombre"
                                + "\nErreur :" + erreur.getMessage());
                        return;
                    }

                    // 
                    if (guessValue == secretNumber) {
                        out("");
                        out("Bravo ! Vous avez trouvé le bon nombre ! : " + secretNumber);
                        break;
                    } else {
                        if (guessValue < secretNumber) {
                            out("\nTrop bas ! Essayez un nombre plus grand.");
                        } else {
                            out("\nTrop élevé ! Essayez un nombre plus petit.");
                        }
                        chance--; // Perte du nombre chance
                        firstTime = false;

                        if (chance > 0) {
                            out("Il vous reste " + chance + " essai(s)");
                        }
                    }
                }

                // Gestion du score
                score += chance;
                if (firstTime) {
                    score += 2;
                }

                if (chance > 0) {
                    out("Vous avez encore " + chance + " essai(s) et votre score est de : " + score + " points.");
                } else {
                    out("Votre nombre d'essai est " + chance + " et votre score de : " + score + " points.");
                }

                /**
                 * Condition qui permet de passer au niveau suivant si
                 * l'utilisateur a trouvé la bonne réponse peut importe la phase
                 * d'échec ou de valeur trouvée en un seul choix incrémentation
                 * de la valeur maxRange et du level pour le tour suivant
                 */
                if (chance > 0) {
                    level++;
                    out("\nVous passez au niveau : " + level + " - du jeu. Trouvez un nombre entre " + 0 + " et " + 10 * level);
                } else {
                    out("Dommage ! Le nombre était " + secretNumber);
                    break;
                }
            }

            response = "";
            while (!response.matches("y") && !response.matches("n")) {
                out("\nVoulez-vous recommencer y ou n ?");
                try {
                    response = scan.next();
                } catch (NoSuchElementException e) {
                    out("Valeur renseigné ne peut être convertie"
                            + "\nErreur :" + e.getMessage());
                    response = "";
                }
                response = response.toLowerCase();
                
                // Réinitialisation des variables jeu au paramètre initiaux
                level = 1;
                chance = maxTries;
                score = 0;
                
                
            }
            
            
        }

    }

    public static void gameGuessMyNnumbe() {

        out("=|=====================================================================|=");
        out("=| Vous êtes dans un jeu de devinette d'un nombre                      |=");
        out("=| Vous avez trois (3) niveaux de difficultés                          |=");
        out("=| Vous débuterez par le niveau (1) avec quatre (5)essais possible     |=");
        out("=| Si vous trouvez le resultat vous passerez au niveau suivant         |=");
        out("=| ou bien vous pouvez choisir le niveau le niveau (2)                 |=");
        out("=|=====================================================================|=");

        //Initialisation des paramètres du jeu
        int answer = 0;
        int randomValue = 10;

        out(" Veuillez inscrire votre choix : ");
        Scanner scan = new Scanner(System.in);

        try {
            answer = scan.nextInt();
        } catch (InputMismatchException erreur) {
            out("Valeur renseigné n'est pas un nombre"
                    + "\nErreur :" + erreur.getMessage());
            return;
        }

        //Première condition d'entrée du jeu au niveau initial
        if (answer == 1) {

            out("=|==============================================|=");
            out("=| Ceci est un jeu de niveau : 1                |=");
            out("=| Trouver un nombre entre  0 et 10             |=");
            out("=| Vous avez 5 chances pour trouver le nombre   |=");
            out("=|==============================================|=");

            Integer inconnu = (int) (Math.random() * randomValue);  //Valeur aléatoire comprise entre 0-10.
            out("Essayer de trouver le nombre caché compris entre 0 à 10");

            //Initialisation des paramères du jeu
            Integer value = -1;
            int chance = 0;
            int gameOver = 5;
            int restChance1 = 0;
            int restChance2 = 0;
            int restChance3 = 0;

            // Boucle du jeu de 0-10, si le candidat trouvre la bonne réponse avec le nombre d'essai restant, il passe au niveau suivant
            while (value != inconnu) {

                chance += 1;

                /**
                 * Comparaison entre la le nombre max de chance "gameOver = 5 "
                 * avec les essais réalisés "chance" Si gameOver égal à chance,
                 * le jeu s'arretera
                 */
                if (chance > gameOver) {
                    out("                                            ");
                    out("Vous avez attenit le nombre limite de chance.\n"
                            + "Game Over");
                    return;

                } else {
                    try {
                        value = scan.nextInt();
                    } catch (InputMismatchException erreur) {
                        out("Valeur renseigné n'est pas un chiffre ;\n"
                                + "Veuillez inscrire un chiffre !"
                                + "\nErreur :" + erreur.getMessage());
                        return;
                    }

                    // Compare si le nombre par l'utilisateur correspond à l'inconnu  
                    if (value > inconnu) {
                        out("Valeur fournie trop grande !");
                        out("Il vous reste " + (gameOver - chance) + " chance");
                    } else if (value < inconnu) {
                        out("Valeur fournie est trop petite !");
                        out("Il vous reste " + (gameOver - chance) + " chance");
                    } else {
                        out("Bravo, le nombre était : " + inconnu + " !");
                        restChance2 = gameOver - chance + 1; // corrige la valeur d'essai à la veleur du tour + 1; sinon la valeur sera inféreuer malgré la valeur trouvée
                    }

                }
            }

            out("                                           ");
            out("=|=======================================|=");
            out("=| Vous passez au niveau : 2             |=");
            out("=| Trouver un nombre enttre 0 et 20      |=");
            out("=| Il vous reste (" + restChance2 + ")chance    |=");
            out("=|=======================================|=");

            randomValue += randomValue; // incrémentation de la valeur aléatoire de plus 10
            Integer inconnu1 = (int) (Math.random() * randomValue);
            out("Essayer de trouver le nombre caché compris entre 0 à " + randomValue);

            chance = 0;  // Réinitialiser la valeur chance à zéro avant de débuter la deuxième partie, sinon chance double de valeur
            while (value != inconnu1) {

                chance += 1;

                /**
                 * Comparaison entre la le nombre max de chance qui est
                 * maintenant contenu dans restChance2 avec les essais réalisés
                 * "chance" Si restChance2 égal à chance, le jeu s'arretera
                 */
                if (chance > restChance2) {
                    out("                                            ");
                    out("Vous avez attenit le nombre limite de chance.\n"
                            + "Game Over");
                    return;
                } else {
                    try {
                        value = scan.nextInt();
                    } catch (InputMismatchException erreur) {
                        out("Valeur renseigné n'est pas un chiffre ;\n"
                                + "Veuillez inscrire un chiffre !"
                                + "\nErreur :" + erreur.getMessage());
                        return;
                    }

                    // Compare si le nombre par l'utilisateur correspond à l'inconnu  
                    if (value > inconnu1) {
                        out("Valeur fournie trop grande !");
                        out("Il vous reste " + (restChance2 - chance) + " chance");
                    } else if (value < inconnu1) {
                        out("Valeur fournie est trop petite !");
                        out("Il vous reste " + (restChance2 - chance) + " chance");
                    } else {
                        out("Bravo, le nombre était : " + inconnu1 + ", vous êtes fort !");
                        restChance3 = restChance2 - chance + 1;
                    }

                }
            }

            out("                                           ");
            out("=|=======================================|=");
            out("=| Vous passez au niveau : 3             |=");
            out("=| Trouver un nombre enttre 0 et 30      |=");
            out("=| Il vous reste (" + restChance3 + ") chance |=");
            out("=|=======================================|=");

            randomValue += randomValue - 10; //Dinifir la valeur de mise à 30 = 40-10
            Integer inconnu2 = (int) (Math.random() * randomValue);
            out("Essayer de trouver le nombre caché compris entre 0 à " + randomValue);

            chance = 0;  // Réinitialiser la valeur chance à zéro avant de débuter la deuxième partie, sinon chance double de valeur 

            while (value != inconnu2) {

                chance += 1;

                /**
                 * Comparaison entre la le nombre max de chance qui est
                 * maintenant contenu dans restChance3 avec les essais réalisés
                 * "chance" Si restChance3 égal à chance, le jeu s'arretera
                 */
                if (chance > restChance3) {
                    out("                                            ");
                    out("Vous avez attenit le nombre limite de chance.\n"
                            + "Game Over");
                    return;
                } else {
                    try {
                        value = scan.nextInt();
                    } catch (InputMismatchException erreur) {
                        out("Valeur renseigné n'est pas un chiffre ;\n"
                                + "Veuillez inscrire un chiffre !"
                                + "\nErreur :" + erreur.getMessage());
                        return;
                    }

                    // Compare si le nombre par l'utilisateur correspond à l'inconnu  
                    if (value > inconnu2) {
                        out("Valeur fournie trop grande !");
                        out("Il vous reste " + (restChance3 - chance) + " chance");
                    } else if (value < inconnu2) {
                        out("Valeur fournie est trop petite !");
                        out("Il vous reste " + (restChance3 - chance) + " chance");
                    } else {
                        out("Bravo, le nombre était : " + inconnu2 + ", vous êtes un génie !");
                        restChance3 = restChance3 - chance + 1;
                        out("Il vous reste encore : " + restChance3 + " chance. Félicitation !!!!");
                    }

                }
            }

        } else if (answer == 2) {
            out(" Jeu niveau 2 : ");

        } else {
            out("L'option choisi ne correspond pas au choix des options défini plus haut !!");
            return;
        }

    }

    public static void trouveLeNombreAleatoire() {

        String response = "y";

        while (response.matches("y")) {

            out("=|=====================================================|=");
            out("=| Trouver un nombre ent 0 et n                        |=");
            out("=| n est le nombre que vous allez inscrire             |=");
            out("=|=====================================================|=");

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

    public static void outNotOnLine(String msg) {

        System.out.print(msg);
    }
}
