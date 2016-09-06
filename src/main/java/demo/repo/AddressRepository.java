package demo.repo;

import demo.model.Address;
import demo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface AddressRepository extends CrudRepository<Address, Long> {

	Collection<Address> findByOwner(User owner);

}
