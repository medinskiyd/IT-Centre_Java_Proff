package hw8.taxi.dao;

import hw8.taxi.domain.Client;
import java.util.List;

/**
 * Created by Дмитрий on 15.03.14.
 */
public interface ClientDao {

   void create(Client client);
   Client read(Long id);
   void update(Client client);
   void delete(Client client);
   List<Client> findAll();
   List<Client> getAllClientByPart();

}
