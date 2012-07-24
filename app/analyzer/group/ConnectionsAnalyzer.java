package analyzer.group;

import java.util.EnumSet;

import analyzer.single.Analyzer;
import analyzer.single.PersonAnalyzer;

import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.schema.Connections;
import com.google.code.linkedinapi.schema.Person;
import com.google.code.linkedinapi.schema.Position;
import com.google.code.linkedinapi.schema.Positions;


public class ConnectionsAnalyzer extends Analyzer{
	private Connections connections_;
	
	public ConnectionsAnalyzer(Connections connections, String keyword){
		this.connections_ = connections;
		this.keyword_ = keyword;
	}
	
	public void process(){
		 for (Person person : this.connections_.getPersonList()) {
			 PersonAnalyzer pa = new PersonAnalyzer(person,this.keyword_);
			 pa.process();
		 }
	}
}
