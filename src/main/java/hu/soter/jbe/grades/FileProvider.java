package hu.soter.jbe.grades;

import java.io.File;

public interface FileProvider {
    // ANGELA
    // Adja vissza a File-t.
    // Ha nem letezik, dobjon kivetelt.
    // NEVKONVENCIO: src/main/resources/2a_nevsor.txt
    File getNevsorFile(String osztaly) throws NevsorNemLetezikException;

    // ATTILA
    // Hozza letre a file-t es adja vissza.
    // NEVKONVENCIO: src/main/resources/2a_nevsor.txt
    File createNevsorFile(String osztaly);

    // BALINT
    // NEVKONVENCIO: src/main/resources/2a_biologia_20250508.txt
    File createErdemjegyFile(String osztaly, String tantargy);

}
