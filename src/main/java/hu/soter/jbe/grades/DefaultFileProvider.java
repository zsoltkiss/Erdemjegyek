package hu.soter.jbe.grades;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DefaultFileProvider implements FileProvider {

    @Override
    public File createErdemjegyFile(String osztaly, String tantargy) {
        String datum = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String fajlNev = osztaly + "_" + tantargy + "_" + datum + ".txt";
        Path path = Path.of("src/main/resources", fajlNev);
        try {
            Files.createDirectories(path.getParent()); // ha nem létezik a mappa
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            return path.toFile();
        } catch (IOException e) {
            throw new RuntimeException("Nem sikerült létrehozni a fájlt: " + path, e);
        }
    }

    @Override
    public File getNevsorFile(String osztaly) throws NevsorNemLetezikException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNevsorFile'");
    }

    @Override
    public File createNevsorFile(String osztaly) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createNevsorFile'");
    }
}
