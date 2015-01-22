package week8.hibernate.dentist.service;



import week8.hibernate.dentist.domain.Client;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 25.05.13
 */
public interface ClientService {
    List<Client> getAllUsers();
    void addNewUser(Client user);
}
