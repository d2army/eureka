package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RelatedKeywordsModel{

	@Id
	public Integer relatedKeywordsId;
	public Integer subjectSourceId;
	public Integer subjectDestId;
	public Float strengthScore;
}
