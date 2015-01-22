package week8.springCalc.dao;

import week8.springCalc.domain.Operation;

import java.util.List;

/**
 * Created by Дмитрий on 12.03.14.
 */
public interface CalkDAO {

    void create(Operation oper);
    Operation read(Long id);
    void update(Operation oper);
    void delete(Operation oper);
    List<Operation> findAll();

}
