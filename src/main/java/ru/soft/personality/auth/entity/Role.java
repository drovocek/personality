package ru.soft.personality.auth.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "ROLE_DATA", uniqueConstraints = {
        @UniqueConstraint(
                columnNames = "name",
                name = "role_data_name_idx")})
public class Role {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "name", nullable = false, updatable = false, unique = true)
    private String name;
}
