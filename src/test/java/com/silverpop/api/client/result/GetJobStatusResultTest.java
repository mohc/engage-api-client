package com.silverpop.api.client.result;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.silverpop.api.client.result.elements.GetJobStatusParameter;
import com.silverpop.api.client.result.elements.GetJobStatusParameters;

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
public class GetJobStatusResultTest extends TestCase {
	@BeforeMethod
	public void setUp() {
	}

	@Test
	public void testToString(){
		try {
			Constructor<GetJobStatusParameter> c = GetJobStatusParameter.class.getDeclaredConstructor(String.class, String.class);
			c.setAccessible(true);
			List<GetJobStatusParameter> params = new ArrayList<GetJobStatusParameter>();
			GetJobStatusParameter p1 = c.newInstance("NOT_ALLOWED", "0");
			GetJobStatusParameter p2 = c.newInstance("LIST_ID", "116347");
			GetJobStatusParameter p3 = c.newInstance("RESULTS_FILE_NAME", "1231474.res");
			GetJobStatusParameter p4 = c.newInstance("SQL_ADDED", "65535");
			GetJobStatusParameter p5 = c.newInstance("DUPLICATES", "0");
			GetJobStatusParameter p6 = c.newInstance("TOTAL_ROWS", "65535");
			GetJobStatusParameter p7 = c.newInstance("ERROR_FILE_NAME", "1241474.err");
			GetJobStatusParameter p8 = c.newInstance("LIST_NAME", "BigList");
			GetJobStatusParameter p9 = c.newInstance("BAD_ADDRESSES", "0");
			GetJobStatusParameter p10 = c.newInstance("SQL_UPDATED", "0");
			GetJobStatusParameter p11 = c.newInstance("BAD_RECORD", "0");
			GetJobStatusParameter p12 = c.newInstance("TOTAL_VALID", "65535");
			params.add(p1);
			params.add(p2);
			params.add(p3);
			params.add(p4);
			params.add(p5);
			params.add(p6);
			params.add(p7);
			params.add(p8);
			params.add(p9);
			params.add(p10);
			params.add(p11);
			params.add(p12);
			
			Constructor<GetJobStatusParameters> c1 = GetJobStatusParameters.class.getDeclaredConstructor(List.class);
			c1.setAccessible(true);
			GetJobStatusParameters prs = c1.newInstance(params);
			
			Constructor<GetJobStatusResult> c3 = GetJobStatusResult.class.getDeclaredConstructor(String.class, Boolean.class, String.class, String.class, GetJobStatusParameters.class);
			c3.setAccessible(true);
			GetJobStatusResult result = c3.newInstance("123", true, "COMPLETE", "Test job", prs);

			String expectedXml ="<RESULT>\n" + 
					"  <JOB_ID>123</JOB_ID>\n" + 
					"  <SUCCESS>true</SUCCESS>\n" + 
					"  <JOB_STATUS>COMPLETE</JOB_STATUS>\n" + 
					"  <JOB_DESCRIPTION>Test job</JOB_DESCRIPTION>\n" + 
					"  <PARAMETERS>\n" + 
					"    <PARAMETER>\n" + 
					"      <NAME>NOT_ALLOWED</NAME>\n" + 
					"      <VALUE>0</VALUE>\n" + 
					"    </PARAMETER>\n" + 
					"    <PARAMETER>\n" + 
					"      <NAME>LIST_ID</NAME>\n" + 
					"      <VALUE>116347</VALUE>\n" + 
					"    </PARAMETER>\n" + 
					"    <PARAMETER>\n" + 
					"      <NAME>RESULTS_FILE_NAME</NAME>\n" + 
					"      <VALUE>1231474.res</VALUE>\n" + 
					"    </PARAMETER>\n" + 
					"    <PARAMETER>\n" + 
					"      <NAME>SQL_ADDED</NAME>\n" + 
					"      <VALUE>65535</VALUE>\n" + 
					"    </PARAMETER>\n" + 
					"    <PARAMETER>\n" + 
					"      <NAME>DUPLICATES</NAME>\n" + 
					"      <VALUE>0</VALUE>\n" + 
					"    </PARAMETER>\n" + 
					"    <PARAMETER>\n" + 
					"      <NAME>TOTAL_ROWS</NAME>\n" + 
					"      <VALUE>65535</VALUE>\n" + 
					"    </PARAMETER>\n" + 
					"    <PARAMETER>\n" + 
					"      <NAME>ERROR_FILE_NAME</NAME>\n" + 
					"      <VALUE>1241474.err</VALUE>\n" + 
					"    </PARAMETER>\n" + 
					"    <PARAMETER>\n" + 
					"      <NAME>LIST_NAME</NAME>\n" + 
					"      <VALUE>BigList</VALUE>\n" + 
					"    </PARAMETER>\n" + 
					"    <PARAMETER>\n" + 
					"      <NAME>BAD_ADDRESSES</NAME>\n" + 
					"      <VALUE>0</VALUE>\n" + 
					"    </PARAMETER>\n" + 
					"    <PARAMETER>\n" + 
					"      <NAME>SQL_UPDATED</NAME>\n" + 
					"      <VALUE>0</VALUE>\n" + 
					"    </PARAMETER>\n" + 
					"    <PARAMETER>\n" + 
					"      <NAME>BAD_RECORD</NAME>\n" + 
					"      <VALUE>0</VALUE>\n" + 
					"    </PARAMETER>\n" + 
					"    <PARAMETER>\n" + 
					"      <NAME>TOTAL_VALID</NAME>\n" + 
					"      <VALUE>65535</VALUE>\n" + 
					"    </PARAMETER>\n" + 
					"  </PARAMETERS>\n" + 
					"</RESULT>";
			String str = result.toString();
			assertEquals(expectedXml, str);
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
