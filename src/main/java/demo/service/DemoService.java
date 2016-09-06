package demo.service;

import demo.model.Address;
import demo.model.User;
import demo.repo.AddressRepository;
import demo.repo.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class DemoService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	public Collection<Address> findAddressesByUser(User user) {

		// if you add this then a more descriptive exception is available
		// Hibernate.initialize(user.getAdresses());

		// Solution
		// user = (User) sessionFactory.getCurrentSession().load(User.class, user.getId());
		// OR
		// user = userRepository.findByUsername(user.getUsername());

		Collection<Address> addresses = user.getAdresses();

		return addresses;

		// Another solution: Fetch addresses directly
		// return addressRepository.findByOwner(user);
	}
}
