package ru.soft.personality.app.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.soft.personality.app.domain.Gift;

import java.util.UUID;

public interface GiftRepository extends JpaRepository<Gift, UUID> {
}