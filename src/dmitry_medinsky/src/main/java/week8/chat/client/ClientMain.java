package week8.chat.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        new ClassPathXmlApplicationContext("ping/clientContext.xml");
    }
}
