package hometask1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyScanner  {

    private String c;
    BufferedReader br;
    FileReader reader;

    public MyScanner(String c) {
        this.c=c;

    }

    public  void nextLine() {

        try (BufferedReader br = new BufferedReader(new FileReader(getC())) ){
            StringBuilder sb = new StringBuilder();
            String elem ;
            while((elem=br.readLine())!= null){
                System.out.println(elem);
                sb.append(elem);

            }

            System.out.println(sb.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void next() {

    }



    public void close() {
        if(reader != null){
            try {
                reader.close();
            }catch (IOException e){}
        }
        if(br !=null){
            try{
                br.close();
            }catch (IOException e){}

        }

    }

    public void nextInt() {


    }



    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

}





