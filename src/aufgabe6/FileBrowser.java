package aufgabe6;// O. Bittel
// 13.4.2011

import java.io.File;
import java.util.List;
import java.util.LinkedList;

public class FileBrowser{

    public static void main(String[] args) {

        File dir = new File("/home/blank/CLionProjects/");
        LinkedList<String> l = new LinkedList<String>();

        dirPrint(dir);
        dirSearch(dir, ".c", l);
        System.out.println(l.toString());
    }

    public static void dirPrint(File file) {

        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println("Verzeichnis: " + f.getParent() + "/" + f.getName() + " Größe: " + f.length());
                String s = f.getParent() + "/" + f.getName();
                File f2 = new File(s);
                dirPrint(f2);
            } else {
                System.out.println("Datei: " + f.getParent() + "/" + f.getName() + " Größe: " + f.length());
            }
        }
    }

    public static void dirSearch(File file, String extension, List<String> l) {

        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                String s = f.getParent() + "/" + f.getName();
                File f2 = new File(s);
                //dirPrint(f2);
                dirSearch(f2, extension, l);
            } else {
                String s = f.getParent() + "/" + f.getName();
                if(s.endsWith(extension)) {
                    l.add(s);
                }
            }
        }

    }

}
