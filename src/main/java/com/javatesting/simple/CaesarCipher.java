/**
 * 
 */
package com.javatesting.simple;

/**
 * @author vijpande
 *
 */
import java.util.Scanner;


public class CaesarCipher {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       // int n = in.nextInt();
        //String s = in.next();
        
        String s = "UGBQTFOTHJ";
        int n =76;
        //int k = in.nextInt() % 26;
        int k = n % 26;
        String str = "";
        
        
        for (int i = 0; i < s.length(); i++) {
            str = str + getAsciiChar(s.charAt(i), k);
        }
        System.out.println(str);
    }
 
    static char getAsciiChar(char ch, int incremental) {
        if (Character.isLetter(ch)) {
            int i = (int) ch;
            i = i + incremental;
 
            if (Character.isUpperCase(ch)) {
                if (i > 90) {
                    int num = (int) ch + incremental;
                    i = num - 26;
                }
            } else if (i > 122) {
                int num = (int) ch + incremental;
                i = num - 26;
            }
            return (char) i;
        }
        return ch;
    }
 
}

