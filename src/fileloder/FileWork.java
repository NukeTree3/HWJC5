package backup.fileloder;

import java.io.File;
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
    public ArrayList<File> getFiles() {
        ArrayList<File> files = new ArrayList<>();
        File folder = new File("src/dirToBackup");
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        for(File file : listOfFiles) {
            if(file.isFile()) {
                files.add(file);
            }
        }
        return files;
    }

    @Override
    public void doBackup(ArrayList<File> files) {
        File folder = new File("src/dirToBackup");
        
    }
}
