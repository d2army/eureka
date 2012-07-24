package api;

import java.util.EnumSet;

import play.cache.Cache;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;

public class LinkedInConnection {
	  private static String API_KEY = "j4lvn0lsmybt";
	  private static String API_SECRET = "AEhrcvtdFeaNNXz0";

	  final private static String REDIRECT_URL = "http://localhost:9000/complete";
	  
	  private String authUrl_;
	  private LinkedInRequestToken requestToken_;
	  private LinkedInOAuthService oauthService_;
	  
	  
	  public LinkedInConnection() {
		  this.oauthService_ = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(API_KEY,API_SECRET);
		  this.requestToken_ = oauthService_.getOAuthRequestToken(LinkedInConnection.REDIRECT_URL);
		  
		  this.authUrl_ = this.requestToken_.getAuthorizationUrl();
	  }
	  
	  public String getAuthUrl(){
		  return this.authUrl_;
	  }
	  
	  public LinkedInApiClient completeAuthentication(String oauthVerifier) {
		  
		  LinkedInAccessToken accessToken = this.oauthService_.getOAuthAccessToken(this.requestToken_, oauthVerifier);
		  LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(API_KEY, API_SECRET); 
		  LinkedInApiClient client = factory.createLinkedInApiClient(accessToken);
		  
		  return client;
	  }
}
