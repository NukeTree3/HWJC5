package backup.fileloder;

import java.io.File;
import java.util.ArrayList;

public interface FileWorkable {
    ArrayList<String> getFilesNames();

    ArrayList<File> getFiles();

    void doBackup(ArrayList<File> files);
}
