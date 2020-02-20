public class Prisoner {


    static int saveThePrisoner(int n, int m, int s) {

        if(s==1) {
         int base= Math.floorMod(m, n);
         if(base==0)
             return n;
         else
             return base;

        }
        else{
            int base=Math.floorMod(m,n)+s-1;
            if(base>n)
                return Math.floorMod(base,n);
            else
                return base;

        }

    }
    public static void main(String[] args) {
       // System.out.println("Helloo"+Math.floorMod(5,2)); 91 111224659 1
         System.out.println(saveThePrisoner(91,111224659,1));


    }

}