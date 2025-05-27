
import java.util.Scanner;

public class fomenuMegjelenites {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Új névsor rögzítése");
        System.out.println("2. Eredmény rögzítése");

        System.out.print("Kérem válasszon egy opciót (1 vagy 2): ");
        int valasztas = scanner.nextInt();
        scanner.nextLine(); 

        
        if (valasztas == 1) {
            System.out.print("Kérem adjon meg egy számot: ");
            int szam = scanner.nextInt();
            System.out.println("Beírt szám: " + szam);
        } else if (valasztas == 2) {
            System.out.print("Kérem adjon meg egy szöveget: ");
            String szoveg = scanner.nextLine();
            System.out.println("Beírt szöveg: " + szoveg);
        } else {
            System.out.println("Érvénytelen választás.");
        }

                scanner.close();
    }
}