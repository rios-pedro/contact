package pedrorios.contactapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pedrorios.contactapi.domain.Contact;
import pedrorios.contactapi.dto.ContactRequest;
import pedrorios.contactapi.dto.ContactResponse;
import pedrorios.contactapi.repository.ContactRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    @Autowired
    private ContactRepository repo;

    public List<ContactResponse> findAll() {
        return repo.findContactByActiveTrue().stream()
                .map(this::toReturn)
                .toList();
    }

    public ContactResponse findById(String id) {
        Contact contact = repo.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
        return toReturn(contact);
    }

    public ContactResponse create(ContactRequest request) {

        long age = ChronoUnit.YEARS.between(request.getBirthDate(), LocalDate.now());

        if (age < 18) {
            throw new RuntimeException("Contato deve ter 18 anos ou mais");
        }

        Contact contact = new Contact();
        contact.setName(request.getName());
        contact.setBirthDate(request.getBirthDate());
        contact.setGender(request.getGender());
        return toReturn(repo.save(contact));
    }

    public ContactResponse update(String id, ContactRequest request) {
        Contact contact = repo.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
        contact.setName(request.getName());
        contact.setBirthDate(request.getBirthDate());
        contact.setGender(request.getGender());
        contact.setActive(request.isActive());
        return toReturn(repo.save(contact));
    }

    public void delete(String id) {
        Contact contact = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));
        repo.delete(contact);
    }

    private ContactResponse toReturn (Contact ct){
        return new ContactResponse(
                ct.getId(),
                ct.getName(),
                ct.getBirthDate(),
                ct.getGender(),
                ct.isActive()
        );

    }
}
