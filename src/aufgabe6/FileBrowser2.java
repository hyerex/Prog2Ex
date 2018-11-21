package aufgabe6;

import javax.swing.*;
import java.io.File;
import java.util.List;
import java.util.LinkedList;

public class FileBrowser2 {

    public static void main(String[] args) {

        File dir = new File("/home/blank/CLionProjects/");
        LinkedList<String> l = new LinkedList<String>();
        traverse(dir, new DirectoryPrintVisitor());

        System.out.println("_--------_-----");

        DirectorySearchVisitor v = new DirectorySearchVisitor();
        v.setExtension(".c");
        traverse(dir, v);
        List<String> list = v.getSearchList();
        System.out.println(list.toString());
    }

    public static void traverse(File dir, DirectoryVisitor visitor) {
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                visitor.enterDirectory(f);
                traverse(f, visitor);
                visitor.leaveDirectory(f);
            } else {
                visitor.visitFile(f);
            }
        }
    }


}
