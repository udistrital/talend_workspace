package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TFTPPutBeginJava
{
  protected static String nl;
  public static synchronized TFTPPutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPPutBeginJava result = new TFTPPutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "                if(log.is";
  protected final String TEXT_31 = "Enabled())";
  protected final String TEXT_32 = NL + "            log.";
  protected final String TEXT_33 = "(\"";
  protected final String TEXT_34 = " - \" ";
  protected final String TEXT_35 = " + (";
  protected final String TEXT_36 = ") ";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "            if (log.isDebugEnabled()) {" + NL + "                class BytesLimit65535_";
  protected final String TEXT_39 = "{" + NL + "                    public void limitLog4jByte() throws Exception{" + NL + "                    StringBuilder ";
  protected final String TEXT_40 = " = new StringBuilder();";
  protected final String TEXT_41 = NL + "                    ";
  protected final String TEXT_42 = ".append(\"Parameters:\");";
  protected final String TEXT_43 = NL + "                            ";
  protected final String TEXT_44 = ".append(\"";
  protected final String TEXT_45 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_46 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_47 = NL + "                            ";
  protected final String TEXT_48 = ".append(\"";
  protected final String TEXT_49 = "\" + \" = \" + ";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "                        ";
  protected final String TEXT_52 = ".append(\" | \");";
  protected final String TEXT_53 = NL + "                    } " + NL + "                } " + NL + "            new BytesLimit65535_";
  protected final String TEXT_54 = "().limitLog4jByte();" + NL + "            }";
  protected final String TEXT_55 = NL + "            StringBuilder ";
  protected final String TEXT_56 = " = new StringBuilder();    ";
  protected final String TEXT_57 = NL + "                    ";
  protected final String TEXT_58 = ".append(";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "                    if(";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = " == null){";
  protected final String TEXT_64 = NL + "                        ";
  protected final String TEXT_65 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_66 = NL + "                        ";
  protected final String TEXT_67 = ".append(";
  protected final String TEXT_68 = ".";
  protected final String TEXT_69 = ");" + NL + "                    }   ";
  protected final String TEXT_70 = NL + "                ";
  protected final String TEXT_71 = ".append(\"|\");";
  protected final String TEXT_72 = NL + "  java.util.Properties props_";
  protected final String TEXT_73 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_74 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_75 = ");" + NL + "  props_";
  protected final String TEXT_76 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_77 = ");" + NL + "  props_";
  protected final String TEXT_78 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_79 = ");" + NL + "  ";
  protected final String TEXT_80 = " " + NL + "  String decryptedProxyPassword_";
  protected final String TEXT_81 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "  String decryptedProxyPassword_";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = "; ";
  protected final String TEXT_86 = NL + NL + "  props_";
  protected final String TEXT_87 = ".put(\"java.net.socks.password\",decryptedProxyPassword_";
  protected final String TEXT_88 = ");        ";
  protected final String TEXT_89 = NL + "int nb_file_";
  protected final String TEXT_90 = " = 0;" + NL;
  protected final String TEXT_91 = "// *** sftp *** //" + NL + "" + NL + "\tclass MyProgressMonitor_";
  protected final String TEXT_92 = " implements com.jcraft.jsch.SftpProgressMonitor {" + NL + "\t\tpublic void init(int op, String src, String dest, long max) {}" + NL + "    \tpublic boolean count(long count) { return true;}" + NL + "    \tpublic void end() {}" + NL + "  \t}" + NL + "" + NL + "\t";
  protected final String TEXT_93 = NL + "    \tcom.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_94 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_95 = "\");" + NL + "\t\t";
  protected final String TEXT_96 = NL + "\t\t\tif(c_";
  protected final String TEXT_97 = "!=null && c_";
  protected final String TEXT_98 = ".getSession()!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_99 = " - Uses an existing connection. Connection username \" + c_";
  protected final String TEXT_100 = ".getSession().getUserName() + \", Connection hostname: \" + c_";
  protected final String TEXT_101 = ".getSession().getHost() + \", Connection port: \" + c_";
  protected final String TEXT_102 = ".getSession().getPort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_103 = NL + "    \tif(c_";
  protected final String TEXT_104 = ".getHome()!=null && !c_";
  protected final String TEXT_105 = ".getHome().equals(c_";
  protected final String TEXT_106 = ".pwd())){" + NL + "  \t\t\tc_";
  protected final String TEXT_107 = ".cd(c_";
  protected final String TEXT_108 = ".getHome());" + NL + "  \t\t}" + NL + "\t";
  protected final String TEXT_109 = "    " + NL + "\t\tclass MyUserInfo_";
  protected final String TEXT_110 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "\t\t" + NL + "     \t   ";
  protected final String TEXT_111 = " " + NL + "          \t\tString decryptedPassphrase_";
  protected final String TEXT_112 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "          \t\tString decryptedPassphrase_";
  protected final String TEXT_115 = " = ";
  protected final String TEXT_116 = "; ";
  protected final String TEXT_117 = NL + "\t\t" + NL + "\t\t\tString passphrase_";
  protected final String TEXT_118 = " = decryptedPassphrase_";
  protected final String TEXT_119 = ";" + NL + "\t\t\tpublic String getPassphrase() { return passphrase_";
  protected final String TEXT_120 = "; }" + NL + "\t\t\tpublic String getPassword() { return null; } " + NL + "\t\t\tpublic boolean promptPassword(String arg0) { return true; } " + NL + "\t\t\tpublic boolean promptPassphrase(String arg0) { return true; } " + NL + "\t\t\tpublic boolean promptYesNo(String arg0) { return true; } " + NL + "      \t\tpublic void showMessage(String arg0) { } " + NL + "      " + NL + "\t\t\tpublic String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "        \tboolean[] echo) {" + NL + "        \t" + NL + "        \t";
  protected final String TEXT_121 = " " + NL + "        \t" + NL + "        \t";
  protected final String TEXT_122 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_123 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_124 = ");";
  protected final String TEXT_125 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_126 = " = ";
  protected final String TEXT_127 = "; ";
  protected final String TEXT_128 = NL + "        \t" + NL + "        \t\tString[] password_";
  protected final String TEXT_129 = " = {decryptedPassword_";
  protected final String TEXT_130 = "};" + NL + "        \t\treturn password_";
  protected final String TEXT_131 = ";" + NL + "      \t\t}" + NL + "\t\t};" + NL + "\t\tfinal com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_132 = " = new MyUserInfo_";
  protected final String TEXT_133 = "();" + NL + "\t\tcom.jcraft.jsch.JSch jsch_";
  protected final String TEXT_134 = "=new com.jcraft.jsch.JSch(); " + NL + "" + NL + "\t\t";
  protected final String TEXT_135 = NL + "\t\t\t";
  protected final String TEXT_136 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_137 = " - SFTP authentication using a public key.\");" + NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_138 = " - Private key: '\" + ";
  protected final String TEXT_139 = " + \"'.\");" + NL + "\t \t\t ";
  protected final String TEXT_140 = NL + "      \t\tjsch_";
  protected final String TEXT_141 = ".addIdentity(";
  protected final String TEXT_142 = ", defaultUserInfo_";
  protected final String TEXT_143 = ".getPassphrase());" + NL + "\t\t";
  protected final String TEXT_144 = NL + "\t\t" + NL + "\t\tcom.jcraft.jsch.Session session_";
  protected final String TEXT_145 = "=jsch_";
  protected final String TEXT_146 = ".getSession(";
  protected final String TEXT_147 = ", ";
  protected final String TEXT_148 = ", ";
  protected final String TEXT_149 = ");" + NL + "\t\tsession_";
  protected final String TEXT_150 = ".setConfig(\"PreferredAuthentications\", \"publickey,password,keyboard-interactive,gssapi-with-mic\");" + NL + "" + NL + "\t\t";
  protected final String TEXT_151 = NL + "\t\t\t";
  protected final String TEXT_152 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_153 = " - SFTP authentication using a password.\");" + NL + "\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t" + NL + "        \t";
  protected final String TEXT_155 = " " + NL + "        \t" + NL + "        \t";
  protected final String TEXT_156 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_157 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_158 = ");";
  protected final String TEXT_159 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_160 = " = ";
  protected final String TEXT_161 = "; ";
  protected final String TEXT_162 = NL + "        \t" + NL + "\t\t\tsession_";
  protected final String TEXT_163 = ".setPassword(decryptedPassword_";
  protected final String TEXT_164 = "); " + NL + "\t\t";
  protected final String TEXT_165 = NL + "\t\tsession_";
  protected final String TEXT_166 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_167 = "); " + NL + "\t\t";
  protected final String TEXT_168 = NL + "\t\tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "\t\t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_169 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "\t\t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "\t\t\t\tproxy_";
  protected final String TEXT_170 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t\t}" + NL + "\t\t\tsession_";
  protected final String TEXT_171 = ".setProxy(proxy_";
  protected final String TEXT_172 = ");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_173 = NL + "\t\t";
  protected final String TEXT_174 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_175 = " - Attempt to connect to '\" + ";
  protected final String TEXT_176 = " + \"' with username '\" + ";
  protected final String TEXT_177 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_178 = NL + "    \tsession_";
  protected final String TEXT_179 = ".connect();" + NL + "    \tcom.jcraft.jsch. Channel channel_";
  protected final String TEXT_180 = "=session_";
  protected final String TEXT_181 = ".openChannel(\"sftp\");" + NL + "    \tchannel_";
  protected final String TEXT_182 = ".connect();" + NL + "\t\t";
  protected final String TEXT_183 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_184 = " - Connect to '\" + ";
  protected final String TEXT_185 = " + \" has succeeded.\" );" + NL + "\t\t";
  protected final String TEXT_186 = NL + "\t\tcom.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_187 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_188 = ";" + NL + "" + NL + "\t\t";
  protected final String TEXT_189 = NL + "\t\t\tc_";
  protected final String TEXT_190 = ".setFilenameEncoding(";
  protected final String TEXT_191 = ");" + NL + "\t\t";
  protected final String TEXT_192 = NL + "\t\t" + NL + "\t";
  protected final String TEXT_193 = NL;
  protected final String TEXT_194 = NL + "\t\tString rootDir_";
  protected final String TEXT_195 = " = c_";
  protected final String TEXT_196 = ".pwd();" + NL + "\t\tString remotedir_";
  protected final String TEXT_197 = " = (";
  protected final String TEXT_198 = ").replaceAll(\"\\\\\\\\\", \"/\");" + NL + "\t\tString[] dirsTree_";
  protected final String TEXT_199 = " = remotedir_";
  protected final String TEXT_200 = ".split(\"/\");" + NL + "\t\tfor (String dir: dirsTree_";
  protected final String TEXT_201 = ") {" + NL + "\t\t\tif (dir.isEmpty()) continue;" + NL + "" + NL + "\t\t\ttry {" + NL + "\t\t\t\tc_";
  protected final String TEXT_202 = ".cd(dir);" + NL + "\t\t\t} catch (com.jcraft.jsch.SftpException ignored) {";
  protected final String TEXT_203 = NL + "\t\t\t\t\tlog.debug(\"Can't find directory \" + dir + \". Component will create it\");";
  protected final String TEXT_204 = NL + "\t\t\t\tc_";
  protected final String TEXT_205 = ".mkdir(dir);" + NL + "\t\t\t\tc_";
  protected final String TEXT_206 = ".cd(dir);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t//back to the root" + NL + "\t\tc_";
  protected final String TEXT_207 = ".cd(rootDir_";
  protected final String TEXT_208 = ");" + NL;
  protected final String TEXT_209 = NL + "\t// because there is not the same method in JSch class as FTPClient class, define a list here" + NL + "\tjava.util.List<String> msg_";
  protected final String TEXT_210 = " = new java.util.ArrayList<String>();" + NL + "\tcom.jcraft.jsch.SftpProgressMonitor monitor";
  protected final String TEXT_211 = " = new MyProgressMonitor_";
  protected final String TEXT_212 = "();" + NL + "\tjava.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_213 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "  ";
  protected final String TEXT_214 = NL + "\t\t\tjava.util.Map<String,String> map";
  protected final String TEXT_215 = " = new java.util.HashMap<String,String>();" + NL + "\t\t    map";
  protected final String TEXT_216 = ".put(";
  protected final String TEXT_217 = ", ";
  protected final String TEXT_218 = ");    " + NL + "\t\t    list";
  protected final String TEXT_219 = ".add(map";
  protected final String TEXT_220 = ");       ";
  protected final String TEXT_221 = "  " + NL + "\tString localdir";
  protected final String TEXT_222 = " = ";
  protected final String TEXT_223 = ";" + NL + "\t";
  protected final String TEXT_224 = NL + "\t\tlog.info(\"";
  protected final String TEXT_225 = " - Putting file to the server.\");" + NL + "\t";
  protected final String TEXT_226 = NL + "\t" + NL + "\tclass StatCheck_";
  protected final String TEXT_227 = " {" + NL + "\t\t\t" + NL + "\t\t\tboolean statOK(com.jcraft.jsch.ChannelSftp client, String path) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\treturn client.stat(path).getAtimeString() != null;" + NL + "\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_228 = NL + "\t\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_229 = " - Directory or file permission denied for checking the status of the path : \" + path);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t}" + NL + "\t" + NL + "\tStatCheck_";
  protected final String TEXT_231 = " sc_";
  protected final String TEXT_232 = " = new StatCheck_";
  protected final String TEXT_233 = "();" + NL + "\t" + NL + "\tfor (java.util.Map<String, String> map";
  protected final String TEXT_234 = " : list";
  protected final String TEXT_235 = ") {" + NL;
  protected final String TEXT_236 = " // *** ftp *** //" + NL + "\t\tcom.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_237 = " =null;" + NL;
  protected final String TEXT_238 = NL + "\t\t\tftp_";
  protected final String TEXT_239 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_240 = "\");" + NL + "" + NL + "\t\t\tString rootDir_";
  protected final String TEXT_241 = " = ftp_";
  protected final String TEXT_242 = ".pwd();" + NL + "\t\t\t";
  protected final String TEXT_243 = NL + "\t\t\t\tif(ftp_";
  protected final String TEXT_244 = "!=null) {" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_245 = " - Uses an existing connection. Connection hostname: \" + ftp_";
  protected final String TEXT_246 = ".getRemoteHost() + \", Connection port: \" + ftp_";
  protected final String TEXT_247 = ".getRemotePort() + \".\"); " + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_248 = NL + "  \t\t";
  protected final String TEXT_249 = NL + "   \t\t\tftp_";
  protected final String TEXT_250 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "\t\t\tftp_";
  protected final String TEXT_251 = ".setRemoteHost(";
  protected final String TEXT_252 = ");" + NL + "\t\t\tftp_";
  protected final String TEXT_253 = ".setRemotePort(";
  protected final String TEXT_254 = ");" + NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_255 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_256 = " - \" + ";
  protected final String TEXT_257 = ");" + NL + "\t\t\t";
  protected final String TEXT_258 = NL + NL + "\t\t    ";
  protected final String TEXT_259 = NL + "\t\t\t\tftp_";
  protected final String TEXT_260 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);" + NL + "\t\t    ";
  protected final String TEXT_261 = NL + "\t\t\t\tftp_";
  protected final String TEXT_262 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);" + NL + "\t\t    ";
  protected final String TEXT_263 = NL + "    \t\tftp_";
  protected final String TEXT_264 = ".setControlEncoding(";
  protected final String TEXT_265 = ");" + NL + "\t\t\t";
  protected final String TEXT_266 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_267 = " - Attempt to connect to '\" + ";
  protected final String TEXT_268 = " + \"' with username '\" +";
  protected final String TEXT_269 = "+ \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_270 = NL + "\t\t    ftp_";
  protected final String TEXT_271 = ".connect();  " + NL + "\t\t    " + NL + "        \t";
  protected final String TEXT_272 = " " + NL + "        \t" + NL + "        \t";
  protected final String TEXT_273 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_274 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_275 = ");";
  protected final String TEXT_276 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_277 = " = ";
  protected final String TEXT_278 = "; ";
  protected final String TEXT_279 = NL + "\t\t    " + NL + "\t\t    ftp_";
  protected final String TEXT_280 = ".login(";
  protected final String TEXT_281 = ", decryptedPassword_";
  protected final String TEXT_282 = ");" + NL + "\t\t\t";
  protected final String TEXT_283 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_284 = " - Connect to '\" + ";
  protected final String TEXT_285 = " +  \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_286 = " " + NL + "\t\t";
  protected final String TEXT_287 = "  " + NL + "" + NL + "\t\t// msg_";
  protected final String TEXT_288 = " likes a String[] to save the message from transfer.  " + NL + "\t\tcom.enterprisedt.net.ftp.TransferCompleteStrings msg_";
  protected final String TEXT_289 = " = ftp_";
  protected final String TEXT_290 = ".getTransferCompleteMessages();" + NL + "\t\tmsg_";
  protected final String TEXT_291 = ".clearAll();" + NL + "\t\tjava.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_292 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL;
  protected final String TEXT_293 = "    " + NL + "\t\t\tjava.util.Map<String,String> map";
  protected final String TEXT_294 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\tmap";
  protected final String TEXT_295 = ".put(";
  protected final String TEXT_296 = ",";
  protected final String TEXT_297 = ");  " + NL + "\t\t\tlist";
  protected final String TEXT_298 = ".add(map";
  protected final String TEXT_299 = ");";
  protected final String TEXT_300 = "  " + NL + "\t\tString remotedir";
  protected final String TEXT_301 = " = (";
  protected final String TEXT_302 = ").replaceAll(\"\\\\\\\\\", \"/\");";
  protected final String TEXT_303 = NL + "\t\t\tboolean isDirectoryExist_";
  protected final String TEXT_304 = " = ftp_";
  protected final String TEXT_305 = ".existsDirectory(remotedir";
  protected final String TEXT_306 = ");" + NL + "" + NL + "\t\t\tif (!isDirectoryExist_";
  protected final String TEXT_307 = ") {" + NL + "\t\t\t\tString rootDir = null;" + NL + "\t\t\t\tString[] dirsTree_";
  protected final String TEXT_308 = " = remotedir";
  protected final String TEXT_309 = ".split(\"/\");" + NL + "\t\t\t\tfor (String dir: dirsTree_";
  protected final String TEXT_310 = ") {" + NL + "\t\t\t\t\tif (!ftp_";
  protected final String TEXT_311 = ".existsDirectory(dir)) {" + NL + "\t\t\t\t\t\tftp_";
  protected final String TEXT_312 = ".mkdir(dir);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tftp_";
  protected final String TEXT_313 = ".chdir(dir);" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tftp_";
  protected final String TEXT_314 = ".chdir(rootDir_";
  protected final String TEXT_315 = ");" + NL + "\t\t\t}";
  protected final String TEXT_316 = NL + "\t\tftp_";
  protected final String TEXT_317 = ".chdir(remotedir";
  protected final String TEXT_318 = ");" + NL + "" + NL + "\t\t";
  protected final String TEXT_319 = "  " + NL + "\t\t\tftp_";
  protected final String TEXT_320 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.BINARY);" + NL + "\t\t";
  protected final String TEXT_321 = "  " + NL + "\t\t\tftp_";
  protected final String TEXT_322 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.ASCII);" + NL + "\t\t";
  protected final String TEXT_323 = NL + "\t\tString localdir";
  protected final String TEXT_324 = "  = ";
  protected final String TEXT_325 = ";" + NL + "" + NL + "\t\t";
  protected final String TEXT_326 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_327 = " - Uploading files to the server.\");" + NL + "\t\t";
  protected final String TEXT_328 = NL + "\t\tfor (java.util.Map<String, String> map";
  protected final String TEXT_329 = " : list";
  protected final String TEXT_330 = ") {";
  protected final String TEXT_331 = NL + "\t\torg.apache.commons.net.ftp.FTPSClient ftp_";
  protected final String TEXT_332 = " = null;" + NL + "\t\tString rootDir_";
  protected final String TEXT_333 = " = null;";
  protected final String TEXT_334 = NL + "\t\t\t";
  protected final String TEXT_335 = NL + "\t\t\t";
  protected final String TEXT_336 = NL + NL + "\tclass MyTrust_";
  protected final String TEXT_337 = " {" + NL + "" + NL + "\t\tprivate javax.net.ssl.TrustManager[] getTrustManagers() " + NL + "\t\tthrows java.security.KeyStoreException, java.security.NoSuchAlgorithmException, " + NL + "\t\t\tjava.security.cert.CertificateException, java.security.UnrecoverableKeyException," + NL + "\t\t\tjava.io.IOException {" + NL + "\t\t\tjava.security.KeyStore ks = java.security.KeyStore.getInstance(\"JKS\");" + NL;
  protected final String TEXT_338 = " " + NL + "\t\t\t\tString decryptedKeyStorePassword_";
  protected final String TEXT_339 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_340 = ");";
  protected final String TEXT_341 = NL + "\t\t\t\tString decryptedKeyStorePassword_";
  protected final String TEXT_342 = " = ";
  protected final String TEXT_343 = "; ";
  protected final String TEXT_344 = NL + "\t\t\tks.load(new java.io.FileInputStream(";
  protected final String TEXT_345 = "), decryptedKeyStorePassword_";
  protected final String TEXT_346 = ".toCharArray());" + NL + "\t\t\tjavax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm());" + NL + "\t\t\ttmf.init(ks);" + NL + "\t\t\treturn tmf.getTrustManagers();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t\tclass SSLSessionReuseFTPSClient_";
  protected final String TEXT_347 = " extends org.apache.commons.net.ftp.FTPSClient {" + NL + "" + NL + "\t\tpublic SSLSessionReuseFTPSClient_";
  protected final String TEXT_348 = "(boolean isImplicit, javax.net.ssl.SSLContext context) {" + NL + "\t\t\tsuper(isImplicit, context);" + NL + "\t\t}" + NL + "" + NL + "\t\t// changed to support TLS session resumption" + NL + "\t\t@Override" + NL + "\t\tprotected void _prepareDataSocket_(final java.net.Socket socket) throws IOException {" + NL + "\t\t\tif(socket instanceof javax.net.ssl.SSLSocket) {" + NL + "\t\t\t\tfinal javax.net.ssl.SSLSession session = ((javax.net.ssl.SSLSocket) _socket_).getSession();" + NL + "\t\t\t\tfinal javax.net.ssl.SSLSessionContext context = session.getSessionContext();" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tfinal java.lang.reflect.Field sessionHostPortCache = context.getClass().getDeclaredField(\"sessionHostPortCache\");" + NL + "\t\t\t\t\tsessionHostPortCache.setAccessible(true);" + NL + "\t\t\t\t\tfinal Object cache = sessionHostPortCache.get(context);" + NL + "\t\t\t\t\tfinal java.lang.reflect.Method putMethod = cache.getClass().getDeclaredMethod(\"put\", Object.class, Object.class);" + NL + "\t\t\t\t\tputMethod.setAccessible(true);" + NL + "\t\t\t\t\tfinal java.lang.reflect.Method getHostMethod = socket.getClass().getDeclaredMethod(\"getHost\");" + NL + "\t\t\t\t\tgetHostMethod.setAccessible(true);" + NL + "\t\t\t\t\tObject host = getHostMethod.invoke(socket);" + NL + "\t\t\t\t\tfinal String key = String.format(\"%s:%s\", host, String.valueOf(socket.getPort())).toLowerCase(java.util.Locale.ROOT);" + NL + "\t\t\t\t\tputMethod.invoke(cache, key, session);" + NL + "\t\t\t\t} catch(Exception e) {";
  protected final String TEXT_349 = NL + "\t\t\t\t\t\tlog.error(\"Can't adapt ftps client to support TLS session resumption\");";
  protected final String TEXT_350 = NL + "\t\t\t\t\tthrow new RuntimeException(e);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t\t\tjavax.net.ssl.SSLContext sslContext_";
  protected final String TEXT_351 = " = null;" + NL + "\t\t\tjavax.net.ssl.TrustManager[] trustManager_";
  protected final String TEXT_352 = " = null;" + NL + "\t\t\tjavax.net.ssl.SSLSocketFactory sslSocketFactory_";
  protected final String TEXT_353 = " = null;" + NL + "" + NL + "\t\t\tMyTrust_";
  protected final String TEXT_354 = " myTrust_";
  protected final String TEXT_355 = " = null;" + NL + "" + NL + "\t\t\ttry {" + NL + "\t\t\t\tsslContext_";
  protected final String TEXT_356 = " = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "\t\t\t\tmyTrust_";
  protected final String TEXT_357 = " = new MyTrust_";
  protected final String TEXT_358 = "();" + NL + "\t\t\t\ttrustManager_";
  protected final String TEXT_359 = " = myTrust_";
  protected final String TEXT_360 = ".getTrustManagers();" + NL + "\t\t\t\tsslContext_";
  protected final String TEXT_361 = ".init(null, trustManager_";
  protected final String TEXT_362 = ", new java.security.SecureRandom());" + NL + "\t\t\t\tsslSocketFactory_";
  protected final String TEXT_363 = " = sslContext_";
  protected final String TEXT_364 = ".getSocketFactory();" + NL + "\t\t\t\tftp_";
  protected final String TEXT_365 = " = new SSLSessionReuseFTPSClient_";
  protected final String TEXT_366 = "(";
  protected final String TEXT_367 = ", sslContext_";
  protected final String TEXT_368 = ");" + NL + "\t\t\t\tftp_";
  protected final String TEXT_369 = ".setControlEncoding(";
  protected final String TEXT_370 = ");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_371 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_372 = " -FTPS security Mode is ";
  protected final String TEXT_373 = ".\");" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_374 = " - Attempt to connect to '\" + ";
  protected final String TEXT_375 = " + \"' with username '\" + ";
  protected final String TEXT_376 = "+ \"'.\");" + NL + "\t\t\t\t";
  protected final String TEXT_377 = NL + "\t\t\t\tftp_";
  protected final String TEXT_378 = ".connect(";
  protected final String TEXT_379 = ",";
  protected final String TEXT_380 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_381 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_382 = " - Connect to '\" + ";
  protected final String TEXT_383 = " + \"' has succeeded.\");" + NL + "\t\t\t\t";
  protected final String TEXT_384 = NL;
  protected final String TEXT_385 = NL + NL + "\t\t\t\t";
  protected final String TEXT_386 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_387 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_388 = ");";
  protected final String TEXT_389 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_390 = " = ";
  protected final String TEXT_391 = "; ";
  protected final String TEXT_392 = NL + NL + "\t\t\t\tboolean isLoginSuccessful_";
  protected final String TEXT_393 = " = ftp_";
  protected final String TEXT_394 = ".login(";
  protected final String TEXT_395 = ", decryptedPassword_";
  protected final String TEXT_396 = ");" + NL + "" + NL + "\t\t\t\tif (!isLoginSuccessful_";
  protected final String TEXT_397 = ") {" + NL + "\t\t\t\t\tthrow new RuntimeException(\"Login failed\");" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tftp_";
  protected final String TEXT_398 = ".setFileType(org.apache.commons.net.ftp.FTP.BINARY_FILE_TYPE);" + NL + "\t\t\t\tftp_";
  protected final String TEXT_399 = ".execPROT(";
  protected final String TEXT_400 = ");" + NL + "\t\t\t\tftp_";
  protected final String TEXT_401 = ".execPBSZ(";
  protected final String TEXT_402 = ");" + NL + "\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t";
  protected final String TEXT_403 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_404 = " - Can't create connection: \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_405 = NL + "\t\t\t\t\tthrow e;";
  protected final String TEXT_406 = NL + "\t\t\t\t\te.printStackTrace();";
  protected final String TEXT_407 = NL + "\t\t\t}";
  protected final String TEXT_408 = NL + "\t\t\t\tftp_";
  protected final String TEXT_409 = ".enterLocalPassiveMode();";
  protected final String TEXT_410 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_411 = " - Using the passive mode.\");";
  protected final String TEXT_412 = NL + "\t\t\tftp_";
  protected final String TEXT_413 = " = (org.apache.commons.net.ftp.FTPSClient)globalMap.get(\"";
  protected final String TEXT_414 = "\");" + NL + "\t\t\t";
  protected final String TEXT_415 = NL + "\t\t\t\tif(ftp_";
  protected final String TEXT_416 = "!=null) {" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_417 = " - Uses an existing connection. Connection hostname: \" +  ftp_";
  protected final String TEXT_418 = ".getRemoteAddress().toString() + \", Connection port: \" + ftp_";
  protected final String TEXT_419 = ".getRemotePort() + \".\"); " + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_420 = NL + "\t\t\t" + NL + "\t\t\trootDir_";
  protected final String TEXT_421 = " = ftp_";
  protected final String TEXT_422 = ".printWorkingDirectory();";
  protected final String TEXT_423 = NL + "\t\tString remotedir_";
  protected final String TEXT_424 = " = (";
  protected final String TEXT_425 = ").replaceAll(\"\\\\\\\\\", \"/\");" + NL;
  protected final String TEXT_426 = NL + "\t\t\tString[] dirsTree_";
  protected final String TEXT_427 = " = remotedir_";
  protected final String TEXT_428 = ".split(\"/\");" + NL + "\t\t\tfor (String dir: dirsTree_";
  protected final String TEXT_429 = ") {" + NL + "\t\t\t\tftp_";
  protected final String TEXT_430 = ".makeDirectory(dir);" + NL + "\t\t\t\tftp_";
  protected final String TEXT_431 = ".changeWorkingDirectory(dir);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tftp_";
  protected final String TEXT_432 = ".changeWorkingDirectory(rootDir_";
  protected final String TEXT_433 = ");";
  protected final String TEXT_434 = NL + "\t\tboolean cwdSuccess_";
  protected final String TEXT_435 = " = ftp_";
  protected final String TEXT_436 = ".changeWorkingDirectory(remotedir_";
  protected final String TEXT_437 = ");" + NL + "" + NL + "\t\tif (!cwdSuccess_";
  protected final String TEXT_438 = ") {" + NL + "\t\t\tthrow new RuntimeException(\"Failed to change remote directory. \" + ftp_";
  protected final String TEXT_439 = ".getReplyString());" + NL + "\t\t}" + NL + "" + NL + "\t\tjava.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_440 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL;
  protected final String TEXT_441 = NL + "\t\t\tjava.util.Map<String,String> map";
  protected final String TEXT_442 = " = new java.util.HashMap<String,String>();" + NL + "\t\t\tmap";
  protected final String TEXT_443 = ".put(";
  protected final String TEXT_444 = ", ";
  protected final String TEXT_445 = ");" + NL + "\t\t\tlist";
  protected final String TEXT_446 = ".add(map";
  protected final String TEXT_447 = ");";
  protected final String TEXT_448 = NL + "\t\tString localdir";
  protected final String TEXT_449 = " = ";
  protected final String TEXT_450 = ";" + NL + "\t\t";
  protected final String TEXT_451 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_452 = " - Uploading files to the server.\");" + NL + "\t\t";
  protected final String TEXT_453 = NL + "\t\tfor (java.util.Map<String, String> map";
  protected final String TEXT_454 = " : list";
  protected final String TEXT_455 = ") {";
  protected final String TEXT_456 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_29);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$") || cidx.matches("^.*?tDBOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_30);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_31);
    
            }
            
    stringBuffer.append(TEXT_32);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_34);
    for(String message : messages){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        debug(str("Start to work."));
    }
    
    public void endWork(){
        debug(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
    
    
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_42);
    
                    java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
                    ignoredParamsTypes.addAll(
                        java.util.Arrays.asList(
                            org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                            org.talend.core.model.process.EParameterFieldType.LABEL,
                            org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                            org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                            org.talend.core.model.process.EParameterFieldType.IMAGE,
                            org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                            org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                            org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                            org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                            org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                            org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                            org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                            org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                            org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                            org.talend.core.model.process.EParameterFieldType.VERSION,
                            org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                            org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                            org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                            org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                            org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                            org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                            org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                            org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                            )
                    );
                    for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                        if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                            continue;
                        }
                        String name = ep.getName();
                        if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                            String epName = "__" + name + "__";
                            String password = "";
                            if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                                password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                            }else{
                                String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                                if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                                    passwordValue = "\"\"";
                                } 
                                password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                            } 
                            
    stringBuffer.append(TEXT_43);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_46);
    
                        }else{
                            String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                            if(value.length()>10000){
                            value = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(value);
                            }
                            
    stringBuffer.append(TEXT_47);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_50);
    
                        }   
                        
    stringBuffer.append(TEXT_51);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_52);
    
                    }
                    debug(var("log4jParamters")); 
                    
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
        } 
        
    
    } 
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_55);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_56);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_57);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_60);
    
                }else{
                
    stringBuffer.append(TEXT_61);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_69);
    
                }
                
    stringBuffer.append(TEXT_70);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_71);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
