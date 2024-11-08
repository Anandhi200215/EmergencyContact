package com.example.EmergencyContact.Controller;


import com.example.EmergencyContact.Entity.EmergencyContact;
import com.example.EmergencyContact.Service.EmergencyContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emergency-contacts")
@RequiredArgsConstructor  // Lombok annotation to generate constructor for autowiring
public class EmergencyContactController {

    private final EmergencyContactService service;

    @GetMapping
    public List<EmergencyContact> getAllContacts() {
        return service.getAllContacts();
    }

    @GetMapping("/{contactId}")
    public EmergencyContact getContactById(@PathVariable Long contactId) {
        return service.getContactById(contactId).get();
    }

    @PostMapping
    public ResponseEntity<EmergencyContact> addContact(@RequestBody EmergencyContact contact) {
        EmergencyContact addedContact = service.addContact(contact);
        return new ResponseEntity<>(addedContact,HttpStatus.CREATED);
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<EmergencyContact> updateContact(@PathVariable Long contactId, @RequestBody EmergencyContact contact) {
        EmergencyContact updatedContact = service.updateContact(contactId, contact);
        return  ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long contactId) {
        service.deleteContact(contactId);
        return ResponseEntity.noContent().build();

    }
}

