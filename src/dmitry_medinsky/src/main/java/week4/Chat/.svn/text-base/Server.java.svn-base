package week4.Chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Дмитрий on 05.02.14.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        try{
            ServerSocket serverSocket = new ServerSocket(3000); // Создаю СерверСокет с портом 3000.
            Socket socket = serverSocket.accept(); // Ожидаю присоединения клиента к СерверСокету.

            try {
                InputStream serverSin = socket.getInputStream(); // Создаю возможность принимать данные в поток ввода.
                OutputStream serverSout = socket.getOutputStream(); // Создаю возможность отправлять данные в поток вывода.

                // Записываю данные в поток PrintWriter'ом.
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(serverSout)));
                // Читаю из потока в BufferedReader.
                BufferedReader in = new BufferedReader(new InputStreamReader(serverSin));

                // Создаю возможность записывать данные из командной строки в BufferedReader.
                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

                String line = ""; // Строка для работы с сообщениями.

                System.out.println(" Соединение установлено: " + socket);
                System.out.println(" Чат запущен! ");

                while(true) {
                    line = in.readLine(); // принимаем строку.
                    if(!line.isEmpty() && line != null){
                        System.out.print(" Новое сообщение: " + line);
                        System.out.println();
                    }
                    if(line.equals("closeChat")) {
                        socket.close();
                        System.out.println(" Сервер остановлен!");
                    }

                       System.out.print(" Введите сообщение: ");
                       line = keyboard.readLine(); // Отправляем
                       out.write(line + '\n');
                       out.flush();
                    }

            } catch (InterruptedIOException e){
                    socket.close();
                    serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(" Сервер остановлен!");
        }
    }
}
