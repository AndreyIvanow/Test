package armstrongnumbers;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static armstrongnumbers.Armstrong.MAX_LEVEL;

public class Verifier {

    // Pre compute the powers of 10
    private final static Map<Integer, BigInteger>[] POW_CACHE = new HashMap[10];

    static {
        for (int i = 0; i < POW_CACHE.length; i++) {
            POW_CACHE[i] = new HashMap<>(MAX_LEVEL);
            for (int j = 1; j <= MAX_LEVEL; j++) {
                POW_CACHE[i].put(j, BigInteger.valueOf(i).pow(j));
            }
        }
    }

    public String apply(final byte[] number) {
        String aSum = aSum(number);
        return isPermutation(number, aSum) ? aSum : null;
    }

    private String aSum(final byte[] number) {
        final int len = number.length;
        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i < len; i++) {
            int digit = number[i];
            sum = sum.add(POW_CACHE[digit].get(len));
        }

        return sum.toString();
    }

    private boolean isPermutation(byte[] number, String aSum) {
        if (aSum.length() != number.length){
            return false;
        }

        int[] charCounter = new int[10];
        int distinctChars = 0;

        for (int i = 0; i < aSum.length(); i++){
            int c = aSum.charAt(i) - '0';

            if (charCounter[c] == 0){
                distinctChars++;
            }
            charCounter[c]++;
        }

        for (int i = 0; i < number.length; i++){
            int c = number[i];

            if (charCounter[c] == 0) {
                return false;
            }
            if (charCounter[c] == 1) {
                distinctChars--;
            }
            charCounter[c]--;
        }
        return distinctChars == 0;
    }


}
