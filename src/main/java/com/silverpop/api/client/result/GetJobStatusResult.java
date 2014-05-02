package com.silverpop.api.client.result;

import java.util.List;

import com.silverpop.api.client.ApiResult;
import com.silverpop.api.client.result.elements.GetJobStatusParameter;
import com.silverpop.api.client.result.elements.GetJobStatusParameters;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 * Copyright {2014} {thanh@mohc.net}<br/>
 * <br/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.<br/> 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0<br/>
 * <br/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. <br/>
 * 
 * See the License for the specific language governing permissions and limitations under the License.<br/>
 *
 *------<br/>
 *
 * Response contains the following elements:
 * <ul>
 * <li>SUCCESS</li>
 * <li>JOB_ID</li>
 * <li>JOB_STATUS</li>
 * <li>JOB_DESCRIPTION</li>
 * <li>PARAMETERS: list that contains &lt;Parameter> elements with name/value pairs</li>
 * </ul>
 * 
 * PARAMETERS list changes depending on JOB_STATUS:<br/>
 * <ul>
 * <li> When a Database Import Job is Waiting/Running, parameters list includes these NAME/VALUE pairs:
 * NOT_ALLOWED, LIST_ID, SQL_ADDED, DUPLICATES, TOTAL_ROWS, LIST_NAME, BAD_ADDRESSES, TOTAL_VALID, BAD_RECORDS</li>
 * <li> When a Database Import Job is Complete, parameters includes:
 * NOT_ALLOWED, LIST_ID, SQL_ADDED, DUPLICATES, TOTAL_ROWS, LIST_NAME, BAD_ADDRESSES, SQL_UPDATED, TOTAL_VALID, BAD_RECORDS</li>
 * <li>When a Database Export Job is Complete, parameters includes:
 * NUM_PROCESSED, LIST_ID, LIST_NAME</li>
 * </ul>
 */
public class GetJobStatusResult implements ApiResult {

	@XStreamAlias("JOB_ID")
	private String jobId;

	@XStreamAlias("SUCCESS")
	private boolean successElement;

	@XStreamAlias("JOB_STATUS")
	private String jobStatus;

	@XStreamAlias("JOB_DESCRIPTION")
	private String jobDescription;

	@XStreamAlias("PARAMETERS")
	private GetJobStatusParameters parameters;
	
	private GetJobStatusResult(){};

	private GetJobStatusResult(String jobId, Boolean successElement, String jobStatus, String jobDescription, GetJobStatusParameters parameters) {
		this.jobId = jobId;
		this.successElement = successElement;
		this.jobStatus = jobStatus;
		this.jobDescription = jobDescription;
		this.parameters = parameters;
	}
	public String getJobId() {
		return jobId;
	}

	public boolean isSuccessElement() {
		return successElement;
	}

	public JobStatus getJobStatus() {
		JobStatus status;
		try {
			status = JobStatus.valueOf(jobStatus);
		} catch (IllegalArgumentException ex) {
			// use the UNKNOWN value instead, Silverpop must have introduced a new valid value
			status = JobStatus.UNKNOWN;
		}
		return status;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public List<GetJobStatusParameter> getParameters() {
		return parameters.getParameters();
	}


	public static enum JobStatus {
		WAITING("WAITING"),
		RUNNING("RUNNING"),
		CANCELED("CANCELED"),
		ERROR("ERROR"),
		COMPLETE("COMPLETE"),

		/** Only used if Silverpop introduced a new value for JOB_STATUS */
		UNKNOWN("UNKNOWN");

		private String value;
		private JobStatus(String value) {
			this.value = value;
		}
		public String toString() {
			return value;
		}
	}

	public String toString() {
		XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));//to stop xstream use double underscores instead of single one
		xstream.alias("RESULT", GetJobStatusResult.class);
		xstream.alias("PARAMETER", GetJobStatusParameter.class);
		xstream.aliasField("PARAMETERS", GetJobStatusResult.class, "parameters");
		xstream.aliasField("JOB_ID", GetJobStatusResult.class, "jobId");
		xstream.aliasField("JOB_DESCRIPTION", GetJobStatusResult.class, "jobDescription");
		xstream.aliasField("JOB_STATUS", GetJobStatusResult.class, "jobStatus");
		xstream.aliasField("SUCCESS", GetJobStatusResult.class, "successElement");
		xstream.aliasField("NAME", GetJobStatusParameter.class, "name");
		xstream.aliasField("VALUE", GetJobStatusParameter.class, "value");
		xstream.addImplicitCollection(GetJobStatusParameters.class, "parameters");
		return xstream.toXML(this);
	}
}
