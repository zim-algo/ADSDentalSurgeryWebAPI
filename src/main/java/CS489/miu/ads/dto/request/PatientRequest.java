package CS489.miu.ads.dto.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class PatientRequest {

    private String firstName;
    private String lastName;
    private String patientNumber;
    private String phoneNumber;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private AddressRequest address;
}
