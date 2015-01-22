package weekend3.association;

import org.hibernate.classic.Session;
import org.hibernate.criterion.Projections;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 11/3/13
 */
public class ProjectionsEx {
    public static void main(String[] args) {
        Session sess = HibernateUtil.getSession();

        List ids = sess.createCriteria(User.class)

                .createAlias("vehicles", "v")
                        //.createCriteria("vehicles")
                //.setProjection(Projections.property("v.id"))
                .setProjection(Projections.projectionList()
                        .add(Projections.property("id"))
                        .add(Projections.property("name"))
                        .add(Projections.property("v.price"), "vprice")
                        //.add(Projections.distinct(Projections.property("name"))
                        )
        .list();

        for (Object elem : ids) {
            Object[] objs = (Object[])elem;
            System.out.println(Arrays.toString(objs));
        }
        System.out.println(ids);
    }
}
