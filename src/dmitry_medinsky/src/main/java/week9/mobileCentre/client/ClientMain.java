package week9.mobileCentre.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;

/**
 * Created by Дмитрий on 21.03.14.
 */
public class ClientMain {
    public static void main(String[] args) throws IOException {
        new ClassPathXmlApplicationContext("mobileCentre/client/clientContext.xml");
    }
}
