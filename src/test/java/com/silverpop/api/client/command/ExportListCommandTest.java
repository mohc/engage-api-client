package com.silverpop.api.client.command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.silverpop.api.client.command.elements.ExportListExportColumns;
import com.silverpop.api.client.xmlapi.XmlApiRequest;

import junit.framework.TestCase;

/**
 * Copyright {2014} {thanh@mohc.net}
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed 
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations under the License.
 *
 */
public class ExportListCommandTest extends TestCase {
	@BeforeMethod
	public void setUp() {
	}

	@Test
	public void testCreateExportListCommand() {
		try {
			List<String> columns = new ArrayList<String>();
			columns.add("Firstname");
			columns.add("Gender");

			ExportListExportColumns exportColumns = new ExportListExportColumns(columns);

			Constructor<ExportListCommand> c3 = ExportListCommand.class.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class, String.class, ExportListExportColumns.class, String.class);
			c3.setAccessible(true);
			String dateStart = "07/25/2011 12:12:12";
			String dateEnd = "07/26/2011 12:12:12";
			ExportListCommand command1 = c3.newInstance("123", ExportListCommand.EXPORT_OPTIN, ExportListCommand.FORMAT_PIPE, ExportListCommand.ENCODING_UTF8, dateStart, dateEnd, exportColumns, "mm/dd/yyy");
			
			//Test1: marshal full ExportList command with EXPORT_COLUMNS
			XmlApiRequest request1 = new XmlApiRequest(command1, null);
			String commandXml1 = request1.marshallCommand();
			
			String expectedXml1 ="<Envelope>\n" + 
					"  <Body>\n" + 
					"    <ExportList>\n" + 
					"      <LIST_ID>123</LIST_ID>\n" + 
					"      <EXPORT_TYPE>OPT_IN</EXPORT_TYPE>\n" + 
					"      <EXPORT_FORMAT>PIPE</EXPORT_FORMAT>\n" + 
					"      <FILE_ENCODING>utf-8</FILE_ENCODING>\n" + 
					"      <DATE_START>07/25/2011 12:12:12</DATE_START>\n" + 
					"      <DATE_END>07/26/2011 12:12:12</DATE_END>\n" + 
					"      <EXPORT_COLUMNS>\n" + 
					"        <COLUMN>Firstname</COLUMN>\n" + 
					"        <COLUMN>Gender</COLUMN>\n" + 
					"      </EXPORT_COLUMNS>\n" + 
					"      <LIST_DATE_FORMAT>mm/dd/yyy</LIST_DATE_FORMAT>\n" + 
					"    </ExportList>\n" + 
					"  </Body>\n" + 
					"</Envelope>";
			assertEquals(expectedXml1, commandXml1);
			
			//Test2: marshal ExportList command WITHOUT EXPORT_COLUMNS
			ExportListCommand command2 = c3.newInstance("123", ExportListCommand.EXPORT_OPTIN, ExportListCommand.FORMAT_PIPE, ExportListCommand.ENCODING_UTF8, dateStart, dateEnd, null, "mm/dd/yyy");
			XmlApiRequest request2 = new XmlApiRequest(command2, null);
			String commandXml2 = request2.marshallCommand();
			String expectedXml2 ="<Envelope>\n" + 
					"  <Body>\n" + 
					"    <ExportList>\n" + 
					"      <LIST_ID>123</LIST_ID>\n" + 
					"      <EXPORT_TYPE>OPT_IN</EXPORT_TYPE>\n" + 
					"      <EXPORT_FORMAT>PIPE</EXPORT_FORMAT>\n" + 
					"      <FILE_ENCODING>utf-8</FILE_ENCODING>\n" + 
					"      <DATE_START>07/25/2011 12:12:12</DATE_START>\n" + 
					"      <DATE_END>07/26/2011 12:12:12</DATE_END>\n" + 
					"      <LIST_DATE_FORMAT>mm/dd/yyy</LIST_DATE_FORMAT>\n" + 
					"    </ExportList>\n" + 
					"  </Body>\n" + 
					"</Envelope>";
			assertEquals(expectedXml2, commandXml2);
		} catch (InvocationTargetException ex) {
			fail();
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		} catch (IllegalArgumentException e) {
			fail();
		} catch (InstantiationException e) {
			fail();
		} catch (IllegalAccessException e) {
			fail();
		}
	}
}
