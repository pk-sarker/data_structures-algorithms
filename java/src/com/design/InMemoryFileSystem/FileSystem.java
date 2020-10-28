package com.design.InMemoryFileSystem;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class FileSystem {
    DirFile root;
    public FileSystem() {
        root = new DirFile();
    }

    public List<String> ls(String path) {
        DirFile df = root;
        List<String> result = new ArrayList<>();
        if (!path.equals("/")) {
            String[] pathComponents = path.split("/");
            for(int i=1 ; i < pathComponents.length; i++) {
                df = df.dirFile.get(pathComponents[i]);
            }
            if (df.isFile) {
                result.add(pathComponents[pathComponents.length -1]);
                return result;
            }
        }

        result = new ArrayList<>(df.dirFile.keySet());
        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        DirFile df = root;
        String[] pathComponents = path.split("/");
        for(int i=1; i< pathComponents.length; i++) {
            if (!df.dirFile.containsKey(pathComponents[i])) {
                df.dirFile.put(pathComponents[i], new DirFile());
            }
            df = df.dirFile.get(pathComponents[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        DirFile df = root;
        String[] pathComponents = filePath.split("/");
        for(int i=1; i<pathComponents.length-1; i++) {
            if (!df.dirFile.containsKey(pathComponents[i])) {
                df.dirFile.put(pathComponents[i], new DirFile());
            }
            df = df.dirFile.get(pathComponents[i]);
        }

        if(!df.dirFile.containsKey(pathComponents[pathComponents.length - 1])) {
            df.dirFile.put(pathComponents[pathComponents.length - 1], new DirFile());
        }

        df = df.dirFile.get(pathComponents[pathComponents.length - 1]);
        df.isFile = true;
        df.content = df.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        DirFile df = root;
        String[] pathComponents = filePath.split("/");
        for(int i=1; i<pathComponents.length-1; i++) {
            if (df.dirFile.containsKey(pathComponents[i])) {
                df = df.dirFile.get(pathComponents[i]);
            }
        }
        df = df.dirFile.get(pathComponents[pathComponents.length - 1]);
        return df.content.toString();
    }
}
