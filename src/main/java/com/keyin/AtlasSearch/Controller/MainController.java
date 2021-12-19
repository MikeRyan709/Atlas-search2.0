package com.keyin.AtlasSearch.Controller;

import com.keyin.AtlasSearch.Model.Location;
import com.keyin.AtlasSearch.Model.Search;
import com.keyin.AtlasSearch.Model.User;
import com.keyin.AtlasSearch.Repository.LocationRepository;
import com.keyin.AtlasSearch.Repository.SearchRepository;
import com.keyin.AtlasSearch.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private SearchRepository searchRepository;

    @GetMapping(path = "/signout")
    public String getLogOutPage() {
        return "signout";
    }

    @GetMapping(path = "/search")
    public String showSearchForm(Model model) {
        Search search = new Search();
        model.addAttribute("search", search);
        //List<String> databaseList = Arrays.asList("PgAdmin(SQL)", "MongoDB(NoSQL)", "Both");
        //model.addAttribute("databaseList", databaseList);
        return "search";
    }

    // search path
    @PostMapping(path = "/search")
    public String submitSearchFormPgAdmin(@ModelAttribute("search")Search search, Model model) {
        List<Location> listLocations = new ArrayList<Location>();
        LocationRepository.findByCountry(search.getTopic()).forEach(listLocations::add);
        model.addAttribute("listLocations", listLocations);
        System.out.println("#######" + listLocations);
        searchRepository.insertWithEntityManager(new Search(search.getTopic(), search.getDatabase()));
        return "search_results";
    }


    // Signup path
    @GetMapping(path = "/signup")
    public String showSignupForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    // Signup path
    @PostMapping(path = "/signup")
    public String submitSignupForm(@ModelAttribute("user")User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        usersRepository.save(user);
        System.out.println(user);
        return "signup_success";
    }

    // Users path
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = usersRepository.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }
}

