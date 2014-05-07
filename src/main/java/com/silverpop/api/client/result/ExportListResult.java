package com.silverpop.api.client.result;

import com.silverpop.api.client.ApiResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("RESULT")
public class ExportListResult implements ApiResult  {
	@XStreamAlias("JOB_ID")
	private String jobId;
	
	@XStreamAlias("SUCCESS")
	private boolean successElement;
	
	@XStreamAlias("FILE_PATH")
	private String filePath;
	
	public String getJobId() {
		return jobId;
	}

	public boolean getSuccessElement() {
		return successElement;
	}
	
	public String getFilePath() {
		return filePath;
	}
}
