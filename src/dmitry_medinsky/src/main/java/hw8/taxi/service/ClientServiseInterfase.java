package hw8.taxi.service;

import hw8.taxi.domain.Client;
import java.util.List;

/**
 * Created by Дмитрий on 15.03.14.
 */
public interface ClientServiseInterfase {

    List<Client> getAllClient();
    void addNewClient(Client client);

}
