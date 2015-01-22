package week1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Дмитрий on 18.01.14.
 */
public class Task1_2 {
    public static void main(String[] args) {
        FileReader reader = null;
        BufferedReader br = null;
        try {
            reader = new FileReader("text.txt");
            br = new BufferedReader(reader);
            int elem = 0;
            while ((elem = reader.read()) != -1) {
                System.out.print((char)elem);
            }
//            String line = "";
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {}
            }
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {}
            }
        }


        try (FileReader reader1 = new FileReader("text.txt");
             BufferedReader br1 =  new BufferedReader(reader1);
             FileWriter writer = new FileWriter("text1.txt")
        ) {
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br1.readLine()) != null) {
                result.append(line);
            }
            int val1 = 0;
            String val = null;
            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) != '9') {
                    val1 = (int)result.charAt(i) + 1;
                    val += (char)val1;
                } else val += 0;
            }
            writer.write(val);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


