package week8.hibernate.example;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/14/14
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:/week8/hibernate/context.xml");
        SessionFactory factory = context.getBean("mySessionFactory", SessionFactory.class);

        Company company = new Company("Janek&Son");
        Employee employee = new Employee("Nalyvaiko", 23, company);
        company.getEmployees().add(employee);

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();

        List companies = session.createCriteria(Company.class).list();
        System.out.println(companies);

        session.close();
    }
}
