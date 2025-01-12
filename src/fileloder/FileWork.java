package fileloder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class FileWork implements FileWorkable {

    @Override
    public ArrayList<String> getFilesNames(){
        ArrayList<String> files = new ArrayList<>();
        File folder = new File("src/dirToBackup");
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        for(File file : listOfFiles) {
            if(file.isFile()) {
                files.add(file.getName());
            }
        }
        return files;
    }

    @Override
    public void doBackup(ArrayList<String> files) throws IOException {
        for(String fileName : files) {
            Files.copy(Paths.get("src/dirToBackup/" + fileName),Paths.get("src/backup/" + fileName), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    @Override
    public void writeTicTacToeToFile(byte[] ticTacToe) throws IOException {
        FileOutputStream fileInputStream = new FileOutputStream("src/dirToBackup/4.bin");
        fileInputStream.write(ticTacToe[0]);
        fileInputStream.write(ticTacToe[1]);
        fileInputStream.write(ticTacToe[2]);
        fileInputStream.close();
    }

    @Override
    public byte[] readTicTacToeFromFile() throws IOException {
        try(FileInputStream fileInputStream = new FileInputStream("src/dirToBackup/4.bin")) {
            return fileInputStream.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
