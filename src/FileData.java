/**
 * Created by Judit on 2016. 04. 24..
 */

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Ez az oszály a file-ból beolvasásra alkalmazzuk, az egyszerűség kedvéér lett külön osztályba téve
 */
public class FileData {
    private String path;

    /**
     * Ez a függvény beállítja a paraméterben megadott String szöveget elérési útvonalnak
     */
    public void ReadFile(String file_path){
        this.path = file_path;
    }

    /**
     * Ez a függvény egy olyan segédfüggvény, amit arra használunk, hogy megállapítsuk hány sorból áll a szöveges fájl
     */
    public int readLines() throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader bf = new BufferedReader(fr);

        String aLine;
        int numberOfLines = 0;

        while ( ( aLine = bf.readLine( ) ) != null ) {
            numberOfLines++;
        }
        bf.close();
        return numberOfLines;
    }

    /**
     * Ez a függvény végzi a függvényből olvasást soronként - amit kiszámultunk a readLines függvénnyel -
     * és elmenti a sorokat egy string tömbbe
     */
    public String[] OpenFile() throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);

        int numberOfLines = readLines();
        String[] textData = new String[numberOfLines];

        for (int i=0; i < numberOfLines; i++) {
            textData[ i ] = textReader.readLine();
        }

        textReader.close( );
        return textData;
    }
}
