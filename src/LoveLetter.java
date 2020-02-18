import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LoveLetter {


    static int theLoveLetterMystery(String s) {

        int counter=0;
        StringBuilder buildPalindrome = new StringBuilder(s);

        for (int i=0; i<(s.length()/2); i++) {

            if(buildPalindrome.charAt(i)!=buildPalindrome.charAt(s.length()-i-1)) {

                buildPalindrome.setCharAt(s.length() - i - 1, buildPalindrome.charAt(i));
                counter+=Math.abs((int)s.charAt(i) - (int)s.charAt(s.length()-i-1));
            }


        }

        return counter;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(theLoveLetterMystery("abcd"));
    }


    }
