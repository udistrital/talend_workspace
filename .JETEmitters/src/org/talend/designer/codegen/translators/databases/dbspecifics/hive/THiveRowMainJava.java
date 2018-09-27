package org.talend.designer.codegen.translators.databases.dbspecifics.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.text.DateFormat;

public class THiveRowMainJava
{
  protected static String nl;
  public static synchronized THiveRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveRowMainJava result = new THiveRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tquery_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ";" + NL + "\tbw_";
  protected final String TEXT_5 = ".write(query_";
  protected final String TEXT_6 = " + \";\");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_7 = "_QUERY\", query_";
  protected final String TEXT_8 = ");" + NL + "\t" + NL + "\tbw_";
  protected final String TEXT_9 = ".close();" + NL + "" + NL + "\tif(libjars_";
  protected final String TEXT_10 = ".length() > 0) {" + NL + "\t\tinstance_";
  protected final String TEXT_11 = ".setLibJars(libjars_";
  protected final String TEXT_12 = ".toString().substring(0, libjars_";
  protected final String TEXT_13 = ".length()-1));" + NL + "\t}" + NL + "\tinstance_";
  protected final String TEXT_14 = ".callWS(instance_";
  protected final String TEXT_15 = ".sendFiles());" + NL + "\tint exitCode_";
  protected final String TEXT_16 = " = instance_";
  protected final String TEXT_17 = ".execute();" + NL + "\tif(exitCode_";
  protected final String TEXT_18 = " > 0) {" + NL + "\t\t";
  protected final String TEXT_19 = NL + "\t\t\tthrow new Exception(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_20 = NL + "\t\t\tSystem.err.println(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_22 = " - The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_23 = NL + "\t}";
  protected final String TEXT_24 = NL + "        log.debug(\"Query for ";
  protected final String TEXT_25 = ": \" + query_";
  protected final String TEXT_26 = ".replace(\"';'\", \"'\\\\;'\") + \";\");";
  protected final String TEXT_27 = NL + "    query_";
  protected final String TEXT_28 = " = ";
  protected final String TEXT_29 = ";" + NL + "    instance_";
  protected final String TEXT_30 = ".addQuery(query_";
  protected final String TEXT_31 = ".replace(\"';'\", \"'\\\\;'\") + \";\");" + NL + "    globalMap.put(\"";
  protected final String TEXT_32 = "_QUERY\", query_";
  protected final String TEXT_33 = ");" + NL + "    int exitCode_";
  protected final String TEXT_34 = " = instance_";
  protected final String TEXT_35 = ".executeJob();" + NL + "    System.out.println(instance_";
  protected final String TEXT_36 = ".getJobLog());" + NL + "    if(exitCode_";
  protected final String TEXT_37 = " > 0) {" + NL;
  protected final String TEXT_38 = NL + "            throw new Exception(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_39 = NL + "            System.err.println(\"The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_40 = NL + "                log.error(\"";
  protected final String TEXT_41 = " - The Hive job failed. Please read the logs for more details\");";
  protected final String TEXT_42 = NL + "    }";
  protected final String TEXT_43 = NL + "        \tString queries_";
  protected final String TEXT_44 = " = \"\";" + NL + "        \tif (connectionCommandList_";
  protected final String TEXT_45 = " != null) {" + NL + "        \t\tfor (String command : connectionCommandList_";
  protected final String TEXT_46 = ") {" + NL + "        \t\t\tqueries_";
  protected final String TEXT_47 = " += command;" + NL + "        \t\t\t";
  protected final String TEXT_48 = NL + "        \t\t\t\tlog.info(\"";
  protected final String TEXT_49 = " - query added: \" + command);" + NL + "        \t\t\t";
  protected final String TEXT_50 = NL + "        \t\t}" + NL + "        \t}" + NL + "" + NL + "\t\t    query_";
  protected final String TEXT_51 = " = ";
  protected final String TEXT_52 = ";";
  protected final String TEXT_53 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_54 = " - query added: \" + query_";
  protected final String TEXT_55 = ".replace(\"';'\", \"'\\\\;'\").replaceAll(\"\\n\", \" \").replaceAll(\" +\", \" \") + \";\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_56 = " - queries sent to cluster, waiting for execution result ...\");";
  protected final String TEXT_57 = NL + "           \t\tString execution_result_";
  protected final String TEXT_58 = " = instance_";
  protected final String TEXT_59 = ".execute(queries_";
  protected final String TEXT_60 = " + query_";
  protected final String TEXT_61 = ".replace(\"';'\", \"'\\\\;'\") + \";\", ";
  protected final String TEXT_62 = ").getResults();";
  protected final String TEXT_63 = NL + "\t\t\t\tString execution_result_";
  protected final String TEXT_64 = " = instance_";
  protected final String TEXT_65 = ".execute(queries_";
  protected final String TEXT_66 = " + query_";
  protected final String TEXT_67 = ".replace(\"';'\", \"'\\\\;'\") + \";\").getResults();";
  protected final String TEXT_68 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_69 = " - execution finished.\");" + NL + "\t\t\t";
  protected final String TEXT_70 = "    " + NL + "\t\t\t";
  protected final String TEXT_71 = " = null;            " + NL + "\t\t\t";
  protected final String TEXT_72 = NL + "\tquery_";
  protected final String TEXT_73 = " = ";
  protected final String TEXT_74 = ";" + NL + "\twhetherReject_";
  protected final String TEXT_75 = " = false;" + NL + "" + NL + "\t";
  protected final String TEXT_76 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_77 = "_QUERY\",query_";
  protected final String TEXT_78 = ");" + NL + "\t";
  protected final String TEXT_79 = NL + "\t\tjava.sql.ResultSet rs_";
  protected final String TEXT_80 = " = null;" + NL + "\t\t";
  protected final String TEXT_81 = NL + "\ttry {" + NL + "\t\t";
  protected final String TEXT_82 = NL + NL + "java.text.DateFormat dateStrFormat_";
  protected final String TEXT_83 = " = new java.text.SimpleDateFormat(\"yyyyMMddHHmmss\");" + NL + "final String queryIdentifier_";
  protected final String TEXT_84 = " = projectName + \"_\" + jobName + \"_\" + jobVersion.replace(\".\", \"_\") + \"_";
  protected final String TEXT_85 = "_\" + dateStrFormat_";
  protected final String TEXT_86 = ".format(new Date(startTime));" + NL + "// For MapReduce Mode" + NL + "stmt_";
  protected final String TEXT_87 = ".execute(\"set mapred.job.name=\" + queryIdentifier_";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = NL + "    // For Tez Mode" + NL + "    stmt_";
  protected final String TEXT_90 = ".execute(\"set hive.query.name=\" + queryIdentifier_";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = NL + "\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_94 = ".setTimestamp(";
  protected final String TEXT_95 = ",new java.sql.Timestamp(";
  protected final String TEXT_96 = ".getTime()));" + NL + "\t";
  protected final String TEXT_97 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_98 = ".set";
  protected final String TEXT_99 = "(";
  protected final String TEXT_100 = ",";
  protected final String TEXT_101 = ");" + NL + "\t";
  protected final String TEXT_102 = NL + "\t\t\trs_";
  protected final String TEXT_103 = " = pstmt_";
  protected final String TEXT_104 = ".executeQuery();" + NL + "\t";
  protected final String TEXT_105 = NL + "\t    \tpstmt_";
  protected final String TEXT_106 = ".execute();" + NL + "\t    \t";
  protected final String TEXT_107 = NL + "\t\t\t\trs_";
  protected final String TEXT_108 = " = stmt_";
  protected final String TEXT_109 = ".executeQuery(query_";
  protected final String TEXT_110 = ");" + NL + "\t\t\t";
  protected final String TEXT_111 = NL + "\t\t  \tstmt_";
  protected final String TEXT_112 = ".execute(query_";
  protected final String TEXT_113 = ");" + NL + "\t    \t";
  protected final String TEXT_114 = NL + "\t\tlog.info(\"Query sent to HiveServer2 to be executed with [Application Name(MapReduce)/DAG Name(Tez): \" + queryIdentifier_";
  protected final String TEXT_115 = " + \"]\");" + NL + "\t    } catch (java.lang.Exception e) {" + NL + "\t        whetherReject_";
  protected final String TEXT_116 = " = true;" + NL + "\t        ";
  protected final String TEXT_117 = NL + "\t            throw(e);" + NL + "\t            ";
  protected final String TEXT_118 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_119 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_120 = NL + "\t                ";
  protected final String TEXT_121 = " = new ";
  protected final String TEXT_122 = "Struct();" + NL + "\t                ";
  protected final String TEXT_123 = NL + "\t\t                    ";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = " = ";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = ";" + NL + "\t\t                    ";
  protected final String TEXT_128 = NL + "\t                ";
  protected final String TEXT_129 = ".errorCode = ((java.sql.SQLException)e).getSQLState();" + NL + "\t                ";
  protected final String TEXT_130 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_131 = ";" + NL + "\t                ";
  protected final String TEXT_132 = NL + "\t                System.err.print(e.getMessage());" + NL + "\t                ";
  protected final String TEXT_133 = NL + "\t    }" + NL + "\t\t";
  protected final String TEXT_134 = NL + "\t    if(!whetherReject_";
  protected final String TEXT_135 = ") {" + NL + "\t        ";
  protected final String TEXT_136 = NL + "\t                    ";
  protected final String TEXT_137 = " = new ";
  protected final String TEXT_138 = "Struct();" + NL + "\t                    ";
  protected final String TEXT_139 = NL + "\t                    \t    ";
  protected final String TEXT_140 = ".";
  protected final String TEXT_141 = " = rs_";
  protected final String TEXT_142 = ";" + NL + "\t                    \t    ";
  protected final String TEXT_143 = NL + "\t                    \t    ";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = " = ";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = ";" + NL + "\t                    \t    ";
  protected final String TEXT_148 = NL + "\t    }" + NL + "\t    ";
  protected final String TEXT_149 = NL + "\t        commitCounter_";
  protected final String TEXT_150 = "++;" + NL + "\t        if(commitEvery_";
  protected final String TEXT_151 = " <= commitCounter_";
  protected final String TEXT_152 = ") {" + NL + "\t        " + NL + "\t\t\t\t";
  protected final String TEXT_153 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_154 = " - Starting to commit.\");" + NL + "\t\t\t\t";
  protected final String TEXT_155 = NL + "\t        \tconn_";
  protected final String TEXT_156 = ".commit();" + NL + "\t\t\t\t";
  protected final String TEXT_157 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_158 = " - Commit has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_159 = NL + "\t        \t" + NL + "\t        \tcommitCounter_";
  protected final String TEXT_160 = "=0;" + NL + "\t        \t" + NL + "\t        }" + NL + "\t        ";
  protected final String TEXT_161 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String cid =  node.getUniqueName();
String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
String commitEvery = "0";//ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
String propagateRecordset = ElementParameterParser.getValue(node,"__PROPAGATE_RECORD_SET__");
String recordsetColumn = ElementParameterParser.getValue(node,"__RECORD_SET_COLUMN__");

boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);

String theDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
String theVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

String quboleClusterLabel = null;
String quboleEndpoint = null;
String encryptedToken = null;
if("true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"))) {
    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
    for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
        if(connection!=null && connection.equals(pNode.getUniqueName())) {
            theDistribution = ElementParameterParser.getValue(pNode, "__DISTRIBUTION__");
            theVersion = ElementParameterParser.getValue(pNode, "__HIVE_VERSION__");
			if (ElementParameterParser.getBooleanValue(pNode, "__QUBOLE_CLUSTER__")) {
				quboleClusterLabel = ElementParameterParser.getValue(pNode, "__QUBOLE_CLUSTER_LABEL__");
			}
        }
    }
} else {
    // without connection
    encryptedToken = ElementParameterParser.getEncryptedValue(node, "__QUBOLE_API_TOKEN__");
	if (ElementParameterParser.getBooleanValue(node, "__QUBOLE_ENDPOINT__")) {
		quboleEndpoint = ElementParameterParser.getValue(node, "__QUBOLE_ENDPOINT_URL__");
	}
	if (ElementParameterParser.getBooleanValue(node, "__QUBOLE_CLUSTER__")) {
		quboleClusterLabel = ElementParameterParser.getValue(node, "__QUBOLE_CLUSTER_LABEL__");
	}
}

