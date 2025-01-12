package fileloder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface FileWorkable {
    ArrayList<String> getFilesNames();

    void doBackup(ArrayList<String> files) throws IOException;

    void writeTicTacToeToFile(byte[] ticTacToe) throws IOException;

    byte[] readTicTacToeFromFile() throws IOException;
}
