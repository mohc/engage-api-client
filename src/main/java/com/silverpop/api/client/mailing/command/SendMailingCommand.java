package com.silverpop.api.client.mailing.command;

import com.silverpop.api.client.ApiCommand;
import com.silverpop.api.client.ApiResult;
import com.silverpop.api.client.XmlApiProperties;
import com.silverpop.api.client.mailing.result.SendMailingResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlApiProperties("SendMailing")
public class SendMailingCommand implements ApiCommand {
	@XStreamAlias("MailingId")
	private String mailingId;
	
	@XStreamAlias("RecipientEmail")
	private String recipientEmail;
	
	public SendMailingCommand() {}
	
	public SendMailingCommand(String mailingId, String recipientEmail) {
		this.mailingId = mailingId;
		this.recipientEmail = recipientEmail;
	}

	public String getMailingId() {
		return mailingId;
	}

	public void setMailingId(String mailingId) {
		this.mailingId = mailingId;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	public Class<? extends ApiResult> getResultType() {
		return SendMailingResult.class;
	}
}
