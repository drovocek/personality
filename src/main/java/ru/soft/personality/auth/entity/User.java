package ru.soft.personality.auth.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name="user_data")
public class User {

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID id;

	@NotNull
	@NotBlank
	@Column(name = "username", nullable = false)
	private String username;

	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
	public Activity activity;

	@Email
	@Column(name = "email", nullable = false)
	private String email;

	@NotNull
	@NotBlank
	@Column(name = "password", nullable = false)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "USER_ROLE",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return email.equals(user.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
}
