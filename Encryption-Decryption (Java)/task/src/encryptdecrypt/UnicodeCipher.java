package encryptdecrypt;

public class UnicodeCipher extends ReadAndStorageData implements EncAndDec{
    @Override
    public void encrypt(String str, int num, String out) {

        char [] arrStr = str.toCharArray();
        for(int s = 0; s < arrStr.length; s++) {
            arrStr[s] += num;
        }
        String encStr = String.valueOf(arrStr);

        if(out.isEmpty()) {
            System.out.println(encStr);
        } else {
            writeTxt(out ,encStr);
        }

    }

    @Override
    public void decrypt(String str, int num, String out) {

        char [] arrStr = str.toCharArray();
        for(int s = 0; s < arrStr.length; s++) {
            arrStr[s] -= num;
        }
        String encStr = String.valueOf(arrStr);

        if(out.isEmpty()) {
            System.out.println(encStr);
        } else {
            writeTxt(out ,encStr);
        }

    }
}
