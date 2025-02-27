package javaguide.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    /*
    we use the DTO class to transfer the data between the client and
    server
    it is like the object property for the response
    */

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
