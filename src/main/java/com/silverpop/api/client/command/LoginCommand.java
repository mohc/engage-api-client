package com.silverpop.api.client.command;

import com.silverpop.api.client.ApiCommand;
import com.silverpop.api.client.XmlApiProperties;
import com.silverpop.api.client.result.LoginResult;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlApiProperties("Login")
public class LoginCommand implements ApiCommand {

	@XStreamAlias("USERNAME")
	private String username;

	@XStreamAlias("PASSWORD")
	private String password;

	public LoginCommand() {}
	
	public LoginCommand(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Class<LoginResult> getResultType() {
		return LoginResult.class;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}