package com.ds.practice.FormatPhoneNumber;

public class FormatPhoneNumber {

    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int n = number.length();
        int count = 0;
        for(int i=0; i<n; i++) {
            if (Character.isDigit(number.charAt(i))) {
                sb.append(number.charAt(i));
                count++;
            }
        }

        int pos = 0;
        if (count<=3) {
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();

        while(pos<count) {
            if (pos+4 == count) {
                sb2.append(sb.substring(pos, pos+2));
                sb2.append("-");
                sb2.append(sb.substring(pos+2, pos+4));
                pos = pos + 4;
            }  else if (pos+3 <= count) {
                sb2.append(sb.substring(pos, pos+3));
                if (pos+3!=count) {
                    sb2.append("-");
                }
                pos = pos + 3;
            } else {
                sb2.append(sb.substring(pos, count));
                pos = count;
            }
        }
        return sb2.toString();
    }

    public static void main(String args[]) {
        FormatPhoneNumber fp = new FormatPhoneNumber();
        System.out.println("\nInput: 1-2\nOutput: " + fp.reformatNumber("1-2"));
        System.out.println("\nInput: 12-3\nOutput: " + fp.reformatNumber("12-3"));
        System.out.println("\nInput: 123 4-5678\nOutput: " + fp.reformatNumber("123 4-5678"));
        System.out.println("\nInput: --17-5 229 35-39475 \nOutput: " + fp.reformatNumber("--17-5 229 35-39475 "));

    }
}
