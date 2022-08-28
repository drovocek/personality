package ru.soft.personality.domain.dao;

import ru.soft.personality.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
}