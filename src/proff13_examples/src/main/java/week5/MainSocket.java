package week5;


import java.io.*;
import java.net.Socket;

public class MainSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.104",30000);
        PrintWriter wr = new PrintWriter(socket.getOutputStream());
        wr.println("Helllllo!!! fgdfsgdfggsf \n");
       wr.flush();
        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader br =new BufferedReader(in);
        System.out.println(br.readLine());
        wr.println("Amigos,muchachos!!! \n");
        wr.flush();
        System.out.println(br.readLine());



}}
