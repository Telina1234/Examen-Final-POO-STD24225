public class Prestataire extends Travailleur {
    private double tjm;

    public Prestataire(int id, String nom, String prenom, String email, String telephone, double tjm) {
        super(id, nom, prenom, email, telephone);
        this.tjm = tjm;
    }

    public double getTjm() { return tjm; }

    public void appliquerPromotion(Promotion promotion) {
        this.tjm = promotion.getNouvelleValeur();
        ajouterPromotion(promotion);
    }

    @Override
    public double calculerSalaire() {
        double jours = 0;
        for (Pointage p : getPointages()) {
            if (p.getTypeTravail() != TypeTravail.ABS_PAYEE && p.getTypeTravail() != TypeTravail.ABS_NON_PAYEE) {
                jours += p.getQuotaTemps();
            }
        }
        return tjm * jours;
    }
}