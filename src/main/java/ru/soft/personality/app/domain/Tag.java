package ru.soft.personality.app.domain;

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
@Table(name = "TAG", uniqueConstraints = {
        @UniqueConstraint(
                columnNames = "name",
                name = "tag_unique_name_idx")})
public class Tag extends AbstractEntity {

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Range(min = 1, max = Integer.MAX_VALUE)
    @Column(name = "cost", nullable = false)
    private Integer importance;

    @NotBlank
    @Column(name = "color_hash", nullable = false)
    private String colorHash;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private Set<Story> stories = new HashSet<>();

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private Set<Gift> gifts = new HashSet<>();
}
