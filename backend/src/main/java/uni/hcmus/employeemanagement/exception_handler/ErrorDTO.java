package uni.hcmus.employeemanagement.exception_handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Data Transfer Object (DTO) for representing error details.
 * This class is used to encapsulate error information that can be sent in API responses.
 *
 * @author <a href="mailto:21120439@student.hcmus">Bùi Minh Duy</a> *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private Date timestamp; // The time when the error occurred
    private int status; // The HTTP status code of the error
    private String path; // The request path where the error occurred
    private List<String> errors = new ArrayList<>(); // A list of error messages

    /**
     * Adds an error message to the list of errors.
     *
     * @param message the error message to add
     */
    public void addError(String message) {
        errors.add(message);
    }
}
