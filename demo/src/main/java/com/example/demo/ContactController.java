package com.example.demo;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Contact> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Contact find (@PathVariable("id")int id){
        return service.find(id);
    }

    @PostMapping
    public Contact create(@RequestBody Contact contact){
        return service.save(contact);
    }

    @PutMapping
    public Contact update(@PathVariable("id")int id, @RequestBody Contact contact){
        return service.update(id, contact);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id")int id){
        return service.delete(id);
    }

}
