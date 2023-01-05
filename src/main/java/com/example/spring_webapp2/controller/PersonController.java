package com.example.spring_webapp2.controller;

import com.example.spring_webapp2.entity.Person;
import com.example.spring_webapp2.exception.notFoundException;
import com.example.spring_webapp2.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/index")
    public String personList(Model model){
        List<Person> all = personRepository.findAll();
        model.addAttribute("persons", all);
        return "index";
    }

    @PostMapping("/add")
    public String addPerson(Person person, Model model){
        personRepository.save(person);
        return "redirect:/index";
    }

    @GetMapping("signup")
    public String signup(Person person){
        return "add-person";
    }

    @GetMapping("edit/{id}")
    public String updateForm(@PathVariable long id, Model model){
        Optional<Person> personById = personRepository.findById(id);
        Person person = personById.orElseThrow(
                ()->new RuntimeException("person not found: " + id));
        model.addAttribute("person", person);
        return "update-person";
    }

    @PostMapping("update/{id}")
    public String updatePerson(@PathVariable long id, Person person, Model model){
        personRepository.save(person);
        return "redirect:/index";
    }

    @GetMapping("delete/{id}")
    public String deletePerson(@PathVariable long id, Model model){
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new notFoundException(String.valueOf(id)));
        personRepository.delete(person);
        return "redirect:/index";
    }
}
