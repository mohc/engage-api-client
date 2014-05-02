package com.silverpop.api.client.result.elements;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("PARAMETERS")
public class GetJobStatusParameters {

    @XStreamImplicit(itemFieldName="PARAMETER")
    public List<GetJobStatusParameter> parameters;

    private GetJobStatusParameters() {};
    
    private GetJobStatusParameters(List<GetJobStatusParameter> parameters) {
    	this.parameters = parameters;
    }
    
    public List<GetJobStatusParameter> getParameters() {
        return parameters;
    }
}
