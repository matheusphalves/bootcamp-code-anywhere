package one.digital.innovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private long id;

    @Valid
    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @Valid
    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @Valid
    @NotEmpty
    private String cpf;
    private String birthDate;
    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;
}
