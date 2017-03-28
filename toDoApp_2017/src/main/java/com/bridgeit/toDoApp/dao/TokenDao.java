package com.bridgeit.toDoApp.dao;

import com.bridgeit.toDoApp.model.Token;

public interface TokenDao {

	Token getRefreshToken(String refreshToken);

	void addToken(Token tokenNew);

	Token getAccessTokenByAccess(String accessToken);

}
