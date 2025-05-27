package hu.soter.jbe.grades;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileProviderImpl implements FileProvider {

		
	@Override
    public File getNevsorFile(String osztaly) throws NevsorNemLetezikException {
        String path = "src/main/resources/"+ osztaly+ "_nevsor.txt";
        File file = new File(path);

        if (!file.exists()) {
            throw new NevsorNemLetezikException("A nevsor fájl nem létezik: " + path);
        }

        return file;
    }
	
	
	@Override
	public File createNevsorFile(String osztaly) {
		if (osztaly == null || osztaly.trim().isEmpty()) {
			throw new IllegalArgumentException("Az osztály nem lehet null vagy empty");
		}
		String fileName = osztaly + "_nevsor.txt";
		Path filePath = Paths.get("src", "main", "resources", fileName);
		try {
			Files.createDirectories(filePath.getParent());
			if (!Files.exists(filePath)) {
				Files.createFile(filePath);
			}
			return filePath.toFile();
		} catch (IOException e) {
			throw new RuntimeException("Nem sikerült létrehozni a nevsor fájlt: " + e.getMessage(), e);
		}




	}

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


}
