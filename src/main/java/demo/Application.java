package demo;

import demo.model.Address;
import demo.model.User;
import demo.repo.AddressRepository;
import demo.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository, AddressRepository addressRepository) {
        return (args) -> {
            User user = new User("user", "password");

            Address address1 = new Address("aaa", "111");
            address1.setOwner(user);

            Address address2 = new Address("bbb", "222");
            address2.setOwner(user);

//            user.getAdresses().add(address1);
//            user.getAdresses().add(address2);

            userRepository.save(user);
            addressRepository.save(address1);
            addressRepository.save(address2);

        };
    }

}
