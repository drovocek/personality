package ru.soft.personality.domain.dao;

import ru.soft.personality.domain.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GiftRepository extends JpaRepository<Gift, UUID> {
}