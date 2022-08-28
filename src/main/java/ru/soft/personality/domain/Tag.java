package ru.soft.personality.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString(exclude = {"gifts", "stories"})
@Table(name = "tag", uniqueConstraints = {
        @UniqueConstraint(
                columnNames = "name",
                name = "tag_unique_name_idx")})
public class Tag extends AbstractEntity {

    @NotNull
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Range(min = 1, max = Integer.MAX_VALUE)
    @Column(name = "cost", nullable = false)
    private Integer importance;

    @NotNull
    @NotBlank
    @Column(name = "color_hash", nullable = false)
    private String colorHash;

    @ManyToMany(mappedBy = "tags")
    private Set<Story> stories = new HashSet<>();

    @ManyToMany(mappedBy = "tags")
    private Set<Gift> gifts = new HashSet<>();
}
