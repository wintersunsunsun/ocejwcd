package app.controller;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.model.Opt;
import app.model.Quest;
import app.model.QuestId;
import app.repository.OptRepo;
import app.repository.QuestRepo;

@RestController
public class MainController {

	@Autowired
	private QuestRepo questRepo;

	@Autowired
	private OptRepo optRepo;

	@GetMapping(path = "/quest/{tag}/{num}")
	public @ResponseBody String getQuest(@PathVariable("tag") String tag, @PathVariable("num") int num) {
		Optional<Quest> row = questRepo.findById(new QuestId(tag, num));
		return row.get().toString();
	}

	@Transactional
	@PostMapping(path = "/addQuest")
	public void addNewUser(@RequestBody Map<String, Object> reqMap) {
		QuestId questId = new QuestId();
		questId.setNum((int) reqMap.get("num"));
		questId.setTag((String) reqMap.get("tag"));
		Quest quest = new Quest();
		quest.setQuestId(questId);
		quest.setContent((String) reqMap.get("question"));
		quest.setAnswer((String) reqMap.get("answer"));
		quest.setExplanation((String) reqMap.get("explanation"));
		quest.setMulti((boolean) reqMap.get("multi"));
		quest = questRepo.saveAndFlush(quest);

		Map<String, String> options = (Map) reqMap.get("options");
		for (Entry<String, String> entry : options.entrySet()) {
			Opt opt = new Opt();
			opt.setoption(entry.getKey().charAt(0));
			opt.setContent(entry.getValue());
			opt.setQuest(quest);
			optRepo.saveAndFlush(opt);
		}
	}

	@DeleteMapping(path = "/removeAll")
	public void removeAll() {
		questRepo.deleteAll();
		optRepo.deleteAll();
	}
}
