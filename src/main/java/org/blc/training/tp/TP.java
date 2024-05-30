/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.blc.training.tp;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
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
/**
 * Vous devez retrouver la suite d'une séquence de couleur. Les couleurs
 * possible sont (rouge, vert, bleu, orange, marron, noire). La séquence peut
 * être répétitive. L'utilisateur devra spécifier la séquence des couleurs.
 * <p>
 * ok : Un système de niveau permet de démarrer à une séquence de 3 couleurs à
 * retrouver
 * <p>
 * Attente correction : L'utilisateur passera au niveau suivant dès que la
 * séquence est trouvée. Le niveau suivant sera incrément d'une séquence
 * complémentaire.
 * <p>
 * Un score sera attribué en fonction du nombre d'essai effecuté au niveau.
 * <p>
 * ok : Un nombre chance max permet à l'utilisateur de continuer le jeu.
 * <p>
 * ok : Bien évidement l'utilisateur peut arrêter à tout instant le jeu.
 * <p>
 * ok : Il peut également poursuivre (recommencer)
 * <p>
 * Example :
 * <p>
 * Niveau 1 : le système génère la séquence
 * <p>
 * ok : | x | x | x | correspondant à | b | v | o |
 * <p>
 * ok : L'utilisateur propose la séquence séparée comme suit v;n;r
 * <p>
 * Vous devez lui répondre | 1 | x | x | : le 1 permet d'indiquer une valeur
 * bonne mais mal positionnée<p>
 * Essai suivant l'utilisateur indique o;v;m >> | 1 | v | x | ...
 * <p>
 * si résultat ok >> | b | v | o |
 * <p>
 * Niveau 2 : le système génère la séquence du niveau
 * <p>
 * | x | x | x | x | correspondant à | m | o | n | v |
 * <p>
 * ...
 *
 * <p>
 * Astuces : utilisation de tableau argc[] >> TypeVariable n[tailleTableau];
 */
public class TP {

    public static String[] colors = {"rouge", "vert", "bleu", "orange", "marron", "noire"};

    public static void main(String[] args) {

        // Retrouver un nombre de 1 à 10
        trouverLaSuiteDeCouleur();

    }

