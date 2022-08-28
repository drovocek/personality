package ru.soft.personality.domain.dao;

import ru.soft.personality.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StoryRepository extends JpaRepository<Story, UUID> {
}