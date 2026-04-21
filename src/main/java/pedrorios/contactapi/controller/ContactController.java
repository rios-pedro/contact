package pedrorios.contactapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedrorios.contactapi.dto.ContactResponse;
import pedrorios.contactapi.service.ContactService;


import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
@Tag(name = "Contacts", description = "Contact management")
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping
    @Operation(description = "Search all active contacts")
    public ResponseEntity<List<ContactResponse>> findAll() {
            return ResponseEntity.ok(service.findAll());
        }

    @GetMapping(value = "{id}")
    @Operation(description = "Search contact by id")
    public ResponseEntity<ContactResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
