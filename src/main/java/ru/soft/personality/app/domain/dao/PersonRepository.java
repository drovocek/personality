package ru.soft.personality.app.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.soft.personality.app.domain.Person;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}