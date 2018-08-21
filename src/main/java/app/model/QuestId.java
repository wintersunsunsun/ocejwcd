package app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class QuestId implements Serializable {

	@Column(name = "num", nullable = false)
	private Integer num;

	@Column(name = "tag", nullable = false, length = 30)
	private String tag;
	
	public QuestId() {}
	
	public QuestId(String tag, Integer num) {
		this.num = num;
		this.tag = tag;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestId that = (QuestId) o;

        if (!tag.equals(that.tag)) return false;
        return num.equals(that.num);
    }

    @Override
    public int hashCode() {
        int result = num.hashCode();
        result = 31 * result + tag.hashCode();
		return result;
	}
}
