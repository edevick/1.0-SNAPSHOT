package com.sytoss.app.controller;

import com.sytoss.app.exceptions.NotFoundException;
import com.sytoss.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/tickets")
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private int counter = 4;
    private List<Map<String,String>> tickets = new ArrayList<Map<String,String>>(){{
        add(new HashMap<String,String>(){{ put("id","1"); put("1","2"); }});
        add(new HashMap<String,String>(){{ put("id","2"); put("1","3"); }});
        add(new HashMap<String,String>(){{ put("id","3"); put("1","1"); }});

    }};

    @GetMapping
    public List<Map<String,String>> list(){
        return tickets;
    }

    @GetMapping("{id}")
    public Map<String,String> getOne(@PathVariable String id){
       return getTicket(id);
    }

    private Map<String, String> getTicket(@PathVariable String id) {
        return tickets.stream()
                .filter(ticket -> ticket.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
   public Map<String,String> create (@RequestBody Map<String,String> ticket){
        ticket.put("id",String.valueOf(counter++));
        tickets.add(ticket);
        return ticket;
   }


   @PutMapping("{id}")
   public Map<String,String> update(@PathVariable String id, @RequestBody Map<String,String> ticket){
       Map<String, String> ticketFromDb = getTicket(id);
       ticketFromDb.putAll(ticket);
       ticketFromDb.put("id",id);
       return ticketFromDb;
   }

   @DeleteMapping ("{id}")

   public void delete (@PathVariable String id){
       Map<String, String> ticket = getTicket(id);
       tickets.remove(ticket);

   }

   @GetMapping(value = {"/"})
    public String welcomePage(Model model) {
       model.addAttribute("user", new User());
        return "Main";
    }

    @PostMapping("/user")
    public String updateUser(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "Users";
    }

/*    @GetMapping
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String accessDenied(Model model, Principal principal) {
        return "403Page";
    }

*/


}
