package aufgabe6;

import java.io.File;

public class DirectoryPrintVisitor implements DirectoryVisitor {

    int tiefe = 0;
    @Override
    public void enterDirectory(File dir) {
        tiefe++;
        for (int i = 0; i < tiefe; i++) {
            System.out.print("----");
        }
        System.out.println(dir.getName());
    }

    @Override
    public void leaveDirectory(File dir) {
        --tiefe;
    }

    @Override
    public void visitFile(File file) {
        System.out.println(file.getName());
    }
}
