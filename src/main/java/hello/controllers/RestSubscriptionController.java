package hello.controllers;

import hello.models.Subscription;
import hello.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class RestSubscriptionController {

    private final SubscriptionRepository subscriptionRepo;

    public RestSubscriptionController(SubscriptionRepository subscriptionRepo) {
        this.subscriptionRepo = subscriptionRepo;
    }

    @RequestMapping("/subscribe")
    public String subscribe(@RequestParam String name, @RequestParam String email) {
        Optional<Subscription> sub = subscriptionRepo.findByEmail(email);
        if ( sub.isPresent())
            return "Email is already exist";
        else{
        Subscription subscription = new Subscription();
        subscription.setEmail(email);
        subscription.setName(name);
        subscriptionRepo.save(subscription);
        return "Created new subscription for " + email;
    }}
    @RequestMapping("/unsubscribe")
    public String unsubscribe(@RequestParam String email) {
//
        Optional<Subscription> subscription = subscriptionRepo.findByEmail(email);
        if (! subscription.isPresent())
            return "Email not found";
        else {
        subscriptionRepo.delete(subscription.get());//deleting from the database
        return "Unsubscribed " + email;
    }}
}
