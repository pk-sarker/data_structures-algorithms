package com.ds.practice.shorturl;

import java.lang.StringBuilder;

public class ShortURL {


    private String idToShortURL(long id) {
        // Map to store 62 possible characters
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEGHIJKLMNOPQRSTUVWXYZ0123456789";
        char map[] = chars.toCharArray();

        String shorturl;
        StringBuilder sb = new StringBuilder();

        // Convert given integer id to a base 62 number
        while (id>0)
        {
            System.out.println("id%62: "+(id%62)+", map[]: " + map[(int)id%62]);
            sb.append(map[(int) (id%62)]);
            id = id/62;
        }
        System.out.println("short url: "+sb.toString());
        StringBuilder sb1 = sb.reverse();
        System.out.println("short url: "+sb1.toString());
        return sb1.toString();
    }
    private long shortURLtoID(String shortUrl) {
        long id = 0; // initialize result

        // A simple base conversion logic
        for (int i=0; i < shortUrl.length(); i++)
        {
            if ('a' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= 'z')
                id = id*62 + shortUrl.charAt(i) - 'a';
            if ('A' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= 'Z')
                id = id*62 + shortUrl.charAt(i) - 'A';
            if ('0' <= shortUrl.charAt(i) && shortUrl.charAt(i) <= '9')
                id = id*62 + shortUrl.charAt(i) - '0';
        }
        return id;
    }
    public static void main(String args[]) {
        ShortURL su = new ShortURL();
        String shortUrl = su.idToShortURL(398874l);
        System.out.println(shortUrl);
        System.out.println(su.shortURLtoID(shortUrl));
        System.out.println(shortUrl.charAt(0) + " " + (int) shortUrl.charAt(0));
        System.out.println(shortUrl.charAt(0) - 'A');
        System.out.println(shortUrl.charAt(0) - '0' + 51);

    }
}
