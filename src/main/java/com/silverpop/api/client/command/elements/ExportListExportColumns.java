package com.silverpop.api.client.command.elements;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("EXPORT_COLUMNS")
public class ExportListExportColumns {
	
	 @XStreamImplicit(itemFieldName="COLUMN")
   public List<String> exportColumns;
	 
	 public ExportListExportColumns(List<String> exportColumns) {
		 this.exportColumns = exportColumns;
	 }
	 
	 public List<String> getExportColumns() {
     return exportColumns;
 }
}
