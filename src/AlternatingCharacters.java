import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        int delete=0;
        for(int i=0; i<s.length(); i++)
        {
            for(int j=i+1; j<s.length(); j++)
            {

                if(s.charAt(i)==s.charAt(j)) {
                    s = s.substring(0, i) + s.substring(i + 1);
                    delete++;
                    i++;
                }
                else{
                    j=s.length();
                }
            }

        }


        if(s.length()>1 && delete!=0)
            delete=delete+alternatingCharacters(s);

        return delete;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println(result);
        }


        scanner.close();
    }
}
