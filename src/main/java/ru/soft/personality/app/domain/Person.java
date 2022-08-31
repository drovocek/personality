package ru.soft.personality.app.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@ToString(exclude = {"gifts", "stories"})
@Table(name = "PERSON")
public class Person extends AbstractEntity {

    @NotBlank
    @Column(name = "firstname", nullable = false)
    private String firstname;

    @NotBlank
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @NotBlank
    @Column(name = "surname", nullable = false)
    private String surname;

    @NotNull
    @Range(min = 1, max = 100)
    @Column(name = "importance", nullable = false)
    private Integer importance;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Gift> gifts;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Story> stories;
}
