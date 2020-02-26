import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.lang.*;
import java.io.*;

// https://www.hackerrank.com/challenges/determining-dna-health/problem

public class HealthDNA {

    static int math(String[] genes , int[] health, int first, int last, String d){

        int count=0;
        int temp=0;

        for(int i=first; i<last+1; i++){

            temp=count(genes[i],d);

            if(temp!=0)
            {
                count+=health[i]*temp;
            }

        }

        return count;
    }

    static int count(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int res = 0;

        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) {
            /* For current index i, check for
        pattern match */
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
            if (j == M) {
                res++;
                j = 0;
            }
        }
        return res;
    }




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] genes = new String[n];

        String[] genesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String genesItem = genesItems[i];
            genes[i] = genesItem;
        }

        int[] health = new int[n];

        String[] healthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int healthItem = Integer.parseInt(healthItems[i]);
            health[i] = healthItem;
        }

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        BigInteger max = new BigInteger("0");
        BigInteger min=max;

        int [] values = new int[n];

        for (int sItr = 0; sItr < s; sItr++) {

            String[] firstLastd = scanner.nextLine().split(" ");

            int first = Integer.parseInt(firstLastd[0]);

            int last = Integer.parseInt(firstLastd[1]);

            String d = firstLastd[2];

            int count=0;
            int temp=0;

            System.out.println(Arrays.toString(genes)+" "+d);

            for(int i=first; i<last+1; i++){

                temp=count(genes[i],d);

                if(temp!=0)
                {
                    count+=health[i]*temp;
                }

            }

            values[sItr]=count;
            // values[sItr]=count;

            if(max.compareTo(new BigInteger(values[sItr]+""))==1) {
                max = new BigInteger(values[sItr] + "");
            }

            if(min.compareTo(new BigInteger(values[sItr]+""))==-1) {
                min = new BigInteger(values[sItr] + "");
                if(sItr==0) max=min;

            }


        }

        System.out.println(min+" "+max);
        scanner.close();
    }

}


