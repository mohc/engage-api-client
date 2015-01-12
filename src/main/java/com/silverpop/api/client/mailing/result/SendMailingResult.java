package com.silverpop.api.client.mailing.result;

import com.silverpop.api.client.ApiResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("RESULT")
public class SendMailingResult implements ApiResult {
	 @XStreamAlias("SUCCESS")
   private boolean successElement;
	 
	 public boolean getSuccessElement() {
			return successElement;
		}
}
