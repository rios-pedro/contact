package pedrorios.contactapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedrorios.contactapi.domain.Contact;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, String> {
    List<Contact> findContactByActiveTrue();
}
