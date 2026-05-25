package tests.demoqa.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebTablesData {
    private String firstName;
    private String lastName;
    private String age;
    private String email;
    private Integer salary;
    private String department;
}
