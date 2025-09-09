import java.time.LocalDate;

public class Promotion {
    private LocalDate date;
    private String raison;
    private double nouvelleValeur;

    public Promotion(LocalDate date, String raison, double nouvelleValeur) {
        this.date = date;
        this.raison = raison;
        this.nouvelleValeur = nouvelleValeur;
    }

    public LocalDate getDate() { return date; }
    public String getRaison() { return raison; }
    public double getNouvelleValeur() { return nouvelleValeur; }
}