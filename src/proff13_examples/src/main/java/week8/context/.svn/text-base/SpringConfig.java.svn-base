package week8.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 25.05.13
 */
public class SpringConfig {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:/week8/context.xml");
        Man man1 = context.getBean("man1", Man.class);
        Man man2 = context.getBean("man2", Man.class);

        System.out.println(man1);
        System.out.println(man2);

    }
}
