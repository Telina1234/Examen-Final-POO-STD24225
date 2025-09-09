import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class ASATest {

    @Test
    public void testPointageRougeCorrect() {
        Pointage p1 = new Pointage(LocalDate.of(2025,9,1), TypeTravail.ENSEIGNEMENT, 0.5, "c");
        Pointage p2 = new Pointage(LocalDate.of(2025,9,1), TypeTravail.ADMINISTRATION, 0.5, "Adm");
        assertTrue(ASA.pointageRouge(Arrays.asList(p1, p2), LocalDate.of(2025,9,1)));
    }

    @Test
    public void testPointageRougeIncorrect() {
        Pointage p1 = new Pointage(LocalDate.of(2025,9,2), TypeTravail.ENSEIGNEMENT, 0.7, "c");
        Pointage p2 = new Pointage(LocalDate.of(2025,9,2), TypeTravail.ADMINISTRATION, 0.5, "Adm");
        assertFalse(ASA.pointageRouge(Arrays.asList(p1, p2), LocalDate.of(2025,9,2)));
    }

    @Test
    public void testPointageRougeException() {
        Pointage p1 = new Pointage(LocalDate.of(2025,9,3), TypeTravail.ENSEIGNEMENT, 1.2, "c");
        assertThrows(IllegalArgumentException.class, () -> {
            ASA.pointageRouge(Arrays.asList(p1), LocalDate.of(2025,9,3));
        });
    }

    @Test
    public void testGetDaysRed() {
        Pointage p1 = new Pointage(LocalDate.of(2025,9,1), TypeTravail.ENSEIGNEMENT, 1, "c");
        Pointage p2 = new Pointage(LocalDate.of(2025,9,2), TypeTravail.ABS_PAYEE, 1, "Abs");
        Pointage p3 = new Pointage(LocalDate.of(2025,9,3), TypeTravail.ADMINISTRATION, 1, "Adm");
        assertEquals(2, ASA.getDaysRed(Arrays.asList(p1, p2, p3), LocalDate.of(2025,9,1), LocalDate.of(2025,9,3)));
    }

    @Test
    public void testCalculerSalairePrestataire() {
        Prestataire prestataire = new Prestataire(1, "Rabe", "Rakoto", "Rasoa@hei.com", "06", 200);
        prestataire.ajouterPointage(new Pointage(LocalDate.of(2025,9,1), TypeTravail.ENSEIGNEMENT, 1, "c"));
        prestataire.ajouterPointage(new Pointage(LocalDate.of(2025,9,2), TypeTravail.ADMINISTRATION, 0.5, "Adm"));
        prestataire.ajouterPointage(new Pointage(LocalDate.of(2025,9,2), TypeTravail.ABS_PAYEE, 0.5, "Abs"));
        double salaire = ASA.calculerSalairePrestataire(prestataire, LocalDate.of(2025,9,1), LocalDate.of(2025,9,2));
        assertEquals(200 * 1.5, salaire);
    }
}