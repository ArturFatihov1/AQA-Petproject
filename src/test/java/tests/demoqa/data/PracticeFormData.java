package tests.demoqa.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PracticeFormData {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobile;
    private String subjects;
    private String address;
}
