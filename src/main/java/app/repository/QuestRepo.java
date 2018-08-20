package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Quest;

public interface QuestRepo extends JpaRepository<Quest, Integer> {

}
