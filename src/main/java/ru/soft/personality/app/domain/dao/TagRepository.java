package ru.soft.personality.app.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.soft.personality.app.domain.Tag;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
}