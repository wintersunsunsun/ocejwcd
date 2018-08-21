package app.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.json.JSONObject;

@Entity
public class Quest {

	@EmbeddedId
	private QuestId questId;

	@Column(columnDefinition = "TEXT")
	private String content;

	private String answer;

	@Column(columnDefinition = "TEXT")
	private String explanation;

	/** 是否為多選題 */
	private boolean multi;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "quest")
	private List<Opt> options;

	public QuestId getQuestId() {
		return questId;
	}

	public void setQuestId(QuestId questId) {
		this.questId = questId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public boolean isMulti() {
		return multi;
	}

	public void setMulti(boolean multi) {
		this.multi = multi;
	}

	public List<Opt> getOptions() {
		return options;
	}

	public void setOptions(List<Opt> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		Map<String, Object> quest = new HashMap<>();
		quest.put("num", questId.getNum());
		quest.put("tag", questId.getTag());
		quest.put("question", content);
		quest.put("answer", answer);
		quest.put("explanation", explanation);
		quest.put("multi", multi);

		Map<String, String> optMap = new HashMap<>();
		for (Opt option : options) {
			optMap.put(String.valueOf(option.getoption()), option.getContent());
		}
		quest.put("options", optMap);

		return new JSONObject(quest).toString();
	}
}
