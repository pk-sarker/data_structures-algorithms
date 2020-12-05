package com.design.InMemoryFileSystem;
import java.util.Map;
import java.util.HashMap;

public class DirFile {
    public boolean isFile;
    public Map<String, DirFile> dirFile;
    public StringBuffer content;

    public DirFile() {
        isFile = false;
        dirFile = new HashMap<>();
        content = new StringBuffer();
    }
}