    public static void trouverLaSuiteDeCouleur() {
        // Déclaration de vairable

        Scanner scan = new Scanner(System.in);

        //Récupère la valeur
        String yesno = "y";

        Boolean isQuit = false;

        /**
         * Boucle principale de terminaison du programme
         */
        while (yesno.matches("y") && !isQuit) {
            int nowSequence = 3;
            int level = 1;
            int score = 0;
            int chance = 20;

            out("Bienvenue au jeu de devinettes de couleur, vous êtes au niveau : " + level + " \n"
                    + "- Trouvez les séquences de(" + nowSequence + ")couleurs parmis ces couleurs " + Arrays.toString(TP.colors));

            // Boucle de niveau de séquence utilusateur 
            while (chance != 0 && !isQuit) {

                // Génération de la séquence de couleur aléatoire
                String[] colorsSequence = generateRandomSeqColors(nowSequence);
                String[] colorsSeqResult = generateStartSeqColors(nowSequence);
                String[] colorSeqUser = generateStartSeqColors(nowSequence);

                boolean isSeqFind = false;

                // Boucle de chance utilisateur
                while (chance > 0 && !isQuit && !isSeqFind) {

                    //Test si sequence de resultat = sequence tampon / Affichage de la découverte de séquence actuelle
                    out(colorsSeqResult);
                    //Vérification de la valeur inscrite par l'utilisateur
                    String seqString = "";

                    Boolean isCorrectInput = false;
                    int i = 0; //Loop test

                    
                    // Boucle de validation de saisie des utilusateurs
                    while (!isCorrectInput && !isQuit) { // Parce que les informatiosn saisie ne sont pas cohérente par rapport à un nombre ou à quitter

                        seqString = scan.nextLine();
                        isCorrectInput = colorIsInputCorrect(seqString, nowSequence);
                        String msgError = "Vous devez renseigner la séquence comme suit:  exemple : v;n;r  \n"
                                + "correspendant respectivement à vert;noir;rouge. Ou \"q\" pour quitter";

                        
                        if (!isCorrectInput) {
                            i++;

                            //Aide l'utilisateur après 3 erreurs
                            if (i >= 3) {
                                out(msgError);
                                i = 0;
                            }
                        }

                        //Vérifie que l'utilisateur ne souhaite pas quitter
                        if (seqString != null) {
                            if (seqString.toLowerCase().substring(0, 1).matches("q")) {
                                isQuit = true;
                            } else {
//                                out(msgError);
                            }
                        } else {
                            out(msgError);
                        }
                    }// End Boucle de validation de saisie des utilusateurs

                    // Validation du résultat en cas de saisie correcte
                    if (isCorrectInput) {

                        //Convertir saisie user en tab de donnees
                        colorSeqUser = seqString.split(";");
                        //Retrouve le resultat
                        colorsSeqResult = compareColors(colorSeqUser, colorsSequence);
                        isSeqFind = checkSequenceUser(colorSeqUser, colorsSequence);

                        //En cas de resultat correct , passe au niveau suivant
                        if (isSeqFind) {
                            nowSequence++;
                            level++;
                            out("Bravo, vous avez trouvez les séquences " + tabToString(colorsSequence) + " ; vous passez au niveau - " + level);
                            score += chance * level;
                        } else {
                            // DEcompte de points

                            chance--;
                            out("Sequence entree n est pas correcte [chance :" + chance + ", Niveau : " + level + " , Score : " + score + "]");
                            if (chance <= 0) {
                                out("Désoler, vous avez perdu ! Vous n'avez plus de chance. REsultat attendu :" + tabToString(colorsSequence));
                            }
                        }
                    }

                }// Boucle chance user

            }//End Boucle de niveau de séquence utilusateur

            /**
             * Recommence la partie depuis le début ou arrêter
             */
            if (chance <= 0 && !isQuit) {

                yesno = "";
                while (!yesno.matches("y") && !yesno.matches("n")) {
                    out("Voulez-vous recommencer ? y/n");
                    try {
                        yesno = scan.next();
                    } catch (NoSuchElementException e) {
                        out("Merci de specifier une information correct ! ");
                        yesno = "";
                    }
                    yesno = yesno.toLowerCase();
                    out("YesNo tolowerCase :" + yesno + " >> " + yesno.toLowerCase());
                }
            }
        }

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

    /**
     * Méthode génération séquence couleurs
     *
     * @param sizeSequence est un numéro qui définit la taille de la suite de la
     * séquence
     * @return une suite de couleurs aléatoire de la taille de la séquence
     */
    public static String[] generateRandomSeqColors(int sizeSequence) {

        String[] tabColors = new String[sizeSequence];  // Initialisation du tableau avec une taille de 5

        int i = 0;

        while (i < sizeSequence) {
            int choice = (int) (Math.random() * colors.length);
            tabColors[i] = colors[choice].substring(0, 1);// Génère un tab avec les premiers caractères
            i++;
        }
        return tabColors;
    }

// Méthode génération séquence vide
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

    public static void trouverLaSuiteDeCouleurPatrick() {

        // Tableau de couleurs
        String[] colors = {"rouge", "vert", "bleu", "orange", "marron", "noire"};

        Scanner scan = new Scanner(System.in);
        Random aleat = new Random();

        int level = 1;
        int sequence = 3;
        int i = 0;

        String findValue = "";
        String answer = "";

        out("Bienvenue au jeu de devinettes de couleur, vous êtes au niveau : " + level + " \n"
                + "- Trouvez les séquences de(" + sequence + ")couleurs parmis ces couleurs " + Arrays.toString(colors));
        // Générer la séquence de couleurs
        String[] sequenceCouleurs = new String[sequence];

        /**
         * gGeneration d'un tableau de séquence de couleurs aéatoire en fonction
         * deu niveau de séquence et des couleurs disponible
         */
        while (i < sequence) {

            int choice = (int) (Math.random() * colors.length);
            //findValue = colors[choice] + " "; //affiche les couleurs avec un espace
            sequenceCouleurs[i] = colors[choice];

            outNotOnLine(sequenceCouleurs[i] + ","); // test d'afficahage de couleur
            //outNotOnLine(findValue); // test d'afficahage de couleur
            i++;
        }

        out("\nVeuillez inscrire (" + sequence + ") couleurs !!! : ");
        answer = scan.nextLine();
        String[] couleursProposees = answer.split(",");

        //Vérifie la correspondance de la liste de valeurs proposé aléatoirement avec celle inscrite
        if (Arrays.asList(sequenceCouleurs).contains(couleursProposees)) {
            out("C'est bon !");
        } else {
            out("C'est pas bon.");
        }

    }

    public static void gameGuessNumber() {
        // Déclaration de vairable
        int maxLevel = 5;
        int maxTries = 7;
        int guessValue = 0;
        int secretNumber = 0;

        Scanner scan = new Scanner(System.in);

        //Récupère la valeur
        String response = "y";

        int level = 1;
        int score = 0;
        int chance = maxTries;

        while (response.matches("y")) {
            out("\n=|==================================================================|=");
            out("Vous êtes dans un jeu de devinette d'un nombre.                       ");
            out("Vous débuterez par le niveau (1) avec (" + maxTries + ")essais possible. \n"
                    + "Si vous trouvez le bon resultat vous passerez au niveau suivant    ");
            out("ou bien vous avez le choix de débuter la partie au niveau (2)         ");
            out("=|==================================================================|=");

            out("");
            out("Bienvenue au jeu de devinettes du niveau : " + level + " - Trouvez un nombre entre " + 0 + " et " + (level * 10));

            // Boucle de vérification par rappport au niveau max
            while (chance != 0) {

                // Génération de la valeur aléatoire
                secretNumber = (int) (Math.random() * (level * 10));

                boolean firstTime = true;

                // Boucle de vérification par rappport au essai de l'utilisateur
                while (chance > 0) {
                    outNotOnLine("\nDevinez le nombre ? : " + secretNumber);

                    //Vérification de la valeur inscrite par l'utilisateur
                    try {
                        guessValue = scan.nextInt();
                    } catch (InputMismatchException erreur) {
                        out("La valeur renseignée n'est pas un nombre"
                                + "\nErreur :" + erreur.getMessage());
                        return;
                    }

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
                chance = 0;
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

    private static void colorShowSeqFind(String[] colorsSeqResult) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static Boolean colorIsInputCorrect(String seqString, int sizeSequence) {

        if (seqString == null) {
            out("texte nul !!");
            return false;
        }

        // Comparaison du bon nombre de caractère isncrit par le user
        if (seqString.length() != (sizeSequence + sizeSequence - 1)) {
            out("mauvais nbre de caractère");
            return false;
        }

        String[] d = seqString.split(";");

        if (d.length != sizeSequence) {
            out("taille de séquence différent");
            return false;
        }

        int i = 0;

        // Boucle qui parcours les différenets champs séparé par les ";"
        while (i < d.length) {
            int j = 0;
            Boolean exist = false;
            // Boucle qui parcours les différenets champs de couleurs 
            while (j < colors.length && !exist) {

                if (d[i].matches(colors[j].substring(0, 1))) {
                    exist = true;
                }

                j++;
            }
            i++;
            
            if (!exist){
                out("Couleur n'existe pas ");
                return false ;
            }
        }
        return true;
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

    private static String[] convertColorsStringsToTabColors(String seqString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param seqString
     * @return
     */
}
