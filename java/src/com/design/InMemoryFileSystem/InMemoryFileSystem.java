package com.design.InMemoryFileSystem;


public class InMemoryFileSystem {

    public static void main(String args[]) {
        FileSystem fs = new FileSystem();
        System.out.println(fs.ls("/"));
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d", "Pijus");
        System.out.println(fs.ls("/").toString());
        fs.mkdir("/1");
        fs.mkdir("/x");
        System.out.println(fs.ls("/").toString());
        System.out.println(fs.readContentFromFile("/a/b/c/d"));

        fs.addContentToFile("/a/b/c/d", " Kumar");
        System.out.println(fs.readContentFromFile("/a/b/c/d"));

        fs.addContentToFile("/a/b/c/d", " Sarker");
        System.out.println(fs.readContentFromFile("/a/b/c/d"));
        fs.mkdir("/a/b/c/f");
        System.out.println(fs.ls("/a/b/c").toString());
    }
}
