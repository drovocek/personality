package ru.soft.personality.app.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"tags", "person"})
@Entity
@Table(name = "GIFT")
public class Gift extends AbstractEntity {

    @NotNull
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Range(min = 1, max = Integer.MAX_VALUE)
    @Column(name = "cost", nullable = false)
    private Integer cost;

    @Past
    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotEmpty
    @NotNull
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "GIFT_TAG",
            joinColumns = {@JoinColumn(name = "gift_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private Set<Tag> tags = new HashSet<>();

    @NotNull
    @JoinColumn(name = "PERSON_ID", nullable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Person person;
}
