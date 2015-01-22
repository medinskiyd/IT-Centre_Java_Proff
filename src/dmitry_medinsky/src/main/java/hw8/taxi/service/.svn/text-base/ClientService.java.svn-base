package hw8.taxi.service;

import hw8.taxi.dao.ClientDao;
import hw8.taxi.domain.Client;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Дмитрий on 15.03.14.

 Написать приложение, с использованием слоистой архитектуры (спринг, аннотации, хибернэйт, пропертиз).
 Функции:
 - зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
 - вывести всех клиентов порциями по 10 человек (размер порции задается в properties файле)
 - вывести всех клиентов наездивших на сумму больше указанной
 - вывести всех клиентов, делавших заказы за последний месяц

 Класс задания hw8.taxi.service.ClientService
 */
@Service
public class ClientService implements ClientServiseInterfase{

    private ClientDao clientDao;

    @Autowired
    public ClientService(ClientDao dao) {
        clientDao = dao;
    }

    @Override
    public List<Client> getAllClient() {
        return clientDao.findAll();
    }

    //зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
    @Override
    public void addNewClient(Client client) {
        clientDao.create(client);
    }

    public Client getClientById(Long id) {
        return clientDao.read(id);
    }

    //вывести всех клиентов порциями по 10 человек (размер порции задается в properties файле)
    public List<Client> getAllClientByPart() {
        return clientDao.getAllClientByPart();
    }



}
