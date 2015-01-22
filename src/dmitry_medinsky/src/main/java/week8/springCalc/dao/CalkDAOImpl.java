package week8.springCalc.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import week8.springCalc.domain.Operation;

import java.util.List;

/**
 * Created by Дмитрий on 14.03.14.
 */
public class CalkDAOImpl implements CalkDAO {

    private static Logger log = Logger.getLogger(CalkDAOImpl.class);
    private SessionFactory factory;

    public CalkDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public void create(Operation oper) {
    // Написать
    }
    @Override
    public Operation read(Long id) {

        return null;
    }
    @Override
    public void update(Operation oper){

    }
    @Override
    public void delete(Operation operation) {

    }
    @Override
    public List<Operation> findAll() {
    // Написать
        return null;
    }

}
