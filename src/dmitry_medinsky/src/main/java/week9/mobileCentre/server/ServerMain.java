package week9.mobileCentre.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;

/**
 * Created by Дмитрий on 21.03.14.
 */
public class ServerMain {
    public static void main(String[] args) throws IOException {
        new ClassPathXmlApplicationContext("mobileCentre/server/serverContext.xml");
        while (true){
        }
    }
}
