package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Quest;
import app.model.QuestId;

public interface QuestRepo extends JpaRepository<Quest, QuestId> {

}
