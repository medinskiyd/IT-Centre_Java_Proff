package week4.HomeWork.CharServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Дмитрий on 12.02.14.
 * Написать чат сервер. При подключении, пользователь передает
 * на сервер свое имя и получает список всех подключенных к
 * серверу пользователей. Каждый участник может начать чат с
 * любым участником, кроме себя. Реализовать передачу файлов.
 * Для реализации многопоточности использовать Concurent.
 */
public class ChatServer {

        public static void main(String[] args) throws IOException {

            int clientNumber = 1; // номер клиента.
            try{
                ServerSocket serverSocket = new ServerSocket(3000); // Создаю СерверСокет с портом 3000.
                while(true) {
                    Socket socket = serverSocket.accept(); // Ожидаю присоединения клиента к СерверСокету.
                    System.out.println("Клиент № " + clientNumber);
                    Runnable runnable = new MessageThread(socket, clientNumber);
                    Thread thread = new Thread(runnable);
                    thread.start();
                    clientNumber++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public class Client {

            private int clNumber = 0;

            public  void main(String[] args) throws IOException {

                try{
                    Socket socket = new Socket("localhost", 3000);

                    try{
                        InputStream sIn = socket.getInputStream();
                        OutputStream sOut = socket.getOutputStream();

                        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sOut)));
                        BufferedReader in = new BufferedReader(new InputStreamReader(sIn));

                        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                        String line = null;

                        Runnable runnableRead = new MessageRead(socket, 1, line, in);
                        Thread threadRead = new Thread(runnableRead);
                        threadRead.start();

                        Runnable runnableWrite = new MessageWrite(socket, 2, line, keyboard, out);
                        Thread threadWrite = new Thread(runnableWrite);
                        threadWrite.start();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }catch (NullPointerException e){
                    System.out.println(" Введен null");
                }
            }
        }

        /**
         * Created by Дмитрий on 08.02.14.
         */
        public static class MessageThread implements Runnable {
            private Socket socket;
            private int clientNumber;

            public MessageThread(Socket socket, int clientNumber) {
                this.socket = socket;
                this.clientNumber = clientNumber;
            }
            @Override
            public void run(){
                try {

                    InputStream serverSin = socket.getInputStream(); // Создаю возможность принимать данные в поток ввода.
                    OutputStream serverSout = socket.getOutputStream(); // Создаю возможность отправлять данные в поток вывода.

                    // Записываю данные в поток PrintWriter'ом.
                    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(serverSout)));
                    // Читаю из потока в BufferedReader.
                    BufferedReader in = new BufferedReader(new InputStreamReader(serverSin));

                    // Создаю возможность записывать данные из командной строки в BufferedReader.
                    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

                    String line = "...loading..."; // Строка для работы с сообщениями.

                    System.out.println(" Соединение установлено: " + socket);
                    System.out.println(" Чат запущен! ");

                    // В потоке сервере создаю поток для чтение и поток для записи.
                    Runnable runnableRead = new MessageRead(socket, clientNumber, line, in);
                    Thread threadRead = new Thread(runnableRead);
                    threadRead.start();


                    Runnable runnableWrite = new MessageWrite(socket, clientNumber, line, keyboard, out);
                    Thread threadWrite = new Thread(runnableWrite);
                    threadWrite.start();



                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NullPointerException e){
                    System.out.println(" Введен null");
                    e.printStackTrace();
                }
            }
        }

        /**
         * Created by Дмитрий on 08.02.14.
         */
        public static class MessageWrite implements Runnable {

            private Socket socket;
            private int clientNumber;
            private String line;
            private BufferedReader keyboard;
            private PrintWriter out;

            public MessageWrite(Socket socket, int clientNumber, String line, BufferedReader keyboard, PrintWriter out) {
                this.socket = socket;
                this.clientNumber = clientNumber;
                this.line = line;
                this.keyboard = keyboard;
                this.out = out;
            }
            @Override
            public void run(){

                try {
                    while(true) {
                        System.out.print(" Введите сообщение: ");
                        line = keyboard.readLine(); // Отправляем
                        out.write(line + '\n');
                        out.flush();

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * Created by Дмитрий on 08.02.14.
         */
        public static class MessageRead implements Runnable {

            private Socket socket;
            private int clientNumber;
            private String line;
            private BufferedReader in;

            public MessageRead(Socket socket, int clientNumber, String line, BufferedReader in) {
                this.socket = socket;
                this.clientNumber = clientNumber;
                this.line = line;
                this.in = in;
            }
            @Override
            public void run(){
                try {
                    while(true) {
                        if(in.readLine() != null){
                            line = in.readLine(); // принимаем строку.
                            System.out.print(" Чат № " + clientNumber +":"+ line);
                            System.out.println();

                        } else {
                            System.out.println(" Строка NULL");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
}
