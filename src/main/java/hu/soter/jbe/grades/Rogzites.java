package hu.soter.jbe.grades;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Rogzites {

    private final FileProvider provider;
    private final Scanner scanner = new Scanner(System.in);

    public Rogzites(FileProvider provider) {
        this.provider = provider;
    }

    // Hasznalja a scanner-t.
    // Irjon ki 2 opciot egymas ala: 1. Uj nevsor rogzites, 2. Eredmeny rogzites
    // Varjon a user inputra.
    // Elso korben csak ennyit csinaljon: ha 1-et irt be a user, akkor varjon tole meg egy tovabbi szamot. Ha 2-t irt be a user, varjon tole egy string-et.
    // Irja vissza a kepernyore amit a user masodik alkalommal beirt.
    // Zarja be a scanner-t.
    public void fomenuMegjelenites() {

    }

    // Hasznalja a scanner-t.
    // Irjon ki egy rovid "hasznalati utasitast", hogy mit varunk el a user-tol.
    // Kerje be az osztaly nevet, pl. 2a.
    // Kerjen be tetszolges darab nevet.
    // Amikor a user beirja hogy "quit", akkor zarja be a scanner-t.
    // Irja vissza a konzolra az osztaly nevet es a megadott nevsort.
    public void nevsorRogzites() {

    }

    // Hasznalja a scanner-t.
    // Kerje be a tanartol az osztaly nevet, pl. 2a.
    // Kerje el a nevsor File-t a provider-tol.
    // Olvassa be a nevsor file-bol a neveket.
    // Iteraljon a neveken.
    // Minden egyes nevet irjon vissza a konzolra, es kerje be a tanartol az erdemjegyet az adott tanulohoz.
    // Az erdemjegyek csak 1-5 szamok lehetnek.
    // Irja vissza a nevenkent a jegyeket a konzolra, nev: erdemjegy formaban.
    public void jegybeiras() {

    }

    // Irja ki egy txt file-ba az osztaly nevsorat.
    // A File-t a provider-tol kerje el.
    public void nevsorMentes(List<String> nevek, String osztaly) {

    }

    // Irja ki egy txt file-ba az osztaly eredmenyeit adott tantargybol.
    // A File-t a provider-tol kerje el.
    public void erdemjegyMentes(Map<String, Integer> eredmenyek, String osztaly, String tantargy) {

    }

    private void bezaras() {
        scanner.close();
    }
}
