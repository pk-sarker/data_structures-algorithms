package com.ds.practice.LetterCombination;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LetterCombination {
    private Map<String, String> numberLetterMap = new HashMap<String, String>(){{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};

    private List<String> allCombinations = new ArrayList<>();

    public List<String> letterCombination(String digits) {
        if (digits != null && digits.length()>0) {
            this.combine("", digits);
        }
        return allCombinations;
    }

    private void combine(String combination, String remainingDigits) {
        if (remainingDigits.length()==0){
            allCombinations.add(combination);
            return;
        }

        String digit = remainingDigits.substring(0,1);
        String digitLetters = numberLetterMap.get(digit);

        for(int i=0; i<digitLetters.length();i++){
            this.combine(combination+digitLetters.substring(i, i+1), remainingDigits.substring(1));
        }
    }

    public static void main(String args[]) {
        LetterCombination lc = new LetterCombination();
        List<String> list = lc.letterCombination("38");

        list.forEach( (String comb) -> {
            System.out.print(comb +", ");
        });
    }
}
