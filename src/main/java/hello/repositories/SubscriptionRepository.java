package hello.repositories;

import hello.models.Subscription;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
    Optional<Subscription> findByEmail(String email);

}
