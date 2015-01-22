package week9.chat.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerMain {
    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("week9ping/serverContext.xml");
    }
}
