package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class PersonModel extends Model{

    @Id
    public Long id;
    
    @Constraints.Required
	public String name;

	public PersonModel(String name){
		this.name = name;
	}
	
	public static Model.Finder<Long, PersonModel> find =
				new Model.Finder<Long, PersonModel>(Long.class, PersonModel.class);
	
	
	public static boolean exists(String name){
		int rowCount = find.where()
						.ilike("name", name)
						.findRowCount();
		
		return (rowCount > 0 ? true : false);
	}
}
