package hu.soter.jbe.grades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

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

        System.out.println("Válasszon a következők közül: \n1. Új névsor rögzítése\n2. Eredmény rögzítése ");
        int valasztas = scanner.nextInt();

        if (valasztas == 1) {
            nevsorRogzites();
        } else if (valasztas == 2) {
            System.out.print("Kérem adjon meg egy szöveget: ");
            String szoveg = scanner.next();
            System.out.println("Beírt szöveg: " + szoveg);
        } else {
            System.out.println("Érvénytelen választás.");
        }

        bezaras();
    }

    // Hasznalja a scanner-t.
    // Irjon ki egy rovid "hasznalati utasitast", hogy mit varunk el a user-tol.
    // Kerje be az osztaly nevet, pl. 2a.
    // Kerjen be tetszolges darab nevet.
    // Amikor a user beirja hogy "quit", akkor zarja be a scanner-t.
    // Irja vissza a konzolra az osztaly nevet es a megadott nevsort.
    public void nevsorRogzites() {

        System.out.println("Írja be az osztályt! (Pl. 7a)");
        String osztaly = scanner.next();

        System.out.println("Írja be a neveket ENTER-rel elválasztva. Kilépés: Q");

        List<String> names = new ArrayList<>();

        String userInput;

        while (!(userInput = scanner.nextLine()).equals("Q")) {
            names.add(userInput);
        }

        // TODO: workaround! Fix this later!
        List<String> fixedNames =  names.subList(1, names.size());

        nevsorMentes(fixedNames, osztaly);
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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Add meg az osztály nevét (pl. 2a): ");
        String osztalyNev = scanner.nextLine();

        System.out.print("Add meg a tantárgy nevét (pl. biologia): ");
        String tantargy = scanner.nextLine();

        List<String> nevsor = Arrays.asList(
            "Kiss Gábor",
            "Nagy Júlia",
            "Tóth Péter",
            "Szabó Eszter",
            "Kovács Bence"
        );

        Map<String, Integer> jegyek = new LinkedHashMap<>();

        System.out.println("\nOsztály: " + osztalyNev);
        System.out.println("Add meg a tanulók érdemjegyeit:");

        for (String nev : nevsor) {
            int jegy = 0;
            boolean ervenyes = false;

            while (!ervenyes) {
                System.out.print(nev + " érdemjegye (1-5): ");
                try {
                    jegy = Integer.parseInt(scanner.nextLine());
                    if (jegy >= 1 && jegy <= 5) {
                        ervenyes = true;
                    } else {
                        System.out.println("Csak 1 és 5 közötti számot adhatsz meg!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Hibás bemenet! Számot írj be.");
                }
            }

            jegyek.put(nev, jegy);
        }

        // Jegyek fájlba írása
        File fajl = provider.createErdemjegyFile(osztalyNev, tantargy);
        try (FileWriter writer = new FileWriter(fajl)) {
            for (Map.Entry<String, Integer> entry : jegyek.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + System.lineSeparator());
            }
            System.out.println("\nJegyek mentve a fájlba: " + fajl.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Hiba a fájl írása közben: " + e.getMessage());
        }
    }

    // Irja ki egy txt file-ba az osztaly nevsorat.
    // A File-t a provider-tol kerje el.
    public void nevsorMentes(List<String> nevek, String osztaly) {
    try {
        File nevsorFile;
        
        try {
            nevsorFile = provider.getNevsorFile(osztaly);
        } catch (NevsorNemLetezikException e) {
            nevsorFile = provider.createNevsorFile(osztaly);
        }
        
        try (FileWriter writer = new FileWriter(nevsorFile)) {
            for (String nev : nevek) {
                writer.write(nev);
                writer.write(System.lineSeparator());
            }
        }
        
        System.out.println("Névsor mentve a fájlba: " + nevsorFile.getAbsolutePath());
        
        } catch (IOException e) {
            System.out.println("Hiba a fájl írása közben: " + e.getMessage());
        }
    }

    // Irja ki egy txt file-ba az osztaly eredmenyeit adott tantargybol.
    // A File-t a provider-tol kerje el.
    public void erdemjegyMentes(Map<String, Integer> eredmenyek, String osztaly, String tantargy) {

    }

    private void bezaras() {
    	System.out.println("Closing scanner...");
        scanner.close();
    }
}
