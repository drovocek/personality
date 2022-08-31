package ru.soft.personality.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Setter
@Getter
@DynamicUpdate
@Entity
@Table(name = "ACTIVITY")
public class Activity {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "activated", nullable = false, updatable = false)
    private boolean activated;

    @NotBlank
    @Column(name = "uuid",updatable = false)
    private String uuid;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
