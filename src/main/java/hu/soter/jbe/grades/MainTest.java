package hu.soter.jbe.grades;

public class MainTest {

    public static void main(String[] args) {
        
        FileProvider fileProvider = new FileProviderImpl();

        Rogzites r = new Rogzites(fileProvider);

        r.fomenuMegjelenites();

//        fileProvider.createNevsorFile("3b");

//        Rogzites rogzites = new Rogzites(fileProvider);
//        rogzites.jegybeiras();



    }

}
