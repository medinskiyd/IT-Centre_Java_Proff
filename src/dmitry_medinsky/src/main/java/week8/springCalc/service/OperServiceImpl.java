package week8.springCalc.service;

import week8.springCalc.dao.CalkDAO;
import week8.springCalc.domain.Operation;

import java.util.List;


/**
 * Created by Дмитрий on 14.03.14.
 */
public class OperServiceImpl implements OperService {

        private CalkDAO CalkDAO;

        public OperServiceImpl(CalkDAO dao) {
            CalkDAO = dao;
        }

        @Override
        public List<Operation> getAllOper() {
            return CalkDAO.findAll();
        }

        @Override
        public void addNewOper(Operation oper) {
            CalkDAO.create(oper);
        }

}
