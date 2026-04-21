package pedrorios.contactapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {

    private String id;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private boolean active = true;


}
