package algorithm.bitmasking;

import java.util.Arrays;

public class GetBinary {

    public static String getBinary(int num) {
        byte[] binary = new byte[4];
        int binaryIndex = binary.length - 1;
        while (num >= 1) {
            if (num == 1) binary[binaryIndex] = 1;
            else if ((num & 1) == 0) binary[binaryIndex] = 0;
            else binary[binaryIndex] = 1;
            binaryIndex--;
            num = num / 2;
        }
        return Arrays.toString(binary);
    }
}
