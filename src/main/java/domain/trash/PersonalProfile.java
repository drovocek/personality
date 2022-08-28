package domain.trash;

import domain.Gift;
import domain.Story;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;
import java.util.List;

public class PersonalProfile {

    private String firstname;
    private String lastname;
    private String surname;

    private LocalDate dateOfBirth;

    private String religion;

    @Range(min = 0, max = 100)
    private Integer importance;

    private List<Gift> gifts;

    private List<Story> stories;
}
