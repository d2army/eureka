package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonSubjectMappingModel{

	@Id
	public Integer personSubjectMappingId;
	public Integer personId;
	public Integer subjectId;
	public Float strengthScore;
	
}
