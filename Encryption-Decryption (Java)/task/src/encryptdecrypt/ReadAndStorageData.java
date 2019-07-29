package encryptdecrypt;

import java.io.*;
import java.util.*;

class ReadAndStorageData {
     static String readTxt(String nameFile) {
        File file = new File(nameFile.trim());
        String text = "";
         boolean fil = file.exists();
        try(Scanner scan = new Scanner(file)) {
            while(scan.hasNextLine()) {
                text = scan.nextLine();
            }
        } catch(FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        }

        return text;
    }

     static void writeTxt(String nameFile, String text) {
        File file = new File(nameFile);

        try(FileWriter writer = new FileWriter(file)) {

            writer.write(text);
        } catch(IOException ex) {
            System.out.println("Write IOException");
        }
    }
}
