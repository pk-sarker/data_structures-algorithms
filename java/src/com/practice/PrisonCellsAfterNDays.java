package com.practice;

import java.util.Arrays;
import java.util.HashMap;

public class PrisonCellsAfterNDays {
    public static int[] prisonAfterNDays(int[] cells, int N) {
        int[] row = new int[cells.length];
        int n = cells.length;
        boolean[] rowAr = new boolean[n];
        boolean[] cellAr = new boolean[n];
        for(int i=0; i<n; i++) {
            cellAr[i] = cells[i] == 1 ? true:false;
        }

        int count = 0;

        HashMap<String, int[]> wholePattern = new HashMap<>();

        int loopCount = 0;
        while(count < N) {
            String key = Arrays.toString(cells).replace(", ","").substring(1, n+1);
            if (!wholePattern.containsKey(key)) {
                for(int i=0; i<n; i++) {
                    if (i==0 || i==n-1) {
                        row[i] = 0;
                    } else if (cells[i-1] == cells[i+1]) {
                        row[i] = 1;
                    }
                }
                wholePattern.put(key, row);
            } else {
                System.out.println(">> " + loopCount);
                row = wholePattern.get(key);
                break;
            }
            cells = new int[n];
            cells = row;
            row = new int[n];
            count++;
            loopCount++;
        }

        // if loop count is found
        // number of transformation = N % loopCount = x < loopCount
        //  now just do transformation for x times only.

        return cells;
    }

    public static void main(String args[]) {
        System.out.println("\nInput: [0,1,0,1,1,0,0,1] N=7\nOutput: " + Arrays.toString(PrisonCellsAfterNDays.prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 30)));
    }
}