org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
try {
    hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(theDistribution, theVersion);
} catch (java.lang.Exception e) {
    e.printStackTrace();
    return "";
}
boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

if(hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
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
    
		if(("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_19);
    
		} else {

    stringBuffer.append(TEXT_20);
    
			if(isLog4jEnabled) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
			}
		}

    stringBuffer.append(TEXT_23);
    
} else if (hiveDistrib.isGoogleDataprocDistribution()) {
    if(isLog4jEnabled) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
    }

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
        if(("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_38);
    
        } else {

    stringBuffer.append(TEXT_39);
    
            if(isLog4jEnabled) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
            }
        }

    stringBuffer.append(TEXT_42);
    
} else if (hiveDistrib.isQuboleDistribution()) { // qubole execution
        
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
     if (isLog4jEnabled) { 
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
     } 
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_52);
    
			if (isLog4jEnabled) {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
			}
            if (quboleClusterLabel != null) {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(quboleClusterLabel);
    stringBuffer.append(TEXT_62);
    
            } else {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    
			}
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
			}
} else { // normal mode
	List<Map<String, String>> prepareStatementParameters = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SET_PREPAREDSTATEMENT_PARAMETERS__");  
	
	String incomingConnName = null;
	
	Set<String> inputCols = new HashSet<String>();
	
	List<IMetadataColumn> columnList = null;
	
	String rejectConnName = null;
	List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	if(rejectConns != null && rejectConns.size() > 0) {
	    IConnection rejectConn = rejectConns.get(0);
	    rejectConnName = rejectConn.getName();
	}
	List<IMetadataColumn> rejectColumnList = null;
	IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
	if(metadataTable != null) {
	    rejectColumnList = metadataTable.getListColumns();      
	}
	
	List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
	
	boolean hasOutgoingDataConnection = false;
	for(IConnection conn : outgoingConns) {
	    if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			if(!hasOutgoingDataConnection){
				hasOutgoingDataConnection = true;
			}
			
    stringBuffer.append(TEXT_70);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_71);
          
	    }
	}
	
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata!=null) {
			List< ? extends IConnection> conns = node.getIncomingConnections();
			columnList = metadata.getListColumns();
			if(conns != null && conns.size()>0){
				IConnection conn = conns.get(0);
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					incomingConnName = conn.getName();
					IMetadataTable inputMetadataTable = conn.getMetadataTable();
					for (IMetadataColumn inputCol : inputMetadataTable.getListColumns()) {
						inputCols.add(inputCol.getLabel());
					}
				}
			}//end of connection size.
		}//end of metadatas
	}
	if(!hasOutgoingDataConnection || columnList == null || columnList.size() < 1){
		propagateRecordset = "false";
	}
	
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    
	if(("true").equals(propagateRecordset)) {
	    
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    
	}
	
    stringBuffer.append(TEXT_81);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
     
