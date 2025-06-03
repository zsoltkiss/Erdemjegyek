package hu.soter.jbe.grades;

import java.util.Arrays;

public class MainTest {

    public static void main(String[] args) {
        
        FileProvider fileProvider = new FileProviderImpl();

        Rogzites r = new Rogzites(fileProvider);

        r.fomenuMegjelenites();

//        fileProvider.createNevsorFile("3b");

        Rogzites rogzites = new Rogzites(fileProvider);
//        rogzites.jegybeiras();




        rogzites.nevsorMentes(Arrays.asList("Tóth Benedek", "Csépai Kálmán", "Fésűs Olga", "Szurok Szerénke"), "7b");



    }

}
