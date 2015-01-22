package week8.chat.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        new ClassPathXmlApplicationContext("ping/serverContext.xml");
//        System.out.println("Press any key to terminate");

    }
}
