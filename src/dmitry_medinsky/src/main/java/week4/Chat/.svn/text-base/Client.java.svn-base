package week4.Chat;

import org.apache.log4j.net.SocketServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Дмитрий on 05.02.14.
 */
public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 3000);

        try{
            InputStream sIn = socket.getInputStream();
            OutputStream sOut = socket.getOutputStream();

            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sOut)));
            BufferedReader in = new BufferedReader(new InputStreamReader(sIn));

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;


                while(true) {
                    System.out.print(" Напишите сообщение: ");
                    line = keyboard.readLine();
                    out.write(line + '\n');
                    out.flush(); // заставляем поток закончить передачу данных.

                    line = in.readLine(); // принимаем строку.
                    if(!line.isEmpty() && line != null){
                        System.out.print(" Новое сообщение: " + line);
                        System.out.println();
                    }
                    if(line.equals("closeChat")) {
                        socket.close();
                        System.out.println(" Сервер остановлен!");
                    }
                }
        } catch(IOException e) {
            System.out.println(" Соединение прервано! Сервер не отчечает.");
        } finally {
            System.out.println(" Клиент остановлен!");
        }





    }



}
