package org.example;

import java.util.Scanner;

/**
 * Application console de gestion de pharmacie.
 */
public class Main {
    public static void main(String[] args) {
        MedicamentManager manager = new MedicamentManager();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n--- Gestion de Pharmacie ---");
            System.out.println("1. Ajouter un médicament");
            System.out.println("2. Afficher les médicaments");
            System.out.println("3. Modifier un médicament");
            System.out.println("4. Supprimer un médicament");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Quantité : ");
                    int quantite = scanner.nextInt();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    manager.ajouterMedicament(nom, quantite, prix);
                    break;
                case 2:
                    manager.afficherMedicaments();
                    break;
                case 3:
                    System.out.print("ID du médicament à modifier : ");
                    int idMod = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nouveau nom : ");
                    String newNom = scanner.nextLine();
                    System.out.print("Nouvelle quantité : ");
                    int newQuantite = scanner.nextInt();
                    System.out.print("Nouveau prix : ");
                    double newPrix = scanner.nextDouble();
                    manager.modifierMedicament(idMod, newNom, newQuantite, newPrix);
                    break;
                case 4:
                    System.out.print("ID du médicament à supprimer : ");
                    int idSup = scanner.nextInt();
                    manager.supprimerMedicament(idSup);
                    break;
                case 0:
                    System.out.println("Fermeture de l'application...");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 0);

        scanner.close();
    }
}
