package week8.hibernate.dentist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import week8.hibernate.dentist.view.Menu;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
@Component
public class Main {
    @Autowired
    private Menu menu;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/weekend4/spring/hibernate/dentist/applicationContext.xml");
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        Menu main = context.getBean("menu", Menu.class);
        main.main();
    }
}
