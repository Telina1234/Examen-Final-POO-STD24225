public class Prestataire extends Travailleur {
    private double tjm;

    public Prestataire(int id, String nom, String prenom, String email, String telephone, double tjm) {
        super(id, nom, prenom, email, telephone);
        this.tjm = tjm;
    }

    public double getTjm() {
        return tjm;
    }

    public void setTjm(double tjm) {
        this.tjm = tjm;
    }

    public void appliquerPromotion(Promotion promotion) {
        this.tjm = promotion.getNouvelleValeur();
        ajouterPromotion(promotion);
    }
}   
