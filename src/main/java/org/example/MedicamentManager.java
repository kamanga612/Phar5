package org.example;

import java.util.*;

public class MedicamentManager {
    private List<Medicament> medicaments;
    private int nextId;
    private static final String FILE_PATH = "medicaments.json";

    public MedicamentManager() {
        // Charger la liste depuis le fichier JSON au démarrage
        this.medicaments = PersistenceUtil.loadMedicaments(FILE_PATH);
        // Déterminer le nextId en fonction du maximum existant
        this.nextId = medicaments.stream()
                .mapToInt(Medicament::getId)
                .max()
                .orElse(0) + 1;
    }

    public void ajouterMedicament(String nom, int quantite, double prix) {
        Medicament med = new Medicament(nextId++, nom, quantite, prix);
        medicaments.add(med);
        PersistenceUtil.saveMedicaments(medicaments, FILE_PATH);
        System.out.println("Médicament ajouté !");
    }

    public void afficherMedicaments() {
        if (medicaments.isEmpty()) {
            System.out.println("Aucun médicament trouvé.");
            return;
        }
        medicaments.forEach(System.out::println);
    }

    public void modifierMedicament(int id, String nouveauNom, int nouvelleQuantite, double nouveauPrix) {
        for (Medicament med : medicaments) {
            if (med.getId() == id) {
                med.setNom(nouveauNom);
                med.setQuantite(nouvelleQuantite);
                med.setPrix(nouveauPrix);
                PersistenceUtil.saveMedicaments(medicaments, FILE_PATH);
                System.out.println("Médicament modifié !");
                return;
            }
        }
        System.out.println("Médicament introuvable.");
    }

    public void supprimerMedicament(int id) {
        Iterator<Medicament> iterator = medicaments.iterator();
        while (iterator.hasNext()) {
            Medicament med = iterator.next();
            if (med.getId() == id) {
                iterator.remove();
                PersistenceUtil.saveMedicaments(medicaments, FILE_PATH);
                System.out.println("Médicament supprimé !");
                return;
            }
        }
        System.out.println("Médicament introuvable.");
    }
}
