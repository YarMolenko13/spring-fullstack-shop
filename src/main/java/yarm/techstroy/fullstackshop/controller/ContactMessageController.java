package yarm.techstroy.fullstackshop.controller;

import org.springframework.web.bind.annotation.*;
import yarm.techstroy.fullstackshop.model.ContactMessage;
import yarm.techstroy.fullstackshop.repository.ContactMessageRepository;

import java.util.List;

@RestController
@RequestMapping(value = "api/contact/")
public class ContactMessageController {

    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageController(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    @GetMapping("get")
    public List<ContactMessage> getAllContacts() {
        return contactMessageRepository.findAll();
    }

    @PostMapping("add")
    public String addNewContactMessage(@RequestBody ContactMessage message) {
        contactMessageRepository.save(message);
        return "Ok";
    }
}
