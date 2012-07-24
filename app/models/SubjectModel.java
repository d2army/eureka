package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubjectModel{

	@Id
	public int subjectId;
	public String subjectName;
	
	
}
