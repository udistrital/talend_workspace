package org.talend.designer.codegen.translators.databases.dbspecifics.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class THiveConnectionBeginJava
{
  protected static String nl;
  public static synchronized THiveConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveConnectionBeginJava result = new THiveConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL + "\t\tfinal String hdInsightPassword_";
  protected final String TEXT_2 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_3 = ");";
  protected final String TEXT_4 = NL + "\t\tfinal String hdInsightPassword_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = "; ";
  protected final String TEXT_7 = " " + NL + "\t\tfinal String wasbPassword_";
  protected final String TEXT_8 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\t\tfinal String wasbPassword_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = "; ";
  protected final String TEXT_13 = NL + "\t" + NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_14 = " = new StringBuilder();" + NL + "\t" + NL + "\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_15 = " = new org.talend.bigdata.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t+ \"AccountName=\"" + NL + "\t\t+ ";
  protected final String TEXT_16 = NL + "\t\t+ \";\"" + NL + "\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = ");" + NL + "\t\t\t" + NL + "\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_19 = " = new org.talend.bigdata.launcher.webhcat.QueryJob(azureFs_";
  protected final String TEXT_20 = ", org.talend.bigdata.launcher.utils.JobType.HIVE);" + NL + "\t\t\t\t\t" + NL + "\tinstance_";
  protected final String TEXT_21 = ".setCredentials(new org.talend.bigdata.launcher.security.HDInsightCredentials(";
  protected final String TEXT_22 = ", hdInsightPassword_";
  protected final String TEXT_23 = "));" + NL + "\tinstance_";
  protected final String TEXT_24 = ".setUsername(";
  protected final String TEXT_25 = ");" + NL + "\tinstance_";
  protected final String TEXT_26 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_27 = " + \":\" + ";
  protected final String TEXT_28 = ");" + NL + "\tinstance_";
  protected final String TEXT_29 = ".setStatusFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_30 = "));" + NL + "\tinstance_";
  protected final String TEXT_31 = ".setRemoteFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_32 = "));" + NL + "\t" + NL + "\tjava.util.List<String> connectionCommandList_";
  protected final String TEXT_33 = " = new java.util.ArrayList<String>();" + NL + "\t";
  protected final String TEXT_34 = NL + "\t\tconnectionCommandList_";
  protected final String TEXT_35 = ".add(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_36 = " + \";\");" + NL + "\t\tconnectionCommandList_";
  protected final String TEXT_37 = ".add(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_38 = " + \";\");" + NL + "\t\tconnectionCommandList_";
  protected final String TEXT_39 = ".add(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_40 = " + \";\");";
  protected final String TEXT_41 = NL + "\t\t\tconnectionCommandList_";
  protected final String TEXT_42 = ".add(\"SET \"+";
  protected final String TEXT_43 = "+\"=\"+";
  protected final String TEXT_44 = " + \";\");";
  protected final String TEXT_45 = NL + NL + "\tString dbname_";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = ";" + NL + "\tif(dbname_";
  protected final String TEXT_48 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_49 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_50 = ".trim())) {" + NL + "\t\tconnectionCommandList_";
  protected final String TEXT_51 = ".add(\"use \" + dbname_";
  protected final String TEXT_52 = " + \";\");" + NL + "\t}" + NL + "" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_53 = "\", instance_";
  protected final String TEXT_54 = ");" + NL + "\tglobalMap.put(\"commandList_";
  protected final String TEXT_55 = "\", connectionCommandList_";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL;
  protected final String TEXT_58 = NL + NL + "java.util.List<String> connectionCommandList_";
  protected final String TEXT_59 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_60 = NL + "        connectionCommandList_";
  protected final String TEXT_61 = ".add(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_62 = " + \";\");" + NL + "        connectionCommandList_";
  protected final String TEXT_63 = ".add(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_64 = " + \";\");" + NL + "        connectionCommandList_";
  protected final String TEXT_65 = ".add(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_66 = " + \";\");";
  protected final String TEXT_67 = NL + "            connectionCommandList_";
  protected final String TEXT_68 = ".add(\"SET \"+";
  protected final String TEXT_69 = "+\"=\"+";
  protected final String TEXT_70 = " + \";\");";
  protected final String TEXT_71 = NL + NL + "    String dbname_";
  protected final String TEXT_72 = " = ";
  protected final String TEXT_73 = ";" + NL + "    if(dbname_";
  protected final String TEXT_74 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_75 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_76 = ".trim())) {" + NL + "        connectionCommandList_";
  protected final String TEXT_77 = ".add(\"use \" + dbname_";
  protected final String TEXT_78 = " + \";\");" + NL + "    }" + NL + "" + NL + "    org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob instance_";
  protected final String TEXT_79 = " =" + NL + "        new org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob.Builder()" + NL + "        .withTalendJobName(projectName + \"_\" + jobName + \"_\" + jobVersion.replace(\".\",\"_\") + \"_\" + pid)" + NL + "        .withClusterName(";
  protected final String TEXT_80 = ")" + NL + "        .withRegion(";
  protected final String TEXT_81 = ")" + NL + "        .withProjectId(";
  protected final String TEXT_82 = ")" + NL + "        .withJarsBucket(";
  protected final String TEXT_83 = ")";
  protected final String TEXT_84 = NL + "                .withServiceAccountCredentialsPath(";
  protected final String TEXT_85 = ")";
  protected final String TEXT_86 = NL + NL + "        .withInitialisationQueries(connectionCommandList_";
  protected final String TEXT_87 = ")" + NL + "        .build();";
  protected final String TEXT_88 = NL + "        for (String command: connectionCommandList_";
  protected final String TEXT_89 = " ) {" + NL + "            log.debug(\"Initialization command from ";
  protected final String TEXT_90 = ": \" + command);" + NL + "        }";
  protected final String TEXT_91 = NL + NL + "    globalMap.put(\"conn_";
  protected final String TEXT_92 = "\", instance_";
  protected final String TEXT_93 = ");" + NL + "    // Will be used to put additionals jars on google storage" + NL + "    globalMap.put(\"stagingBucket_";
  protected final String TEXT_94 = "\", ";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL;
  protected final String TEXT_97 = NL + NL + "java.util.List<String> connectionCommandList_";
  protected final String TEXT_98 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_99 = NL + "        connectionCommandList_";
  protected final String TEXT_100 = ".add(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_101 = " + \";\");" + NL + "        connectionCommandList_";
  protected final String TEXT_102 = ".add(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_103 = " + \";\");" + NL + "        connectionCommandList_";
  protected final String TEXT_104 = ".add(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_105 = " + \";\");";
  protected final String TEXT_106 = NL + "            connectionCommandList_";
  protected final String TEXT_107 = ".add(\"SET \"+";
  protected final String TEXT_108 = "+\"=\"+";
  protected final String TEXT_109 = " + \";\");";
  protected final String TEXT_110 = NL + NL + "    String dbname_";
  protected final String TEXT_111 = " = ";
  protected final String TEXT_112 = ";" + NL + "    if(dbname_";
  protected final String TEXT_113 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_114 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_115 = ".trim())) {" + NL + "        connectionCommandList_";
  protected final String TEXT_116 = ".add(\"use \" + dbname_";
  protected final String TEXT_117 = " + \";\");" + NL + "    }" + NL + "" + NL + "\tString api_token_";
  protected final String TEXT_118 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_119 = ");" + NL + "" + NL + "\torg.talend.bigdata.launcher.qubole.QuboleHiveClient instance_";
  protected final String TEXT_120 = " =" + NL + "\t\tnew org.talend.bigdata.launcher.qubole.QuboleHiveClient.Builder()" + NL + "\t\t\t.setApiKey(api_token_";
  protected final String TEXT_121 = ")" + NL + "\t\t\t";
  protected final String TEXT_122 = " .setApiEndpoint(";
  protected final String TEXT_123 = ") ";
  protected final String TEXT_124 = NL + "\t\t\t.build();" + NL;
  protected final String TEXT_125 = NL + "\t\tlog.info(\"";
  protected final String TEXT_126 = " - connection created.\");" + NL + "        for (String command: connectionCommandList_";
  protected final String TEXT_127 = " ) {" + NL + "            log.debug(\"Initialization command from ";
  protected final String TEXT_128 = ": \" + command);" + NL + "        }";
  protected final String TEXT_129 = NL + NL + "    globalMap.put(\"conn_";
  protected final String TEXT_130 = "\", instance_";
  protected final String TEXT_131 = ");" + NL + "    if (!connectionCommandList_";
  protected final String TEXT_132 = ".isEmpty()) {" + NL + "    \tglobalMap.put(\"conn_init_statements_";
  protected final String TEXT_133 = "\", connectionCommandList_";
  protected final String TEXT_134 = ");" + NL + "    }";
  protected final String TEXT_135 = NL + "\t\t";
  protected final String TEXT_136 = NL + "\t";
  protected final String TEXT_137 = NL + "\t\t\tString driverClass_";
  protected final String TEXT_138 = " = \"";
  protected final String TEXT_139 = "\";" + NL + "\t\t\tjava.lang.Class.forName(driverClass_";
  protected final String TEXT_140 = ");";
  protected final String TEXT_141 = NL + "\t\t\tSharedDBConnectionLog4j.initLogger(log,\"";
  protected final String TEXT_142 = "\");";
  protected final String TEXT_143 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_144 = " = ";
  protected final String TEXT_145 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_146 = " = ";
  protected final String TEXT_147 = ".getDBConnection(\"";
  protected final String TEXT_148 = "\",url_";
  protected final String TEXT_149 = ",dbUser_";
  protected final String TEXT_150 = " , dbPwd_";
  protected final String TEXT_151 = " , sharedConnectionName_";
  protected final String TEXT_152 = ");";
  protected final String TEXT_153 = NL + "\t\tconn_";
  protected final String TEXT_154 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_155 = ",dbUser_";
  protected final String TEXT_156 = ",dbPwd_";
  protected final String TEXT_157 = ");";
  protected final String TEXT_158 = NL + "\t\t\tlog.debug(\"";
  protected final String TEXT_159 = " - Connection is set auto commit to '";
  protected final String TEXT_160 = "'.\");";
  protected final String TEXT_161 = NL + "\t\t\tconn_";
  protected final String TEXT_162 = ".setAutoCommit(";
  protected final String TEXT_163 = ");";
  protected final String TEXT_164 = NL + "\t\t\t\tconn_";
  protected final String TEXT_165 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_166 = ");";
  protected final String TEXT_167 = NL + "                if(true) {" + NL + "                    throw new java.lang.Exception(\"The distribution ";
  protected final String TEXT_168 = " does not support this version of Hive . Please check your component configuration.\");" + NL + "                }";
  protected final String TEXT_169 = NL + "                if(true) {" + NL + "                    throw new java.lang.Exception(\"The distribution ";
  protected final String TEXT_170 = " does not support this connection mode . Please check your component configuration.\");" + NL + "                }";
  protected final String TEXT_171 = NL + "                if(true) {" + NL + "                    throw new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "                }";
  protected final String TEXT_172 = NL + "          org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_173 = " = new org.apache.hadoop.conf.Configuration();";
  protected final String TEXT_174 = NL + "          System.setProperty(";
  protected final String TEXT_175 = " ,";
  protected final String TEXT_176 = ");";
  protected final String TEXT_177 = NL + "            conf_";
  protected final String TEXT_178 = ".set(";
  protected final String TEXT_179 = " ,";
  protected final String TEXT_180 = ");";
  protected final String TEXT_181 = NL + "          org.apache.hadoop.security.UserGroupInformation.setConfiguration(conf_";
  protected final String TEXT_182 = ");" + NL + "          org.apache.hadoop.security.UserGroupInformation.getLoginUser();";
  protected final String TEXT_183 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.sasl.enabled\", \"true\");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionDriverName\", ";
  protected final String TEXT_184 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"false\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_186 = NL + "\t\t\t\t\tSystem.setProperty(\"hive.security.authorization.enabled\", \"true\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_187 = NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionURL\", ";
  protected final String TEXT_188 = ");" + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionUserName\", ";
  protected final String TEXT_189 = ");" + NL + "" + NL + "        \t\t";
  protected final String TEXT_190 = NL + NL + "        \t\t";
  protected final String TEXT_191 = NL + "            \tString decryptedMetastorePassword_";
  protected final String TEXT_192 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_193 = ");" + NL + "       \t\t \t";
  protected final String TEXT_194 = NL + "            \tString decryptedMetastorePassword_";
  protected final String TEXT_195 = " = ";
  protected final String TEXT_196 = ";" + NL + "    \t\t\t";
  protected final String TEXT_197 = NL + NL + "\t\t\t\tSystem.setProperty(\"javax.jdo.option.ConnectionPassword\", decryptedMetastorePassword_";
  protected final String TEXT_198 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.kerberos.principal\", ";
  protected final String TEXT_199 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_200 = NL + "\t\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.principal\", ";
  protected final String TEXT_201 = ");" + NL + "\t\t\t\t\tSystem.setProperty(\"hive.server2.authentication.kerberos.keytab\", ";
  protected final String TEXT_202 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_203 = NL + "\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_204 = ", ";
  protected final String TEXT_205 = ");";
  protected final String TEXT_206 = NL + "\t\t\t\tSystem.setProperty(\"mapred.job.tracker\", ";
  protected final String TEXT_207 = ");";
  protected final String TEXT_208 = NL + "\t\t\t\tSystem.setProperty(\"";
  protected final String TEXT_209 = "\", ";
  protected final String TEXT_210 = ");";
  protected final String TEXT_211 = NL + "                String username_";
  protected final String TEXT_212 = " = ";
  protected final String TEXT_213 = ";" + NL + "                if(username_";
  protected final String TEXT_214 = "!=null && !\"\".equals(username_";
  protected final String TEXT_215 = ".trim())) {" + NL + "                    System.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_216 = ");" + NL + "                }";
  protected final String TEXT_217 = NL + "\t\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_218 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "\t\t\t";
  protected final String TEXT_219 = NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.local\", \"false\");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_220 = " + \":\" + ";
  protected final String TEXT_221 = ");" + NL + "\t\t\t\tSystem.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "\t\t\t\tString url_";
  protected final String TEXT_222 = " = \"jdbc:";
  protected final String TEXT_223 = "://\";";
  protected final String TEXT_224 = NL + "\t\t\t\t\tString dbUserName_";
  protected final String TEXT_225 = " = ";
  protected final String TEXT_226 = ";" + NL + "\t\t\t\t\tif(dbUserName_";
  protected final String TEXT_227 = "!=null && !\"\".equals(dbUserName_";
  protected final String TEXT_228 = ".trim())) {" + NL + "\t\t\t\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\",dbUserName_";
  protected final String TEXT_229 = ");" + NL + "\t\t\t\t\t\t//make relative file path work for hive" + NL + "\t\t\t\t\t\tglobalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "\t\t\t\t\t\tSystem.setProperty(\"user.name\",dbUserName_";
  protected final String TEXT_230 = ");" + NL + "\t\t\t\t\t\tglobalMap.put(\"dbUser_";
  protected final String TEXT_231 = "\",dbUserName_";
  protected final String TEXT_232 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_233 = NL + "\t\t\t\t\tString url_";
  protected final String TEXT_234 = " = \"jdbc:";
  protected final String TEXT_235 = "://\" + ";
  protected final String TEXT_236 = " + \":\" + ";
  protected final String TEXT_237 = " + \"/\" + ";
  protected final String TEXT_238 = " + \";\";" + NL + "" + NL + "\t\t\t\t\t// Add HADOOP_CONF_DIR to the classpath if it's present" + NL + "\t\t\t\t\tString hadoopConfDir_";
  protected final String TEXT_239 = " = System.getenv(\"HADOOP_CONF_DIR\");" + NL + "\t\t\t\t\tif(hadoopConfDir_";
  protected final String TEXT_240 = " != null){" + NL + "\t\t\t\t\t\tjava.net.URLClassLoader sysloader = (java.net.URLClassLoader) ClassLoader.getSystemClassLoader();" + NL + "\t\t\t\t\t\tjava.lang.reflect.Method method = java.net.URLClassLoader.class.getDeclaredMethod(\"addURL\", new Class[] { java.net.URL.class });" + NL + "\t\t\t\t\t\tmethod.setAccessible(true);" + NL + "\t\t\t\t\t\tmethod.invoke(sysloader,new Object[] { new java.io.File(hadoopConfDir_";
  protected final String TEXT_241 = ").toURI().toURL() });" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\torg.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_242 = " = new org.apache.hadoop.conf.Configuration();" + NL + "" + NL + "\t\t\t\t\t// Adding any talend-site.xml files on the classpath" + NL + "\t\t\t\t\tconf_";
  protected final String TEXT_243 = ".addResource(\"talend-site.xml\");" + NL + "\t\t\t\t\tString tldHiveKerberosAuth = conf_";
  protected final String TEXT_244 = ".get(\"talend.kerberos.authentication\", \"\");" + NL + "\t\t\t\t\tString tldHiveKerberosKtPrincipal = conf_";
  protected final String TEXT_245 = ".get(\"talend.kerberos.keytab.principal\", \"\");" + NL + "\t\t\t\t\tString tldHiveKerberosKtPath = conf_";
  protected final String TEXT_246 = ".get(\"talend.kerberos.keytab.path\", \"\");" + NL + "\t\t\t\t\tString tldHiveEnc = conf_";
  protected final String TEXT_247 = ".get(\"talend.encryption\", \"\");" + NL + "\t\t\t\t\tString tldHiveSslTsPath = conf_";
  protected final String TEXT_248 = ".get(\"talend.ssl.trustStore.path\", \"\");" + NL + "\t\t\t\t\tString tldHiveSslTsPassword = conf_";
  protected final String TEXT_249 = ".get(\"talend.ssl.trustStore.password\", \"\");" + NL + "" + NL + "\t\t\t\t\t// Add configurations from hive-site.xml" + NL + "\t\t\t\t\tconf_";
  protected final String TEXT_250 = ".addResource(\"hive-site.xml\");" + NL + "" + NL + "\t\t\t\t\t// Add configurations from yarn-site.xml" + NL + "\t\t\t\t\tconf_";
  protected final String TEXT_251 = ".addResource(\"yarn-site.xml\");" + NL + "" + NL + "\t\t\t\t\t// Add configurations from mapred-site.xml" + NL + "\t\t\t\t\tconf_";
  protected final String TEXT_252 = ".addResource(\"mapred-site.xml\");" + NL + "" + NL + "\t\t\t\t\t// Add configurations from hdfs-site.xml" + NL + "\t\t\t\t\tconf_";
  protected final String TEXT_253 = ".addResource(\"hdfs-site.xml\");";
  protected final String TEXT_254 = NL + "\t\t\t\t\t\t// Add configurations from hbase-site.xml" + NL + "\t\t\t\t\t\tconf_";
  protected final String TEXT_255 = ".addResource(\"hbase-site.xml\");";
  protected final String TEXT_256 = NL + "\t\t\t\t\t\tconf_";
  protected final String TEXT_257 = ".set(";
  protected final String TEXT_258 = " ,";
  protected final String TEXT_259 = ");";
  protected final String TEXT_260 = NL + "\t\t\t\t\t\tlog.debug(\"CLASSPATH_CONFIGURATION_";
  protected final String TEXT_261 = "\" + \" Loaded : \" + conf_";
  protected final String TEXT_262 = ");" + NL + "\t\t\t\t\t\tlog.debug(\"CLASSPATH_CONFIGURATION_";
  protected final String TEXT_263 = "\" + \" key value pairs : \");" + NL + "\t\t\t\t\t\tjava.util.Iterator<java.util.Map.Entry<String,String>> iterator_log_";
  protected final String TEXT_264 = " = conf_";
  protected final String TEXT_265 = ".iterator();" + NL + "\t\t\t\t\t\twhile(iterator_log_";
  protected final String TEXT_266 = ".hasNext()){" + NL + "\t\t\t\t\t\t\tjava.util.Map.Entry<String,String> property = iterator_log_";
  protected final String TEXT_267 = ".next();" + NL + "\t\t\t\t\t\t\tlog.debug(\"CLASSPATH_CONFIGURATION_";
  protected final String TEXT_268 = " \" + property.getKey() + \" : \" + property.getValue());" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_269 = NL + "\t\t\t\t\tif(org.apache.hadoop.security.UserGroupInformation.isSecurityEnabled()){" + NL + "" + NL + "" + NL + "\t\t\t\t\t\tString hiveServer2KerberosPrincipal = conf_";
  protected final String TEXT_270 = ".get(\"hive.server2.authentication.kerberos.principal\", \"\");" + NL + "\t\t\t\t\t\tString urlKerberosParameter = \"principal=\" + hiveServer2KerberosPrincipal;" + NL + "" + NL + "\t\t\t\t\t\t// Keytab configurations" + NL + "\t\t\t\t\t\tif(tldHiveKerberosAuth.equalsIgnoreCase(\"keytab\")){" + NL + "\t\t\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(tldHiveKerberosKtPrincipal, tldHiveKerberosKtPath);" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t\t// SSL configurations" + NL + "\t\t\t\t\t\tif(tldHiveEnc.equalsIgnoreCase(\"ssl\")){";
  protected final String TEXT_271 = NL + "\t\t\t\t\t\t\t\turl_";
  protected final String TEXT_272 = " += urlKerberosParameter + \";ssl=true\" +\";sslTrustStore=\" + tldHiveSslTsPath + \";trustStorePassword=\" + tldHiveSslTsPassword;";
  protected final String TEXT_273 = NL + "\t\t\t\t\t\t\t\turl_";
  protected final String TEXT_274 = " += urlKerberosParameter + \";sasl.qop=auth-conf\";";
  protected final String TEXT_275 = NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\turl_";
  protected final String TEXT_276 = " += urlKerberosParameter;" + NL + "\t\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\t}else{" + NL + "" + NL + "\t\t\t\t\t\t// SSL configurations" + NL + "\t\t\t\t\t\tif(tldHiveEnc.equalsIgnoreCase(\"ssl\")){" + NL + "\t\t\t\t\t\t\turl_";
  protected final String TEXT_277 = " += \";ssl=true\" +\";sslTrustStore=\" + tldHiveSslTsPath + \";trustStorePassword=\" + tldHiveSslTsPassword;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}";
  protected final String TEXT_278 = NL + "\t\t\t\t            System.setProperty(\"pname\", \"MapRLogin\");" + NL + "\t\t\t\t            System.setProperty(\"https.protocols\", \"TLSv1.2\");" + NL + "\t\t\t\t            System.setProperty(\"mapr.home.dir\", ";
  protected final String TEXT_279 = ");" + NL + "\t\t\t\t            System.setProperty(\"hadoop.login\", ";
  protected final String TEXT_280 = ");" + NL + "\t\t\t\t            ";
  protected final String TEXT_281 = NL + "\t\t\t\t\t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_282 = ", ";
  protected final String TEXT_283 = ");";
  protected final String TEXT_284 = NL + "                            com.mapr.login.client.MapRLoginHttpsClient maprLogin_";
  protected final String TEXT_285 = " = new com.mapr.login.client.MapRLoginHttpsClient();" + NL + "                            maprLogin_";
  protected final String TEXT_286 = ".getMapRCredentialsViaKerberos(";
  protected final String TEXT_287 = ", ";
  protected final String TEXT_288 = ");";
  protected final String TEXT_289 = NL + "\t\t\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_290 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_291 = ");";
  protected final String TEXT_292 = NL + "\t\t\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_293 = " = ";
  protected final String TEXT_294 = ";";
  protected final String TEXT_295 = NL + "\t\t\t\t\t\t\t\tString url_";
  protected final String TEXT_296 = " = \"jdbc:";
  protected final String TEXT_297 = "://\" + ";
  protected final String TEXT_298 = " + \":\" + ";
  protected final String TEXT_299 = " + \"/\" + ";
  protected final String TEXT_300 = " + \";principal=\" + ";
  protected final String TEXT_301 = "+\";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_302 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_303 = ";";
  protected final String TEXT_304 = NL + "\t\t\t\t\t\t\tString url_";
  protected final String TEXT_305 = " = \"jdbc:";
  protected final String TEXT_306 = "://\" + ";
  protected final String TEXT_307 = " + \":\" + ";
  protected final String TEXT_308 = " + \"/\" + ";
  protected final String TEXT_309 = " + \";principal=\" + ";
  protected final String TEXT_310 = "+\";sasl.qop=auth-conf\";";
  protected final String TEXT_311 = NL + "\t\t\t\t\t\tString url_";
  protected final String TEXT_312 = " = \"jdbc:";
  protected final String TEXT_313 = "://\" + ";
  protected final String TEXT_314 = " + \":\" + ";
  protected final String TEXT_315 = " + \"/\" + ";
  protected final String TEXT_316 = " + \";principal=\" + ";
  protected final String TEXT_317 = ";";
  protected final String TEXT_318 = NL + "\t\t\t\t            System.setProperty(\"pname\", \"MapRLogin\");" + NL + "\t\t\t\t            System.setProperty(\"https.protocols\", \"TLSv1.2\");" + NL + "\t\t\t\t            System.setProperty(\"mapr.home.dir\", ";
  protected final String TEXT_319 = ");" + NL + "\t\t\t\t            com.mapr.login.client.MapRLoginHttpsClient maprLogin_";
  protected final String TEXT_320 = " = new com.mapr.login.client.MapRLoginHttpsClient();" + NL + "\t\t\t\t            ";
  protected final String TEXT_321 = NL + "\t\t\t\t                System.setProperty(\"hadoop.login\", ";
  protected final String TEXT_322 = ");" + NL + "\t\t\t\t                ";
  protected final String TEXT_323 = NL + "\t\t\t\t                maprLogin_";
  protected final String TEXT_324 = ".setCheckUGI(false);" + NL + "\t\t\t\t                ";
  protected final String TEXT_325 = NL + "                                String decryptedMaprPassword_";
  protected final String TEXT_326 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_327 = ");";
  protected final String TEXT_328 = NL + "                                String decryptedMaprPassword_";
  protected final String TEXT_329 = " = ";
  protected final String TEXT_330 = ";";
  protected final String TEXT_331 = NL + "                \t\t\t\tmaprLogin_";
  protected final String TEXT_332 = ".getMapRCredentialsViaPassword(";
  protected final String TEXT_333 = ", ";
  protected final String TEXT_334 = ", decryptedMaprPassword_";
  protected final String TEXT_335 = ", ";
  protected final String TEXT_336 = ", \"\");" + NL + "                \t\t\t\t";
  protected final String TEXT_337 = NL + "                \t\t\t\tmaprLogin_";
  protected final String TEXT_338 = ".getMapRCredentialsViaPassword(";
  protected final String TEXT_339 = ", ";
  protected final String TEXT_340 = ", decryptedMaprPassword_";
  protected final String TEXT_341 = ", ";
  protected final String TEXT_342 = ");" + NL + "                \t\t\t\t";
  protected final String TEXT_343 = NL + "\t\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_344 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_345 = ");";
  protected final String TEXT_346 = NL + "\t\t\t\t\t\t\t\tString decryptedSslStorePassword_";
  protected final String TEXT_347 = " = ";
  protected final String TEXT_348 = ";";
  protected final String TEXT_349 = NL + "\t\t\t\t\t\t\tString url_";
  protected final String TEXT_350 = " = \"jdbc:";
  protected final String TEXT_351 = "://\" + ";
  protected final String TEXT_352 = " + \":\" + ";
  protected final String TEXT_353 = " + \"/\" + ";
  protected final String TEXT_354 = "+ \";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_355 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_356 = ";";
  protected final String TEXT_357 = NL + "\t\t\t\t\t\t\tString url_";
  protected final String TEXT_358 = " = \"jdbc:";
  protected final String TEXT_359 = "://\" + ";
  protected final String TEXT_360 = " + \":\" + ";
  protected final String TEXT_361 = " + \"/\" + ";
  protected final String TEXT_362 = ";";
  protected final String TEXT_363 = NL + "\t\t\t\tString additionalJdbcSettings_";
  protected final String TEXT_364 = " = ";
  protected final String TEXT_365 = ";" + NL + "\t\t\t\tif(!\"\".equals(additionalJdbcSettings_";
  protected final String TEXT_366 = ".trim())) {" + NL + "\t\t\t\t\tif(!additionalJdbcSettings_";
  protected final String TEXT_367 = ".startsWith(\";\")) {" + NL + "\t\t\t\t\t\tadditionalJdbcSettings_";
  protected final String TEXT_368 = " = \";\" + additionalJdbcSettings_";
  protected final String TEXT_369 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\turl_";
  protected final String TEXT_370 = " += additionalJdbcSettings_";
  protected final String TEXT_371 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_372 = NL + "\t\t\tconn_";
  protected final String TEXT_373 = ".setAutoCommit(";
  protected final String TEXT_374 = ");";
  protected final String TEXT_375 = NL + NL + "\t";
  protected final String TEXT_376 = NL + NL + "\tString dbUser_";
  protected final String TEXT_377 = " = ";
  protected final String TEXT_378 = ";";
  protected final String TEXT_379 = NL + "\t" + NL + "\t";
  protected final String TEXT_380 = NL + "\t\tString dbPwd_";
  protected final String TEXT_381 = " = null;" + NL + "\t";
  protected final String TEXT_382 = NL + "\t\t";
  protected final String TEXT_383 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_384 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_385 = ");";
  protected final String TEXT_386 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_387 = " = ";
  protected final String TEXT_388 = "; ";
  protected final String TEXT_389 = NL + "\t\tString dbPwd_";
  protected final String TEXT_390 = " = decryptedPassword_";
  protected final String TEXT_391 = ";" + NL + "\t";
  protected final String TEXT_392 = NL + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_393 = " = null;" + NL + "\t";
  protected final String TEXT_394 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_395 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_396 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_397 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_398 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_399 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_400 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_401 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_402 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_403 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_404 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_405 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_406 = " - Written records count: \" + nb_line_";
  protected final String TEXT_407 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_408 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_409 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_410 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_411 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_412 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_413 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_414 = " - Writing the record \" + nb_line_";
  protected final String TEXT_415 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_416 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_417 = " - Processing the record \" + nb_line_";
  protected final String TEXT_418 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_419 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_420 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_421 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_422 = NL + "\t\t\t\tif(conn_";
  protected final String TEXT_423 = " != null) {" + NL + "\t\t\t\t\tif(conn_";
  protected final String TEXT_424 = ".getMetaData() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_425 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_426 = " - Uses an existing connection ";
  protected final String TEXT_427 = ".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_428 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_429 = " - Uses an existing connection with username '\" + conn_";
  protected final String TEXT_430 = ".getMetaData().getUserName() + \"'. Connection URL: \" + conn_";
  protected final String TEXT_431 = ".getMetaData().getURL() + \".\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_432 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_433 = NL + "\t\t\tconn_";
  protected final String TEXT_434 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_435 = ", dbUser_";
  protected final String TEXT_436 = ", dbPwd_";
  protected final String TEXT_437 = ");" + NL + "\t\t\t";
  protected final String TEXT_438 = NL + "\t\t\tconn_";
  protected final String TEXT_439 = ".rollback();" + NL + "\t\t\t";
  protected final String TEXT_440 = NL + "\t\t\tconn_";
  protected final String TEXT_441 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_442 = NL + "\t\t\tconn_";
  protected final String TEXT_443 = ".close();" + NL + "\t\t\t";
  protected final String TEXT_444 = NL + "\t\t\t\tconn_";
  protected final String TEXT_445 = ".setAutoCommit(";
  protected final String TEXT_446 = ");" + NL + "\t\t\t";
  protected final String TEXT_447 = NL + "\t\t\t\tlog.";
  protected final String TEXT_448 = "(\"";
  protected final String TEXT_449 = " - \" + ";
  protected final String TEXT_450 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_451 = NL + "\t    \t\tlog.";
  protected final String TEXT_452 = "(\"";
  protected final String TEXT_453 = "\");" + NL + "\t\t\t";
  protected final String TEXT_454 = NL + "\t\t\t\tpstmt_";
  protected final String TEXT_455 = ".executeBatch();" + NL + "\t\t\t";
  protected final String TEXT_456 = NL + "\t\t\t\tint countSum_";
  protected final String TEXT_457 = " = 0;" + NL + "\t\t\t\tfor(int countEach_";
  protected final String TEXT_458 = ": pstmt_";
  protected final String TEXT_459 = ".executeBatch()) {" + NL + "\t\t\t\t\tcountSum_";
  protected final String TEXT_460 = " += (countEach_";
  protected final String TEXT_461 = " < 0 ? 0 : ";
  protected final String TEXT_462 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_463 = NL + "\t";
  protected final String TEXT_464 = NL + "\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_465 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\tif (dataSources_";
  protected final String TEXT_466 = " == null) {";
  protected final String TEXT_467 = NL + "\t\t";
  protected final String TEXT_468 = NL + "\t\t";
  protected final String TEXT_469 = NL + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_470 = "\", conn_";
  protected final String TEXT_471 = ");";
  protected final String TEXT_472 = NL + "\t} else {" + NL + "\t\tString dsAlias_";
  protected final String TEXT_473 = " = ";
  protected final String TEXT_474 = ";" + NL + "\t\tif (dataSources_";
  protected final String TEXT_475 = ".get(dsAlias_";
  protected final String TEXT_476 = ") == null) {" + NL + "   \t\t\tthrow new Exception(\"No DataSource with alias: \" + dsAlias_";
  protected final String TEXT_477 = " + \" available!\");" + NL + "      \t}" + NL + "\t\tconn_";
  protected final String TEXT_478 = " = dataSources_";
  protected final String TEXT_479 = ".get(dsAlias_";
  protected final String TEXT_480 = ").getConnection();" + NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_481 = "\", conn_";
  protected final String TEXT_482 = ");" + NL + "\t}";
  protected final String TEXT_483 = NL + "\tif (null != conn_";
  protected final String TEXT_484 = ") {" + NL + "\t\t";
  protected final String TEXT_485 = NL + "\t}";
  protected final String TEXT_486 = NL;
  protected final String TEXT_487 = NL + "\tglobalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "\tSystem.setProperty(\"path.separator\", ";
  protected final String TEXT_488 = ");" + NL + "" + NL + "\tjava.sql.Statement init_";
  protected final String TEXT_489 = " = conn_";
  protected final String TEXT_490 = ".createStatement();";
  protected final String TEXT_491 = NL + "        init_";
  protected final String TEXT_492 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_493 = ");" + NL + "\t    init_";
  protected final String TEXT_494 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_495 = ");";
  protected final String TEXT_496 = NL + "\t\tinit_";
  protected final String TEXT_497 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_498 = ");";
  protected final String TEXT_499 = NL + "\t\t\tinit_";
  protected final String TEXT_500 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_501 = ");";
  protected final String TEXT_502 = NL + "\t\t\tinit_";
  protected final String TEXT_503 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_504 = ");";
  protected final String TEXT_505 = NL + "    \t\tinit_";
  protected final String TEXT_506 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "    \t\tinit_";
  protected final String TEXT_507 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_508 = ");";
  protected final String TEXT_509 = NL + "\t\t\tinit_";
  protected final String TEXT_510 = ".execute(\"SET mapreduce.jobhistory.address=\" + ";
  protected final String TEXT_511 = ");" + NL + "\t\t\t";
  protected final String TEXT_512 = NL + "\t\t\tinit_";
  protected final String TEXT_513 = ".execute(\"SET dfs.client.use.datanode.hostname=true\");";
  protected final String TEXT_514 = NL + "\t\t\tinit_";
  protected final String TEXT_515 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_516 = ");";
  protected final String TEXT_517 = NL + "\t\t\tinit_";
  protected final String TEXT_518 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_519 = ");";
  protected final String TEXT_520 = NL + "\t\t\t\tinit_";
  protected final String TEXT_521 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_522 = NL + "\t\t\t\tinit_";
  protected final String TEXT_523 = ".execute(\"SET mapreduce.job.map.output.collector.class=org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "\t\t\t\tinit_";
  protected final String TEXT_524 = ".execute(\"SET mapreduce.job.reduce.shuffle.consumer.plugin.class=org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_525 = NL + "\t\t\t\tinit_";
  protected final String TEXT_526 = ".execute(\"SET mapreduce.application.classpath=";
  protected final String TEXT_527 = "\");";
  protected final String TEXT_528 = NL + "\t\t\tinit_";
  protected final String TEXT_529 = ".execute(\"SET yarn.application.classpath=";
  protected final String TEXT_530 = "\");";
  protected final String TEXT_531 = NL + "\t\t\tinit_";
  protected final String TEXT_532 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_533 = ");" + NL + "\t\t\tinit_";
  protected final String TEXT_534 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_535 = ");" + NL + "\t\t\tinit_";
  protected final String TEXT_536 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_537 = ");";
  protected final String TEXT_538 = NL + "\t\t\tinit_";
  protected final String TEXT_539 = ".execute(\"SET \"+";
  protected final String TEXT_540 = "+\"=\"+";
  protected final String TEXT_541 = ");";
  protected final String TEXT_542 = NL + NL + "\t";
  protected final String TEXT_543 = NL;
  protected final String TEXT_544 = NL + "    \t\tinit_";
  protected final String TEXT_545 = ".execute(\"SET hive.execution.engine=tez\");";
  protected final String TEXT_546 = NL + "                        System.err.println(\"Please set the path of Tez lib in 'Tez lib path'!\");";
  protected final String TEXT_547 = NL;
  protected final String TEXT_548 = NL + "        String username_";
  protected final String TEXT_549 = " = (";
  protected final String TEXT_550 = " != null && !\"\".equals(";
  protected final String TEXT_551 = ")) ? ";
  protected final String TEXT_552 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_553 = " = null;";
  protected final String TEXT_554 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_555 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_556 = ".set(\"";
  protected final String TEXT_557 = "\", ";
  protected final String TEXT_558 = ");" + NL + "        ";
  protected final String TEXT_559 = NL + "            conf_";
  protected final String TEXT_560 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_561 = NL + "        \t\tconf_";
  protected final String TEXT_562 = ".set(";
  protected final String TEXT_563 = " ,";
  protected final String TEXT_564 = ");" + NL + "        \t";
  protected final String TEXT_565 = NL + "            username_";
  protected final String TEXT_566 = " = null;" + NL + "    \t\tconf_";
  protected final String TEXT_567 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_568 = ");" + NL + "    \t\t";
  protected final String TEXT_569 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_570 = ", ";
  protected final String TEXT_571 = ");" + NL + "    \t\t";
  protected final String TEXT_572 = NL + "\t\t\tconf_";
  protected final String TEXT_573 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_574 = "+\",\"+username_";
  protected final String TEXT_575 = ");" + NL + "        \tfs_";
  protected final String TEXT_576 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_577 = ");";
  protected final String TEXT_578 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_579 = " == null || \"\".equals(username_";
  protected final String TEXT_580 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_581 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_582 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_583 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_584 = ".get(\"";
  protected final String TEXT_585 = "\")),conf_";
  protected final String TEXT_586 = ",username_";
  protected final String TEXT_587 = ");" + NL + "        \t}\t";
  protected final String TEXT_588 = NL + "                    String hdfsUserName_";
  protected final String TEXT_589 = " = (";
  protected final String TEXT_590 = " != null && !\"\".equals(";
  protected final String TEXT_591 = ")) ? ";
  protected final String TEXT_592 = " : System.getProperty(\"user.name\");" + NL + "                    String tezLibPath_";
  protected final String TEXT_593 = " = \"/tmp/\" + hdfsUserName_";
  protected final String TEXT_594 = " + \"/talend_tez_libs/";
  protected final String TEXT_595 = "\";";
  protected final String TEXT_596 = NL + "                    String tezLibPath_";
  protected final String TEXT_597 = " = ";
  protected final String TEXT_598 = ";";
  protected final String TEXT_599 = NL + "                fs_";
  protected final String TEXT_600 = ".mkdirs(new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_601 = "));";
  protected final String TEXT_602 = NL + "                String[] classPaths_";
  protected final String TEXT_603 = " = System.getProperty(\"java.class.path\").split(";
  protected final String TEXT_604 = "String.valueOf(globalMap.get(\"current_client_path_separator\"))";
  protected final String TEXT_605 = "System.getProperty(\"path.separator\")";
  protected final String TEXT_606 = ");" + NL + "                String tezLibLocalPath_";
  protected final String TEXT_607 = " = null;" + NL + "                for(String classPath_";
  protected final String TEXT_608 = " : classPaths_";
  protected final String TEXT_609 = "){";
  protected final String TEXT_610 = NL + "                        if(classPath_";
  protected final String TEXT_611 = ".endsWith(\"";
  protected final String TEXT_612 = "\")){" + NL + "                            org.apache.hadoop.fs.Path tezJarPath_";
  protected final String TEXT_613 = " = new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_614 = " + \"/";
  protected final String TEXT_615 = "\");" + NL + "                            if(!fs_";
  protected final String TEXT_616 = ".exists(tezJarPath_";
  protected final String TEXT_617 = ")){" + NL + "                                fs_";
  protected final String TEXT_618 = ".copyFromLocalFile(false, false, new org.apache.hadoop.fs.Path(classPath_";
  protected final String TEXT_619 = "), tezJarPath_";
  protected final String TEXT_620 = ");" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_621 = NL + "                }";
  protected final String TEXT_622 = NL + "                String tezLibPath_";
  protected final String TEXT_623 = " = ";
  protected final String TEXT_624 = ";";
  protected final String TEXT_625 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_626 = " = new StringBuilder();" + NL + "\t\t\tString[] tezLibPaths_";
  protected final String TEXT_627 = " = tezLibPath_";
  protected final String TEXT_628 = ".split(\",\");" + NL + "\t\t\tscript_";
  protected final String TEXT_629 = ".append(\"SET tez.lib.uris=\");" + NL + "\t\t\tint tezLibPathCount_";
  protected final String TEXT_630 = " = 1;" + NL + "\t\t\tfor(String tezLibPathKey_";
  protected final String TEXT_631 = " : tezLibPaths_";
  protected final String TEXT_632 = "){" + NL + "\t\t\t\t script_";
  protected final String TEXT_633 = ".append(";
  protected final String TEXT_634 = " + \"/\" + tezLibPathKey_";
  protected final String TEXT_635 = ");" + NL + "\t\t\t\t if(tezLibPathCount_";
  protected final String TEXT_636 = " < tezLibPaths_";
  protected final String TEXT_637 = ".length){" + NL + "\t\t\t\t \tscript_";
  protected final String TEXT_638 = ".append(\",\");" + NL + "\t\t\t\t }" + NL + "\t\t\t\t tezLibPathCount_";
  protected final String TEXT_639 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tinit_";
  protected final String TEXT_640 = ".execute(script_";
  protected final String TEXT_641 = ".toString());" + NL + "\t\t";
  protected final String TEXT_642 = NL + "\t";
  protected final String TEXT_643 = NL + NL + "\tinit_";
  protected final String TEXT_644 = ".close();" + NL + "" + NL + "\t";
  protected final String TEXT_645 = NL + "\t\tjava.sql.Statement statement_";
  protected final String TEXT_646 = " = conn_";
  protected final String TEXT_647 = ".createStatement();" + NL + "\t\t";
  protected final String TEXT_648 = NL + "\t\t\tstatement_";
  protected final String TEXT_649 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_650 = ");" + NL + "\t\t";
  protected final String TEXT_651 = NL + NL + "\t\t";
  protected final String TEXT_652 = NL + "\t\t\tstatement_";
  protected final String TEXT_653 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_654 = ");" + NL + "\t\t";
  protected final String TEXT_655 = NL + NL + "\t\t";
  protected final String TEXT_656 = NL + "\t\t\tstatement_";
  protected final String TEXT_657 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_658 = ");" + NL + "\t\t";
  protected final String TEXT_659 = NL + NL + "\t\t";
  protected final String TEXT_660 = NL + "\t\t\tstatement_";
  protected final String TEXT_661 = ".execute(\"SET hbase.security.authentication=kerberos\");" + NL + "\t\t\tstatement_";
  protected final String TEXT_662 = ".execute(\"SET hbase.rpc.engine=org.apache.hadoop.hbase.ipc.SecureRpcEngine\");" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_663 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_664 = ".execute(\"SET hbase.master.kerberos.principal=\"+";
  protected final String TEXT_665 = ");" + NL + "\t\t\t";
  protected final String TEXT_666 = NL + "\t\t\t";
  protected final String TEXT_667 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_668 = ".execute(\"SET hbase.regionserver.kerberos.principal=\"+";
  protected final String TEXT_669 = ");" + NL + "\t\t\t";
  protected final String TEXT_670 = NL + "\t\t";
  protected final String TEXT_671 = NL + NL + "\t\t";
  protected final String TEXT_672 = NL + "\t\t\t\tstatement_";
  protected final String TEXT_673 = ".execute(\"add jar \"+";
  protected final String TEXT_674 = ");" + NL + "\t\t";
  protected final String TEXT_675 = NL + "\t\tstatement_";
  protected final String TEXT_676 = ".close();" + NL + "\t";
  protected final String TEXT_677 = NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_678 = "\",conn_";
  protected final String TEXT_679 = ");" + NL + "" + NL + "\tglobalMap.put(\"db_";
  protected final String TEXT_680 = "\",";
  protected final String TEXT_681 = ");" + NL + "" + NL + "\tString currentClientPathSeparator_";
  protected final String TEXT_682 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "\tif(currentClientPathSeparator_";
  protected final String TEXT_683 = "!=null) {" + NL + "\t\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_684 = ");" + NL + "\t\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "\t}" + NL + "" + NL + "\tString currentClientUsername_";
  protected final String TEXT_685 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "\tif(currentClientUsername_";
  protected final String TEXT_686 = "!=null) {" + NL + "\t\tSystem.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_687 = ");" + NL + "\t\tglobalMap.put(\"current_client_user_name\", null);" + NL + "\t}" + NL + "" + NL + "\tString originalHadoopUsername_";
  protected final String TEXT_688 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_689 = "\");" + NL + "\tif(originalHadoopUsername_";
  protected final String TEXT_690 = "!=null) {" + NL + "\t\tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_691 = ");" + NL + "\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_692 = "\", null);" + NL + "\t} else {" + NL + "\t\tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument theCodeGenArgument = (CodeGeneratorArgument) argument;
	INode theNode = (INode)theCodeGenArgument.getArgument();
	String theDistribution = ElementParameterParser.getValue(theNode, "__DISTRIBUTION__");
	String theVersion = ElementParameterParser.getValue(theNode, "__HIVE_VERSION__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(theNode.getProcess(), "__LOG4J_ACTIVATE__"));

	org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
	try {
		hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(theDistribution, theVersion);
	} catch (java.lang.Exception e) {
		e.printStackTrace();
		return "";
	}
	boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

    if (hiveDistrib.isExecutedThroughWebHCat()) { // Connection through WebHCat api

    

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String cid = node.getUniqueName();

	String passwordFieldName = "__HDINSIGHT_PASSWORD__";
	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_3);
    
	} else {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_6);
    
	}
			
	passwordFieldName = "__WASB_PASSWORD__";
	if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_9);
    
	} else {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_12);
    
	}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
	boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
	if(setMemory) {
		String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
		String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
		String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_40);
    
	}
	
	List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
	if(advProps!=null) {
		for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_44);
    
		}
	}

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
    } else if (hiveDistrib.isGoogleDataprocDistribution()) { // Connection through Dataproc api

    stringBuffer.append(TEXT_57);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String dbname = ElementParameterParser.getValue(node, "__DBNAME__");

    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
    boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
    if(setMemory) {
        String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
        String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
        String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_66);
    
    }

    List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
    if(advProps!=null) {
        for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_70);
    
        }
    }

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_CLUSTER_ID__"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_REGION__"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_PROJECT_ID__"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_JARS_BUCKET__"));
    stringBuffer.append(TEXT_83);
    
            if(ElementParameterParser.getBooleanValue(node, "__DEFINE_PATH_TO_GOOGLE_CREDENTIALS__")) {
        
    stringBuffer.append(TEXT_84);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PATH_TO_GOOGLE_CREDENTIALS__"));
    stringBuffer.append(TEXT_85);
    
            }
        
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
    if(isLog4jEnabled) {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
    }

    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_JARS_BUCKET__"));
    stringBuffer.append(TEXT_95);
    
    } else if (hiveDistrib.isQuboleDistribution()) { // Connection through Qubole api

    stringBuffer.append(TEXT_96);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String dbname = ElementParameterParser.getValue(node, "__DBNAME__");

String encryptedToken = ElementParameterParser.getEncryptedValue(node, "__QUBOLE_API_TOKEN__");
String quboleEndpoint = null;
if (ElementParameterParser.getBooleanValue(node, "__QUBOLE_ENDPOINT__")) {
	quboleEndpoint = ElementParameterParser.getValue(node, "__QUBOLE_ENDPOINT_URL__");
}

    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
    boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
    if(setMemory) {
        String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
        String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
        String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_105);
    
    }

    List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
    if(advProps!=null) {
        for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_109);
    
        }
    }

    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(encryptedToken);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
     if (quboleEndpoint != null) {
    stringBuffer.append(TEXT_122);
    stringBuffer.append(quboleEndpoint);
    stringBuffer.append(TEXT_123);
    } 
    stringBuffer.append(TEXT_124);
    
    if(isLog4jEnabled) {

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    
    }

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
    } else { // JDBC connection

    stringBuffer.append(TEXT_135);
    stringBuffer.append(TEXT_136);
    
	class DefaultConnectionUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected boolean isLog4jEnabled;
	    
	    public void beforeComponentProcess(INode node){
	    }
	    
		public void createURL(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
		
		public void classForName(INode node){

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
		}
		
		//for example, postgresql jdbc and redshift jdbc both can process the url : jdbc:postgresql://, 
		//we need to adjust the register order to make sure to use postgresql jdbc to process it
		public void adjustDriverRegisterOrderForConflcit() {
		
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");
			String shareDBClass = "SharedDBConnection";
			if(isLog4jEnabled){
				shareDBClass = "SharedDBConnectionLog4j";

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
			}

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(shareDBClass);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
		}
		
		public void createConnection(INode node) {

    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
		}
		
		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if(isLog4jEnabled){

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_160);
    
			}

    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_163);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    

	class ConnectionUtil extends DefaultConnectionUtil{
		private String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
		private org.talend.hadoop.distribution.component.HiveComponent hiveDistrib;
		private boolean isCustom;

		public ConnectionUtil(org.talend.hadoop.distribution.component.HiveComponent hiveDistrib) {
			this.hiveDistrib = hiveDistrib;
			this.isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
		}

		public void createConnection(INode node) {
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");

			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));

			boolean securityIsEnabled = useKrb && (isCustom || (this.hiveDistrib.doSupportKerberos() && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer))));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    
			} else {
				super.createConnection(node);
			}
		}

		public void createURL(INode node) {
			super.createURL(node);
			String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
			String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
			String fsDefalutName = "fs.default.name";
			String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");

			boolean setMapredJT = "true".equals(ElementParameterParser.getValue(node, "__SET_MAPRED_JT__"));
			boolean setNamenode = "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"));
			List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");

			boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));

			boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
			boolean securityIsEnabled = useKrb && (isCustom || (this.hiveDistrib.doSupportKerberos() && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer))));
			boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
			boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
			boolean securedEmbeddedHive2 = securedEmbedded && "HIVE2".equalsIgnoreCase(hiveServer);

			String hivePrincipal = ElementParameterParser.getValue(node, "__HIVE_PRINCIPAL__");
			boolean useSsl = "true".equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
			String sslTrustStore = ElementParameterParser.getValue(node, "__SSL_TRUST_STORE__");
			String sslStorepasswordFieldName = "__SSL_TRUST_STORE_PASSWORD__";

			boolean configureFromClassPath = "true".equals(ElementParameterParser.getValue(node, "__CONFIGURATIONS_FROM_CLASSPATH__"));
			boolean storeByHBase = "true".equals(ElementParameterParser.getValue(node, "__STORE_BY_HBASE__"));
		    
		    boolean useMapRTicket = ElementParameterParser.getBooleanValue(node, "__USE_MAPRTICKET__");
		    String mapRTicketUsername = ElementParameterParser.getValue(node, "__MAPRTICKET_USERNAME__");
		    String mapRTicketCluster = ElementParameterParser.getValue(node, "__MAPRTICKET_CLUSTER__");
		    String mapRTicketDuration = ElementParameterParser.getValue(node, "__MAPRTICKET_DURATION__");

		    boolean setMapRHomeDir = ElementParameterParser.getBooleanValue(node, "__SET_MAPR_HOME_DIR__");
		    String mapRHomeDir = ElementParameterParser.getValue(node, "__MAPR_HOME_DIR__");

		    boolean setMapRHadoopLogin = ElementParameterParser.getBooleanValue(node, "__SET_HADOOP_LOGIN__");
		    String mapRHadoopLogin = ElementParameterParser.getValue(node, "__HADOOP_LOGIN__");


			if(hiveServer!=null && !"".equals(hiveServer.trim()) && (this.isCustom || this.hiveDistrib.doSupportHive2())) {
				hiveServer = hiveServer.toLowerCase();
				if ("hive2".equals(hiveServer)) {
					javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
				}
			} else {
				hiveServer = "hive";
			}

            if(("hive".equals(hiveServer) && !hiveDistrib.doSupportHive1()) || ("hive2".equals(hiveServer) && !hiveDistrib.doSupportHive2())) {

    stringBuffer.append(TEXT_167);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_168);
    
            }

            if(("STANDALONE".equals(connectionMode) && !hiveDistrib.doSupportStandaloneMode()) || ("EMBEDDED".equals(connectionMode) && !hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_169);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_170);
    
            }

            if("STANDALONE".equals(connectionMode) && "hive".equals(hiveServer) && !hiveDistrib.doSupportHive1Standalone()) {

    stringBuffer.append(TEXT_171);
    
          }
          	// When configuraing from the classpath we do not set the variables using System.setProperty
          	// We set them directly on the Hadoop Configuration object
			if((hadoopProps.size() > 0) && (!configureFromClassPath)) {
        if(securityIsEnabled) {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
        }
        for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_174);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_176);
    
          if(securityIsEnabled) {

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_180);
    
          }
        }
        if(securityIsEnabled) {

    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
        }
			}

			if(securedEmbedded) {
				String metastoreUrl = ElementParameterParser.getValue(node, "__METASTORE_JDBC_URL__");
				String driverClass = ElementParameterParser.getValue(node, "__METASTORE_CLASSNAME__");
				String metastoreUsername = ElementParameterParser.getValue(node, "__METASTORE_USERNAME__");
				boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
				String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
				String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");

    stringBuffer.append(TEXT_183);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_184);
    if(securedEmbeddedHive2){
					// Disable authorization when using local HiveServer2 in secure mode
					
    stringBuffer.append(TEXT_185);
    
				}else{
					
    stringBuffer.append(TEXT_186);
    
				}
			
    stringBuffer.append(TEXT_187);
    stringBuffer.append(metastoreUrl);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(metastoreUsername);
    stringBuffer.append(TEXT_189);
    
        		String passwordFieldName = "__METASTORE_PASSWORD__";
        		
    stringBuffer.append(TEXT_190);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_193);
    } else {
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_196);
    }
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_199);
    
				if(securedEmbeddedHive2){
				
    stringBuffer.append(TEXT_200);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_PRINCIPAL__"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HIVESERVER2_LOCAL_KEYTAB__"));
    stringBuffer.append(TEXT_202);
    
				}
			
    
				if(useKeytab) {

    stringBuffer.append(TEXT_203);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_205);
    
				}
			}

			if(((this.isCustom && !useYarn) || (!this.isCustom && this.hiveDistrib.isHadoop1())) && setMapredJT && !configureFromClassPath) {
				String mapredJT = ElementParameterParser.getValue(node, "__MAPRED_JT__");

    stringBuffer.append(TEXT_206);
    stringBuffer.append(mapredJT);
    stringBuffer.append(TEXT_207);
    
			}

			if(setNamenode && !configureFromClassPath) {
				String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_208);
    stringBuffer.append(fsDefalutName);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_210);
    
			}

			boolean setHadoopUser = "true".equals(ElementParameterParser.getValue(node, "__SET_HADOOP_USER__"));
		    if (setHadoopUser) {
	            String hadoopUser = ElementParameterParser.getValue(node, "__HADOOP_USER__");
                
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    
            }
		    
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    

			// BEGIN IF01
			if("EMBEDDED".equals(connectionMode) && (this.isCustom || this.hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_219);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_223);
    
				if(this.isCustom || (!this.isCustom && this.hiveDistrib.doSupportImpersonation())) {
					String dbuser = ElementParameterParser.getValue(node, "__USER__");

    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    
				}

			// END IF01
			// BEGIN IF02
			} else if("STANDALONE".equals(connectionMode) && (this.isCustom || this.hiveDistrib.doSupportStandaloneMode())) {
				boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
				String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
				String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
				String additionalJdbcSettings = ElementParameterParser.getValue(node, "__HIVE_ADDITIONAL_JDBC__");
				// User the classpath to infer Kerberos parameters
				// BEGIN IF03
				if(configureFromClassPath){

    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    
					if(storeByHBase){

    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    
					}

					// Set advanced hadoop properties
					if(hadoopProps.size() > 0) {
						for(Map<String, String> item : hadoopProps){

    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_259);
    
						}
					}

					// log all loaded xxx-site.xml files and all of the key value pairs for debugging
					if(isLog4jEnabled){

    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    
					}

    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    
							if(this.hiveDistrib.doSupportSSLwithKerberos()){

    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    
							}else{

    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    
							}

    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    
				// END IF03
				// BEGIN IF04
				} else {
				// BEGIN IF 06
					if(securedStandaloneHive2) {
					    if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
				            
    stringBuffer.append(TEXT_278);
    stringBuffer.append(setMapRHomeDir ? mapRHomeDir : "\"/opt/mapr\"" );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(setMapRHadoopLogin ? mapRHadoopLogin : "\"kerberos\"");
    stringBuffer.append(TEXT_280);
    
				        }
						if(useKeytab) {

    stringBuffer.append(TEXT_281);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_283);
    
						}
						if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
                            
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_288);
    
                        }

						// Using SSL in Secure Mode
						if(useSsl && this.hiveDistrib.doSupportSSL()){

							// Does the distrib support SSL + KERBEROS
							if(this.hiveDistrib.doSupportSSLwithKerberos()){
								if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_291);
    
								}else{

    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_294);
    
								}

    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    
							// Does the distrib support only SASL-QOP + KERBEROS
							}else {
						

    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_310);
    
							}
						}else{

    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_317);
    
						}
					// END IF06
					// BEGIN IF07
					} else {
					    // Mapr ticket
					    
					    if ((isCustom || hiveDistrib.doSupportMapRTicket()) && useMapRTicket) {
				            String passwordFieldName = "__MAPRTICKET_PASSWORD__";
				            
    stringBuffer.append(TEXT_318);
    stringBuffer.append(setMapRHomeDir ? mapRHomeDir : "\"/opt/mapr\"" );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    
				            if (setMapRHadoopLogin) {
				                
    stringBuffer.append(TEXT_321);
    stringBuffer.append(mapRHadoopLogin);
    stringBuffer.append(TEXT_322);
    
				            } else {
				                
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    
				            }
	                        if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_327);
    } else {
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_330);
    }
                			if(hiveDistrib.doSupportMaprTicketV52API()){
                				
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(mapRTicketUsername);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_336);
    
                			} else {
                				
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(mapRTicketCluster);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(mapRTicketUsername);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(mapRTicketDuration);
    stringBuffer.append(TEXT_342);
    
                			}
				        }
						// Using SSL in non Secure Mode
						if(useSsl && this.hiveDistrib.doSupportSSL()){
							if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_345);
    
							}else{

    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append( ElementParameterParser.getValue(node, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_348);
    
							}

    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    
						}else{

    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_362);
    
						}
					// END IF07
					}
				// END IF04
				}

    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(additionalJdbcSettings);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    
			// END IF02
			}
		}

		public void setAutoCommit(INode node) {
			boolean useTransaction = false;//("true").equals(ElementParameterParser.getValue(node,"__IS_USE_AUTO_COMMIT__"));
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));
			if (useTransaction) {

    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_374);
    
			}
		}

		public String getDirverClassName(INode node){
			return javaDbDriver;
		}
	}//end class

	connUtil = new ConnectionUtil(hiveDistrib);

    //----------------------------component codes-----------------------------------------
    stringBuffer.append(TEXT_375);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    if(dbschema == null||dbschema.trim().length()==0) {
    	 dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
    }
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHARED_CONNECTION__"));

    
	connUtil.beforeComponentProcess(node);
	connUtil.createURL(node);

    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_378);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_379);
    if(dbpass != null && dbpass.trim().length() == 0) {
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    } else {
		String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_382);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_385);
    } else {
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_388);
    }
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    }
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_394);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_395);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_396);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_399);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_402);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_405);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_407);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_410);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_412);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_413);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_415);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_416);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_419);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_421);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	class DefaultLog4jCodeGenerateUtil extends DefaultLog4jFileUtil{

 		String connection = "";
 		boolean hasInit = false;
 		String dataAction ;
 		String dataOperationPrefix;
		String useBatchSize;
		String batchSize;
		String dbSchema;
 		boolean logCommitCounter = false;

		public DefaultLog4jCodeGenerateUtil(){
		}

		public DefaultLog4jCodeGenerateUtil(INode node) {
			super(node);
	    	init();
		}

	    public void beforeComponentProcess(INode node){
	    	this.node = node;
	    	init();
	    }

		private void init() {
			if(hasInit){
				return;
			}
 			this.cid = node.getUniqueName();
			this.isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			String useConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
			if(useConn == null || "".equals(useConn) || "true".equals(useConn)){
				connection = ElementParameterParser.getValue(node,"__CONNECTION__");
				if(!"".equals(connection)){
					connection = "'" + connection+"' ";
				}
			}
			//for output
			dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
			if(dataAction != null && !("").equals(dataAction)){
				logCommitCounter=true;
			}
			useBatchSize = ElementParameterParser.getValue(node, "__USE_BATCH_SIZE__");
			batchSize =ElementParameterParser.getValue(node, "__BATCH_SIZE__");
			hasInit = true;
		}

		public void debugDriverClassName() {
			logInfo(node,"debug",cid+" - Driver ClassName: \"+driverClass_"+cid+"+\".");
		}

		public void debugConnectionParams(INode node) {
			beforeComponentProcess(node);
			debugDriverClassName();
		}

		public void useExistConnection(INode node){
			beforeComponentProcess(node);
			if(isLog4jEnabled) {
			
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    if (cid.contains("tImpala") || cid.contains("tHive")) {
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_427);
    } else {
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    }
    stringBuffer.append(TEXT_432);
    
			}
		}

		public void connect(INode node){
			beforeComponentProcess(node);
			connect();
		}

		public void connect(){
			connect_begin();
			
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    
			connect_end();
		}

		public void connect_begin(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"' with the username '\" + dbUser_"+cid+" + \"'.");
		}

		public void connect_begin_noUser(){
			logInfo(node,"debug",cid+" - Connection attempt to '\" + url_"+cid+" + \"'.");
		}

		public void connect_end(){
			logInfo(node,"debug",cid+" - Connection to '\" + url_"+cid+" + \"' has succeeded.");
		}

		public void rollback(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection "+connection+"starting to rollback.");
			
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    
			logInfo(node,"debug",cid+" - Connection "+connection+"rollback has succeeded.");
		}

		public void commit(INode node){
			beforeComponentProcess(node);
			commit();
		}

		private void commit(){
			commit_begin();
			
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    
			commit_end();
		}

		private void commit_begin(){
			if(logCommitCounter){
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit \" + commitCounter_"+cid+"+ \" records.");
			}else{
				logInfo(node,"debug",cid+" - Connection "+connection+"starting to commit.");
			}
		}
		private void commit_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"commit has succeeded.");
		}

		public void close(INode node){
			beforeComponentProcess(node);
			close();
		}

		private void close(){
			close_begin();
			
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    
			close_end();
		}

		public void close_begin(){
			logInfo(node,"debug",cid+" - Closing the connection "+connection+"to the database.");
		}
		public void close_end(){
			logInfo(node,"debug",cid+" - Connection "+connection+"to the database closed.");
		}

		public void autoCommit(INode node,boolean autoCommit){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Connection is set auto commit to '"+autoCommit+"'.");
			
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(autoCommit);
    stringBuffer.append(TEXT_446);
    
		}

		public void query(INode node){
			beforeComponentProcess(node);
			//for input
	 		String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
			logInfo(node,"debug",cid+" - Executing the query: '\" + "+dbquery +" + \"'.");
		}

		public void retrieveRecordsCount(INode node){
			beforeComponentProcess(node);
			logInfo(node,"debug",cid+" - Retrieved records count: \"+nb_line_"+cid+" + \" .");
		}

		public void logError(INode node,String logLevel,String exception){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_447);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(exception);
    stringBuffer.append(TEXT_450);
    
			}
	    }

	    public void logError(INode node,String logLevel){
	    	logError(node,logLevel,"e");
	    }
	    
	    public void logInfo(INode node,String logLevel,String message){
	    	beforeComponentProcess(node);
	    	if(isLog4jEnabled){
	    	
    stringBuffer.append(TEXT_451);
    stringBuffer.append(logLevel);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_453);
    
			}
	    }
		/**
		*batchType :
		*			1: do not get return value of executeBatch();
		*			2: get return value of executeBatch();
		*
		*/
		public void executeBatch(INode node,int batchType){
			beforeComponentProcess(node);
			boolean logBatch = ("true").equals(useBatchSize) && !("").equals(batchSize) && !("0").equals(batchSize);
			if(logBatch){
				logInfo(node,"debug",cid+" - Executing the "+dataAction+" batch.");
			}
			if(batchType==1){
			
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    
			}else if(batchType==2){
				boolean isMysqlBatchInsert = false;
				if ((node.getUniqueName().contains("tMysqlOutput")||node.getUniqueName().contains("tAmazonMysqlOutput")) && ("INSERT").equals(dataAction)) {
					isMysqlBatchInsert = true;
				}
			
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(isMysqlBatchInsert? "1" : "countEach_"+cid );
    stringBuffer.append(TEXT_462);
    
			}
			if(logBatch){
				logInfo(node,"debug",cid+" - The "+dataAction+" batch execution has succeeded.");
			}
		}
	}

	DefaultLog4jCodeGenerateUtil log4jCodeGenerateUtil = new DefaultLog4jCodeGenerateUtil();

    
	connUtil.adjustDriverRegisterOrderForConflcit();
	
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_463);
    connUtil.useShareConnection(node);
    
	} else {
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){

    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    
		}

    stringBuffer.append(TEXT_467);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_468);
    
		log4jCodeGenerateUtil.debugConnectionParams(node);
		log4jCodeGenerateUtil.connect_begin();
		connUtil.createConnection(node);
		log4jCodeGenerateUtil.connect_end();
		
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    
		}
	}

    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_485);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_486);
    
	String storeByHBase = ElementParameterParser.getValue(node, "__STORE_BY_HBASE__");
	String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
	String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
	String zookeeperQuorumForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_QUORUM__");
	String zookeeperClientPortForHBase = ElementParameterParser.getValue(node, "__ZOOKEEPER_CLIENT_PORT__");
	boolean setZNodeParent = "true".equals(ElementParameterParser.getValue(node, "__SET_ZNODE_PARENT__"));
	String zNodeParent = ElementParameterParser.getValue(node, "__ZNODE_PARENT__");
	String hbaseMasterPrincipal = ElementParameterParser.getValue(node, "__HBASE_MASTER_PRINCIPAL__");
	String hbaseRegionServerPrincipal = ElementParameterParser.getValue(node, "__HBASE_REGIONSERVER_PRINCIPAL__");

	String defineRegisterJar = ElementParameterParser.getValue(node, "__DEFINE_REGISTER_JAR__");
	List<Map<String, String>> registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__REGISTER_JAR__");
	String hiveServer = ElementParameterParser.getValue(node, "__HIVE_SERVER__");

	boolean useYarn = "true".equals(ElementParameterParser.getValue(node, "__USE_YARN__"));
	boolean setResourceManager = "true".equals(ElementParameterParser.getValue(node, "__SET_RESOURCE_MANAGER__"));

	String yarnClasspathSeparator = ElementParameterParser.getValue(node, "__CLASSPATH_SEPARATOR__");

	boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
	boolean securityIsEnabled = useKrb && (isCustom || (hiveDistrib.doSupportKerberos() && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer))));
	boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
	boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
	boolean securedEmbeddedHive2 = securedEmbedded && "HIVE2".equalsIgnoreCase(hiveServer);

	boolean isKerberosAvailableHadoop2 = !isCustom && hiveDistrib.isHadoop2() && hiveDistrib.doSupportKerberos();
	boolean isHadoop2 = !isCustom && hiveDistrib.isHadoop2();
	boolean isKerberosAvailableHadoop1 = !isCustom && hiveDistrib.isHadoop1() && hiveDistrib.doSupportKerberos();
	boolean configureFromClassPath = "true".equals(ElementParameterParser.getValue(node, "__CONFIGURATIONS_FROM_CLASSPATH__"));


    stringBuffer.append(TEXT_487);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    
    if(!configureFromClassPath && !isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
        String mapMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_MAP_MEMORY_MB__");
        String reduceMemory = ElementParameterParser.getValue(node,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_495);
    
	}

	if(securedEmbedded) {
		String namenodePrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_498);
    
		if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
			String jobtrackerPrincipal = ElementParameterParser.getValue(node, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_501);
    
		}
		if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
			String resourceManagerPrincipal = ElementParameterParser.getValue(node, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_504);
    
		}

	}

	if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
		if(!configureFromClassPath && setResourceManager) {
			String resourceManager = ElementParameterParser.getValue(node, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_508);
    
		}

		boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_JOBHISTORY_ADDRESS__"));
		if(!configureFromClassPath && setJobHistoryAddress) {
			String jobHistoryAddress = ElementParameterParser.getValue(node,"__JOBHISTORY_ADDRESS__");
			
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_511);
    
		}

		if ("true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"))) {

    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    
		}

		boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(node, "__SET_SCHEDULER_ADDRESS__"));
		if(!configureFromClassPath && setSchedulerAddress) {
			String schedulerAddress = ElementParameterParser.getValue(node,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_516);
    
		}

		if(!configureFromClassPath && "true".equals(ElementParameterParser.getValue(node, "__SET_FS_DEFAULT_NAME__"))) {
			String namenode = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");

    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(namenode);
    stringBuffer.append(TEXT_519);
    
		}

		if("EMBEDDED".equals(connectionMode) && (isCustom || hiveDistrib.doSupportEmbeddedMode())) {
			boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
			if((isCustom && useYarn && crossPlatformSubmission) || (!isCustom && hiveDistrib.doSupportCrossPlatformSubmission())) {

    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    
			}

			if("MAPR410".equals(hiveVersion)){

    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    
			}
			if(hiveDistrib.doSupportCustomMRApplicationCP()){

    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(hiveDistrib.getCustomMRApplicationCP());
    stringBuffer.append(TEXT_527);
    
			}

    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(hiveDistrib.getYarnApplicationClasspath());
    stringBuffer.append(TEXT_530);
    
		}

		boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
		if(setMemory) {
			String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
			String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
			String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_537);
    
		}
	}

	List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
	if(advProps!=null) {
		for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_540);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_541);
    
		}
	}

    stringBuffer.append(TEXT_542);
    stringBuffer.append(TEXT_543);
    