if(hiveDistrib.doSupportTezForHive()) {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    
}

    stringBuffer.append(TEXT_92);
    		
		if (usePrepareStatement) {
		
			for (Map<String, String> param : prepareStatementParameters) {
				
				if ("Date".equals(param.get("PARAMETER_TYPE"))) {
	
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(param.get("PARAMETER_INDEX"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(param.get("PARAMETER_VALUE"));
    stringBuffer.append(TEXT_96);
    
				} else {
	
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(param.get("PARAMETER_TYPE"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(param.get("PARAMETER_INDEX"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(param.get("PARAMETER_VALUE"));
    stringBuffer.append(TEXT_101);
    
				}
			}
			
			if(("true").equals(propagateRecordset)){
	
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    
			} else {
	
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    
			}
			
		} else {
			if(("true").equals(propagateRecordset)){
			
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    
			} else {
		    
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    
			}
		}
		
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
	        if (("true").equals(dieOnError)) {
	            
    stringBuffer.append(TEXT_117);
    
	        } else {
				if(isLog4jEnabled){
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    }
	            if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {
	                
    stringBuffer.append(TEXT_120);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_122);
    
	                if(incomingConnName!=null){
		                for(IMetadataColumn column : columnList) {
		                	if (inputCols.contains(column.getLabel())) {
		                    
    stringBuffer.append(TEXT_123);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_127);
    
		                    }
		                }
	                }
	                
    stringBuffer.append(TEXT_128);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_131);
    
	            } else {
	                
    stringBuffer.append(TEXT_132);
    
	            }
	        } 
	        
    stringBuffer.append(TEXT_133);
    
		
	if(outgoingConns != null && outgoingConns.size() > 0) {
	    
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    
	        for(IConnection outgoingConn : outgoingConns) {
	            if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
	                if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	                    
    stringBuffer.append(TEXT_136);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_138);
    
	                    for(IMetadataColumn column : columnList) {
	                    	if(("true").equals(propagateRecordset) && column.getLabel().equals(recordsetColumn)){
	                    	    
    stringBuffer.append(TEXT_139);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    
	                    	} else {
	                    		if(incomingConnName!=null){
	                    			if (inputCols.contains(column.getLabel())) {
	                    	    
    stringBuffer.append(TEXT_143);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_147);
    
	                    	    	}
	                    	    }
	              			}
	                    }
	                }
	            }
	        }
	        
    stringBuffer.append(TEXT_148);
    
	}	
		
	if(!("true").equals(useExistingConn)) {
		if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
	        
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    }
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    }
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
		}
	}
}

    stringBuffer.append(TEXT_161);
    return stringBuffer.toString();
  }
}
