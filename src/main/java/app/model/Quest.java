package app.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.json.JSONObject;

@Entity
public class Quest {

    /** 題號 */
    @Id
    private Integer id;

    private String tag;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String answer;

    @Column(columnDefinition = "TEXT")
    private String explanation;

    /** 是否為多選題 */
    private boolean multi;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "quest")
    private List<Opt> options;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the tag
     */
    public Integer getTag() {
        return tag;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @return the explanation
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @param explanation the explanation to set
     */
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    /**
     * @return the options
     */
    public List<Opt> getOptions() {
        return options;
    }

    /**
     * @param options the options to set
     */
    public void setOptions(List<Opt> options) {
        this.options = options;
    }
    
    /**
     * @return the multi
     */
    public boolean isMulti() {
        return multi;
    }

    /**
     * @param multi the multi to set
     */
    public void setMulti(boolean multi) {
        this.multi = multi;
    }

    @Override
    public String toString() {
        Map<String, Object> quest = new HashMap<>();
        quest.put("id", id);
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
