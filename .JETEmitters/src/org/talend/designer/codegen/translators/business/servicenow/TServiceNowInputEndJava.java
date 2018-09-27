package org.talend.designer.codegen.translators.business.servicenow;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TServiceNowInputEndJava
{
  protected static String nl;
  public static synchronized TServiceNowInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TServiceNowInputEndJava result = new TServiceNowInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "}// responce loop" + NL + "     try{" + NL + "        String error_";
  protected final String TEXT_2 = " = ((org.json.JSONObject)";
  protected final String TEXT_3 = "_json.get(\"error\")).getString(\"message\");" + NL + "        String detail_";
  protected final String TEXT_4 = " = ((org.json.JSONObject)";
  protected final String TEXT_5 = "_json.get(\"error\")).getString(\"detail\");" + NL + "        ";
  protected final String TEXT_6 = NL + "  log.error(error_";
  protected final String TEXT_7 = "+\" --Detail: \"+detail_";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "    System.err.println(error_";
  protected final String TEXT_10 = "+\" --Detail: \"+detail_";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "    }catch(org.json.JSONException je_";
  protected final String TEXT_13 = "){" + NL + "    //ignore" + NL + "    }" + NL + "} else {" + NL + "\tString error_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = "_json.getJSONObject(\"error\").getString(\"message\");" + NL + "\tboolean no_record_";
  protected final String TEXT_16 = " = (";
  protected final String TEXT_17 = "_response.getStatusLine().getStatusCode() == 404) && (\"No Record found\".equals(error_";
  protected final String TEXT_18 = "));" + NL + "\tif(!no_record_";
  protected final String TEXT_19 = ") {" + NL + "\t\tthrow new org.apache.http.HttpException(error_";
  protected final String TEXT_20 = ");" + NL + "\t}" + NL + "} " + NL + "} finally {" + NL + "\t";
  protected final String TEXT_21 = "_response.close();" + NL + "}" + NL + "} finally {" + NL + "\t";
  protected final String TEXT_22 = "_httpclient.close();" + NL + "}" + NL + "globalMap.put(\"";
  protected final String TEXT_23 = "_NB_LINE\",nb_line_";
  protected final String TEXT_24 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
if(isLog4jEnabled){
  
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
}else{
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
