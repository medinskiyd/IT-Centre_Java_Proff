package week9.chat.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientMain {
    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("week9ping/clientContext.xml");
    }
}
