package hw8.taxi;

import hw8.taxi.view.JMenuBarSwing;
import hw8.taxi.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by Дмитрий on 15.03.14.
 */
@Component
public class Main {

    @Autowired
    private Menu menu;

        public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/week8/hw8/taxi/context.xml");
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        Menu main = context.getBean("menu", Menu.class);
        main.main();
    }

}
