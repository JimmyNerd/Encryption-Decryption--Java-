package encryptdecrypt;

import java.util.Scanner;

 class SourceData extends ReadAndStorageData {

    void whatNeedToDo(String[] args) {
        Scanner scan = new Scanner(System.in);
        String mod = "";
        String data = "";
        String in = "";
        String out = "";
        String alg = "";
        int key = 0;



        for(int w = 0; w < args.length; w++) {
            switch (args[w]) {
                case "-alg":
                    alg = args[++w];
                    break;
                case "-mode":
                    mod = args[++w];
                    break;
                case "-key":
                    key = Integer.parseInt(args[++w]);
                    break;
                case "-data":
                    data = args[++w];
                    if(data.isEmpty()) {
                        data = scan.next();
                    }
                    break;
                case "-in":
                    in = args[++w];
                    if(in.isEmpty()) {
                        break;
                    }
                    break;
                case "-out":
                    out = args[++w];
                    break;
            }
        }
        if(!data.equals("")) {
            encOrDec(mod, alg, data, key, out);
        } else {
            data = readTxt(in);
            encOrDec(mod, alg, data, key, out);
        }


    }

    private static void encOrDec(String mod, String alg, String data, int key, String out) {
        UnicodeCipher uni = new UnicodeCipher();
        ShiftCipher shif = new ShiftCipher();
        if("enc".equals(mod) && "unicode".equals(alg)) {
                 uni.encrypt(data, key, out);
        } else if("dec".equals(mod) && "unicode".equals(alg)) {
                uni.decrypt(data, key, out);
        } else if("enc".equals(mod) && "shift".equals(alg)) {
                shif.encrypt(data, key, out);
        } else if("dec".equals(mod) && "shift".equals(alg)) {
                shif.decrypt(data, key, out);
        }
    }

}
