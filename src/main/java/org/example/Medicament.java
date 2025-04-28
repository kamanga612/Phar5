package org.example;

public class Medicament {
    private int id;
    private String nom;
    private int quantite;
    private double prix;

    public Medicament(int id, String nom, int quantite, double prix) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public int getQuantite() { return quantite; }
    public double getPrix() { return prix; }

    public void setNom(String nom) { this.nom = nom; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
    public void setPrix(double prix) { this.prix = prix; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nom: " + nom + ", Quantité: " + quantite + ", Prix: " + prix;
    }
}
