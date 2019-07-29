package encryptdecrypt;

public class ShiftCipher extends ReadAndStorageData implements EncAndDec{

    private String alphabet = "qrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";

    @Override
    public void encrypt(String str, int num, String out) {
        char [] arr = str.toCharArray();

        char[] abcArr = alphabet.toCharArray();

        for(int w = 0; w < arr.length; w++) {
            int s = 0;
            if(arr[w] == ' ') {
                continue;
            }
            while (arr[w] != abcArr[s]) {
                s++;
            }
            arr[w] = abcArr[s + num];
        }

        String encStr = String.valueOf(arr);

        if(out.isEmpty()) {
            System.out.println(encStr);
        } else {
            writeTxt(out ,encStr);
        }
    }

    @Override
    public void decrypt(String str, int num, String out) {

        char [] arr = str.toCharArray();

        char[] abcArr = alphabet.toCharArray();

        for(int w = 0; w < arr.length; w++) {
            int s = 0;
            if(arr[w] == ' ') {
                continue;
            }
            while (arr[w] != abcArr[s]) {
                s++;
            }
            arr[w] = abcArr[s - num];
        }

        String encStr = String.valueOf(arr);

        if(out.isEmpty()) {
            System.out.println(encStr);
        } else {
            writeTxt(out ,encStr);
        }

    }
}
