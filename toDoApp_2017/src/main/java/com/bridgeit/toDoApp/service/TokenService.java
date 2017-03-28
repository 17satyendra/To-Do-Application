package com.bridgeit.toDoApp.service;

import com.bridgeit.toDoApp.model.Token;

public interface TokenService {

	Token getTokenByRefToken(String refreshToken);

	void addToken(Token tokenNew);

	Token getAccessTokenByAcc(String accessToken);

}