LogUtil commonLog = new LogUtil(node);
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String ftpsPort = ElementParameterParser.getValue(node, "__FTPS_PORT__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");

boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
boolean use_encoding = "true".equals(ElementParameterParser.getValue(node, "__USE_ENCODING__"));

String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");  
String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");

List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");  
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");

String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean createDirIfNotExist = ("true").equals(ElementParameterParser.getValue(node, "__CREATE_DIR_IF_NOT_EXIST__"));
boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
boolean sftp = false;
boolean ftps = false; 

String protectionLevel = ElementParameterParser.getValue(node, "__FTPS_PROT__");
String protectionBufferSize = ElementParameterParser.getValue(node, "__FTPS_PROTECTION_BUFF_SIZE__");

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String passwordFieldName = "";

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

//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.
if (useProxy) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_79);
    
passwordFieldName = "__PROXY_PASSWORD__";
if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_82);
    } else {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    if (sftp) {
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    if (("true").equals(useExistingConn)) {
    	String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_95);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    } else {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    
            passwordFieldName = "__PASSPHRASE__";
            if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
            
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_113);
    } else {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    
        	passwordFieldName = "__PASSWORD__";
        	
    stringBuffer.append(TEXT_121);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_124);
    } else {
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_135);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(privateKey);
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_151);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    
        	passwordFieldName = "__PASSWORD__";
        	
    stringBuffer.append(TEXT_155);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_158);
    } else {
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    }
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    if (!useProxy) {
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    }
    stringBuffer.append(TEXT_173);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_185);
    }
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    if(use_encoding) {
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_191);
    }
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    
	if (createDirIfNotExist) {

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    
				if (isLog4jEnabled) {

    stringBuffer.append(TEXT_203);
    
				}

    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    
	}

    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    
	for (int i = 0; i < files.size(); i++) {
    	Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_216);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_217);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_220);
    
	}
  
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_223);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    }
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    }
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    } else if (!ftps) {
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    
		if (("true").equals(useExistingConn)) {
			String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    }
    stringBuffer.append(TEXT_248);
    } else {
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_254);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append((("ACTIVE").equals(connectMode))?"\"Using the active mode.\"":"\"Using the passive mode.\"");
    stringBuffer.append(TEXT_257);
    }
    stringBuffer.append(TEXT_258);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    } else {
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    }
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_265);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    
        	passwordFieldName = "__PASSWORD__";
        	
    stringBuffer.append(TEXT_272);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_275);
    } else {
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_278);
    }
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_285);
    }
    stringBuffer.append(TEXT_286);
    }
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    
		for (int i = 0; i < files.size(); i++) {
			Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_295);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_296);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_299);
    
		}
  
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_302);
    
		if (createDirIfNotExist) {

    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    
		}

    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_318);
    if ("binary".equalsIgnoreCase(ElementParameterParser.getValue(node, "__MODE__"))) {
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_320);
    } else { 
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    }
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_325);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    }
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    
} else { // *** ftps *** // 
		String keystoreFile = ElementParameterParser.getValue(node,"__KEYSTORE_FILE__"); 

		String securityMode = ElementParameterParser.getValue(node, "__SECURITY_MODE__");

    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    
		if(("false").equals(useExistingConn)){

    stringBuffer.append(TEXT_334);
     /* create connection */ 
    stringBuffer.append(TEXT_335);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    
			passwordFieldName = "__KEYSTORE_PASS__";
			if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_340);
    
			} else {

    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_343);
    
			}

    stringBuffer.append(TEXT_344);
    stringBuffer.append(keystoreFile);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    
					if (isLog4jEnabled) {

    stringBuffer.append(TEXT_349);
    
					}

    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append("IMPLICIT".equals(securityMode));
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_370);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(securityMode);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_376);
    }
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(ftpsPort );
    stringBuffer.append(TEXT_380);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_383);
    }
    stringBuffer.append(TEXT_384);
    
				passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_385);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_388);
    } else {
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_391);
    }
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(protectionLevel );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(protectionBufferSize );
    stringBuffer.append(TEXT_402);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    }
    
				if (dieOnError) {

    stringBuffer.append(TEXT_405);
    
				} else {

    stringBuffer.append(TEXT_406);
    
				}

    stringBuffer.append(TEXT_407);
    
			if ("PASSIVE".equals(connectMode)) {

    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    
				if (isLog4jEnabled) {

    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    
				}
			}
		} else {
			String conn= "conn_" + connection; 

    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_413);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_414);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_419);
    }
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_422);
    
		}

    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_425);
    
		if(createDirIfNotExist) {

    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    
		}

    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_440);
    
		for (int i = 0; i < files.size(); i++) {
			Map<String, String> line = files.get(i);

    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_443);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_444);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_447);
    
		}

    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_450);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    }
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    
} /* close ftps */

    stringBuffer.append(TEXT_456);
    return stringBuffer.toString();
  }
}