class PrepareTez{
	public void invoke(INode node, String cid){
        String hiveDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

        org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
        try {
            hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(hiveDistribution, hiveVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

        boolean changePathSeparator = !hiveDistrib.isExecutedThroughWebHCat();

        String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
        boolean useTez = "tez".equals(ElementParameterParser.getValue(node, "__EXECUTION_ENGINE__"));
    	boolean supportTez = (isCustom || hiveDistrib.doSupportTezForHive()) && "EMBEDDED".equals(connectionMode);
    	if(supportTez && useTez){
    	
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    
            if(advProps != null){
                for(Map<String, String> item : advProps){
                    if("\"tez.lib.uris\"".equals(item.get("PROPERTY"))){
                    
    stringBuffer.append(TEXT_546);
      
                    }
                }
            }
            boolean installTez = "INSTALL".equals(ElementParameterParser.getValue(node, "__TEZ_LIB__"));
            if(installTez){
                //prepare the folder
                
    stringBuffer.append(TEXT_547);
    
class GetFileSystem{
	public void invoke(INode node, String cid){
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String fsDefaultNameKey = "fs.default.name";
        
        String distribution = null;
        String hadoopVersion = null;
        boolean isCustom = false;

        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    
        distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

        org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
        try {
            hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
        
        
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_558);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_564);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_568);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_569);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_571);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    
        }else{
        
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_587);
    
        }
    }
}

      
                (new GetFileSystem()).invoke(node, cid);
                String tezLibFolder = ElementParameterParser.getValue(node, "__TEZ_LIB_FOLDER__");
                boolean useDefaultTezLibFolder = "\"/tmp/{USERNAME}/talend_tez_libs/{custom|HIVE_VERSION}\"".equals(tezLibFolder);
                if(useDefaultTezLibFolder){
                
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_594);
    stringBuffer.append(isCustom?"custom":hiveVersion);
    stringBuffer.append(TEXT_595);
    
                }else{
                
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(tezLibFolder);
    stringBuffer.append(TEXT_598);
    
                }
                
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_601);
    
                List<String> tezLibJarsName = new java.util.ArrayList<String>();
                if(isCustom){
                    List<Map<String,String>> tezLibJarsNameValue = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__TEZ_LIB_NAME__");
                    for(Map<String, String> tezLibJarsNameV : tezLibJarsNameValue){
                        tezLibJarsName.add(tezLibJarsNameV.get("JAR_NAME"));
                    }
                }else{
                    String tezLibJarsNameValue = ElementParameterParser.getValue(node, "__TEZ_JARS_NAME__");
                    if(tezLibJarsNameValue != null && !"".equals(tezLibJarsNameValue)){
                        tezLibJarsName = java.util.Arrays.asList(tezLibJarsNameValue.split(","));
                    }
                }
                
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    if(changePathSeparator){
    stringBuffer.append(TEXT_604);
    }else{
    stringBuffer.append(TEXT_605);
    }
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    
                    for(String jarName : tezLibJarsName){
                    
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_611);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    
                    }
                    
    stringBuffer.append(TEXT_621);
    
            }else{
            
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TEZ_LIB_PATH__"));
    stringBuffer.append(TEXT_624);
    
            }
            //define the location of tez lib    
            
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__"));
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    
    	}
    }
}

    stringBuffer.append(TEXT_642);
    
	(new PrepareTez()).invoke(node, cid);
	
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    if("true".equalsIgnoreCase(storeByHBase) && (isCustom || hiveDistrib.doSupportHBaseForHive())) {
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    if(!configureFromClassPath && zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_650);
    }
    stringBuffer.append(TEXT_651);
    if(!configureFromClassPath && zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_654);
    }
    stringBuffer.append(TEXT_655);
    if(!configureFromClassPath && setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_658);
    }
    stringBuffer.append(TEXT_659);
    if(!configureFromClassPath && useKrb){
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_662);
    if(hbaseMasterPrincipal!=null && !"".equals(hbaseMasterPrincipal) && !"\"\"".equals(hbaseMasterPrincipal)){
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    stringBuffer.append(hbaseMasterPrincipal);
    stringBuffer.append(TEXT_665);
    }
    stringBuffer.append(TEXT_666);
    if(hbaseRegionServerPrincipal!=null && !"".equals(hbaseRegionServerPrincipal) && !"\"\"".equals(hbaseRegionServerPrincipal)){
    stringBuffer.append(TEXT_667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_668);
    stringBuffer.append(hbaseRegionServerPrincipal);
    stringBuffer.append(TEXT_669);
    }
    stringBuffer.append(TEXT_670);
    }
    stringBuffer.append(TEXT_671);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
			for(Map<String, String> jar : registerJarForHBase){
				String path = jar.get("JAR_PATH");
				if(path == null || "".equals(path) || "\"\"".equals(path)) {
					continue;
				}
		
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_674);
    
			}
		}
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_676);
    }
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_692);
    
	}

    return stringBuffer.toString();
  }
}
