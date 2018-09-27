package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPFileExistEndJava
{
  protected static String nl;
  public static synchronized TFTPFileExistEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPFileExistEndJava result = new TFTPFileExistEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t";
  protected final String TEXT_2 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Closing the connection to the server.\");" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\tsession_";
  protected final String TEXT_5 = ".disconnect(); " + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_7 = " - Connection to the server closed.\");" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\tc_";
  protected final String TEXT_9 = ".cd(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\tftp_";
  protected final String TEXT_12 = ".disconnect();";
  protected final String TEXT_13 = NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_15 = " - Closing the connection to the server.\");" + NL + "\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tftp_";
  protected final String TEXT_17 = ".quit();" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_19 = " - Connection to the server closed.\");" + NL + "\t\t\t\t";
  protected final String TEXT_20 = NL + "      \t\t} catch(java.net.SocketException se_";
  protected final String TEXT_21 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_23 = " - \" + se_";
  protected final String TEXT_24 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "        \t\t//ignore failure" + NL + "      \t\t}";
  protected final String TEXT_26 = NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Closing the connection to the server.\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "      \t\tftp_";
  protected final String TEXT_30 = ".quit();" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_32 = " - Connection to the server closed.\");" + NL + "\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\tftp_";
  protected final String TEXT_34 = ".chdir(";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String remoteDir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String ignoreFailureAtQuit= ElementParameterParser.getValue(node,"__IGNORE_FAILURE_AT_QUIT__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean sftp = false;
boolean ftps = false;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if (("true").equals(useExistingConn)) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();
  for (INode n : nodeList) {
    if (n.getUniqueName().equals(connection)) {
      sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
      ftps = ("true").equals(ElementParameterParser.getValue(n, "__FTPS__"));
    }
  }
} else {
  sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
  ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__"));
}

if (sftp) { // *** sftp *** //
	if (!"true".equals(useExistingConn)) {

    stringBuffer.append(TEXT_1);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    }
    
	} else if (moveToCurrentDir){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_10);
    
	}
} else if (ftps) { // *** ftps *** //
	if (!("true").equals(useExistingConn)) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
	}
} else { // *** ftp *** //
	if (!("true").equals(useExistingConn)) {
		if (("true").equals(ignoreFailureAtQuit)) {
    
    stringBuffer.append(TEXT_13);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    
    	} else {
    
    stringBuffer.append(TEXT_26);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    }
    
		}
	} else {
		if (moveToCurrentDir) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(remoteDir );
    stringBuffer.append(TEXT_35);
    
		}
	}
}

    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
