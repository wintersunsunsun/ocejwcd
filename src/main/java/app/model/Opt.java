package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Opt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private char option;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "quest_id")
    private Quest quest;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the option
     */
    public char getoption() {
        return option;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param option the option to set
     */
    public void setoption(char option) {
        this.option = option;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the quest
     */
    public Quest getQuest() {
        return quest;
    }

    /**
     * @param quest the quest to set
     */
    public void setQuest(Quest quest) {
        this.quest = quest;
    }
}
