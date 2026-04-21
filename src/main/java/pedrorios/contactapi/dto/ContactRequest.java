package pedrorios.contactapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {

    @NotBlank(message = "Request name.")
    private String name;

    private LocalDate birthDate;

    @Pattern(regexp = "^[FM]$", message = "Gender need to be M or F.")
    private String gender;

    private boolean active;
}
