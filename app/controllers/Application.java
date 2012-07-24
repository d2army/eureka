package controllers;

import play.cache.Cache;
import play.mvc.Controller;
import play.mvc.Result;
import analyzer.group.MasterAnalyzer;
import api.LinkedInConnection;

import com.google.code.linkedinapi.client.LinkedInApiClient;

public class Application extends Controller {

	//temporary test constants
	private final static String KEYWORD = "Java";
	
	
	public static Result index() {
		Cache.set("LinkedInApiClient", null);
		LinkedInConnection lic = new LinkedInConnection();
		Cache.set("LinkedInConnection", lic);
		return redirect(lic.getAuthUrl());
	}

	public static Result complete(String oauth_verifier) {
		if (Cache.get("LinkedInConnection") == null){
			return redirect("/");
		} else {
			LinkedInConnection lic = (LinkedInConnection) Cache.get("LinkedInConnection");
			LinkedInApiClient client = lic.completeAuthentication(oauth_verifier);
			Cache.set("LinkedInApiClient",client);
			return redirect("/process");
		}
	}
	
	
	public static Result process() {
		if (Cache.get("LinkedInApiClient") == null) {
			return redirect("/");
		} else {
			LinkedInApiClient client = (LinkedInApiClient) Cache.get("LinkedInApiClient");
			MasterAnalyzer ma = new MasterAnalyzer(client, Application.KEYWORD);
			ma.process();
			String finalResults = ma.getFinalResults();
			
			return ok("Results : "+finalResults);
		}		
		
	}
}