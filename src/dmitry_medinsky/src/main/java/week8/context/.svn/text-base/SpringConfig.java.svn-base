package week8.context;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created by Дмитрий on 12.03.14.
 * 2-й способ создания контекста для Spring.
 */
public class SpringConfig {

    public static void main(String[] args) {
        //---------- Для настройки Spring context  ----------
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:/week8/context.xml");

        //---------- Создаем бины ----------
        Man director1 = context.getBean("director1", Man.class);
        Man director2 = context.getBean("director2", Man.class);

        Firm firm1 = context.getBean("firm1", Firm.class);
        Firm firm2 = context.getBean("firm2", Firm.class);


        //---------- Вывод данных в консоль ----------
        System.out.println("Фирмы:");
        System.out.println(firm1.toString());
        System.out.println(firm2.toString());

    }

}
