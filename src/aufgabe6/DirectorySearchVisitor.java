package aufgabe6;

import java.io.File;
import java.util.LinkedList;

public class DirectorySearchVisitor implements DirectoryVisitor {

    String extension;
    LinkedList<String> searchList = new LinkedList();

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void clearSearchList() {
        searchList.clear();
    }

    public LinkedList<String> getSearchList() {
        return searchList;
    }

    @Override
    public void enterDirectory(File dir) {
        return;
    }

    @Override
    public void leaveDirectory(File dir) {
        return;
    }

    @Override
    public void visitFile(File file) {
        String s = file.getParent() + "/" + file.getName();
        if(s.endsWith(this.extension)){
            searchList.add(s);
        }
    }
}
