package hu.soter.jbe.grades;

public class MainTest {

    public static void main(String[] args) {
        
        FileProvider fileProvider = new DefaultFileProvider();
        Rogzites rogzites = new Rogzites(fileProvider);
        rogzites.jegybeiras();

    }

}
