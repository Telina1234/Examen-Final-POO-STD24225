import java.time.LocalDate;
import java.util.List;

public class ASA {

    public static boolean pointageRouge(List<Pointage> pointages, LocalDate date) {
        double total = 0;
        for (Pointage p : pointages) {
            if (p.getDate().equals(date)) {
                double quota = p.getQuotaTemps();
                if (quota > 1 || quota <= 0) {
                    throw new IllegalArgumentException("Quota de temps incorrect : " + quota);
                }
                total += quota;
            }
        }
        return total == 1;
    }

    public static int getDaysRed(List<Pointage> pointages, LocalDate debut, LocalDate fin) {
        return (int) pointages.stream()
            .filter(p -> !p.getDate().isBefore(debut) && !p.getDate().isAfter(fin))
            .filter(p -> p.getTypeTravail() != TypeTravail.ABS_PAYEE && p.getTypeTravail() != TypeTravail.ABS_NON_PAYEE)
            .map(Pointage::getDate)
            .distinct()
            .count();
    }

    public static double calculerSalairePrestataire(Prestataire prestataire, LocalDate debut, LocalDate fin) {
        double tjm = prestataire.getTjm();
        double jours = 0;
        for (Pointage p : prestataire.getPointages()) {
            if (!p.getDate().isBefore(debut) && !p.getDate().isAfter(fin)) {
                if (p.getTypeTravail() != TypeTravail.ABS_PAYEE && p.getTypeTravail() != TypeTravail.ABS_NON_PAYEE) {
                    jours += p.getQuotaTemps();
                }
            }
        }
        return tjm * jours;
    }
}