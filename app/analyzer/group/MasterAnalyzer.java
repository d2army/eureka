package analyzer.group;

import java.util.EnumSet;

import analyzer.single.Analyzer;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.schema.Connections;

public class MasterAnalyzer extends Analyzer {
	final private static EnumSet<ProfileField> FIELDS_TO_GRAB = EnumSet.of(
			  ProfileField.FIRST_NAME, 
			  ProfileField.LAST_NAME, 
			  ProfileField.SPECIALTIES,
			  ProfileField.POSITIONS,
			  ProfileField.EDUCATIONS, 
			  ProfileField.SKILLS,
			  ProfileField.INTERESTS,
			  ProfileField.HONORS, 
			  ProfileField.RECOMMENDATIONS_RECEIVED
			  );
	private LinkedInApiClient client_;
	
	public MasterAnalyzer(LinkedInApiClient client, String keyword){
		this.client_ = client;
		this.keyword_ = keyword;
	}
	
	public void setKeyword(String keyword){
		this.keyword_ = keyword;
	}
	
	public void process() {
		Connections connections = this.client_.getConnectionsForCurrentUser(MasterAnalyzer.FIELDS_TO_GRAB);
		ConnectionsAnalyzer ca = new ConnectionsAnalyzer(connections, this.keyword_);
		ca.process();
	}

}
