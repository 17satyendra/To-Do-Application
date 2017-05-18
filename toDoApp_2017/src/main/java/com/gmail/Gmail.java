package com.gmail;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.bridgeit.toDoApp.model.GmailProfile;
import com.bridgeit.toDoApp.model.GmailToken;

public class Gmail {
	
	public String scope_url="https://www.googleapis.com/auth/userinfo.profile";
	public String Gmail_CLIENT_ID="708988921879-kvjfn4ctfjve5sfcv0p6m2inc1nnas52.apps.googleusercontent.com";
	public String Gmail_SECRET_KEY = "Y58D6oclbmye3b3XRtXmyCop";
	public String Gmail_RERDIRECT_URI = "/postgmailLogin";
	public String Gmail_URL = "https://accounts.google.com/o/oauth2/auth?client_id=%s&redirect_uri=%s&state=%s&"
			+ "response_type=code&scope=%s&approval_prompt=force&access_type=offline";
	
	public String Gmail_ACCESS_TOKEN_URL = "https://accounts.google.com/o/oauth2/token?client_id=%s"
			+ "&client_secret=%s&redirect_uri=%s&grant_type=%s";
	public String Gmail_GET_USER_URL = "https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token=%s";
	
	public Gmail() {
		System.out.println(getClass().getSimpleName()+" created");
	}
	public 	String getGmailUrl(String appUrl, String pState) {
		System.out.println("Inside gmaIL FOR GET GMAIL URL");

		appUrl = appUrl + Gmail_RERDIRECT_URI;
		return String.format(Gmail_URL, new String[]{ Gmail_CLIENT_ID, appUrl, pState, scope_url });
	}


	public GmailProfile authUser(String authCode, String appUrl) {
		
		System.out.println("Inside gmaIL FOR GET GMAIL profile");
		String accessToken = getAccessToken(authCode, appUrl);
		return getUserProfile(accessToken);
		
	}


	private GmailProfile getUserProfile(String accessToken) {

		System.out.println("Inside gmaIL FOR GET GMAIL getuserprofile");
		String accProfileUrl = String.format(Gmail_GET_USER_URL, new String[]{ accessToken });
		  
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target( accProfileUrl );
		 
		
		Response response =  target.request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println( response );
		GmailProfile profile = response.readEntity(GmailProfile.class);
		
		client.close();
		return profile;
	}


	private String getAccessToken(String authCode, String appUrl) {
		
		System.out.println("Inside gmaIL FOR GET GMAIL getAccess token");
		appUrl = appUrl + Gmail_RERDIRECT_URI;
		String accTokenUrl = String.format(Gmail_ACCESS_TOKEN_URL, new String[]{ Gmail_CLIENT_ID, Gmail_SECRET_KEY, appUrl, authCode });
		  
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target( accTokenUrl );
		 
		Response response =  target.request().accept(MediaType.APPLICATION_JSON).get();
		GmailToken gmailToken = response.readEntity(GmailToken.class);
		
		client.close();
		return gmailToken.getAccess_token();
	}

}
