package week8.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week8.context.Man;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/14/14
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:/week8/properties/context.xml");
        Man man1 = context.getBean("man1", Man.class);
        Man man2 = context.getBean("man2", Man.class);

        System.out.println(man1);
        System.out.println(man2);
    }
}
