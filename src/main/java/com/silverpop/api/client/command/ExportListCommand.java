package com.silverpop.api.client.command;

import com.silverpop.api.client.ApiCommand;
import com.silverpop.api.client.ApiResult;
import com.silverpop.api.client.XmlApiProperties;
import com.silverpop.api.client.command.elements.ExportListExportColumns;
import com.silverpop.api.client.result.ExportListResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XmlApiProperties("ExportList")
public class ExportListCommand implements ApiCommand {
	public static final String EXPORT_ALL 					= "ALL";
	public static final String EXPORT_OPTIN 				= "OPT_IN";
	public static final String EXPORT_OPTOUT 				= "OPT_OUT";
	public static final String EXPORT_UNDELIVERABLE = "UNDELIVERABLE";
	
	public static final String FORMAT_CSV						= "CSV";
	public static final String FORMAT_TAB						= "TAB";
	public static final String FORMAT_PIPE					= "PIPE";
	
	public static final String ENCODING_UTF8				= "utf-8";
	public static final String ENCODING_ISO88591		= "iso-8859-1";
	
	public static final String DEFAULT_DATE_FORMAT  = "yyyy-mm-dd";
	
	@XStreamAlias("LIST_ID")
	private String listId;
	
	@XStreamAlias("EXPORT_TYPE")
	private String exportType;
	
	@XStreamAlias("EXPORT_FORMAT")
	private String exportFormat;
	
	@XStreamAlias("FILE_ENCODING")
	private String fileEncoding;
	
	@XStreamAlias("DATE_START")
	private String dateStart;
	
	@XStreamAlias("DATE_END")
	private String dateEnd;
	
	@XStreamAlias("EXPORT_COLUMNS")
	private ExportListExportColumns exportColumns;
	
	@XStreamAlias("LIST_DATE_FORMAT")
	private String listDateFormat;
	
	public ExportListCommand(String listId, String exportType, String exportFormat, String fileEncoding, String dateStart, String dateEnd, ExportListExportColumns exportColumns, String listDateFormat) {
		this.listId = listId;
		this.exportType = exportType;
		this.exportFormat = exportFormat;
		this.fileEncoding = fileEncoding;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.exportColumns = exportColumns;
		this.listDateFormat = listDateFormat;
	}

	public Class<? extends ApiResult> getResultType() {
		return ExportListResult.class;
	}

	public String getListId() {
		return listId;
	}

	public void setListId(String listId) {
		this.listId = listId;
	}

	public String getExportType() {
		return exportType;
	}

	public void setExportType(String exportType) {
		this.exportType = exportType;
	}

	public String getExportFormat() {
		return exportFormat;
	}

	public void setExportFormat(String exportFormat) {
		this.exportFormat = exportFormat;
	}

	public String getFileEncoding() {
		return fileEncoding;
	}

	public void setFileEncoding(String fileEncoding) {
		this.fileEncoding = fileEncoding;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public ExportListExportColumns getExportColumns() {
		return exportColumns;
	}

	public void setExportColumns(ExportListExportColumns exportColumns) {
		this.exportColumns = exportColumns;
	}

	public String getListDateFormat() {
		return listDateFormat;
	}

	public void setListDateFormat(String listDateFormat) {
		this.listDateFormat = listDateFormat;
	}
}
