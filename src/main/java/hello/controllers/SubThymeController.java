package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import hello.models.Subscription;
import hello.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class SubThymeController {

    @Autowired
    private SubscriptionRepository subRepository;

    @GetMapping("/thSub")
    public String showBooks(Model model) {
        model.addAttribute("book", new Subscription()); // New Book to add
        model.addAttribute("books", subRepository.findAll());
        return "books";
    }

    @PostMapping("/thSub")
    public String addBook(@ModelAttribute("book") Subscription sub){
        subRepository.save(sub);
        return "thankyou";
    }

}






