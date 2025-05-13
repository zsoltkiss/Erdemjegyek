package hu.soter.jbe.grades;

import java.io.File;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File createErdemjegyFile(String osztaly, String tantargy) {
		// TODO Auto-generated method stub
		return null;
	}

}
