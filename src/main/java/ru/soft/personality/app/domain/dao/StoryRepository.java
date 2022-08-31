package ru.soft.personality.app.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.soft.personality.app.domain.Story;

import java.util.UUID;

public interface StoryRepository extends JpaRepository<Story, UUID> {
}