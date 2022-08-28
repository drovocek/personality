package domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString(exclude = {"tags", "person"})
@Table(name = "story", uniqueConstraints = {
        @UniqueConstraint(
                columnNames = "name",
                name = "tag_unique_name_idx")})
public class Story extends AbstractEntity {

    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    @NotEmpty
    @NotNull
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Story_Tag",
            joinColumns = {@JoinColumn(name = "story_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private Set<Tag> tags = new HashSet<>();

    @NotNull
    @JoinColumn(name = "PERSON_ID", nullable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Person person;
}
