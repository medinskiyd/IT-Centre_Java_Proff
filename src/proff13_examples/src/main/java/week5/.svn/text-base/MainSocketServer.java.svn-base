package week5;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainSocketServer {
    public static void main(String[] args)throws IOException{
       ServerSocket serverSocket = new ServerSocket(30000);
       Socket socket=serverSocket.accept();
//        Socket socket = new Socket("192.168.1.104",30000);
        PrintWriter wr = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
       BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder st = new StringBuilder();
      while (true){
           String string =brr.readLine() ;
         // st.append(string);

            wr.println(st.append(string));
            wr.flush();
          String str = br.readLine();
        System.out.println(str);

    }
}
}