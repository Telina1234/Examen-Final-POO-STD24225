import java.time.LocalDate;

public class Pointage {
    private LocalDate date;
    private TypeTravail typeTravail;
    private double quotaTemps;
    private String description;

    public Pointage(LocalDate date, TypeTravail typeTravail, double quotaTemps, String description) {
        this.date = date;
        this.typeTravail = typeTravail;
        this.quotaTemps = quotaTemps;
        this.description = description;
    }

    public LocalDate getDate() { return date; }
    public TypeTravail getTypeTravail() { return typeTravail; }
    public double getQuotaTemps() { return quotaTemps; }
    public String getDescription() { return description; }
}