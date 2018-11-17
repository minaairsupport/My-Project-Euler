import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;


public class Problem168 {

   public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int m = sc.nextInt();
         int result =  solve(m);
         System.out.println(result);
    }
    
    public static int solve(int m) {

        final BigInteger max = TEN.pow(m);
        
        BigInteger HUNDRED_THOUSEND = TEN.pow(5);
        
        int sum = 0;

        for (BigInteger p = TEN; p.compareTo(max) < 0; p = p.multiply(TEN)) {
            for (BigInteger q = ONE; q.compareTo(TEN) < 0; q = q.add(ONE)) {
           
                final BigInteger den = TEN.multiply(q).subtract(ONE);
                final BigInteger diff = p.subtract(q);
                
                for (BigInteger y = ONE; y.compareTo(TEN) < 0; y = y.add(ONE)) {
                    
                    final BigInteger[] qr = y.multiply(diff).divideAndRemainder(den);
                    
                    if (qr[1].equals(ZERO)) {
                        
                        final BigInteger n = TEN.multiply(qr[0]).add(y);
                        
                        if (n.compareTo(p) > 0) {
                            sum += n.mod(HUNDRED_THOUSEND).intValue();
                            sum %= 100000;
                        }
                    }
                }
            }
        }

        return sum;
    }
}