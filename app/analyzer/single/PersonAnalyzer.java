package analyzer.single;

import java.util.List;

import models.PersonModel;
import analyzer.group.EducationsAnalyzer;
import analyzer.group.HonorsAnalyzer;
import analyzer.group.InterestsAnalyzer;
import analyzer.group.PositionsAnalyzer;
import analyzer.group.RecommendationsReceivedAnalyzer;
import analyzer.group.SkillsAnalyzer;

import com.google.code.linkedinapi.schema.Educations;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Positions;
import com.google.code.linkedinapi.schema.RecommendationsReceived;
import com.google.code.linkedinapi.schema.Skills;

public class PersonAnalyzer extends Analyzer {
	private Person person_;
	
	public PersonAnalyzer(Person person, String keyword){
		this.person_ = person;
		this.keyword_ = keyword;
	}
	
	/**
	 * init
	 * 
	 * Is this Person already in the database
	 */
	private void init(){
		String fullName = this.person_.getFirstName()+" "+this.person_.getLastName();
		boolean alreadyExists = PersonModel.exists(fullName);
		
		if(alreadyExists == true){
			
		} else {
			//need to create person
			PersonModel pm = new PersonModel(fullName);
			pm.save();
		}

	}
	
	
	public void process(){
		this.init();
		
		Positions positionList = this.person_.getPositions();
  	  	PositionsAnalyzer pa = new PositionsAnalyzer(positionList, this.keyword_);
  	  	pa.process();
  	  	
  	  	Educations educationList = this.person_.getEducations();
  	  	EducationsAnalyzer ea = new EducationsAnalyzer(educationList);
  	  	
  	  	Skills skillsList = this.person_.getSkills();
  	  	SkillsAnalyzer sa = new SkillsAnalyzer(skillsList);
  	  	
  	  	String specialties = this.person_.getSpecialties();
  	  	SpecialtiesAnalyzer spa = new SpecialtiesAnalyzer(specialties);
  	  	
  	  	String interestList = this.person_.getInterests();
  	  	InterestsAnalyzer ia = new InterestsAnalyzer(interestList);
  	  	
  	  	String honorsList = this.person_.getHonors();
  	  	HonorsAnalyzer ha = new HonorsAnalyzer(honorsList);
  	  	
  	  	RecommendationsReceived recommendationsList = this.person_.getRecommendationsReceived();
  	  	RecommendationsReceivedAnalyzer rra = new RecommendationsReceivedAnalyzer(recommendationsList);
  	  	
	}
}
