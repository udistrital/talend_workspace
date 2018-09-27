package org.talend.designer.codegen.translators.databases.dbspecifics.jdbc;

import org.talend.core.model.metadata.IMetadataColumn;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.MappingTypeRetriever;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import org.talend.commons.utils.StringUtils;

public class TJDBCSCDELTBeginJava {
  protected static String nl;
  public static synchronized TJDBCSCDELTBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJDBCSCDELTBeginJava result = new TJDBCSCDELTBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "                if(log.is";
  protected final String TEXT_4 = "Enabled())";
  protected final String TEXT_5 = NL + "            log.";
  protected final String TEXT_6 = "(\"";
  protected final String TEXT_7 = " - \" ";
  protected final String TEXT_8 = " + (";
  protected final String TEXT_9 = ") ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "            if (log.isDebugEnabled()) {" + NL + "                class BytesLimit65535_";
  protected final String TEXT_12 = "{" + NL + "                    public void limitLog4jByte() throws Exception{" + NL + "                    StringBuilder ";
  protected final String TEXT_13 = " = new StringBuilder();";
  protected final String TEXT_14 = NL + "                    ";
  protected final String TEXT_15 = ".append(\"Parameters:\");";
  protected final String TEXT_16 = NL + "                            ";
  protected final String TEXT_17 = ".append(\"";
  protected final String TEXT_18 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_19 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_20 = NL + "                            ";
  protected final String TEXT_21 = ".append(\"";
  protected final String TEXT_22 = "\" + \" = \" + ";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "                        ";
  protected final String TEXT_25 = ".append(\" | \");";
  protected final String TEXT_26 = NL + "                    } " + NL + "                } " + NL + "            new BytesLimit65535_";
  protected final String TEXT_27 = "().limitLog4jByte();" + NL + "            }";
  protected final String TEXT_28 = NL + "            StringBuilder ";
  protected final String TEXT_29 = " = new StringBuilder();    ";
  protected final String TEXT_30 = NL + "                    ";
  protected final String TEXT_31 = ".append(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "                    if(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = " == null){";
  protected final String TEXT_37 = NL + "                        ";
  protected final String TEXT_38 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_39 = NL + "                        ";
  protected final String TEXT_40 = ".append(";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ");" + NL + "                    }   ";
  protected final String TEXT_43 = NL + "                ";
  protected final String TEXT_44 = ".append(\"|\");";
  protected final String TEXT_45 = NL;
  protected final String TEXT_46 = NL + "    java.sql.Connection conn_";
  protected final String TEXT_47 = " = (java.sql.Connection) globalMap.get(\"";
  protected final String TEXT_48 = "\");" + NL + "    String dbUser_";
  protected final String TEXT_49 = " = (String)globalMap.get(\"";
  protected final String TEXT_50 = "\");";
  protected final String TEXT_51 = NL + "    java.lang.Class.forName(";
  protected final String TEXT_52 = ");" + NL + "    String url_";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = ";" + NL + "    String dbUser_";
  protected final String TEXT_55 = " = ";
  protected final String TEXT_56 = ";" + NL;
  protected final String TEXT_57 = NL;
  protected final String TEXT_58 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_59 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_62 = " = ";
  protected final String TEXT_63 = "; ";
  protected final String TEXT_64 = NL + NL + "    String dbPwd_";
  protected final String TEXT_65 = " = decryptedPassword_";
  protected final String TEXT_66 = ";" + NL + "" + NL + "    java.sql.Connection conn_";
  protected final String TEXT_67 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_68 = ", dbUser_";
  protected final String TEXT_69 = ", dbPwd_";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL;
  protected final String TEXT_72 = NL + NL + "String dbschema_";
  protected final String TEXT_73 = " = ";
  protected final String TEXT_74 = ";" + NL + "String sourceTable_";
  protected final String TEXT_75 = " = ";
  protected final String TEXT_76 = ";" + NL + "String tableName_";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = ";" + NL;
  protected final String TEXT_79 = NL + "String schemaForSearch_";
  protected final String TEXT_80 = " = null;" + NL + "String tableForSearch_";
  protected final String TEXT_81 = " = tableName_";
  protected final String TEXT_82 = ";";
  protected final String TEXT_83 = NL + NL + "if(dbschema_";
  protected final String TEXT_84 = "!=null && !dbschema_";
  protected final String TEXT_85 = ".trim().isEmpty()) {" + NL + "\ttableName_";
  protected final String TEXT_86 = " = dbschema_";
  protected final String TEXT_87 = " + \"";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = "\" + tableName_";
  protected final String TEXT_90 = ";" + NL + "    sourceTable_";
  protected final String TEXT_91 = " = dbschema_";
  protected final String TEXT_92 = " + \"";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = "\" + sourceTable_";
  protected final String TEXT_95 = ";" + NL + "    ";
  protected final String TEXT_96 = NL + "    schemaForSearch_";
  protected final String TEXT_97 = " = dbschema_";
  protected final String TEXT_98 = ";";
  protected final String TEXT_99 = NL + "}" + NL;
  protected final String TEXT_100 = NL;
  protected final String TEXT_101 = NL + "int deletedCount_";
  protected final String TEXT_102 = " = 0;";
  protected final String TEXT_103 = NL;
  protected final String TEXT_104 = NL + "            try (java.sql.Statement stmtDrop_";
  protected final String TEXT_105 = " = conn_";
  protected final String TEXT_106 = ".createStatement()) {";
  protected final String TEXT_107 = NL + "                              stmtDrop_";
  protected final String TEXT_108 = ".setQueryTimeout(Integer.valueOf(Integer.valueOf(";
  protected final String TEXT_109 = ")));";
  protected final String TEXT_110 = NL + "                stmtDrop_";
  protected final String TEXT_111 = ".execute(\"";
  protected final String TEXT_112 = "\" ";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "            }";
  protected final String TEXT_115 = NL + "                 conn_";
  protected final String TEXT_116 = ".commit();";
  protected final String TEXT_117 = NL + "            try (java.sql.Statement stmtCreate_";
  protected final String TEXT_118 = " = conn_";
  protected final String TEXT_119 = ".createStatement()) {";
  protected final String TEXT_120 = NL + "                              stmtCreate_";
  protected final String TEXT_121 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_122 = "));";
  protected final String TEXT_123 = NL + "                        stmtCreate_";
  protected final String TEXT_124 = ".execute(((\"";
  protected final String TEXT_125 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = ", \"";
  protected final String TEXT_128 = "\")";
  protected final String TEXT_129 = ".toUpperCase()";
  protected final String TEXT_130 = ")+\")";
  protected final String TEXT_131 = "\"));";
  protected final String TEXT_132 = NL + "                stmtCreate_";
  protected final String TEXT_133 = ".execute(\"";
  protected final String TEXT_134 = ")\");";
  protected final String TEXT_135 = NL + "            }";
  protected final String TEXT_136 = NL + "            try (java.sql.Statement stmtCreate_";
  protected final String TEXT_137 = " = conn_";
  protected final String TEXT_138 = ".createStatement()) {";
  protected final String TEXT_139 = NL + "                              stmtCreate_";
  protected final String TEXT_140 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_141 = "));";
  protected final String TEXT_142 = NL + "                    stmtCreate_";
  protected final String TEXT_143 = ".execute(((\"";
  protected final String TEXT_144 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = ", \"";
  protected final String TEXT_147 = "\")";
  protected final String TEXT_148 = ".toUpperCase()";
  protected final String TEXT_149 = ")+\")";
  protected final String TEXT_150 = "\"));";
  protected final String TEXT_151 = NL + "                stmtCreate_";
  protected final String TEXT_152 = ".execute(\"";
  protected final String TEXT_153 = ")\");";
  protected final String TEXT_154 = NL + "            }";
  protected final String TEXT_155 = NL;
  protected final String TEXT_156 = NL + "                    String keyCheckTable_";
  protected final String TEXT_157 = " = \"[Informix]\"+\"[\"+";
  protected final String TEXT_158 = "+\"][\"+";
  protected final String TEXT_159 = "+\"][\"+";
  protected final String TEXT_160 = "+\"][\"+";
  protected final String TEXT_161 = "+\"][\"+";
  protected final String TEXT_162 = "+\"]\"+ \"[checktable]\" + \"[\" + ";
  protected final String TEXT_163 = " + \"]\";";
  protected final String TEXT_164 = NL + "                    // [%connection%][checktable][tableName]" + NL + "                    String keyCheckTable_";
  protected final String TEXT_165 = " = conn_";
  protected final String TEXT_166 = " + \"[checktable]\" + \"[\" + ";
  protected final String TEXT_167 = " + \"]\";";
  protected final String TEXT_168 = NL + NL + "                if(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_169 = ")== null){//}" + NL + "" + NL + "                    synchronized (GlobalResource.resourceLockMap.get(keyCheckTable_";
  protected final String TEXT_170 = ")) {//}" + NL + "                        if(GlobalResource.resourceMap.get(keyCheckTable_";
  protected final String TEXT_171 = ")== null){//}";
  protected final String TEXT_172 = NL + "                                boolean whetherExist_";
  protected final String TEXT_173 = " = false;" + NL + "                                try (java.sql.Statement isExistStmt_";
  protected final String TEXT_174 = " = conn_";
  protected final String TEXT_175 = ".createStatement()) {" + NL + "                                    try {" + NL + "                                        isExistStmt_";
  protected final String TEXT_176 = ".execute(\"SELECT TOP 1 1 FROM [\" + tableName_";
  protected final String TEXT_177 = " + \"]\" );" + NL + "                                        whetherExist_";
  protected final String TEXT_178 = " = true;" + NL + "                                    } catch (java.lang.Exception e){" + NL + "                                        whetherExist_";
  protected final String TEXT_179 = " = false;" + NL + "                                    }" + NL + "                                }";
  protected final String TEXT_180 = NL + "                                ";
  protected final String TEXT_181 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_182 = " = conn_";
  protected final String TEXT_183 = ".getMetaData();" + NL + "                                if(tableNameForSearch_";
  protected final String TEXT_184 = ".indexOf(\"\\\"\")==-1){" + NL + "                                    tableNameForSearch_";
  protected final String TEXT_185 = " = tableNameForSearch_";
  protected final String TEXT_186 = ".toUpperCase();" + NL + "                                }else{" + NL + "                                    tableNameForSearch_";
  protected final String TEXT_187 = " = tableNameForSearch_";
  protected final String TEXT_188 = ".replaceAll(\"\\\"\",\"\");" + NL + "                                }" + NL + "                                boolean whetherExist_";
  protected final String TEXT_189 = " = false;" + NL + "                                try (java.sql.ResultSet rsTable_";
  protected final String TEXT_190 = " = dbMetaData_";
  protected final String TEXT_191 = ".getTables(null, dbschemaForSearch_";
  protected final String TEXT_192 = ", tableNameForSearch_";
  protected final String TEXT_193 = ", new String[]{\"TABLE\"})) {" + NL + "                                    if(rsTable_";
  protected final String TEXT_194 = ".next()) {" + NL + "                                        whetherExist_";
  protected final String TEXT_195 = " = true;" + NL + "                                    }" + NL + "                                }" + NL;
  protected final String TEXT_196 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_197 = " = conn_";
  protected final String TEXT_198 = ".getMetaData();" + NL + "                                boolean whetherExist_";
  protected final String TEXT_199 = " = false;" + NL + "                                try (java.sql.ResultSet rsTable_";
  protected final String TEXT_200 = " = dbMetaData_";
  protected final String TEXT_201 = ".getTables(null, null, null, new String[]{\"TABLE\"})) {" + NL + "                                    while(rsTable_";
  protected final String TEXT_202 = ".next()) {" + NL + "                                        String table_";
  protected final String TEXT_203 = " = rsTable_";
  protected final String TEXT_204 = ".getString(\"TABLE_NAME\");" + NL + "                                        String schema_";
  protected final String TEXT_205 = " = rsTable_";
  protected final String TEXT_206 = ".getString(\"TABLE_SCHEM\");" + NL + "                                        if(table_";
  protected final String TEXT_207 = ".equals";
  protected final String TEXT_208 = "IgnoreCase";
  protected final String TEXT_209 = "(";
  protected final String TEXT_210 = ")" + NL + "                                            && (schema_";
  protected final String TEXT_211 = ".equals";
  protected final String TEXT_212 = "IgnoreCase";
  protected final String TEXT_213 = "(dbschema_";
  protected final String TEXT_214 = ") || dbschema_";
  protected final String TEXT_215 = ".trim().length() ==0)) {" + NL + "                                            whetherExist_";
  protected final String TEXT_216 = " = true;" + NL + "                                            break;" + NL + "                                        }" + NL + "                                    }" + NL + "                                }";
  protected final String TEXT_217 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_218 = " = conn_";
  protected final String TEXT_219 = ".getMetaData();" + NL + "                                boolean whetherExist_";
  protected final String TEXT_220 = " = false;" + NL + "                                try (java.sql.ResultSet rsTable_";
  protected final String TEXT_221 = " = dbMetaData_";
  protected final String TEXT_222 = ".getTables(null, null, null, new String[]{\"TABLE\"})) {" + NL + "                                    while(rsTable_";
  protected final String TEXT_223 = ".next()) {" + NL + "                                        String table_";
  protected final String TEXT_224 = " = rsTable_";
  protected final String TEXT_225 = ".getString(\"TABLE_NAME\");" + NL + "                                        String schema_";
  protected final String TEXT_226 = " = rsTable_";
  protected final String TEXT_227 = ".getString(\"TABLE_SCHEM\");" + NL + "                                        if(table_";
  protected final String TEXT_228 = ".equals";
  protected final String TEXT_229 = "IgnoreCase";
  protected final String TEXT_230 = "((";
  protected final String TEXT_231 = ")";
  protected final String TEXT_232 = ".toUpperCase()";
  protected final String TEXT_233 = ")" + NL + "                                            && (schema_";
  protected final String TEXT_234 = ".equals";
  protected final String TEXT_235 = "IgnoreCase";
  protected final String TEXT_236 = "(dbschema_";
  protected final String TEXT_237 = ") || (dbschema_";
  protected final String TEXT_238 = ".trim().length() ==0 && dbUser_";
  protected final String TEXT_239 = ".equalsIgnoreCase(schema_";
  protected final String TEXT_240 = ")))) {" + NL + "                                            whetherExist_";
  protected final String TEXT_241 = " = true;" + NL + "                                            break;" + NL + "                                        }" + NL + "                                    }" + NL + "                                }";
  protected final String TEXT_242 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_243 = " = conn_";
  protected final String TEXT_244 = ".getMetaData();" + NL + "                                boolean whetherExist_";
  protected final String TEXT_245 = " = false;" + NL + "                                try (java.sql.ResultSet rsTable_";
  protected final String TEXT_246 = " = dbMetaData_";
  protected final String TEXT_247 = ".getTables(null, null, null, new String[]{\"TABLE\"})) {" + NL + "                                    String defaultSchema_";
  protected final String TEXT_248 = " = \"public\";" + NL + "                                    if(dbschema_";
  protected final String TEXT_249 = " == null || dbschema_";
  protected final String TEXT_250 = ".trim().length() == 0) {" + NL + "                                        try(java.sql.Statement stmtSchema_";
  protected final String TEXT_251 = " = conn_";
  protected final String TEXT_252 = ".createStatement();" + NL + "                                            java.sql.ResultSet rsSchema_";
  protected final String TEXT_253 = " = stmtSchema_";
  protected final String TEXT_254 = ".executeQuery(\"select current_schema() \")) {" + NL + "                                            while(rsSchema_";
  protected final String TEXT_255 = ".next()){" + NL + "                                                defaultSchema_";
  protected final String TEXT_256 = " = rsSchema_";
  protected final String TEXT_257 = ".getString(\"current_schema\");" + NL + "                                            }" + NL + "                                        }" + NL + "                                    }" + NL + "                                    while(rsTable_";
  protected final String TEXT_258 = ".next()) {" + NL + "                                        String table_";
  protected final String TEXT_259 = " = rsTable_";
  protected final String TEXT_260 = ".getString(\"TABLE_NAME\");" + NL + "                                        String schema_";
  protected final String TEXT_261 = " = rsTable_";
  protected final String TEXT_262 = ".getString(\"TABLE_SCHEM\");" + NL + "                                        if(table_";
  protected final String TEXT_263 = ".equals";
  protected final String TEXT_264 = "IgnoreCase";
  protected final String TEXT_265 = "(";
  protected final String TEXT_266 = ")" + NL + "                                            && (schema_";
  protected final String TEXT_267 = ".equals";
  protected final String TEXT_268 = "IgnoreCase";
  protected final String TEXT_269 = "(dbschema_";
  protected final String TEXT_270 = ") || ((dbschema_";
  protected final String TEXT_271 = " ==null || dbschema_";
  protected final String TEXT_272 = ".trim().length() ==0) && defaultSchema_";
  protected final String TEXT_273 = ".equals";
  protected final String TEXT_274 = "IgnoreCase";
  protected final String TEXT_275 = "(schema_";
  protected final String TEXT_276 = ")))) {" + NL + "                                            whetherExist_";
  protected final String TEXT_277 = " = true;" + NL + "                                            break;" + NL + "                                        }" + NL + "                                    }" + NL + "                                }";
  protected final String TEXT_278 = NL + "                                String tableForSearch_";
  protected final String TEXT_279 = " = ";
  protected final String TEXT_280 = ";" + NL + "                                if(tableForSearch_";
  protected final String TEXT_281 = " != null){" + NL + "                                    if(tableForSearch_";
  protected final String TEXT_282 = ".startsWith(\"\\\"\") && tableForSearch_";
  protected final String TEXT_283 = ".endsWith(\"\\\"\")){" + NL + "                                        tableForSearch_";
  protected final String TEXT_284 = " =  tableForSearch_";
  protected final String TEXT_285 = ".substring(1,tableForSearch_";
  protected final String TEXT_286 = ".length()-1);" + NL + "                                    }else{" + NL + "                                        tableForSearch_";
  protected final String TEXT_287 = " =  tableForSearch_";
  protected final String TEXT_288 = ".toUpperCase();" + NL + "                                    }" + NL + "                                }" + NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_289 = " = conn_";
  protected final String TEXT_290 = ".getMetaData();" + NL + "                                boolean whetherExist_";
  protected final String TEXT_291 = " = false;" + NL + "                                try (java.sql.ResultSet rsTable_";
  protected final String TEXT_292 = " = dbMetaData_";
  protected final String TEXT_293 = ".getTables(null, conn_";
  protected final String TEXT_294 = ".getSchema(), tableForSearch_";
  protected final String TEXT_295 = ", new String[]{\"TABLE\"})) {" + NL + "                                       if(rsTable_";
  protected final String TEXT_296 = ".next()) {" + NL + "                                        whetherExist_";
  protected final String TEXT_297 = " = true;" + NL + "                                    }" + NL + "                                }";
  protected final String TEXT_298 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_299 = " = conn_";
  protected final String TEXT_300 = ".getMetaData();" + NL + "                                boolean whetherExist_";
  protected final String TEXT_301 = " = false;" + NL + "                                try (java.sql.ResultSet rsTable_";
  protected final String TEXT_302 = " = dbMetaData_";
  protected final String TEXT_303 = ".getTables(null, schemaForSearch_";
  protected final String TEXT_304 = ", null, new String[]{\"TABLE\"})) {" + NL + "                                    while(rsTable_";
  protected final String TEXT_305 = ".next()) {" + NL + "                                        if(rsTable_";
  protected final String TEXT_306 = ".getString(\"TABLE_NAME\").equalsIgnoreCase(tableForSearch_";
  protected final String TEXT_307 = ")) {" + NL + "                                            whetherExist_";
  protected final String TEXT_308 = " = true;" + NL + "                                            break;" + NL + "                                        }" + NL + "                                    }" + NL + "                                }";
  protected final String TEXT_309 = NL + "                                java.sql.DatabaseMetaData dbMetaData_";
  protected final String TEXT_310 = " = conn_";
  protected final String TEXT_311 = ".getMetaData();" + NL + "                                boolean whetherExist_";
  protected final String TEXT_312 = " = false;" + NL + "                                try (java.sql.ResultSet rsTable_";
  protected final String TEXT_313 = " = dbMetaData_";
  protected final String TEXT_314 = ".getTables(null, null, null, new String[]{\"TABLE\"})) {" + NL + "                                    while(rsTable_";
  protected final String TEXT_315 = ".next()) {" + NL + "                                        String table_";
  protected final String TEXT_316 = " = rsTable_";
  protected final String TEXT_317 = ".getString(\"TABLE_NAME\");" + NL + "                                        if(table_";
  protected final String TEXT_318 = ".equalsIgnoreCase(";
  protected final String TEXT_319 = ")) {" + NL + "                                            whetherExist_";
  protected final String TEXT_320 = " = true;" + NL + "                                            break;" + NL + "                                        }" + NL + "                                    }" + NL + "                                }";
  protected final String TEXT_321 = NL + "                                if(!whetherExist_";
  protected final String TEXT_322 = ") {" + NL + "                                    try (java.sql.Statement stmtCreate_";
  protected final String TEXT_323 = " = conn_";
  protected final String TEXT_324 = ".createStatement()) {";
  protected final String TEXT_325 = NL + "                                                      stmtCreate_";
  protected final String TEXT_326 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_327 = "));";
  protected final String TEXT_328 = NL + "                                            stmtCreate_";
  protected final String TEXT_329 = ".execute(((\"";
  protected final String TEXT_330 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_331 = ".";
  protected final String TEXT_332 = ", \"";
  protected final String TEXT_333 = "\")";
  protected final String TEXT_334 = ".toUpperCase()";
  protected final String TEXT_335 = ")+\")";
  protected final String TEXT_336 = "\"));";
  protected final String TEXT_337 = NL + "                                        stmtCreate_";
  protected final String TEXT_338 = ".execute(\"";
  protected final String TEXT_339 = ")\");";
  protected final String TEXT_340 = NL + "                                    }" + NL + "                                }";
  protected final String TEXT_341 = NL + "                                if(whetherExist_";
  protected final String TEXT_342 = ") {" + NL + "                                    try (java.sql.Statement stmtDrop_";
  protected final String TEXT_343 = " = conn_";
  protected final String TEXT_344 = ".createStatement()) {";
  protected final String TEXT_345 = NL + "                                                      stmtDrop_";
  protected final String TEXT_346 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_347 = "));";
  protected final String TEXT_348 = NL + "                                        stmtDrop_";
  protected final String TEXT_349 = ".execute(\"";
  protected final String TEXT_350 = "\" ";
  protected final String TEXT_351 = ");";
  protected final String TEXT_352 = NL + "                                    }";
  protected final String TEXT_353 = NL + "                                            conn_";
  protected final String TEXT_354 = ".commit();";
  protected final String TEXT_355 = NL + "                                }" + NL + "                                try(java.sql.Statement stmtCreate_";
  protected final String TEXT_356 = " = conn_";
  protected final String TEXT_357 = ".createStatement()) {";
  protected final String TEXT_358 = NL + "                                                  stmtCreate_";
  protected final String TEXT_359 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_360 = "));";
  protected final String TEXT_361 = NL + "                                        stmtCreate_";
  protected final String TEXT_362 = ".execute(((\"";
  protected final String TEXT_363 = "\").replace(\"{TALEND_DYNAMIC_COLUMN}\",DynamicUtils.getCreateTableSQL(";
  protected final String TEXT_364 = ".";
  protected final String TEXT_365 = ", \"";
  protected final String TEXT_366 = "\")";
  protected final String TEXT_367 = ".toUpperCase()";
  protected final String TEXT_368 = ")+\")";
  protected final String TEXT_369 = "\"));";
  protected final String TEXT_370 = NL + "                                    stmtCreate_";
  protected final String TEXT_371 = ".execute(\"";
  protected final String TEXT_372 = ")\");";
  protected final String TEXT_373 = NL + "                                }";
  protected final String TEXT_374 = NL + "                            GlobalResource.resourceMap.put(keyCheckTable_";
  protected final String TEXT_375 = ", true);" + NL + "            //{{{" + NL + "                        } // end of if" + NL + "                    } // end synchronized" + NL + "                }";
  protected final String TEXT_376 = NL + "            try (java.sql.Statement stmtClear_";
  protected final String TEXT_377 = " = conn_";
  protected final String TEXT_378 = ".createStatement()) {";
  protected final String TEXT_379 = NL + "                              stmtClear_";
  protected final String TEXT_380 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_381 = "));";
  protected final String TEXT_382 = NL + "                stmtClear_";
  protected final String TEXT_383 = ".executeUpdate(\"";
  protected final String TEXT_384 = "\");";
  protected final String TEXT_385 = NL + "            }";
  protected final String TEXT_386 = NL + "            int rsTruncCountNumber_";
  protected final String TEXT_387 = " = 0;" + NL + "            try(java.sql.Statement stmtTruncCount_";
  protected final String TEXT_388 = " = conn_";
  protected final String TEXT_389 = ".createStatement()) {";
  protected final String TEXT_390 = NL + "                              stmtTruncCount_";
  protected final String TEXT_391 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_392 = "));";
  protected final String TEXT_393 = NL + "                try (java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_394 = " = stmtTruncCount_";
  protected final String TEXT_395 = ".executeQuery(\"";
  protected final String TEXT_396 = "\")) {" + NL + "                    if(rsTruncCount_";
  protected final String TEXT_397 = ".next()) {" + NL + "                        rsTruncCountNumber_";
  protected final String TEXT_398 = " = rsTruncCount_";
  protected final String TEXT_399 = ".getInt(1);" + NL + "                    }" + NL + "                }" + NL + "            }" + NL + "            try (java.sql.Statement stmtTrunc_";
  protected final String TEXT_400 = " = conn_";
  protected final String TEXT_401 = ".createStatement()) {";
  protected final String TEXT_402 = NL + "                              stmtTrunc_";
  protected final String TEXT_403 = ".setQueryTimeout(Integer.valueOf(";
  protected final String TEXT_404 = "));";
  protected final String TEXT_405 = NL + "                conn_";
  protected final String TEXT_406 = ".commit();";
  protected final String TEXT_407 = NL + "                stmtTrunc_";
  protected final String TEXT_408 = ".executeUpdate(\"";
  protected final String TEXT_409 = "\");";
  protected final String TEXT_410 = NL + "                    if(!conn_";
  protected final String TEXT_411 = ".getAutoCommit()){" + NL + "                        conn_";
  protected final String TEXT_412 = ".commit();" + NL + "                    }";
  protected final String TEXT_413 = NL + "                deletedCount_";
  protected final String TEXT_414 = " += rsTruncCountNumber_";
  protected final String TEXT_415 = ";" + NL + "            }";
  protected final String TEXT_416 = NL + "            try (java.sql.Statement stmtTruncCount_";
  protected final String TEXT_417 = " = conn_";
  protected final String TEXT_418 = ".createStatement();" + NL + "                java.sql.ResultSet rsTruncCount_";
  protected final String TEXT_419 = " = stmtTruncCount_";
  protected final String TEXT_420 = ".executeQuery(\"";
  protected final String TEXT_421 = "\");" + NL + "                java.sql.Statement stmtTrunc_";
  protected final String TEXT_422 = " = conn_";
  protected final String TEXT_423 = ".createStatement()) {";
  protected final String TEXT_424 = NL + "                conn_";
  protected final String TEXT_425 = ".commit();";
  protected final String TEXT_426 = NL + "                stmtTrunc_";
  protected final String TEXT_427 = ".executeUpdate(\"";
  protected final String TEXT_428 = "\");";
  protected final String TEXT_429 = NL + "                while(rsTruncCount_";
  protected final String TEXT_430 = ".next()) {" + NL + "                    deletedCount_";
  protected final String TEXT_431 = " += rsTruncCount_";
  protected final String TEXT_432 = ".getInt(1);" + NL + "                }" + NL + "            }";
  protected final String TEXT_433 = NL;
  protected final String TEXT_434 = NL + "    System.out.println(\"[";
  protected final String TEXT_435 = "] table action ";
  protected final String TEXT_436 = " done\\n\");";
  protected final String TEXT_437 = NL;
  protected final String TEXT_438 = NL;
  protected final String TEXT_439 = NL + "String sequence_";
  protected final String TEXT_440 = " = ";
  protected final String TEXT_441 = ";";
  protected final String TEXT_442 = NL + "    String sequenceValueFetchPattern_";
  protected final String TEXT_443 = ";" + NL + "    if(dbschema_";
  protected final String TEXT_444 = "!=null && !dbschema_";
  protected final String TEXT_445 = ".trim().isEmpty()) {" + NL + "        sequenceValueFetchPattern_";
  protected final String TEXT_446 = " = dbschema_";
  protected final String TEXT_447 = " + \".\" + sequence_";
  protected final String TEXT_448 = "+\".nextval \";" + NL + "        //snowflake is not case sensitive, so no need to consider the quoter here." + NL + "    }else{" + NL + "        sequenceValueFetchPattern_";
  protected final String TEXT_449 = " = sequence_";
  protected final String TEXT_450 = "+\".nextval \";" + NL + "    }";
  protected final String TEXT_451 = NL + "String sequenceValueFetchPattern_";
  protected final String TEXT_452 = " = \"NEXT VALUE FOR ";
  protected final String TEXT_453 = "\";";
  protected final String TEXT_454 = NL;
  protected final String TEXT_455 = NL + "\t";
  protected final String TEXT_456 = NL;
  protected final String TEXT_457 = NL + "    String updateForType1_";
  protected final String TEXT_458 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_459 = " + \"` d, `\" + sourceTable_";
  protected final String TEXT_460 = " + \"` t SET ";
  protected final String TEXT_461 = " WHERE ";
  protected final String TEXT_462 = " AND (";
  protected final String TEXT_463 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_464 = " = conn_";
  protected final String TEXT_465 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_466 = ".executeUpdate(updateForType1_";
  protected final String TEXT_467 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_468 = ".close();";
  protected final String TEXT_469 = NL + "        System.out.println(\"[";
  protected final String TEXT_470 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_471 = " + \"\\ndone\");";
  protected final String TEXT_472 = "        " + NL + "    String changeDateTime_";
  protected final String TEXT_473 = " = (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_474 = "\"))).toString();" + NL + "\t";
  protected final String TEXT_475 = NL + "    String changeDateTime_";
  protected final String TEXT_476 = "_begin = changeDateTime_";
  protected final String TEXT_477 = ";" + NL + "    String changeDateTime_";
  protected final String TEXT_478 = "_end = changeDateTime_";
  protected final String TEXT_479 = ";" + NL + "    ";
  protected final String TEXT_480 = NL + "\t        changeDateTime_";
  protected final String TEXT_481 = "_begin = routines.system.DBDateParser.getDBDateParser(\"";
  protected final String TEXT_482 = "\").getDateString(\"";
  protected final String TEXT_483 = "\",\"";
  protected final String TEXT_484 = "\",(Long)start_Hash.get(\"";
  protected final String TEXT_485 = "\"),";
  protected final String TEXT_486 = ");" + NL + "\t";
  protected final String TEXT_487 = NL + "    \t\tchangeDateTime_";
  protected final String TEXT_488 = "_end = routines.system.DBDateParser.getDBDateParser(\"";
  protected final String TEXT_489 = "\").getDateString(\"";
  protected final String TEXT_490 = "\",\"";
  protected final String TEXT_491 = "\",(Long)start_Hash.get(\"";
  protected final String TEXT_492 = "\"),";
  protected final String TEXT_493 = ");";
  protected final String TEXT_494 = NL + "    String updateForType2_";
  protected final String TEXT_495 = " = \"UPDATE `\" + tableName_";
  protected final String TEXT_496 = " + \"` d, `\" + sourceTable_";
  protected final String TEXT_497 = " + \"` t SET `";
  protected final String TEXT_498 = "` = '\" + (changeDateTime_";
  protected final String TEXT_499 = ") + \"'";
  protected final String TEXT_500 = ", `";
  protected final String TEXT_501 = "` = 0";
  protected final String TEXT_502 = " WHERE ";
  protected final String TEXT_503 = " AND (";
  protected final String TEXT_504 = ") AND d.`";
  protected final String TEXT_505 = "` IS NULL\"; " + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_506 = " = conn_";
  protected final String TEXT_507 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_508 = ".executeUpdate(updateForType2_";
  protected final String TEXT_509 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_510 = ".close();";
  protected final String TEXT_511 = NL + "    \tString updateForType2_";
  protected final String TEXT_512 = "_debug = \"UPDATE `\" + tableName_";
  protected final String TEXT_513 = " + \"` d, `\" + sourceTable_";
  protected final String TEXT_514 = " + \"` t SET `";
  protected final String TEXT_515 = "` = '\" + (changeDateTime_";
  protected final String TEXT_516 = "_end) + \"'";
  protected final String TEXT_517 = ", `";
  protected final String TEXT_518 = "` = 0";
  protected final String TEXT_519 = " WHERE ";
  protected final String TEXT_520 = " AND (";
  protected final String TEXT_521 = ") AND d.`";
  protected final String TEXT_522 = "` IS NULL\"; " + NL + "        System.out.println(\"[";
  protected final String TEXT_523 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_524 = "_debug + \"\\ndone\");";
  protected final String TEXT_525 = NL + "    String insertForType2_";
  protected final String TEXT_526 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_527 = " + \"`(";
  protected final String TEXT_528 = ") SELECT t.";
  protected final String TEXT_529 = ", '\" + " + NL + "    (changeDateTime_";
  protected final String TEXT_530 = ") + \"', NULL";
  protected final String TEXT_531 = ", 1";
  protected final String TEXT_532 = ", d.`";
  protected final String TEXT_533 = "` + 1";
  protected final String TEXT_534 = " FROM `\" + " + NL + "    sourceTable_";
  protected final String TEXT_535 = " + \"` t, `\" + tableName_";
  protected final String TEXT_536 = " + \"` d WHERE ";
  protected final String TEXT_537 = " AND (";
  protected final String TEXT_538 = ") AND d.`";
  protected final String TEXT_539 = "` = '\" + (changeDateTime_";
  protected final String TEXT_540 = ") + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_541 = " = conn_";
  protected final String TEXT_542 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_543 = ".executeUpdate(insertForType2_";
  protected final String TEXT_544 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_545 = ".close();";
  protected final String TEXT_546 = NL + "\t\tString insertForType2_";
  protected final String TEXT_547 = "_debug = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_548 = " + \"`(";
  protected final String TEXT_549 = ") SELECT t.";
  protected final String TEXT_550 = ", '\" + (changeDateTime_";
  protected final String TEXT_551 = "_begin) + \"', NULL";
  protected final String TEXT_552 = ", 1";
  protected final String TEXT_553 = ", d.`";
  protected final String TEXT_554 = "` + 1";
  protected final String TEXT_555 = " FROM `\" + sourceTable_";
  protected final String TEXT_556 = " + \"` t, `\" + tableName_";
  protected final String TEXT_557 = " + \"` d WHERE ";
  protected final String TEXT_558 = " AND (";
  protected final String TEXT_559 = ") AND d.`";
  protected final String TEXT_560 = "` = '\" + (changeDateTime_";
  protected final String TEXT_561 = "_end) + \"'\";" + NL + "        System.out.println(\"[";
  protected final String TEXT_562 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_563 = "_debug + \"\\ndone\");";
  protected final String TEXT_564 = NL + "String insert_";
  protected final String TEXT_565 = " = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_566 = " + \"`(";
  protected final String TEXT_567 = ") SELECT t.";
  protected final String TEXT_568 = "\"";
  protected final String TEXT_569 = " + \", '\" + (changeDateTime_";
  protected final String TEXT_570 = ") + \"', NULL\"";
  protected final String TEXT_571 = NL + "+ \"";
  protected final String TEXT_572 = ", 1";
  protected final String TEXT_573 = ", 1";
  protected final String TEXT_574 = " FROM `\" + " + NL + "sourceTable_";
  protected final String TEXT_575 = " + \"` t LEFT JOIN `\" + tableName_";
  protected final String TEXT_576 = " + \"` d ON ";
  protected final String TEXT_577 = " WHERE (";
  protected final String TEXT_578 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_579 = " = conn_";
  protected final String TEXT_580 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_581 = ".executeUpdate(insert_";
  protected final String TEXT_582 = ");" + NL + "stmtInsert_";
  protected final String TEXT_583 = ".close();";
  protected final String TEXT_584 = NL + "\tString insert_";
  protected final String TEXT_585 = "_debug = \"INSERT INTO `\" + tableName_";
  protected final String TEXT_586 = " + \"`(";
  protected final String TEXT_587 = ") SELECT t.";
  protected final String TEXT_588 = "\"";
  protected final String TEXT_589 = " + \", '\" + (changeDateTime_";
  protected final String TEXT_590 = "_begin) + \"', NULL\"";
  protected final String TEXT_591 = " + \"";
  protected final String TEXT_592 = ", 1";
  protected final String TEXT_593 = ", 1";
  protected final String TEXT_594 = " FROM `\" + sourceTable_";
  protected final String TEXT_595 = " + \"` t LEFT JOIN `\" + tableName_";
  protected final String TEXT_596 = " + \"` d ON ";
  protected final String TEXT_597 = " WHERE (";
  protected final String TEXT_598 = ")\";" + NL + "    System.out.println(\"[";
  protected final String TEXT_599 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_600 = "_debug + \"\\ndone\");";
  protected final String TEXT_601 = NL;
  protected final String TEXT_602 = NL + "\t";
  protected final String TEXT_603 = NL;
  protected final String TEXT_604 = NL + "java.util.Date currentDate_";
  protected final String TEXT_605 = " = new java.util.Date((Long)start_Hash.get(\"";
  protected final String TEXT_606 = "\"));" + NL + "String dateString_";
  protected final String TEXT_607 = " = routines.system.FormatterUtils.format_Date(currentDate_";
  protected final String TEXT_608 = ", \"yyyy-MM-dd HH:mm:ss\");" + NL + "String dateValue_";
  protected final String TEXT_609 = " = \"to_date('\" + dateString_";
  protected final String TEXT_610 = " + \"', 'yyyy-mm-dd HH24:MI:SS')\";";
  protected final String TEXT_611 = NL + "    String updateForType1_";
  protected final String TEXT_612 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_613 = " + \" d SET (";
  protected final String TEXT_614 = ") = (SELECT ";
  protected final String TEXT_615 = " FROM \" + sourceTable_";
  protected final String TEXT_616 = " + \" t WHERE ";
  protected final String TEXT_617 = " AND (";
  protected final String TEXT_618 = ")) WHERE EXISTS (SELECT 1 FROM \" + sourceTable_";
  protected final String TEXT_619 = " + \" t WHERE ";
  protected final String TEXT_620 = " AND (";
  protected final String TEXT_621 = "))\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_622 = " = conn_";
  protected final String TEXT_623 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_624 = ".executeUpdate(updateForType1_";
  protected final String TEXT_625 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_626 = ".close();";
  protected final String TEXT_627 = NL + "        System.out.println(\"[";
  protected final String TEXT_628 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_629 = " + \"\\ndone\");";
  protected final String TEXT_630 = NL + "    String updateForType2_";
  protected final String TEXT_631 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_632 = " + \" d SET ";
  protected final String TEXT_633 = " = \" +";
  protected final String TEXT_634 = NL + "        \"(SELECT t.";
  protected final String TEXT_635 = " FROM \" + sourceTable_";
  protected final String TEXT_636 = " +" + NL + "        \" t WHERE ";
  protected final String TEXT_637 = ")\"";
  protected final String TEXT_638 = NL + "    \tdateValue_";
  protected final String TEXT_639 = NL + "    + \"";
  protected final String TEXT_640 = ", ";
  protected final String TEXT_641 = " = 0";
  protected final String TEXT_642 = " WHERE EXISTS (SELECT 1 FROM \" + sourceTable_";
  protected final String TEXT_643 = " +" + NL + "    \" t WHERE ";
  protected final String TEXT_644 = " AND (";
  protected final String TEXT_645 = ")) AND d.";
  protected final String TEXT_646 = " \"" + NL + "    +";
  protected final String TEXT_647 = NL + "     \" IS NULL\";";
  protected final String TEXT_648 = NL + "     \"= to_date ('\" + ";
  protected final String TEXT_649 = " +\"-01-01', 'yyyy-mm-dd')\";";
  protected final String TEXT_650 = NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_651 = " = conn_";
  protected final String TEXT_652 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_653 = ".executeUpdate(updateForType2_";
  protected final String TEXT_654 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_655 = ".close();";
  protected final String TEXT_656 = NL + "        System.out.println(\"[";
  protected final String TEXT_657 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_658 = " + \"\\ndone\");";
  protected final String TEXT_659 = NL + "    String insertForType2_";
  protected final String TEXT_660 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_661 = " + \"(";
  protected final String TEXT_662 = ", ";
  protected final String TEXT_663 = ") SELECT ";
  protected final String TEXT_664 = "\" + ";
  protected final String TEXT_665 = " + \".NEXTVAL, ";
  protected final String TEXT_666 = "t.";
  protected final String TEXT_667 = ", \"" + NL + "    +";
  protected final String TEXT_668 = NL + "    dateValue_";
  protected final String TEXT_669 = NL + "    \"t.";
  protected final String TEXT_670 = "\"";
  protected final String TEXT_671 = NL + "     +";
  protected final String TEXT_672 = NL + "     \", NULL\"";
  protected final String TEXT_673 = NL + "     \", to_date('\"+";
  protected final String TEXT_674 = "+\"-01-01', 'yyyy-mm-dd')\"";
  protected final String TEXT_675 = NL + "     +\"";
  protected final String TEXT_676 = ", 1";
  protected final String TEXT_677 = ", d.";
  protected final String TEXT_678 = " + 1";
  protected final String TEXT_679 = " FROM \" +" + NL + "    sourceTable_";
  protected final String TEXT_680 = " + \" t, \" + tableName_";
  protected final String TEXT_681 = " + \" d WHERE ";
  protected final String TEXT_682 = " AND (";
  protected final String TEXT_683 = ") AND d.";
  protected final String TEXT_684 = " = \"" + NL + "" + NL + "" + NL + "    +";
  protected final String TEXT_685 = NL + "        \"(SELECT t.";
  protected final String TEXT_686 = " FROM \" + sourceTable_";
  protected final String TEXT_687 = " +" + NL + "        \" t WHERE ";
  protected final String TEXT_688 = ")\"";
  protected final String TEXT_689 = NL + "    \tdateValue_";
  protected final String TEXT_690 = NL + "    ;" + NL + "" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_691 = " = conn_";
  protected final String TEXT_692 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_693 = ".executeUpdate(insertForType2_";
  protected final String TEXT_694 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_695 = ".close();";
  protected final String TEXT_696 = NL + "        System.out.println(\"[";
  protected final String TEXT_697 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_698 = " + \"\\ndone\");";
  protected final String TEXT_699 = NL + "String insert_";
  protected final String TEXT_700 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_701 = " + \"(";
  protected final String TEXT_702 = ", ";
  protected final String TEXT_703 = ") SELECT ";
  protected final String TEXT_704 = "\" + ";
  protected final String TEXT_705 = " + \".NEXTVAL, ";
  protected final String TEXT_706 = "t.";
  protected final String TEXT_707 = "\"" + NL;
  protected final String TEXT_708 = " + \", \"" + NL + "\t+" + NL + "\t";
  protected final String TEXT_709 = NL + "\t dateValue_";
  protected final String TEXT_710 = NL + "\t";
  protected final String TEXT_711 = NL + "\t\"t.";
  protected final String TEXT_712 = "\"" + NL + "\t";
  protected final String TEXT_713 = NL + "\t+" + NL + "\t";
  protected final String TEXT_714 = NL + "\t\t\", NULL\"" + NL + "\t";
  protected final String TEXT_715 = NL + "\t\t \", to_date('\"+";
  protected final String TEXT_716 = "+\"-01-01', 'yyyy-mm-dd')\"" + NL + "\t";
  protected final String TEXT_717 = NL;
  protected final String TEXT_718 = NL + NL + "+ \"";
  protected final String TEXT_719 = ", 1";
  protected final String TEXT_720 = ", 1";
  protected final String TEXT_721 = " FROM \" +" + NL + "" + NL + "sourceTable_";
  protected final String TEXT_722 = " + \" t LEFT JOIN \" + tableName_";
  protected final String TEXT_723 = " + \" d ON ";
  protected final String TEXT_724 = " WHERE (";
  protected final String TEXT_725 = ")\";" + NL + "" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_726 = " = conn_";
  protected final String TEXT_727 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_728 = ".executeUpdate(insert_";
  protected final String TEXT_729 = ");" + NL + "stmtInsert_";
  protected final String TEXT_730 = ".close();";
  protected final String TEXT_731 = NL + "    System.out.println(\"[";
  protected final String TEXT_732 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_733 = " + \"\\ndone\");";
  protected final String TEXT_734 = NL;
  protected final String TEXT_735 = NL + "\t";
  protected final String TEXT_736 = NL;
  protected final String TEXT_737 = NL + "    String updateForType1_";
  protected final String TEXT_738 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_739 = " +\" FROM \"+ sourceTable_";
  protected final String TEXT_740 = " + \" t SET ";
  protected final String TEXT_741 = " WHERE ";
  protected final String TEXT_742 = " AND (";
  protected final String TEXT_743 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_744 = " = conn_";
  protected final String TEXT_745 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_746 = ".executeUpdate(updateForType1_";
  protected final String TEXT_747 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_748 = ".close();";
  protected final String TEXT_749 = NL + "    String updateForType2_";
  protected final String TEXT_750 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_751 = NL + "                                    + \" FROM \" + sourceTable_";
  protected final String TEXT_752 = " + \" t\"" + NL + "                                    + \" SET ";
  protected final String TEXT_753 = " = cast('\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_754 = "\")))" + NL + "                                    + \"' as timestamp format 'YYYY-MM-DDBHH:MI:SS.S(F)')";
  protected final String TEXT_755 = ", ";
  protected final String TEXT_756 = " = 0";
  protected final String TEXT_757 = " \"" + NL + "                                    + \" WHERE ";
  protected final String TEXT_758 = " AND (";
  protected final String TEXT_759 = ") AND \" + tableName_";
  protected final String TEXT_760 = " + \".";
  protected final String TEXT_761 = " IS NULL\";" + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_762 = " = conn_";
  protected final String TEXT_763 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_764 = ".executeUpdate(updateForType2_";
  protected final String TEXT_765 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_766 = ".close();";
  protected final String TEXT_767 = NL + "    String insertForType2_";
  protected final String TEXT_768 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_769 = " + \"(";
  protected final String TEXT_770 = ", ";
  protected final String TEXT_771 = ") SELECT ";
  protected final String TEXT_772 = "\" + ";
  protected final String TEXT_773 = " + \".NEXTVAL, ";
  protected final String TEXT_774 = "t.";
  protected final String TEXT_775 = ", cast('\" +" + NL + "    (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_776 = "\"))) + \"' as timestamp format 'YYYY-MM-DDBHH:MI:SS.S(F)'), NULL";
  protected final String TEXT_777 = ", 1";
  protected final String TEXT_778 = ", d.";
  protected final String TEXT_779 = " + 1";
  protected final String TEXT_780 = " FROM \" +" + NL + "    sourceTable_";
  protected final String TEXT_781 = " + \" t, \" + tableName_";
  protected final String TEXT_782 = " + \" d WHERE ";
  protected final String TEXT_783 = " AND (";
  protected final String TEXT_784 = ") AND d.";
  protected final String TEXT_785 = " = cast('\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_786 = "\"))) + \"' as timestamp format 'YYYY-MM-DDBHH:MI:SS.S(F)')\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_787 = " = conn_";
  protected final String TEXT_788 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_789 = ".executeUpdate(insertForType2_";
  protected final String TEXT_790 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_791 = ".close();";
  protected final String TEXT_792 = NL + "String insert_";
  protected final String TEXT_793 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_794 = " + \"(";
  protected final String TEXT_795 = ", ";
  protected final String TEXT_796 = ") SELECT ";
  protected final String TEXT_797 = "\" + ";
  protected final String TEXT_798 = " + \".NEXTVAL, ";
  protected final String TEXT_799 = "t.";
  protected final String TEXT_800 = "\"";
  protected final String TEXT_801 = " + \", cast('\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_802 = "\"))) + \"' as timestamp format 'YYYY-MM-DDBHH:MI:SS.S(F)'), NULL\"";
  protected final String TEXT_803 = NL + "+ \"";
  protected final String TEXT_804 = ", 1";
  protected final String TEXT_805 = ", 1";
  protected final String TEXT_806 = " FROM \" +" + NL + "sourceTable_";
  protected final String TEXT_807 = " + \" t LEFT JOIN \" + tableName_";
  protected final String TEXT_808 = " + \" d ON ";
  protected final String TEXT_809 = " WHERE (";
  protected final String TEXT_810 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_811 = " = conn_";
  protected final String TEXT_812 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_813 = ".executeUpdate(insert_";
  protected final String TEXT_814 = ");" + NL + "stmtInsert_";
  protected final String TEXT_815 = ".close();";
  protected final String TEXT_816 = NL;
  protected final String TEXT_817 = NL + "\t";
  protected final String TEXT_818 = NL;
  protected final String TEXT_819 = NL + "    String updateForType1_";
  protected final String TEXT_820 = " = \"UPDATE \\\"\" + tableName_";
  protected final String TEXT_821 = " + \"\\\" d SET ";
  protected final String TEXT_822 = " FROM \\\"\" + sourceTable_";
  protected final String TEXT_823 = " + \"\\\" t WHERE ";
  protected final String TEXT_824 = " AND (";
  protected final String TEXT_825 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_826 = " = conn_";
  protected final String TEXT_827 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_828 = ".executeUpdate(updateForType1_";
  protected final String TEXT_829 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_830 = ".close();";
  protected final String TEXT_831 = NL + "        System.out.println(\"[";
  protected final String TEXT_832 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_833 = " + \"\\ndone\");";
  protected final String TEXT_834 = NL + "    String updateForType2_";
  protected final String TEXT_835 = " = \"UPDATE \\\"\" + tableName_";
  protected final String TEXT_836 = " + \"\\\" d SET \\\"";
  protected final String TEXT_837 = "\\\" = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_838 = "\"))) + \"'";
  protected final String TEXT_839 = ", \\\"";
  protected final String TEXT_840 = "\\\" = 0";
  protected final String TEXT_841 = " FROM \\\"\" + sourceTable_";
  protected final String TEXT_842 = " + \"\\\" t WHERE ";
  protected final String TEXT_843 = " AND (";
  protected final String TEXT_844 = ") AND d.\\\"";
  protected final String TEXT_845 = "\\\" IS NULL\";" + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_846 = " = conn_";
  protected final String TEXT_847 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_848 = ".executeUpdate(updateForType2_";
  protected final String TEXT_849 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_850 = ".close();";
  protected final String TEXT_851 = NL + "        System.out.println(\"[";
  protected final String TEXT_852 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_853 = " + \"\\ndone\");";
  protected final String TEXT_854 = NL + "    String insertForType2_";
  protected final String TEXT_855 = " = \"INSERT INTO \\\"\" + tableName_";
  protected final String TEXT_856 = " + \"\\\"(";
  protected final String TEXT_857 = "\\\"";
  protected final String TEXT_858 = "\\\", ";
  protected final String TEXT_859 = ") SELECT ";
  protected final String TEXT_860 = "NEXTVAL('\" + ";
  protected final String TEXT_861 = " + \"'), ";
  protected final String TEXT_862 = "t.";
  protected final String TEXT_863 = ", '\" + " + NL + "    (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_864 = "\"))) + \"', NULL";
  protected final String TEXT_865 = ", 1";
  protected final String TEXT_866 = ", d.\\\"";
  protected final String TEXT_867 = "\\\" + 1";
  protected final String TEXT_868 = " FROM \\\"\" + " + NL + "    sourceTable_";
  protected final String TEXT_869 = " + \"\\\" t, \\\"\" + tableName_";
  protected final String TEXT_870 = " + \"\\\" d WHERE ";
  protected final String TEXT_871 = " AND (";
  protected final String TEXT_872 = ") AND d.\\\"";
  protected final String TEXT_873 = "\\\" = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_874 = "\"))) + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_875 = " = conn_";
  protected final String TEXT_876 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_877 = ".executeUpdate(insertForType2_";
  protected final String TEXT_878 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_879 = ".close();";
  protected final String TEXT_880 = NL + "        System.out.println(\"[";
  protected final String TEXT_881 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_882 = " + \"\\ndone\");";
  protected final String TEXT_883 = NL + "String insert_";
  protected final String TEXT_884 = " = \"INSERT INTO \\\"\" + tableName_";
  protected final String TEXT_885 = " + \"\\\"(";
  protected final String TEXT_886 = "\\\"";
  protected final String TEXT_887 = "\\\", ";
  protected final String TEXT_888 = ") SELECT ";
  protected final String TEXT_889 = "NEXTVAL('\" + ";
  protected final String TEXT_890 = " + \"'), ";
  protected final String TEXT_891 = "t.";
  protected final String TEXT_892 = "\"";
  protected final String TEXT_893 = " + \", '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_894 = "\"))) + \"', NULL\"";
  protected final String TEXT_895 = NL + "+ \"";
  protected final String TEXT_896 = ", 1";
  protected final String TEXT_897 = ", 1";
  protected final String TEXT_898 = " FROM \\\"\" + " + NL + "sourceTable_";
  protected final String TEXT_899 = " + \"\\\" t LEFT JOIN \\\"\" + tableName_";
  protected final String TEXT_900 = " + \"\\\" d ON ";
  protected final String TEXT_901 = " WHERE (";
  protected final String TEXT_902 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_903 = " = conn_";
  protected final String TEXT_904 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_905 = ".executeUpdate(insert_";
  protected final String TEXT_906 = ");" + NL + "stmtInsert_";
  protected final String TEXT_907 = ".close();";
  protected final String TEXT_908 = NL + "    System.out.println(\"[";
  protected final String TEXT_909 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_910 = " + \"\\ndone\");";
  protected final String TEXT_911 = NL;
  protected final String TEXT_912 = NL + "\t";
  protected final String TEXT_913 = NL;
  protected final String TEXT_914 = NL + "    String updateForType1_";
  protected final String TEXT_915 = " = \"UPDATE \\\"\" + tableName_";
  protected final String TEXT_916 = " + \"\\\" d SET (";
  protected final String TEXT_917 = ") = (SELECT ";
  protected final String TEXT_918 = " FROM \\\"\" + sourceTable_";
  protected final String TEXT_919 = " + \"\\\" t WHERE ";
  protected final String TEXT_920 = " AND (";
  protected final String TEXT_921 = ")) WHERE EXISTS (SELECT 1 FROM \\\"\" + sourceTable_";
  protected final String TEXT_922 = " + \"\\\" t WHERE ";
  protected final String TEXT_923 = " AND (";
  protected final String TEXT_924 = "))\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_925 = " = conn_";
  protected final String TEXT_926 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_927 = ".executeUpdate(updateForType1_";
  protected final String TEXT_928 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_929 = ".close();";
  protected final String TEXT_930 = NL + "        System.out.println(\"[";
  protected final String TEXT_931 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_932 = " + \"\\ndone\");";
  protected final String TEXT_933 = NL + "    String updateForType2_";
  protected final String TEXT_934 = " = \"UPDATE \\\"\" + tableName_";
  protected final String TEXT_935 = " + \"\\\" d SET \\\"";
  protected final String TEXT_936 = "\\\" = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_937 = "\"))) + \"'";
  protected final String TEXT_938 = ", \\\"";
  protected final String TEXT_939 = "\\\" = 0";
  protected final String TEXT_940 = " WHERE EXISTS (SELECT 1 FROM \\\"\" + sourceTable_";
  protected final String TEXT_941 = " + " + NL + "    \"\\\" t WHERE ";
  protected final String TEXT_942 = " AND (";
  protected final String TEXT_943 = ")) AND d.\\\"";
  protected final String TEXT_944 = "\\\" IS NULL\";" + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_945 = " = conn_";
  protected final String TEXT_946 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_947 = ".executeUpdate(updateForType2_";
  protected final String TEXT_948 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_949 = ".close();";
  protected final String TEXT_950 = NL + "        System.out.println(\"[";
  protected final String TEXT_951 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_952 = " + \"\\ndone\");";
  protected final String TEXT_953 = NL + "    String insertForType2_";
  protected final String TEXT_954 = " = \"INSERT INTO \\\"\" + tableName_";
  protected final String TEXT_955 = " + \"\\\"(";
  protected final String TEXT_956 = "\\\"";
  protected final String TEXT_957 = "\\\", ";
  protected final String TEXT_958 = ") SELECT ";
  protected final String TEXT_959 = "NEXT VALUE FOR \" + ";
  protected final String TEXT_960 = " + \", ";
  protected final String TEXT_961 = "t.";
  protected final String TEXT_962 = ", '\" + " + NL + "    (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_963 = "\"))) + \"', CAST(NULL AS ";
  protected final String TEXT_964 = ")";
  protected final String TEXT_965 = ", 1";
  protected final String TEXT_966 = ", d.\\\"";
  protected final String TEXT_967 = "\\\" + 1";
  protected final String TEXT_968 = " FROM \\\"\" + " + NL + "    sourceTable_";
  protected final String TEXT_969 = " + \"\\\" t, \\\"\" + tableName_";
  protected final String TEXT_970 = " + \"\\\" d WHERE ";
  protected final String TEXT_971 = " AND (";
  protected final String TEXT_972 = ") AND d.\\\"";
  protected final String TEXT_973 = "\\\" = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_974 = "\"))) + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_975 = " = conn_";
  protected final String TEXT_976 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_977 = ".executeUpdate(insertForType2_";
  protected final String TEXT_978 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_979 = ".close();";
  protected final String TEXT_980 = NL + "        System.out.println(\"[";
  protected final String TEXT_981 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_982 = " + \"\\ndone\");";
  protected final String TEXT_983 = NL + "String insert_";
  protected final String TEXT_984 = " = \"INSERT INTO \\\"\" + tableName_";
  protected final String TEXT_985 = " + \"\\\"(";
  protected final String TEXT_986 = "\\\"";
  protected final String TEXT_987 = "\\\", ";
  protected final String TEXT_988 = ") SELECT ";
  protected final String TEXT_989 = "NEXT VALUE FOR \" + ";
  protected final String TEXT_990 = " + \", ";
  protected final String TEXT_991 = "t.";
  protected final String TEXT_992 = "\"";
  protected final String TEXT_993 = " + \", '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_994 = "\"))) + \"', CAST(NULL AS ";
  protected final String TEXT_995 = ")\"";
  protected final String TEXT_996 = NL + "+ \"";
  protected final String TEXT_997 = ", 1";
  protected final String TEXT_998 = ", 1";
  protected final String TEXT_999 = " FROM \\\"\" + " + NL + "sourceTable_";
  protected final String TEXT_1000 = " + \"\\\" t LEFT JOIN \\\"\" + tableName_";
  protected final String TEXT_1001 = " + \"\\\" d ON ";
  protected final String TEXT_1002 = " WHERE (";
  protected final String TEXT_1003 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1004 = " = conn_";
  protected final String TEXT_1005 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1006 = ".executeUpdate(insert_";
  protected final String TEXT_1007 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1008 = ".close();";
  protected final String TEXT_1009 = NL + "    System.out.println(\"[";
  protected final String TEXT_1010 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1011 = " + \"\\ndone\");";
  protected final String TEXT_1012 = NL;
  protected final String TEXT_1013 = NL + "\t";
  protected final String TEXT_1014 = NL;
  protected final String TEXT_1015 = NL + "    String updateForType1_";
  protected final String TEXT_1016 = " = \"UPDATE \\\"\" + tableName_";
  protected final String TEXT_1017 = " + \"\\\" d SET ";
  protected final String TEXT_1018 = " FROM \\\"\" + sourceTable_";
  protected final String TEXT_1019 = " + \"\\\" t WHERE ";
  protected final String TEXT_1020 = " AND (";
  protected final String TEXT_1021 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_1022 = " = conn_";
  protected final String TEXT_1023 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_1024 = ".executeUpdate(updateForType1_";
  protected final String TEXT_1025 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_1026 = ".close();";
  protected final String TEXT_1027 = NL + "        System.out.println(\"[";
  protected final String TEXT_1028 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_1029 = " + \"\\ndone\");";
  protected final String TEXT_1030 = NL + "    String updateForType2_";
  protected final String TEXT_1031 = " = \"UPDATE \\\"\" + tableName_";
  protected final String TEXT_1032 = " + \"\\\" d SET \\\"";
  protected final String TEXT_1033 = "\\\" = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1034 = "\"))) + \"'";
  protected final String TEXT_1035 = ", \\\"";
  protected final String TEXT_1036 = "\\\" = 0";
  protected final String TEXT_1037 = " FROM \\\"\" + sourceTable_";
  protected final String TEXT_1038 = " + \"\\\" t WHERE ";
  protected final String TEXT_1039 = " AND (";
  protected final String TEXT_1040 = ") AND d.\\\"";
  protected final String TEXT_1041 = "\\\" IS NULL\";" + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_1042 = " = conn_";
  protected final String TEXT_1043 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_1044 = ".executeUpdate(updateForType2_";
  protected final String TEXT_1045 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_1046 = ".close();";
  protected final String TEXT_1047 = NL + "        System.out.println(\"[";
  protected final String TEXT_1048 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_1049 = " + \"\\ndone\");";
  protected final String TEXT_1050 = NL + "    String insertForType2_";
  protected final String TEXT_1051 = " = \"INSERT INTO \\\"\" + tableName_";
  protected final String TEXT_1052 = " + \"\\\"(";
  protected final String TEXT_1053 = "\\\"";
  protected final String TEXT_1054 = "\\\", ";
  protected final String TEXT_1055 = ") SELECT ";
  protected final String TEXT_1056 = "NEXTVAL('\" + ";
  protected final String TEXT_1057 = " + \"'), ";
  protected final String TEXT_1058 = "t.";
  protected final String TEXT_1059 = ", '\" + " + NL + "    (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1060 = "\"))) + \"', NULL";
  protected final String TEXT_1061 = ", 1";
  protected final String TEXT_1062 = ", d.\\\"";
  protected final String TEXT_1063 = "\\\" + 1";
  protected final String TEXT_1064 = " FROM \\\"\" + " + NL + "    sourceTable_";
  protected final String TEXT_1065 = " + \"\\\" t, \\\"\" + tableName_";
  protected final String TEXT_1066 = " + \"\\\" d WHERE ";
  protected final String TEXT_1067 = " AND (";
  protected final String TEXT_1068 = ") AND d.\\\"";
  protected final String TEXT_1069 = "\\\" = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1070 = "\"))) + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_1071 = " = conn_";
  protected final String TEXT_1072 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_1073 = ".executeUpdate(insertForType2_";
  protected final String TEXT_1074 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_1075 = ".close();";
  protected final String TEXT_1076 = NL + "        System.out.println(\"[";
  protected final String TEXT_1077 = "] type2 new active row sql\\n\" + insertForType2_";
  protected final String TEXT_1078 = " + \"\\ndone\");";
  protected final String TEXT_1079 = NL + "String insert_";
  protected final String TEXT_1080 = " = \"INSERT INTO \\\"\" + tableName_";
  protected final String TEXT_1081 = " + \"\\\"(";
  protected final String TEXT_1082 = "\\\"";
  protected final String TEXT_1083 = "\\\", ";
  protected final String TEXT_1084 = ") SELECT ";
  protected final String TEXT_1085 = "NEXTVAL('\" + ";
  protected final String TEXT_1086 = " + \"'), ";
  protected final String TEXT_1087 = "t.";
  protected final String TEXT_1088 = "\"";
  protected final String TEXT_1089 = " + \", '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1090 = "\"))) + \"', NULL\"";
  protected final String TEXT_1091 = NL + "+ \"";
  protected final String TEXT_1092 = ", 1";
  protected final String TEXT_1093 = ", 1";
  protected final String TEXT_1094 = " FROM \\\"\" + " + NL + "sourceTable_";
  protected final String TEXT_1095 = " + \"\\\" t LEFT JOIN \\\"\" + tableName_";
  protected final String TEXT_1096 = " + \"\\\" d ON ";
  protected final String TEXT_1097 = " WHERE (";
  protected final String TEXT_1098 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1099 = " = conn_";
  protected final String TEXT_1100 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1101 = ".executeUpdate(insert_";
  protected final String TEXT_1102 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1103 = ".close();";
  protected final String TEXT_1104 = NL + "    System.out.println(\"[";
  protected final String TEXT_1105 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1106 = " + \"\\ndone\");";
  protected final String TEXT_1107 = NL;
  protected final String TEXT_1108 = NL + "\t";
  protected final String TEXT_1109 = NL;
  protected final String TEXT_1110 = NL + "    String updateForType1_";
  protected final String TEXT_1111 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_1112 = " + \" SET ";
  protected final String TEXT_1113 = " FROM \" + sourceTable_";
  protected final String TEXT_1114 = " + \" t WHERE ";
  protected final String TEXT_1115 = " AND (";
  protected final String TEXT_1116 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_1117 = " = conn_";
  protected final String TEXT_1118 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_1119 = ".executeUpdate(updateForType1_";
  protected final String TEXT_1120 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_1121 = ".close();";
  protected final String TEXT_1122 = NL + "        System.out.println(\"[";
  protected final String TEXT_1123 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_1124 = " + \"\\ndone\");";
  protected final String TEXT_1125 = NL + "    String updateForType2_";
  protected final String TEXT_1126 = " = \"UPDATE \" + tableName_";
  protected final String TEXT_1127 = " + \" SET ";
  protected final String TEXT_1128 = " = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1129 = "\"))) + \"'";
  protected final String TEXT_1130 = ", ";
  protected final String TEXT_1131 = " = 0";
  protected final String TEXT_1132 = " FROM \" + sourceTable_";
  protected final String TEXT_1133 = " + \" t WHERE ";
  protected final String TEXT_1134 = " AND (";
  protected final String TEXT_1135 = ") AND \" + tableName_";
  protected final String TEXT_1136 = " + \".";
  protected final String TEXT_1137 = " IS NULL\";" + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_1138 = " = conn_";
  protected final String TEXT_1139 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_1140 = ".executeUpdate(updateForType2_";
  protected final String TEXT_1141 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_1142 = ".close();";
  protected final String TEXT_1143 = NL + "        System.out.println(\"[";
  protected final String TEXT_1144 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_1145 = " + \"\\ndone\");";
  protected final String TEXT_1146 = NL + "    String insertForType2_";
  protected final String TEXT_1147 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_1148 = " + \"(";
  protected final String TEXT_1149 = ", ";
  protected final String TEXT_1150 = ") SELECT ";
  protected final String TEXT_1151 = "\" + ";
  protected final String TEXT_1152 = " + \".NEXTVAL, ";
  protected final String TEXT_1153 = "t.";
  protected final String TEXT_1154 = ", '\" + " + NL + "    (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1155 = "\"))) + \"', NULL";
  protected final String TEXT_1156 = ", 1";
  protected final String TEXT_1157 = ", d.";
  protected final String TEXT_1158 = " + 1";
  protected final String TEXT_1159 = " FROM \" + " + NL + "    sourceTable_";
  protected final String TEXT_1160 = " + \" t, \" + tableName_";
  protected final String TEXT_1161 = " + \" d WHERE ";
  protected final String TEXT_1162 = " AND (";
  protected final String TEXT_1163 = ") AND d.";
  protected final String TEXT_1164 = " = '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1165 = "\"))) + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_1166 = " = conn_";
  protected final String TEXT_1167 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_1168 = ".executeUpdate(insertForType2_";
  protected final String TEXT_1169 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_1170 = ".close();";
  protected final String TEXT_1171 = NL + "        System.out.println(\"[";
  protected final String TEXT_1172 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_1173 = " + \"\\ndone\");";
  protected final String TEXT_1174 = NL + "String insert_";
  protected final String TEXT_1175 = " = \"INSERT INTO \" + tableName_";
  protected final String TEXT_1176 = " + \"(";
  protected final String TEXT_1177 = ", ";
  protected final String TEXT_1178 = ") SELECT ";
  protected final String TEXT_1179 = "\" + ";
  protected final String TEXT_1180 = " + \".NEXTVAL, ";
  protected final String TEXT_1181 = "t.";
  protected final String TEXT_1182 = "\"";
  protected final String TEXT_1183 = " + \", '\" + (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1184 = "\"))) + \"', NULL\"";
  protected final String TEXT_1185 = NL + "+ \"";
  protected final String TEXT_1186 = ", 1";
  protected final String TEXT_1187 = ", 1";
  protected final String TEXT_1188 = " FROM \" + " + NL + "sourceTable_";
  protected final String TEXT_1189 = " + \" t LEFT JOIN \" + tableName_";
  protected final String TEXT_1190 = " + \" d ON ";
  protected final String TEXT_1191 = " WHERE (";
  protected final String TEXT_1192 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1193 = " = conn_";
  protected final String TEXT_1194 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1195 = ".executeUpdate(insert_";
  protected final String TEXT_1196 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1197 = ".close();";
  protected final String TEXT_1198 = NL + "    System.out.println(\"[";
  protected final String TEXT_1199 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1200 = " + \"\\ndone\");";
  protected final String TEXT_1201 = NL;
  protected final String TEXT_1202 = NL + "\t";
  protected final String TEXT_1203 = NL;
  protected final String TEXT_1204 = NL + "    String updateForType1_";
  protected final String TEXT_1205 = " = \"UPDATE ";
  protected final String TEXT_1206 = " SET ";
  protected final String TEXT_1207 = " FROM ";
  protected final String TEXT_1208 = " d, ";
  protected final String TEXT_1209 = " t WHERE ";
  protected final String TEXT_1210 = " AND (";
  protected final String TEXT_1211 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_1212 = " = conn_";
  protected final String TEXT_1213 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_1214 = ".executeUpdate(updateForType1_";
  protected final String TEXT_1215 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_1216 = ".close();";
  protected final String TEXT_1217 = NL + "        System.out.println(\"[";
  protected final String TEXT_1218 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_1219 = " + \"\\ndone\");";
  protected final String TEXT_1220 = "        " + NL + "    String changeDateTime_";
  protected final String TEXT_1221 = " = (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1222 = "\"))).toString();" + NL + "\t" + NL + "    String updateForType2_";
  protected final String TEXT_1223 = " = \"UPDATE ";
  protected final String TEXT_1224 = " SET ";
  protected final String TEXT_1225 = " = '\" + (changeDateTime_";
  protected final String TEXT_1226 = ") + \"'";
  protected final String TEXT_1227 = ", ";
  protected final String TEXT_1228 = " = 0";
  protected final String TEXT_1229 = " FROM ";
  protected final String TEXT_1230 = " d, ";
  protected final String TEXT_1231 = " t WHERE ";
  protected final String TEXT_1232 = " AND (";
  protected final String TEXT_1233 = ") AND d.";
  protected final String TEXT_1234 = " IS NULL\"; " + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_1235 = " = conn_";
  protected final String TEXT_1236 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_1237 = ".executeUpdate(updateForType2_";
  protected final String TEXT_1238 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_1239 = ".close();";
  protected final String TEXT_1240 = NL + "        System.out.println(\"[";
  protected final String TEXT_1241 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_1242 = " + \"\\ndone\");";
  protected final String TEXT_1243 = NL + "    String insertForType2_";
  protected final String TEXT_1244 = " = \"INSERT INTO ";
  protected final String TEXT_1245 = "(";
  protected final String TEXT_1246 = ", ";
  protected final String TEXT_1247 = ") SELECT \" + ";
  protected final String TEXT_1248 = "sequenceValueFetchPattern_";
  protected final String TEXT_1249 = " + \", \" + ";
  protected final String TEXT_1250 = "\" t.";
  protected final String TEXT_1251 = ", '\" + " + NL + "    (changeDateTime_";
  protected final String TEXT_1252 = ") + \"', NULL";
  protected final String TEXT_1253 = ", 1";
  protected final String TEXT_1254 = ", d.";
  protected final String TEXT_1255 = " + 1";
  protected final String TEXT_1256 = " FROM ";
  protected final String TEXT_1257 = " t, ";
  protected final String TEXT_1258 = " d WHERE ";
  protected final String TEXT_1259 = " AND (";
  protected final String TEXT_1260 = ") AND d.";
  protected final String TEXT_1261 = " = '\" + (changeDateTime_";
  protected final String TEXT_1262 = ") + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_1263 = " = conn_";
  protected final String TEXT_1264 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_1265 = ".executeUpdate(insertForType2_";
  protected final String TEXT_1266 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_1267 = ".close();";
  protected final String TEXT_1268 = NL + "        System.out.println(\"[";
  protected final String TEXT_1269 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_1270 = " + \"\\ndone\");";
  protected final String TEXT_1271 = NL + "String insert_";
  protected final String TEXT_1272 = " = \"INSERT INTO ";
  protected final String TEXT_1273 = "(";
  protected final String TEXT_1274 = ", ";
  protected final String TEXT_1275 = ") SELECT \" + ";
  protected final String TEXT_1276 = "sequenceValueFetchPattern_";
  protected final String TEXT_1277 = " + \", \" + ";
  protected final String TEXT_1278 = "\" t.";
  protected final String TEXT_1279 = "\"";
  protected final String TEXT_1280 = " + \", '\" + (changeDateTime_";
  protected final String TEXT_1281 = ") + \"', NULL\"";
  protected final String TEXT_1282 = NL + "+ \"";
  protected final String TEXT_1283 = ", 1";
  protected final String TEXT_1284 = ", 1";
  protected final String TEXT_1285 = " FROM ";
  protected final String TEXT_1286 = " t LEFT JOIN ";
  protected final String TEXT_1287 = " d ON ";
  protected final String TEXT_1288 = " WHERE (";
  protected final String TEXT_1289 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1290 = " = conn_";
  protected final String TEXT_1291 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1292 = ".executeUpdate(insert_";
  protected final String TEXT_1293 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1294 = ".close();";
  protected final String TEXT_1295 = NL + "    System.out.println(\"[";
  protected final String TEXT_1296 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1297 = " + \"\\ndone\");";
  protected final String TEXT_1298 = NL + "\t";
  protected final String TEXT_1299 = NL;
  protected final String TEXT_1300 = NL + "    String updateForType1_";
  protected final String TEXT_1301 = " = \"UPDATE ";
  protected final String TEXT_1302 = " d SET ";
  protected final String TEXT_1303 = " FROM ";
  protected final String TEXT_1304 = " t WHERE ";
  protected final String TEXT_1305 = " AND (";
  protected final String TEXT_1306 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_1307 = " = conn_";
  protected final String TEXT_1308 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_1309 = ".executeUpdate(updateForType1_";
  protected final String TEXT_1310 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_1311 = ".close();";
  protected final String TEXT_1312 = NL + "        System.out.println(\"[";
  protected final String TEXT_1313 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_1314 = " + \"\\ndone\");";
  protected final String TEXT_1315 = "        " + NL + "    String changeDateTime_";
  protected final String TEXT_1316 = " = (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1317 = "\"))).toString();" + NL + "\t" + NL + "    String updateForType2_";
  protected final String TEXT_1318 = " = \"UPDATE ";
  protected final String TEXT_1319 = " d SET ";
  protected final String TEXT_1320 = " = '\" + (changeDateTime_";
  protected final String TEXT_1321 = ") + \"'";
  protected final String TEXT_1322 = ", ";
  protected final String TEXT_1323 = " = 0";
  protected final String TEXT_1324 = " FROM ";
  protected final String TEXT_1325 = " t WHERE ";
  protected final String TEXT_1326 = " AND (";
  protected final String TEXT_1327 = ") AND d.";
  protected final String TEXT_1328 = " IS NULL\"; " + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_1329 = " = conn_";
  protected final String TEXT_1330 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_1331 = ".executeUpdate(updateForType2_";
  protected final String TEXT_1332 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_1333 = ".close();";
  protected final String TEXT_1334 = NL + "        System.out.println(\"[";
  protected final String TEXT_1335 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_1336 = " + \"\\ndone\");";
  protected final String TEXT_1337 = NL + "    String insertForType2_";
  protected final String TEXT_1338 = " = \"INSERT INTO ";
  protected final String TEXT_1339 = "(";
  protected final String TEXT_1340 = ", ";
  protected final String TEXT_1341 = ") SELECT \" + ";
  protected final String TEXT_1342 = "sequenceValueFetchPattern_";
  protected final String TEXT_1343 = " + \", \" + ";
  protected final String TEXT_1344 = "\" t.";
  protected final String TEXT_1345 = ", '\" + " + NL + "    (changeDateTime_";
  protected final String TEXT_1346 = ") + \"', NULL";
  protected final String TEXT_1347 = ", 1";
  protected final String TEXT_1348 = ", d.";
  protected final String TEXT_1349 = " + 1";
  protected final String TEXT_1350 = " FROM ";
  protected final String TEXT_1351 = " t, ";
  protected final String TEXT_1352 = " d WHERE ";
  protected final String TEXT_1353 = " AND (";
  protected final String TEXT_1354 = ") AND d.";
  protected final String TEXT_1355 = " = '\" + (changeDateTime_";
  protected final String TEXT_1356 = ") + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_1357 = " = conn_";
  protected final String TEXT_1358 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_1359 = ".executeUpdate(insertForType2_";
  protected final String TEXT_1360 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_1361 = ".close();";
  protected final String TEXT_1362 = NL + "        System.out.println(\"[";
  protected final String TEXT_1363 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_1364 = " + \"\\ndone\");";
  protected final String TEXT_1365 = NL + "String insert_";
  protected final String TEXT_1366 = " = \"INSERT INTO ";
  protected final String TEXT_1367 = "(";
  protected final String TEXT_1368 = ", ";
  protected final String TEXT_1369 = ") SELECT \" + ";
  protected final String TEXT_1370 = "sequenceValueFetchPattern_";
  protected final String TEXT_1371 = " + \", \" + ";
  protected final String TEXT_1372 = "\" t.";
  protected final String TEXT_1373 = "\"";
  protected final String TEXT_1374 = " + \", '\" + (changeDateTime_";
  protected final String TEXT_1375 = ") + \"', NULL\"";
  protected final String TEXT_1376 = NL + "+ \"";
  protected final String TEXT_1377 = ", 1";
  protected final String TEXT_1378 = ", 1";
  protected final String TEXT_1379 = " FROM ";
  protected final String TEXT_1380 = " t LEFT JOIN ";
  protected final String TEXT_1381 = " d ON ";
  protected final String TEXT_1382 = " WHERE (";
  protected final String TEXT_1383 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1384 = " = conn_";
  protected final String TEXT_1385 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1386 = ".executeUpdate(insert_";
  protected final String TEXT_1387 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1388 = ".close();";
  protected final String TEXT_1389 = NL + "    System.out.println(\"[";
  protected final String TEXT_1390 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1391 = " + \"\\ndone\");";
  protected final String TEXT_1392 = NL + "\t";
  protected final String TEXT_1393 = NL;
  protected final String TEXT_1394 = NL + "sequenceValueFetchPattern_";
  protected final String TEXT_1395 = " = \"NEXTVAL(\\'\"+sequence_";
  protected final String TEXT_1396 = "+\"\\')\";";
  protected final String TEXT_1397 = NL + "    String updateForType1_";
  protected final String TEXT_1398 = " = \"UPDATE ";
  protected final String TEXT_1399 = " SET ";
  protected final String TEXT_1400 = " FROM ";
  protected final String TEXT_1401 = " t WHERE ";
  protected final String TEXT_1402 = " AND (";
  protected final String TEXT_1403 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_1404 = " = conn_";
  protected final String TEXT_1405 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_1406 = ".executeUpdate(updateForType1_";
  protected final String TEXT_1407 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_1408 = ".close();";
  protected final String TEXT_1409 = NL + "        System.out.println(\"[";
  protected final String TEXT_1410 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_1411 = " + \"\\ndone\");";
  protected final String TEXT_1412 = "        " + NL + "    String changeDateTime_";
  protected final String TEXT_1413 = " = (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1414 = "\"))).toString();" + NL + "\t//joinClauseString : ";
  protected final String TEXT_1415 = NL + "\t//whereClauseString : ";
  protected final String TEXT_1416 = NL + "    String updateForType2_";
  protected final String TEXT_1417 = " = \"UPDATE ";
  protected final String TEXT_1418 = " SET ";
  protected final String TEXT_1419 = " = '\" + " + NL + "    (changeDateTime_";
  protected final String TEXT_1420 = ") + \"'";
  protected final String TEXT_1421 = ", ";
  protected final String TEXT_1422 = " = 0";
  protected final String TEXT_1423 = " FROM ";
  protected final String TEXT_1424 = " t WHERE ";
  protected final String TEXT_1425 = " AND (";
  protected final String TEXT_1426 = ") AND ";
  protected final String TEXT_1427 = ".";
  protected final String TEXT_1428 = " IS NULL\"; " + NL + "" + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_1429 = " = conn_";
  protected final String TEXT_1430 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_1431 = ".executeUpdate(updateForType2_";
  protected final String TEXT_1432 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_1433 = ".close();";
  protected final String TEXT_1434 = NL + "        System.out.println(\"[";
  protected final String TEXT_1435 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_1436 = " + \"\\ndone\");";
  protected final String TEXT_1437 = NL + "    String insertForType2_";
  protected final String TEXT_1438 = " = \"INSERT INTO ";
  protected final String TEXT_1439 = "(";
  protected final String TEXT_1440 = ", ";
  protected final String TEXT_1441 = ") SELECT \" + ";
  protected final String TEXT_1442 = "sequenceValueFetchPattern_";
  protected final String TEXT_1443 = " + \", \" + ";
  protected final String TEXT_1444 = "\" t.";
  protected final String TEXT_1445 = ", '\" + " + NL + "    (changeDateTime_";
  protected final String TEXT_1446 = ") + \"', NULL";
  protected final String TEXT_1447 = ", 1";
  protected final String TEXT_1448 = ", ";
  protected final String TEXT_1449 = ".";
  protected final String TEXT_1450 = " + 1";
  protected final String TEXT_1451 = " FROM ";
  protected final String TEXT_1452 = " t,";
  protected final String TEXT_1453 = " WHERE ";
  protected final String TEXT_1454 = " AND (";
  protected final String TEXT_1455 = ") AND ";
  protected final String TEXT_1456 = ".";
  protected final String TEXT_1457 = " = '\" + (changeDateTime_";
  protected final String TEXT_1458 = ") + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_1459 = " = conn_";
  protected final String TEXT_1460 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_1461 = ".executeUpdate(insertForType2_";
  protected final String TEXT_1462 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_1463 = ".close();";
  protected final String TEXT_1464 = NL + "        System.out.println(\"[";
  protected final String TEXT_1465 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_1466 = " + \"\\ndone\");";
  protected final String TEXT_1467 = NL + "String insert_";
  protected final String TEXT_1468 = " = \"INSERT INTO ";
  protected final String TEXT_1469 = "(";
  protected final String TEXT_1470 = ", ";
  protected final String TEXT_1471 = ") SELECT \" + ";
  protected final String TEXT_1472 = "sequenceValueFetchPattern_";
  protected final String TEXT_1473 = " + \", \" + ";
  protected final String TEXT_1474 = "\" t.";
  protected final String TEXT_1475 = "\"";
  protected final String TEXT_1476 = " + \", '\" + (changeDateTime_";
  protected final String TEXT_1477 = ") + \"', NULL\"";
  protected final String TEXT_1478 = NL + "+ \"";
  protected final String TEXT_1479 = ", 1";
  protected final String TEXT_1480 = ", 1";
  protected final String TEXT_1481 = " FROM ";
  protected final String TEXT_1482 = " t LEFT JOIN ";
  protected final String TEXT_1483 = " ON ";
  protected final String TEXT_1484 = " WHERE (";
  protected final String TEXT_1485 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1486 = " = conn_";
  protected final String TEXT_1487 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1488 = ".executeUpdate(insert_";
  protected final String TEXT_1489 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1490 = ".close();";
  protected final String TEXT_1491 = NL + "    System.out.println(\"[";
  protected final String TEXT_1492 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1493 = " + \"\\ndone\");";
  protected final String TEXT_1494 = NL;
  protected final String TEXT_1495 = NL + "    String updateForType1_";
  protected final String TEXT_1496 = " = \"UPDATE ";
  protected final String TEXT_1497 = " d SET ";
  protected final String TEXT_1498 = " FROM ";
  protected final String TEXT_1499 = " d, ";
  protected final String TEXT_1500 = " t WHERE ";
  protected final String TEXT_1501 = " AND (";
  protected final String TEXT_1502 = ")\";" + NL + "    " + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_1503 = " = conn_";
  protected final String TEXT_1504 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_1505 = ".executeUpdate(updateForType1_";
  protected final String TEXT_1506 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_1507 = ".close();";
  protected final String TEXT_1508 = NL + "        System.out.println(\"[";
  protected final String TEXT_1509 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_1510 = " + \"\\ndone\");";
  protected final String TEXT_1511 = "        " + NL + "    String changeDateTime_";
  protected final String TEXT_1512 = " = (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1513 = "\"))).toString();" + NL + "\t" + NL + "    String updateForType2_";
  protected final String TEXT_1514 = " = \"UPDATE ";
  protected final String TEXT_1515 = " d SET ";
  protected final String TEXT_1516 = " = '\" + (changeDateTime_";
  protected final String TEXT_1517 = ") + \"'";
  protected final String TEXT_1518 = ", ";
  protected final String TEXT_1519 = " = 0";
  protected final String TEXT_1520 = " FROM  ";
  protected final String TEXT_1521 = " d, ";
  protected final String TEXT_1522 = " t WHERE ";
  protected final String TEXT_1523 = " AND (";
  protected final String TEXT_1524 = ") AND d.";
  protected final String TEXT_1525 = " IS NULL\"; " + NL + " " + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_1526 = " = conn_";
  protected final String TEXT_1527 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_1528 = ".executeUpdate(updateForType2_";
  protected final String TEXT_1529 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_1530 = ".close();";
  protected final String TEXT_1531 = NL + "        System.out.println(\"[";
  protected final String TEXT_1532 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_1533 = " + \"\\ndone\");";
  protected final String TEXT_1534 = NL + "    String insertForType2_";
  protected final String TEXT_1535 = " = \"INSERT INTO ";
  protected final String TEXT_1536 = " (";
  protected final String TEXT_1537 = ", ";
  protected final String TEXT_1538 = ") SELECT \" + ";
  protected final String TEXT_1539 = "sequenceValueFetchPattern_";
  protected final String TEXT_1540 = " + \", \" + ";
  protected final String TEXT_1541 = "\" t.";
  protected final String TEXT_1542 = ", '\" + " + NL + "    (changeDateTime_";
  protected final String TEXT_1543 = ") + \"', NULL";
  protected final String TEXT_1544 = ", 1";
  protected final String TEXT_1545 = ", d.";
  protected final String TEXT_1546 = " + 1";
  protected final String TEXT_1547 = " FROM ";
  protected final String TEXT_1548 = " t, ";
  protected final String TEXT_1549 = " d WHERE ";
  protected final String TEXT_1550 = " AND (";
  protected final String TEXT_1551 = ") AND d.";
  protected final String TEXT_1552 = " = '\" + (changeDateTime_";
  protected final String TEXT_1553 = ") + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_1554 = " = conn_";
  protected final String TEXT_1555 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_1556 = ".executeUpdate(insertForType2_";
  protected final String TEXT_1557 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_1558 = ".close();";
  protected final String TEXT_1559 = NL + "        System.out.println(\"[";
  protected final String TEXT_1560 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_1561 = " + \"\\ndone\");";
  protected final String TEXT_1562 = NL + "String insert_";
  protected final String TEXT_1563 = " = \"INSERT INTO ";
  protected final String TEXT_1564 = " (";
  protected final String TEXT_1565 = ", ";
  protected final String TEXT_1566 = ") SELECT \" + ";
  protected final String TEXT_1567 = "sequenceValueFetchPattern_";
  protected final String TEXT_1568 = " + \", \" + ";
  protected final String TEXT_1569 = "\" t.";
  protected final String TEXT_1570 = "\"";
  protected final String TEXT_1571 = " + \", '\" + (changeDateTime_";
  protected final String TEXT_1572 = ") + \"', NULL\"";
  protected final String TEXT_1573 = NL + "+ \"";
  protected final String TEXT_1574 = ", 1";
  protected final String TEXT_1575 = ", 1";
  protected final String TEXT_1576 = " FROM ";
  protected final String TEXT_1577 = " t LEFT JOIN ";
  protected final String TEXT_1578 = " d ON ";
  protected final String TEXT_1579 = " WHERE (";
  protected final String TEXT_1580 = ")\";" + NL + "" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1581 = " = conn_";
  protected final String TEXT_1582 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1583 = ".executeUpdate(insert_";
  protected final String TEXT_1584 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1585 = ".close();";
  protected final String TEXT_1586 = NL + "    System.out.println(\"[";
  protected final String TEXT_1587 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1588 = " + \"\\ndone\");";
  protected final String TEXT_1589 = NL + "\t";
  protected final String TEXT_1590 = NL;
  protected final String TEXT_1591 = NL + "    String updateForType1_";
  protected final String TEXT_1592 = " = \"UPDATE ";
  protected final String TEXT_1593 = " SET ";
  protected final String TEXT_1594 = " FROM ";
  protected final String TEXT_1595 = " d, ";
  protected final String TEXT_1596 = " t WHERE ";
  protected final String TEXT_1597 = " AND (";
  protected final String TEXT_1598 = ")\";" + NL + "    java.sql.Statement stmtType1Update_";
  protected final String TEXT_1599 = " = conn_";
  protected final String TEXT_1600 = ".createStatement();" + NL + "    stmtType1Update_";
  protected final String TEXT_1601 = ".executeUpdate(updateForType1_";
  protected final String TEXT_1602 = ");" + NL + "    stmtType1Update_";
  protected final String TEXT_1603 = ".close();";
  protected final String TEXT_1604 = NL + "        System.out.println(\"[";
  protected final String TEXT_1605 = "] type1 update sql\\n\" + updateForType1_";
  protected final String TEXT_1606 = " + \"\\ndone\");";
  protected final String TEXT_1607 = "        " + NL + "    String changeDateTime_";
  protected final String TEXT_1608 = " = (new java.sql.Timestamp((Long)start_Hash.get(\"";
  protected final String TEXT_1609 = "\"))).toString();" + NL + "\t" + NL + "    String updateForType2_";
  protected final String TEXT_1610 = " = \"UPDATE ";
  protected final String TEXT_1611 = " SET ";
  protected final String TEXT_1612 = " = '\" + (changeDateTime_";
  protected final String TEXT_1613 = ") + \"'";
  protected final String TEXT_1614 = ", ";
  protected final String TEXT_1615 = " = 0";
  protected final String TEXT_1616 = " FROM ";
  protected final String TEXT_1617 = " d, ";
  protected final String TEXT_1618 = " t WHERE ";
  protected final String TEXT_1619 = " AND (";
  protected final String TEXT_1620 = ") AND d.";
  protected final String TEXT_1621 = " IS NULL\"; " + NL + "    java.sql.Statement stmtType2Update_";
  protected final String TEXT_1622 = " = conn_";
  protected final String TEXT_1623 = ".createStatement();" + NL + "    stmtType2Update_";
  protected final String TEXT_1624 = ".executeUpdate(updateForType2_";
  protected final String TEXT_1625 = ");" + NL + "    stmtType2Update_";
  protected final String TEXT_1626 = ".close();";
  protected final String TEXT_1627 = NL + "        System.out.println(\"[";
  protected final String TEXT_1628 = "] type2 update sql\\n\" + updateForType2_";
  protected final String TEXT_1629 = " + \"\\ndone\");";
  protected final String TEXT_1630 = NL + "    String insertForType2_";
  protected final String TEXT_1631 = " = \"INSERT INTO ";
  protected final String TEXT_1632 = "(";
  protected final String TEXT_1633 = ", ";
  protected final String TEXT_1634 = ") SELECT \" + ";
  protected final String TEXT_1635 = "sequenceValueFetchPattern_";
  protected final String TEXT_1636 = " + \", \" + ";
  protected final String TEXT_1637 = "\" t.";
  protected final String TEXT_1638 = ", '\" + " + NL + "    (changeDateTime_";
  protected final String TEXT_1639 = ") + \"', NULL";
  protected final String TEXT_1640 = ", 1";
  protected final String TEXT_1641 = ", d.";
  protected final String TEXT_1642 = " + 1";
  protected final String TEXT_1643 = " FROM ";
  protected final String TEXT_1644 = " t, ";
  protected final String TEXT_1645 = " d WHERE ";
  protected final String TEXT_1646 = " AND (";
  protected final String TEXT_1647 = ") AND d.";
  protected final String TEXT_1648 = " = '\" + (changeDateTime_";
  protected final String TEXT_1649 = ") + \"'\";" + NL + "    java.sql.Statement stmtType2Insert_";
  protected final String TEXT_1650 = " = conn_";
  protected final String TEXT_1651 = ".createStatement();" + NL + "    stmtType2Insert_";
  protected final String TEXT_1652 = ".executeUpdate(insertForType2_";
  protected final String TEXT_1653 = ");" + NL + "    stmtType2Insert_";
  protected final String TEXT_1654 = ".close();";
  protected final String TEXT_1655 = NL + "        System.out.println(\"[";
  protected final String TEXT_1656 = "] type2 new active row slq\\n\" + insertForType2_";
  protected final String TEXT_1657 = " + \"\\ndone\");";
  protected final String TEXT_1658 = NL + "String insert_";
  protected final String TEXT_1659 = " = \"INSERT INTO ";
  protected final String TEXT_1660 = "(";
  protected final String TEXT_1661 = ", ";
  protected final String TEXT_1662 = ") SELECT \" + ";
  protected final String TEXT_1663 = "sequenceValueFetchPattern_";
  protected final String TEXT_1664 = " + \", \" + ";
  protected final String TEXT_1665 = "\" t.";
  protected final String TEXT_1666 = "\"";
  protected final String TEXT_1667 = " + \", '\" + (changeDateTime_";
  protected final String TEXT_1668 = ") + \"', NULL\"";
  protected final String TEXT_1669 = NL + "+ \"";
  protected final String TEXT_1670 = ", 1";
  protected final String TEXT_1671 = ", 1";
  protected final String TEXT_1672 = " FROM ";
  protected final String TEXT_1673 = " t LEFT JOIN ";
  protected final String TEXT_1674 = " d ON ";
  protected final String TEXT_1675 = " WHERE (";
  protected final String TEXT_1676 = ")\";" + NL + "java.sql.Statement stmtInsert_";
  protected final String TEXT_1677 = " = conn_";
  protected final String TEXT_1678 = ".createStatement();" + NL + "stmtInsert_";
  protected final String TEXT_1679 = ".executeUpdate(insert_";
  protected final String TEXT_1680 = ");" + NL + "stmtInsert_";
  protected final String TEXT_1681 = ".close();";
  protected final String TEXT_1682 = NL + "    System.out.println(\"[";
  protected final String TEXT_1683 = "] new rows sql\\n\" + insert_";
  protected final String TEXT_1684 = " + \"\\ndone\");";

    public static final String INSERT_COLUMN_NAME = "insertColName";
    public static final String INSERT_VALUE_STMT = "insertValueStmt";
    public static final String UPDATE_SET_STMT = "updateSetStmt";
    public static final String UPDATE_WHERE_STMT = "updateWhereStmt";
    public static final String DELETE_WHERE_STMT = "deleteWhereStmt";
    public static final String FIRST_UPDATE_KEY = "firstUpdateKeyColumn";
    public static final String FIRST_DELETE_KEY = "firstDeleteKeyColumn";
    public static final String FIRST_INSERT_COLUMN = "firstInsertColumn";
    public static final String FIRST_UPDATE_COLUMN = "firstUpdateColumn";
    public static final int NORMAL_TYPE = 0;
    public static final int INSERT_TYPE = 1;
    public static final int UPDATE_TYPE = 2;
    public static final String ACCESS = "access_id";
    public static final String AS400 = "as400_id";
    public static final String DB2 = "ibmdb2_id";
    public static final String FIREBIRD = "firebird_id";
    public static final String GREENPLUM = "greenplum_id";
    public static final String HSQLDB = "hsqldb_id";
    public static final String HIVE = "hive_id";
    public static final String INFORMIX = "informix_id";
    public static final String INGRES = "ingres_id";
    public static final String VECTORWISE = "vectorwise_id";
    public static final String INTERBASE = "interbase_id";
    public static final String JAVADB = "javadb_id";
    public static final String MAXDB = "maxdb_id";
    public static final String MSSQL = "id_MSSQL";
    public static final String MYSQL = "mysql_id";
    public static final String NETEZZA = "netezza_id";
    public static final String ORACLE = "oracle_id";
    public static final String PARACCEL = "paraccel_id";
    public static final String POSTGRESQL = "postgres_id";
    public static final String REDSHIFT = "redshift_id";
    public static final String POSTGREPLUS = "postgresplus_id";
    public static final String SQLITE = "sqlite_id";
    public static final String SYBASE = "sybase_id";
    public static final String SNOWFLAKE = "snowflake_id";
    public static final String TERADATA = "teradata_id";
    public static final String VERTICA = "vertica_id";
    public static final String ODBC = "MSODBC";
    public static final String JDBC = "JDBC";
    public static final String EXASOL = "Exasol_id";
    public static final String SAPHANA = "saphana_id";
    private static Map<String, Manager> managerMap = new HashMap<String, Manager>();
    public class Column {
        IMetadataColumn column;
        String name;
        String dataType;
        String operator;
        String columnName;
        String sqlStmt;
        String value;
        boolean addCol;
        boolean isKey;
        boolean isAutoIncrement;
        int startValue;
        int step;
        boolean isUpdateKey;
        boolean isDeleteKey;
        boolean insertable = true;
        boolean updatable = true;
        List<Column> replacement = new ArrayList<Column>();
        
        boolean isDynamic = false;
        
        public Column(String colName, String sqlStmt, boolean addCol) {
            this.column = null;
            this.name = colName;
            this.columnName = colName;
            this.sqlStmt = sqlStmt;
            this.value = "?";
            this.addCol = addCol;
        }
        public Column(IMetadataColumn column) {
            this.column = column;
            this.name = column.getLabel();
            this.sqlStmt = "?";
            this.value = "?";
            this.addCol = false;
            this.columnName = column.getOriginalDbColumnName();
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            this(column, isKey, useFieldOptions, fieldOption);
            if(isSpecifyIdentityKey) {
                if(column.getLabel().equals(identityKey)) {
                    isAutoIncrement = false;
                    this.startValue = startValue;
                    this.step = step;
                }
            }
        }
        public Column(IMetadataColumn column, boolean isKey, boolean useFieldOptions, Map<String, String> fieldOption) {
            this(column);
            this.isKey = isKey;
            if(useFieldOptions) {
                this.isUpdateKey = fieldOption.get("UPDATE_KEY").equals("true");
                this.isDeleteKey = fieldOption.get("DELETE_KEY").equals("true");
                this.insertable = fieldOption.get("INSERTABLE").equals("true");
                this.updatable = fieldOption.get("UPDATABLE").equals("true");                
            } else {
                this.insertable = true;
                if (isKey) {
                    this.isUpdateKey = true;
                    this.isDeleteKey = true;
                    this.updatable = false;
                }
                else {
                    this.isUpdateKey = false;
                    this.isDeleteKey = false;
                    this.updatable = true;
                }                
            }
        }
        public boolean isReplaced() {
            return replacement.size() > 0;
        }
        public void replace(Column column) {
            this.replacement.add(column);
        }
        public List<Column> getReplacement() {
            return this.replacement;
        }
        public void setColumn(IMetadataColumn column) {
            this.column = column;
        }
        public IMetadataColumn getColumn() {
            return this.column;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }
        public String getColumnName() {
            return this.columnName;
        }
        public void setIsAddCol(boolean isadd) {
            this.addCol = isadd;
        }
        public boolean isAddCol() {
            return this.addCol;
        }
        public void setSqlStmt(String sql) {
            this.sqlStmt = sql;
        }
        public String getSqlStmt() {
            if(this.getColumn()!=null) {
                if (this.getColumn().getTalendType().equals("id_Geometry")) {
                    
                    if ("MDSYS.SDO_GEOMETRY".equalsIgnoreCase(this.getColumn().getType())) {
                        return "?";
                    } else {
                        return "GeomFromText(?, ?)";    // For PostGIS
                    }
                } else {
                    return this.sqlStmt;
                }
            } else {
                return this.sqlStmt;
            }
        }
        public void setValue(String value) {
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }
        public void setDataType(String dataType) {
            this.dataType = dataType;
        }
        public String getDataType() {
            return dataType;
        }
        public void setOperator(String operator) {
            this.operator = operator;
        }
        public String getOperator() {
            return operator;
        }
        public boolean isAutoIncrement() {
            return this.isAutoIncrement;
        }
        public void setAutoIncrement(boolean isAutoIncrement) {
            this.isAutoIncrement = isAutoIncrement;
        }
        public int getStartValue() {
            return this.startValue;
        }
        public void setStartValue(int startValue) {
            this.startValue = startValue;
        }
        public int getStep() {
            return this.step;
        }
        public void setStep(int step) {
            this.step = step;
        }
        public boolean isKey() {
            return this.isKey;
        }
        public void setKey(boolean isKey) {
            this.isKey = isKey;
        }
        public boolean isUpdateKey() {
            return this.isUpdateKey;
        }
        public void setUpdateKey(boolean isUpdateKey) {
            this.isUpdateKey = isUpdateKey;
        }
        public boolean isDeleteKey() {
            return this.isDeleteKey;
        }
        public void setDeleteKey(boolean isDeleteKey) {
            this.isDeleteKey = isDeleteKey;
        }
        public boolean isInsertable() {
            return this.insertable;
        }
        public void setInsertable(boolean insertable) {
            this.insertable = insertable;
        }
        public boolean isUpdatable() {
            return this.updatable;
        }
        public void setUpdatable(boolean updatable) {
            this.updatable = updatable;
        }
        
        public boolean isDynamic() {
            return isDynamic;
        }
        
        public void setDynamic(boolean isDynamic) {
            this.isDynamic = isDynamic;
        }
    }
        
    public Column getColumn(IMetadataColumn column) {
        return new Column(column);
    }

    public Column getColumn(String colName, String sqlStmt, boolean addCol) {
        return new Column(colName, sqlStmt, addCol);
    }
    
    public Column getColumn(IMetadataColumn column, boolean isKey, boolean useFieldsOptions, Map<String, String> fieldOption) {
        return new Column(column, isKey, useFieldsOptions, fieldOption);
    }

    public abstract class Manager {
        
        protected INode node;// add the Node, it will be more convenient
        public void setNode(INode node) {
           this.node = node;
        }
        
        protected String cid;        
        protected abstract String getDBMSId();
        protected abstract String getLProtectedChar();
        protected abstract String getRProtectedChar();        
        public Manager() {}
        public Manager(String cid) {
            this.cid = cid;
        }
      protected  String getLProtectedChar(String columName) {
          return getLProtectedChar();
      }
      protected  String getRProtectedChar(String columName) {
          return getRProtectedChar();        
      }
      protected boolean contaionsSpaces(String columnName) {
          if (columnName != null) {
              if (columnName.startsWith("\" + ") && columnName.endsWith(" + \"")) {
                  return false;
              }
              
              if (columnName.contains(" ")) {
                  return true;
              }
              // minus are also a problem
              if (columnName.contains("-")) {
                  return true;
              }
          }
          return false;
      }

        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(1) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }
        public String getDeleteTableSQL() {
            StringBuilder deleteTableSQL = new StringBuilder();
            deleteTableSQL.append("DELETE FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return deleteTableSQL.toString();
        }
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return truncateTableSQL.toString();
        }
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE " + getRProtectedChar());
            return truncate_reuse_stroage_TableSQL.toString();
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else if(ORACLE.equalsIgnoreCase(getDBMSId()) && dataType.matches("TIMESTAMP WITH TIME ZONE")){
                            createSQL.append("TIMESTAMP("+length+") WITH TIME ZONE");
                        }else{                            
                            createSQL.append(dataType);
                        }
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if (((MYSQL.equalsIgnoreCase(getDBMSId()))||(AS400.equalsIgnoreCase(getDBMSId())))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else if ((SNOWFLAKE.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("NUMBER".equalsIgnoreCase(dataType)))||("VARCHAR".equalsIgnoreCase(dataType))
                                    || ("CHAR".equalsIgnoreCase(dataType))||(("CHARACTER".equalsIgnoreCase(dataType)))||("STRING".equalsIgnoreCase(dataType))|| ("TEXT".equalsIgnoreCase(dataType))
                                    ||(("BINARY".equalsIgnoreCase(dataType)))||("VARBINARY".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            // move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                            if(MYSQL.equalsIgnoreCase(getDBMSId()) ) {
                                String columnStr = getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() );
                                int index = pkList.indexOf(columnStr);
                                if(index !=-1){
                                    for (int i=index;i>0;i--) {
                                        pkList.set(i, pkList.get(i-1));
                                    }
                                    pkList.set(0, columnStr);
                                }
                            }
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            if(DB2.equalsIgnoreCase(getDBMSId())&&column.isKey()){
                            	createSQL.append(" not null ");
                            }else{
                                createSQL.append(setNullable(column.getColumn().isNullable()));
                            }
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
        
        protected String getLengthStringRepresentation(String dataType, Integer length) {
        	return String.valueOf(length);
    	}
    
        protected String getAutoIncrement(int startValue, int step) {
            if(SYBASE.equalsIgnoreCase(getDBMSId()) || EXASOL.equalsIgnoreCase(getDBMSId())){
                return " IDENTITY NOT NULL";
            } else if(MYSQL.equalsIgnoreCase(getDBMSId()) ) {
                return " AUTO_INCREMENT";
            } else if(DB2.equalsIgnoreCase(getDBMSId())){
                return " Generated by default AS IDENTITY(START WITH "+startValue+", INCREMENT BY "+step+", NO CACHE )";
            } else if(TERADATA.equalsIgnoreCase(getDBMSId())){
                return " generated by default as identity (start with " + startValue + " increment by " + step + " no cycle) not null";
            }else {
                return " IDENTITY (" + startValue + ", " + step + ") NOT NULL";
            }
        }
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return "";
            }
        }
        protected String setDefaultValue(String defaultValue, String columnType) {
            if (defaultValue == null || defaultValue.equals("\"\"") || defaultValue.equals("")) {
                return " ";
            } else if ((defaultValue.startsWith("\"") || defaultValue.startsWith("'"))
                    && (defaultValue.endsWith("\"") || defaultValue.endsWith("'"))) {
                return " default '" + defaultValue.substring(1, defaultValue.length() - 1) + "' ";
            } else if (defaultValue.equalsIgnoreCase("null")) {
                return " default null ";
            } else {
                return " default " + defaultValue + " ";
            }
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() + ", " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();
        }

        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols, boolean isSpecifyIdentityKey, String identityKey, int startValue, int step) {
            List<Column> stmtStructure = createColumnList(columnList, useFieldOptions, fieldOptions, addCols);
            if(isSpecifyIdentityKey) {
                for(Column column : stmtStructure) {
                    if(column.name.equals(identityKey)) {
                        column.setAutoIncrement(true);
                        column.setStartValue(startValue);
                        column.setStep(step);
                        break;
                    }
                }
            }
            return stmtStructure;
        }
        
        private boolean dynamicColumnIsReplaced = false;
        
        public List<Column> createColumnList(List<IMetadataColumn> columnList, boolean useFieldOptions, List<Map<String, String>> fieldOptions, List<Map<String, String>> addCols) {
            List<Column> stmtStructure = new ArrayList<Column>();            
            for(IMetadataColumn column : columnList) {
                Map<String, String> fieldOption = null;
                if(fieldOptions != null && fieldOptions.size() > 0) {
                    for(Map<String, String> tmpFieldOption : fieldOptions) {
                        if(column.getLabel().equals(tmpFieldOption.get("SCHEMA_COLUMN"))) {
                            fieldOption = tmpFieldOption;
                            break;
                        }
                    }
                }
                
                Column skeletonColumn = getColumn(column, column.isKey(), useFieldOptions, fieldOption);
                skeletonColumn.setOperator("=");
                skeletonColumn.setDataType(column.getType());
                stmtStructure.add(skeletonColumn);
                
                if("id_Dynamic".equals(column.getTalendType())) {
                    skeletonColumn.setDynamic(true);
                }
            }
            
            dynamicColumnIsReplaced = false;
            
            if(addCols != null && addCols.size() > 0) {
                for(IMetadataColumn column : columnList) {
                    for(Map<String, String> additionColumn : addCols) {
                        if(additionColumn.get("REFCOL").equals(column.getLabel())) {
                            int stmtIndex = 0;
                            for(Column stmtStr : stmtStructure){          
                                if(stmtStr.getName().equals(additionColumn.get("REFCOL"))) {
                                    break;
                                }
                                stmtIndex++;
                            }           
                            if(additionColumn.get("POS").equals("AFTER")) {
                                Column insertAfter = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertAfter.setDataType(additionColumn.get("DATATYPE"));
                                insertAfter.setOperator("=");
                                stmtStructure.add(stmtIndex+1, insertAfter);
                            } else if(additionColumn.get("POS").equals("BEFORE")) {
                                Column insertBefore = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                insertBefore.setDataType(additionColumn.get("DATATYPE"));
                                insertBefore.setOperator("=");
                                stmtStructure.add(stmtIndex, insertBefore);
                            } else if(additionColumn.get("POS").equals("REPLACE")) {
                                Column replacementCol = getColumn("\" + " + additionColumn.get("NAME") + " + \"", "\" + " + additionColumn.get("SQL") + " + \"", true);
                                replacementCol.setDataType(additionColumn.get("DATATYPE"));
                                replacementCol.setOperator("=");                                
                                Column replacedCol = (Column) stmtStructure.get(stmtIndex);
                                replacementCol.setKey(replacedCol.isKey());
                                replacementCol.setUpdateKey(replacedCol.isUpdateKey());
                                replacementCol.setDeleteKey(replacedCol.isDeleteKey());
                                replacementCol.setUpdatable(replacedCol.isUpdatable());
                                replacementCol.setInsertable(replacedCol.isInsertable());
                                replacedCol.replace(replacementCol);
                                
                                if(replacedCol.isDynamic()) {
                                    dynamicColumnIsReplaced = true;
                                }
                            }                            
                        }
                    }
                }
            }
            
            return stmtStructure;
        }
        
        public boolean isDynamicColumnReplaced() {
            return dynamicColumnIsReplaced;
        }
        
        public Map<String, StringBuilder> createProcessSQL(List<Column> stmtStructure) {
            Map<String, StringBuilder> actionSQLMap = new HashMap<String, StringBuilder>();
            if(stmtStructure==null || stmtStructure.size() < 1) {
                actionSQLMap.put(INSERT_COLUMN_NAME, new StringBuilder());
                actionSQLMap.put(INSERT_VALUE_STMT, new StringBuilder());
                actionSQLMap.put(UPDATE_SET_STMT, new StringBuilder());
                actionSQLMap.put(UPDATE_WHERE_STMT, new StringBuilder());
                actionSQLMap.put(DELETE_WHERE_STMT, new StringBuilder());
                actionSQLMap.put(FIRST_UPDATE_KEY, new StringBuilder());
                actionSQLMap.put(FIRST_DELETE_KEY, new StringBuilder());
                actionSQLMap.put(FIRST_INSERT_COLUMN, new StringBuilder());
                actionSQLMap.put(FIRST_UPDATE_COLUMN, new StringBuilder());
            } else {
                for(Column column : stmtStructure) {
                    if(column.isReplaced()) {
                        List<Column> replacedColumns = column.getReplacement();
                        for(Column replacedColumn : replacedColumns) {
                            actionSQLMap = processSQLClause(replacedColumn, actionSQLMap);
                        }
                    } else {
                        actionSQLMap = processSQLClause(column, actionSQLMap);        
                    }
                }
            }
            return actionSQLMap;
        }
        
        private boolean isSpecifyIdentityKey = false;
        
        public void setIsSpecifyIdentityKey(boolean isSpecifyIdentityKey) {
            this.isSpecifyIdentityKey = isSpecifyIdentityKey;
        }
        
        private Map<String, StringBuilder> processSQLClause(Column column, Map<String, StringBuilder> actionSQLMap) {
            StringBuilder insertColName = actionSQLMap.get(INSERT_COLUMN_NAME);
            if(insertColName == null) {
                insertColName = new StringBuilder();
            }
            StringBuilder insertValueStmt = actionSQLMap.get(INSERT_VALUE_STMT);
            if(insertValueStmt == null) {
                insertValueStmt = new StringBuilder();
            }
            StringBuilder updateSetStmt = actionSQLMap.get(UPDATE_SET_STMT);
            if(updateSetStmt == null) {
                updateSetStmt = new StringBuilder(); 
            }
            StringBuilder updateWhereStmt = actionSQLMap.get(UPDATE_WHERE_STMT);
            if(updateWhereStmt == null) {
                updateWhereStmt = new StringBuilder();
            }
            StringBuilder deleteWhereStmt = actionSQLMap.get(DELETE_WHERE_STMT);
            if(deleteWhereStmt == null) {
                deleteWhereStmt = new StringBuilder();
            }
            StringBuilder firstUpdateKeyColumn = actionSQLMap.get(FIRST_UPDATE_KEY);
            if(firstUpdateKeyColumn == null) {
                firstUpdateKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstDeleteKeyColumn = actionSQLMap.get(FIRST_DELETE_KEY);
            if(firstDeleteKeyColumn == null) {
                firstDeleteKeyColumn = new StringBuilder("true");
            }
            StringBuilder firstInsertColumn = actionSQLMap.get(FIRST_INSERT_COLUMN);
            if(firstInsertColumn == null) {
                firstInsertColumn = new StringBuilder("true");
            }
            StringBuilder firstUpdateColumn = actionSQLMap.get(FIRST_UPDATE_COLUMN);
            if(firstUpdateColumn == null) {
                firstUpdateColumn = new StringBuilder("true");
            }
            String suffix = null;
            String separate = null;
            String identityKey = ElementParameterParser.getValue(node, "__IDENTITY_FIELD__");
            if(!(isSpecifyIdentityKey && (column.getName().equals(identityKey))) && column.isInsertable() && !column.isDynamic()) {
                if(firstInsertColumn.toString().equals("true")) {
                    suffix = "";
                    firstInsertColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                insertColName.append(suffix);
                insertColName.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()));
                insertValueStmt.append(suffix);
                insertValueStmt.append(column.getSqlStmt());
            }
            if(column.isUpdatable() && !column.isDynamic()) {
                if(firstUpdateColumn.toString().equals("true")) {
                    suffix = "";
                    firstUpdateColumn = new StringBuilder("false");
                } else {
                    suffix = ",";
                }
                updateSetStmt.append(suffix);
                updateSetStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " " + column.getOperator() + " " + column.getSqlStmt());
            }
            if(column.isDeleteKey() && !column.isDynamic()) {
                if(firstDeleteKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstDeleteKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                deleteWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(deleteWhereStmt, column);                 
            }
            if(column.isUpdateKey() && !column.isDynamic()) {
                if(firstUpdateKeyColumn.toString().equals("true")) {
                    separate = "";
                    firstUpdateKeyColumn = new StringBuilder("false");
                } else {
                    separate = " AND ";
                }
                updateWhereStmt.append(separate);
                
                //feature:2880
                whereStmtSupportNull(updateWhereStmt, column);                
                                            
            }
            actionSQLMap.put(INSERT_COLUMN_NAME, insertColName);
            actionSQLMap.put(INSERT_VALUE_STMT, insertValueStmt);
            actionSQLMap.put(UPDATE_SET_STMT, updateSetStmt);
            actionSQLMap.put(UPDATE_WHERE_STMT, updateWhereStmt);
            actionSQLMap.put(DELETE_WHERE_STMT, deleteWhereStmt);
            actionSQLMap.put(FIRST_UPDATE_KEY, firstUpdateKeyColumn);
            actionSQLMap.put(FIRST_DELETE_KEY, firstDeleteKeyColumn);
            actionSQLMap.put(FIRST_INSERT_COLUMN, firstInsertColumn);
            actionSQLMap.put(FIRST_UPDATE_COLUMN, firstUpdateColumn);
            return actionSQLMap;
        }
        public String getGenerateType(String typeToGenerate) {
            if(typeToGenerate.equals("byte[]")) {
                typeToGenerate = "Bytes";
            } else if(typeToGenerate.equals("java.util.Date")) {
                typeToGenerate = "Date";
            } else if(typeToGenerate.equals("Integer")) {
                typeToGenerate = "Int";
            } else if(typeToGenerate.equals("List")) {  
                typeToGenerate = "Object";                 
            } else {
                typeToGenerate=typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
            return typeToGenerate;
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType) {
            return generateSetStmt(typeToGenerate, dbType, column, index, incomingConnName, cid, actionType, null); 
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                    
                }                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                    
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic + ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");                
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }
            else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();            
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType) {
            return generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, actionType, null); 
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        // @Deprecated : see bug8551
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt) {
            String replaceStr = null;
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " +  replaceStr + ")";
            }else {
                return stmt + cid + ".replaceFirst(\"\\\\?\", " + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ")";
            }
            
                
        }
        
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit);
        }
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit) {
            String replaceStr = null;
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if(generatedType.equals("char") || generatedType.equals("Character")) {
                replaceStr = "\"'\" + String.valueOf(" + incomingConnName + "." + column.getName() + ") + \"'\"";
            } else if(generatedType.equals("String")) {
                replaceStr = "\"'\" + " + incomingConnName + "." + column.getName() + " + \"'\"";
            } else if(generatedType.equals("java.util.Date")) {
                replaceStr = "\"'\" + new java.text.SimpleDateFormat(" + column.getColumn().getPattern() + ").format(" + incomingConnName + "." + column.getName() + ") + \"'\"";
                
            } else {
                replaceStr = "String.valueOf(" + incomingConnName + "." + column.getName() + ")";
            }
            
            if (generatedType.equals("int") || generatedType.equals("float") || generatedType.equals("double") ||generatedType.equals("long") 
                    || generatedType.equals("short") || generatedType.equals("boolean") || generatedType.equals("byte") || generatedType.equals("char")) {
                    if (index == 1 && dynCol == null) {
                        return  stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +  replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                    } else {
                        return  stmt + cid + ".append(" +  replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                    }
            }else {
                if (index == 1 && dynCol == null) {
                    return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+index+"])";
                } else {
                    return stmt + cid + ".append(" + incomingConnName + "." + column.getName() +"== null ?  \"null\" :" + replaceStr + ").append("+sqlSplit+cid+"["+dynamicIndex+"])";
                }
            }
        }
        
        //feature:2880 @6980 in debug mode
        public String retrieveSQL(String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            return retrieveSQL(null,generatedType, column, incomingConnName, cid, stmt, index, sqlSplit, replaceFixedStr);
        }
        
        public String retrieveSQL(String dynCol,String generatedType, Column column, String incomingConnName, String cid, String stmt, int index, String sqlSplit, String replaceFixedStr) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            if (index == 1 && dynCol == null) {
                return stmt + cid + ".append("+sqlSplit+cid+"[0]).append(" +replaceFixedStr+ ").append("+sqlSplit+cid+"["+index+"])";
            } else {
                return stmt + cid + ".append(" +replaceFixedStr+").append("+sqlSplit+cid+"["+dynamicIndex+"])";
            }
        }
        
        //extract a method for feature:2880, it is a default implement, need every tDBOutput to implement it, if it really want to support the "whereNULL" issue
        //@see: the implement of MSSQLManager
        //feature:2880 @6980
        //i.e: 
        //1.select * FROM user where ((true = true AND name is NULL) OR name = ?);
        //2.select * FROM user where ((true = false AND name is NULL) OR name = ?);
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;

            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn()!=null && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName())
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(column.getColumnName()) + column.getColumnName() + getRProtectedChar(column.getColumnName()) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
        // for feature:2880, it will consider the "whereNULL" issue in the generated code.
        // @Deprecated: because the "index" with a small problem when increase it.
        private String generateSetStmt_4_whereSupportNull(String typeToGenerate, Column column, int index,
                String incomingConnName, String cid, int actionType) {

            boolean whereSupportNull = false;

            // if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }

            StringBuilder setStmt = new StringBuilder();

            // the 3 conditions are important
            if (column.isUpdateKey() && whereSupportNull && column.getColumn().isNullable()) {
                setStmt.append(generateSetBooleanForNullableKeyStmt(column, index, incomingConnName, cid, NORMAL_TYPE));
            }

            // the old behave
            setStmt.append(generateSetStmt(typeToGenerate, column, index, incomingConnName, cid, NORMAL_TYPE));

            return setStmt.toString();
        }

        protected String generateSetBooleanForNullableKeyStmt(String dynCol, Column column, int index, String incomingConnName, String cid,
                int actionType) {
            return generateSetBooleanForNullableKeyStmt(column, (incomingConnName+"."+dynCol+".getColumnCount()+"+index), incomingConnName, cid, actionType);
        }

        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType, String dynamic) {
            return generateSetBooleanForNullableKeyStmt(column, (index + dynamic + cid), incomingConnName, cid, actionType);
        }

        protected String generateSetBooleanForNullableKeyStmt(Column column, String index, String incomingConnName, String cid,
                int actionType) {
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            //TODO generate setXXXX code according to each db .
            setStmt.append(prefix + cid + ".setInt(" + index + ",  ((" + incomingConnName + "." + column.getName() + "==null)?1:0));\r\n");
            return setStmt.toString();
        } 
        
        // for feature:2880 @6980, generate the "set XXXX" java code.thie code is about  the column whether is null(in java) prefix condition.
        //@see:getColumnIsNullCondition()
        //need all db to implement.
        protected String generateSetBooleanForNullableKeyStmt(Column column, int index, String incomingConnName, String cid,
                int actionType) {
            return generateSetBooleanForNullableKeyStmt(column, ""+index, incomingConnName, cid, actionType);
        }     
        
        public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, 
                String fieldDelimiter, 
                String newLineChar,
                String nullIndicator) {
        return null;
            
        }
        
        public String generateCode4TabelExist() {
            boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
            String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
            StringBuilder code = new StringBuilder();  
            code.append("String tableNameForSearch_" + cid + "= " + getTableName4Search(useExistingConnection, connection) + ";\r\n");
            if (hasSchema()) {
                code.append("String dbschemaForSearch_" + cid + "= null;\r\n");
                code.append("if(dbschema_" + cid + "== null || dbschema_" + cid + ".trim().length() == 0) {\r\n");
                code.append("dbschemaForSearch_" + cid + "= " + getUserName4Search(useExistingConnection, connection)+ ";\r\n");
                code.append("} else {\r\n");
                code.append("dbschemaForSearch_" + cid + "= " + getShemaName4Search(useExistingConnection, connection)+ ";\r\n");
                code.append("}\r\n");
            }
            return code.toString();
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + " + ElementParameterParser.getValue(node,"__TABLE__") +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }

        /*
         * maybe some db need add getLProtectedChar() and getRProtectedChar() to schema name.
         * this because of some db default add getLProtectedChar() and getRProtectedChar() to schema when create table. e.g:db2
         * 
         * in fact the db add getLProtectedChar() and getRProtectedChar() to scheam when create table that is wrong
        */
        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "";   
        }   
        
        protected boolean hasSchema() {
            return false;
        }
        
        protected String getInsertQueryForDynamicSchema(String connection, String tableName, String insertColumnNames, String insertValues, String dataAction) {
            StringBuilder statementQuery = new StringBuilder();
            String quote = "\"";
            String dot = ".";
            String plus = "+";
            String comma = ",";

            StringBuilder queryPrefix = new StringBuilder("String ");

            if ("INSERT_IGNORE".equals(dataAction)) {
                queryPrefix.append("insert_").append(cid).append(" = ").append(quote).append("INSERT IGNORE INTO ");
            } else if ("REPLACE".equals(dataAction)) {
                queryPrefix.append("replace_").append(cid).append(" = ").append(quote).append("REPLACE INTO ");
            } else if ("INSERT_ON_DUPLICATE_KEY_UPDATE".equals(dataAction)) {
                queryPrefix.append("insertIgnore_").append(cid).append(" = ").append(quote).append("INSERT IGNORE INTO ");
            } else {
                queryPrefix.append("insert_").append(cid).append(" = ").append(quote).append("INSERT INTO ");
            }
            statementQuery.append(queryPrefix).append(getLProtectedChar()).append(quote).append(plus).append(tableName).append(cid).append(plus).append(quote).append(getRProtectedChar()).append(" (").append(quote).append(plus)
                .append("DynamicUtils.getInsertIntoStmtColumnsList(").append(connection).append(dot).append(getDynamicColumn()).append(comma).append(quote).append(getDBMSId()).append(quote).append(comma).append(" new StringBuilder(").append(quote).append(insertColumnNames).append(quote).append("))").append(plus)
                .append(quote).append(") VALUES (").append(quote).append(plus)
                .append("DynamicUtils.getInsertIntoStmtValuesList(").append(connection).append(dot).append(getDynamicColumn()).append(comma).append(quote).append(getDBMSId()).append(quote).append(comma).append(" new StringBuilder(").append(quote).append(insertValues).append(quote).append("))").append(plus)
                .append(quote).append(")").append(quote);

            return statementQuery.toString();
        }

        protected String getUpdateQueryForDynamicSchema(String connection, String tableName, String updateSetStmt, String updateWhereStmt, boolean supportNullWhere) {
            StringBuilder statementQuery = new StringBuilder();
            String quote = "\"";
            String dot = ".";
            String plus = "+";
            String comma = ",";
            statementQuery.append("String update_").append(cid).append(" = ").append(quote).append("UPDATE ").append(getLProtectedChar()).append(quote).append(plus).append(tableName).append(cid).append(plus).append(quote).append(getRProtectedChar()).append(" SET ").append(quote).append(plus)
                .append("DynamicUtils.getUpdateSet(").append(connection).append(dot).append(getDynamicColumn()).append(comma).append(quote).append(getDBMSId()).append(quote).append(comma).append(" new StringBuilder(").append(quote).append(updateSetStmt).append(quote).append("))").append(plus)
                .append(quote).append(" WHERE ").append(quote).append(plus)
                .append("DynamicUtils.getUpdateWhere(").append(connection).append(dot).append(getDynamicColumn()).append(comma).append(quote).append(getDBMSId()).append(quote).append(comma).append(" new StringBuilder(").append(quote).append(updateWhereStmt).append(quote).append(")").append(comma).append(supportNullWhere).append(")");
            return statementQuery.toString();
        }
    }
    
    public class AS400Manager extends Manager {
        public AS400Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return AS400;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class AccessManager extends Manager {
        public AccessManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ACCESS;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }   
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else {
                if (typeToGenerate.equals("Long")) {
                    setStmt.append(prefix + cid + ".setBigDecimal(" + index + ",new BigDecimal(" + incomingConnName + "." + column.getName() + "));\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class DB2Manager extends Manager {
        public DB2Manager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return DB2;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }       
        
        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " IMMEDIATE");
            return truncateTableSQL.toString();
        }
        
        public String getTruncateReuseStroageTableSQL() {
            StringBuilder truncate_reuse_stroage_TableSQL = new StringBuilder();
            truncate_reuse_stroage_TableSQL.append("TRUNCATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + " REUSE STORAGE IMMEDIATE");
            return truncate_reuse_stroage_TableSQL.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            // try to build a sql like 
            // update customers a 
            // set (city_name,customer_type)=(select b.city_name,b.customer_type 
            //        from tmp_cust_city b 
            //        where b.customer_id=a.customer_id) // wheresub
            //        where exists (select 1 
            //        from tmp_cust_city b
            //        where b.customer_id=a.customer_id
            //        )
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }
        
        //feature:2880 @6980
        //need all db to implement, return the column whether is null(in java) prefix condition.
        protected String getColumnIsNullCondition() {
            return "1";
        }
        
    }
    
    public class FirebirdManager extends Manager {
        public FirebirdManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return FIREBIRD;
        }
        protected String getLProtectedChar() {
            return " ";
        }
        protected String getRProtectedChar() {
            return " ";
        }
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if ((MYSQL.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            
            // add VectorWise option
            if (VECTORWISE.equalsIgnoreCase(getDBMSId())){
                createSQL.append("WITH STRUCTURE = VECTORWISE");
            }
            
            return createSQL.toString();
        }
                
    }
    
    public class HSQLDBManager extends Manager {
        String [] hsqldbKeyWords = {};
        public HSQLDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HSQLDB;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHSQLDBKeyword (String keyword) {
            for (int i=0 ; i < hsqldbKeyWords.length ; i++){
                if (hsqldbKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isHSQLDBKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isHSQLDBKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
    }
    
    public class HiveManager extends Manager {
        String [] hiveKeyWords = {};
        public HiveManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return HIVE;
        }   
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }     
        protected boolean isHiveKeyword (String keyword) {
            for (int i=0 ; i < hiveKeyWords.length ; i++){
                if (hiveKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isHiveKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isHiveKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
    }
    
    public class InformixManager extends Manager {
        public InformixManager(String cid) {
            super(cid);
        }
        public String getSelectionSQL() {
            StringBuilder selectionSQL = new StringBuilder();
            selectionSQL.append("SELECT COUNT(*) FROM " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            return selectionSQL.toString();
        }        
        protected String getDBMSId() {
            return INFORMIX;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class IngresManager extends Manager {
        boolean isTrimSpace = true;
        public IngresManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INGRES;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }  
        protected boolean getTrimSpace() {
            return isTrimSpace;
        }
        protected boolean setTrimSpace(boolean isTrimSpace) {
            this.isTrimSpace = isTrimSpace;
            return isTrimSpace;
        }
        
        public String getCopyFromCSVSQL(List<IMetadataColumn> columnList, String fieldDelimiter, 
                String recordDelimiter, String nullIndicator) {     
            StringBuilder copyBulkSQL = new StringBuilder();
            copyBulkSQL.append("COPY TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar());
            copyBulkSQL.append(" (\"+");                
            int counter = 0;
            for(IMetadataColumn column : columnList) {
                counter++;
                // add each table field and separator
                copyBulkSQL.append( 
                "\n\"\\n" +
                  column.getOriginalDbColumnName() 
                + "="
                + (!getTrimSpace() && ("VARCHAR".equalsIgnoreCase(column.getType()) || "NVARCHAR".equalsIgnoreCase(column.getType()) || "TEXT".equalsIgnoreCase(column.getType())) ? "text(0)" : "char(0)"));
            
                // add these only if not last entry
                if (counter < columnList.size()){
                    copyBulkSQL.append(
                    //convertDelim(fieldDelimiter)
                    "\"+field_delimiter_"+cid +"+\""
                    + (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
                    + " ,"
                    + "\""
                    + "+"
                    );
                } else {
                    copyBulkSQL.append(
                    recordDelimiter
                    + (column.isNullable() ? " WITH NULL ('" + nullIndicator + "')" : "")
                    );
                    copyBulkSQL.append(")");
                }       
            } 
            return copyBulkSQL.toString();
        } 

        public String getTruncateTableSQL() {
            StringBuilder truncateTableSQL = new StringBuilder();
            truncateTableSQL.append("MODIFY " + getLProtectedChar() + "\" + tableName_" 
            + cid + " + \"\\\" TO TRUNCATED");
            return truncateTableSQL.toString();
        }                       
    }
    
    public class VectorWiseManager extends IngresManager {
        public VectorWiseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VECTORWISE;
        }
    }   
    
    public class InterbaseManager extends Manager {
        public InterbaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return INTERBASE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class JavaDBManager extends Manager {
        public JavaDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JAVADB;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class MaxDBManager extends Manager {
        public MaxDBManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MAXDB;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MSSQLManager extends Manager {
        public MSSQLManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MSSQL;
        }
        protected String getLProtectedChar() {
            return "[";
        }
        protected String getRProtectedChar() {
            return "]";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        } 
       
        protected String getColumnIsNullCondition() {
            return "0x1";
        }
        
        protected String generateSetBooleanForNullableKeyStmt(String dynCol,Column column, int index, String incomingConnName, String cid,
                int actionType) {
            String dynamicIndex=""+index;
            if(dynCol!=null){
                dynamicIndex = incomingConnName+"."+dynCol+".getColumnCount()+"+index;
            }
            String prefix = null;
            if (actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if (actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if (actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            setStmt.append(prefix + cid + ".setBoolean(" + dynamicIndex + ", (" + incomingConnName + "." + column.getName()
                    + "==null));\r\n");
            return setStmt.toString();
        } 
        
        public String generateSetStmt(String typeToGenerate, String ignoreDateOutOfRange, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                String dbType = column.getColumn().getType();
                if(dbType==null || "".equals(dbType)){
                    MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
                    dbType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                }
                if("true".equals(ignoreDateOutOfRange) &&("DATE".equals(dbType) || "DATETIME2".equals(dbType) || "DATETIMEOFFSET".equals(dbType))){                    
                    String pattern = column.getColumn().getPattern();
                    setStmt.append("if(" + incomingConnName + "." + column.getName() +"!=null && "+ incomingConnName + "." + column.getName() + ".getTime() < year2_"+cid+"){");
                    if("DATETIMEOFFSET".equals(dbType)) {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDatetimeoffset("+incomingConnName+"."+column.getName()+"));\r\n");
                    } else {
                       setStmt.append(prefix + cid + ".setString(" + index + dynamic + ",TalendDate.formatDate("+pattern+", "+incomingConnName+"."+column.getName()+"));\r\n");
                    }
                    setStmt.append("}else{\r\n");
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                    if("DATETIMEOFFSET".equals(dbType)) {
                        setStmt.append(",calendar_datetimeoffset_").append(cid);
                    }
                    setStmt.append(");\r\n");
                    setStmt.append("}\r\n");
                }else if("TIME".equals(dbType)){//TDI-30431 begin
                    String timePattern = column.getColumn().getPattern();
                    //Compatible with Time,Date and String,it will fail if Time contain fractional seconds.(Solution:Use sqljdbc.jar and setTime() instead)
                    //setStmt.append(prefix + cid + ".setString(" + index + dynamic + "," + incomingConnName + "." + column.getName()+".toString()");// For Time and String
                    setStmt.append(prefix + cid + ".setString(" + index + dynamic + ","
                                    + incomingConnName + "." + column.getName()
                                    +" instanceof java.util.Date ? new java.text.SimpleDateFormat("+timePattern+").format("
                                    + incomingConnName + "." + column.getName()+") : "
                                    + incomingConnName + "." + column.getName()+".toString()");//Compatible with tFileInputDelimiter Date Type and Time and String
                    setStmt.append(");\r\n");
                }else{//TDI-30431 end
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime())");
                    if("DATETIMEOFFSET".equals(dbType)) {
                        setStmt.append(",calendar_datetimeoffset_").append(cid);
                    }
                    setStmt.append(");\r\n");
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        //bug 0016707 fixed:when set INT IDENTITY in schema and use "Specify identity field". the INT IDENTITY in schema by ignored  
                        if(column.isAutoIncrement()) {
                            length = column.getStartValue();
                            precision =  column.getStep();
                            if ("INT IDENTITY".equals(column.column.getType())) {
                                column.setAutoIncrement(false);
                            } 
                        }
                        // end bug0016707
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if ((MYSQL.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + getLengthStringRepresentation(dataType, length));
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + getLengthStringRepresentation(dataType, length));
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
        
        protected String getLengthStringRepresentation(String dataType, Integer length) {
	        if (("VARCHAR".equalsIgnoreCase(dataType) && length > 8000) || ("NVARCHAR".equalsIgnoreCase(dataType) && length > 4000)
	                || ("VARBINARY".equalsIgnoreCase(dataType) && length > 8000)) {
	            return "MAX";
	        }
	        return String.valueOf(length);
	    }
    }
    
    public class MysqlManager extends Manager {
        public MysqlManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return MYSQL;
        }
        protected String getLProtectedChar() {
            return "`";
        }
        protected String getRProtectedChar() {
            return "`";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE){
                prefix = "pstmt_";
            }else if(actionType == INSERT_TYPE){
                prefix = "pstmtInsert_";
            }else if(actionType == UPDATE_TYPE){
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();

            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                //also check if DBType is year
                boolean isDBTypeEqualsYear = column.getColumn().getType().equalsIgnoreCase("year");
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append("date_" + cid + " = " + incomingConnName + "." + column.getName() + ".getTime();\r\n");
                if (isDBTypeEqualsYear) {
                    setStmt.append("java.util.Calendar yearCalendar_" + cid + " = new java.util.GregorianCalendar();\r\n");
                    setStmt.append("yearCalendar_" + cid + ".setTimeInMillis(date_" + cid + ");\r\n");
                    setStmt.append("\r\n");
                    setStmt.append("int yearValue_" + cid + " = yearCalendar_" + cid + ".get(java.util.Calendar.YEAR);\r\n");
                    setStmt.append("if (yearValue_" + cid + " > 2155 || yearValue_" + cid + " < 1901) { \r\n");
                    setStmt.append("\t" + prefix + cid + ".setInt(" + index + ", 0);\r\n");
                } else {
                    setStmt.append("if(date_" + cid + " < year1_" + cid + " || date_" + cid + " >= year10000_" + cid + ") {\r\n");
                    setStmt.append(prefix + cid + ".setString(" + index + ", \"0000-00-00 00:00:00\");\r\n");
                }
                setStmt.append("} else {");

                if (isDBTypeEqualsYear) {
                    setStmt.append("\t" + prefix + cid + ".setInt(" + index + ", yearValue_" + cid + ");\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(date_" + cid + "));\r\n");
                }
                setStmt.append("}\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");

            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }        
    }

    public class NetezzaManager extends Manager {
        public NetezzaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return NETEZZA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                String dateType="Timestamp";
                if("TIME".equalsIgnoreCase(column.getColumn().getType())){
                    dateType = "Time";
                }
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".set"+dateType+"(" + index + dynamic + ", new java.sql."+dateType+"(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class OracleManager extends Manager {
          private String[] oracleKeyWords= {
                    "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
                    "ADD","CONNECT","DISTINCT" ,
                    "ALL","BY","CREATE","DROP",
                    "ALTER","CHAR","CURRENT","ELSE",
                    "AND","CHECK","DATE","EXCLUSIVE",
                    "ANY","CLUSTER","DECIMAL"," EXISTS",
                    "AS","COLUMN","DEFAULT","FILE",
                    "ASC","COMMENT","DELETE","FLOAT",
                    "FOR","LONG","PCTFREE","SUCCESSFUL",
                    "FROM","MAXEXTENTS","PRIOR","SYNONYM",
                    "GRANT","MINUS","PRIVILEGES","SYSDATE",
                    "GROUP","MODE","PUBLIC","TABLE",
                    "HAVING","MODIFY","RAW","THEN",
                    "IDENTIFIED","NETWORK","RENAME","TO",
                    "IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
                    "IN","NOCOMPRESS","REVOKE","UID",
                    "INCREMENT","NOT","ROW","UNION",
                    "INDEX","NOWAIT","ROWID","UNIQUE",
                    "INITIAL","NULL","ROWNUM","UPDATE",
                    "INSERT","NUMBER","ROWS","USER",
                    "INTEGER","OF","SELECT","VALIDATE",
                    "INTERSECT","OFFLINE","SESSION","VALUES",
                    "INTO","ON","SET","VARCHAR",
                    "IS","ONLINE","SHARE","VARCHAR2",
                    "LEVEL","OPTION","SIZE","VIEW",
                    "LIKE","OR","SMALLINT","WHENEVER",
                    "LOCK","ORDER","START","WHERE","WITH"
                    };
        public OracleManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ORACLE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isOracleKeyword (String keyword) {
            for (int i=0 ; i < oracleKeyWords.length ; i++){
                if (oracleKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isOracleKeyword(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
        private String dbVersion = "";
        public void setDbVersion(String dbVersion){
            this.dbVersion = dbVersion;  
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateSetSelectStmt= new StringBuilder();           
            StringBuilder updateWhereSubStmt = new StringBuilder();
            StringBuilder updateWhereMainStmt = new StringBuilder();
            String keySeparator = null;
            String updateSeparator = null;
            
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar() );
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereSubStmt.append(" WHERE \" + \"");
                        updateWhereMainStmt.append(" WHERE EXISTS ( SELECT 1 FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() );
                    }else {
                        keySeparator = " AND ";
                    }
                    updateWhereSubStmt.append(keySeparator);                    
                    updateWhereSubStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());                        

                }else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \" ( ");
                        updateSetSelectStmt.append(" = (SELECT ");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                    updateSetSelectStmt.append(updateSeparator);
                    updateSetSelectStmt.append(getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar()) ;
                }
            }
            updateSetStmt.append(" )");
            updateSetSelectStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar());
            updateWhereSubStmt.append(")");
            
            return updateBulkSQL.append(updateSetStmt).append(updateSetSelectStmt).append(updateWhereSubStmt).append(updateWhereMainStmt).append(updateWhereSubStmt).toString();
        }        
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
        	return generateSetStmt(typeToGenerate, column.getColumn().getType(), column, index, incomingConnName, cid, actionType, dynamic);
        }
        
        public String generateSetStmt(String typeToGenerate, String dbType, Column column, int index, String incomingConnName, String cid, int actionType, String dynamic) {
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            if(dbType == null){
            	dbType = "";
            }
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW"))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");
                }
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("BLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if( typeToGenerate.equals("String")&& dbType.toLowerCase().equals("char")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == \"\0\"){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            }
            else if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                boolean isTSWithTZ = dbType.matches("TIMESTAMP WITH TIME ZONE");
                if(isTSWithTZ && ("ORACLE_11".equals(dbVersion) || "ORACLE_11-6".equals(dbVersion) || "ORACLE_12".equals(dbVersion) || "ORACLE_10".equals(dbVersion))){
                    setStmt.append("if("+ incomingConnName + "." + column.getName() + " instanceof TalendTimestampWithTZ){\r\n");
                    setStmt.append("((oracle.jdbc.OraclePreparedStatement)" + prefix + cid + ").setTIMESTAMPTZ(" + index + dynamic +  ", new oracle.sql.TIMESTAMPTZ(conn_" + cid + ", ((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getTimestamp(),((TalendTimestampWithTZ)"+ incomingConnName + "." + column.getName() +").getCalendar()));\r\n");
                    setStmt.append("}else{");
                    setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    setStmt.append("}");
                }else if ("Date".equalsIgnoreCase(dbType)) {
                    if (!"true".equals(ElementParameterParser.getValue(node, "__USE_TIMESTAMP_FOR_DATE_TYPE__"))) {
                        setStmt.append(prefix + cid + ".setDate(" + index + dynamic +  ", new java.sql.Date(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                    } else {
                        setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()),java.sql.Types.DATE);\r\n");
                    }
                } else {
                    setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic +  ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n"); 
                }
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic +  ", java.sql.Types.DATE);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Bytes") && (dbType != null && (dbType.equals("LONG RAW") || dbType.equals("RAW")))) {
                setStmt.append(prefix + cid + ".setBytes(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
            } else if(typeToGenerate.equals("String") && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setCharacterStream(" + index + dynamic +  ", new java.io.StringReader(" + incomingConnName + "." + column.getName() + "), " + incomingConnName + "." + column.getName() + ".length());\r\n");
            } else if (typeToGenerate.equals("Bytes") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + dynamic +  ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && (dbType.equals("XMLTYPE")||dbType.equals("CLOB")))) {
                setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ",  clobTypeUtil_" + cid + ".getCLOB(" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
            }else if (typeToGenerate.equals("Object") && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setObject(" + index + dynamic +  ",  blobTypeUtil_" + cid + ".getBLOB(" + incomingConnName + "." + column.getName() + ", conn_" + cid + "));\r\n");
            }else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic +  ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            boolean convertToUppercase = ("true").equals(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
            if(convertToUppercase){
                return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ").toUpperCase()" +" + \"" + getRProtectedChar() + "\"";
            }else{
                return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
            }
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public void whereStmtSupportNull(StringBuilder updateWhereStmt, Column column) {
            boolean whereSupportNull = false;
            String columnName = column.getColumnName();
            String dataType = column.getDataType();
            if(dataType!=null)
            {
            boolean trimChar = ("true").equals(ElementParameterParser.getValue(node,"__TRIM_CHAR__"));
            if(trimChar && "char".equals(dataType.toLowerCase()))
            {
                columnName = "trim("+columnName+")";
            }
            }
            //if node = null, it means some components have not support the "whereNULL" issue yet.
            if (node != null) {
                whereSupportNull = ElementParameterParser.getValue(node, "__SUPPORT_NULL_WHERE__").equals("true");
            }
            if (whereSupportNull && column.getColumn()!=null && column.getColumn().isNullable()) {
                updateWhereStmt.append("((" + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + " IS NULL AND " + getColumnIsNullCondition() +" " + column.getOperator() + " " + column.getSqlStmt() + ") ");
                updateWhereStmt.append("OR " + getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName)
                        + column.getOperator() + column.getSqlStmt() + ")");
            } else {
                //if node = null, go this branch as the old behave
                updateWhereStmt.append(getLProtectedChar(columnName) + columnName + getRProtectedChar(columnName) + " "
                        + column.getOperator() + " " + column.getSqlStmt());
            }
        }
    }
    
    public class PostgreManager extends Manager {
        public PostgreManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGRESQL;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            String dbType = column.getColumn().getType();
            StringBuilder setStmt = new StringBuilder();
            if(dbType.equals("UUID") && (typeToGenerate.equals("String") || typeToGenerate.equals("Object"))) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");
            } else if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else if(dbType.equals("UUID") && (typeToGenerate.equals("String") || typeToGenerate.equals("Object"))) {
                setStmt.append(prefix + cid + ".setObject(" + index + ", " + incomingConnName + "." + column.getName() + ", java.sql.Types.OTHER);\r\n");
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class RedshiftManager extends PostgreManager {
         public RedshiftManager(String cid) {
             super(cid);
         }
         
         protected String getDBMSId() {
             return REDSHIFT;
         }
         
         public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if(("DECIMAL".equalsIgnoreCase(dataType) || "NUMERIC".equalsIgnoreCase(dataType)) 
                        	&& (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                            && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {
                        	
                        } else { 
	                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
	                            if (!precisionIgnored) {
	                                prefix = "(";
	                                suffix = ") ";
	                                createSQL.append(prefix + precision);
	                            }
	                            if (!lengthIgnored) {
	                                prefix = (prefix.equals("") ? "(" : prefix);
	                                suffix = (suffix.equals("") ? ") " : suffix);
	                                if (precisionIgnored) {
	                                    createSQL.append(prefix);
	                                    comma = "";
	                                } else {
	                                    comma = ",";
	                                }
	                                createSQL.append(comma + length);
	                            }
	                            createSQL.append(suffix);
	                        } else {
	                            if (!lengthIgnored) {
	                                if (column.getColumn().getLength() == null) {                                  
	                                } else { 
	                                    prefix = "(";
	                                    suffix = ") ";
	                                    createSQL.append(prefix + length);                                    
	                                }
	                            }
	                            if (!precisionIgnored) {
	                                prefix = (prefix.equals("") ? "(" : prefix);
	                                suffix = (suffix.equals("") ? ") " : suffix);
	                                if (lengthIgnored) {
	                                    createSQL.append(prefix);
	                                    comma = "";
	                                } else {
	                                    comma = ",";
	                                }
	                                createSQL.append(comma + precision);
	                            }
	                            if (column.getColumn().getLength() == null) {
	                            } else {
	                                createSQL.append(suffix);
	                            }
	                        }
	                    }
                            
                        if(column.isAutoIncrement()) {
                            // move the autoincrease key column to the first index in the primary defination. Otherwise, it will throw exception
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class GreenplumManager extends PostgrePlusManager {
         public GreenplumManager(String cid) {
             super(cid);
         }
         protected String getDBMSId() {
             return GREENPLUM;
         }
    }
    public class PostgrePlusManager extends Manager {
        public PostgrePlusManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return POSTGREPLUS;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }
        
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        
    }
    
    public class SQLiteManager extends Manager {
        public SQLiteManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SQLITE;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        }        
    }
    
    public class SybaseManager extends Manager {
         private String[] sybaseKeyWords= {
                 "ACCESS" ,"AUDIT","COMPRESS","DESC" , 
                "ADD","CONNECT","COUNT","DISTINCT" ,
                "ALL","BY","CREATE","DROP",
                "ALTER","CHAR","CURRENT","ELSE",
                "AND","CHECK","DATE","EXCLUSIVE",
                "ANY","CLUSTER","DECIMAL"," EXISTS",
                "AS","COLUMN","DEFAULT","FILE",
                "ASC","COMMENT","DELETE","FLOAT",
                "FOR","LONG","PCTFREE","SUCCESSFUL",
                "FROM","FALSE","MAXEXTENTS","PRIOR","SYNONYM",
                "GRANT","MINUS","PRIVILEGES","SYSDATE",
                "GROUP","MODE","PUBLIC","TABLE",
                "HAVING","MODIFY","RAW","THEN",
                "IDENTIFIED","NETWORK","RENAME","TO",
                "IMMEDIATE","NOAUDIT","RESOURCE","TRIGGER",
                "IN","NOCOMPRESS","REVOKE","UID",
                "INCREMENT","NOT","ROW","UNION",
                "INDEX","NOWAIT","ROWID","UNIQUE",
                "INITIAL","NULL","ROWNUM","UPDATE",
                "INSERT","NUMBER","ROWS","USER",
                "INTEGER","OF","SELECT","VALIDATE",
                "INTERSECT","OFFLINE","SESSION","VALUES",
                "INTO","ON","SET","VARCHAR",
                "IS","ONLINE","SHARE",
                "LEVEL","OPTION","SIZE","VIEW",
                "LIKE","OR","SMALLINT","WHENEVER",
                "LOCK","ORDER","START","WHERE","WITH"
                 
         };
        public SybaseManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SYBASE;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected boolean isSybaseKeyword (String keyword) {
            for (int i=0 ; i < sybaseKeyWords.length ; i++){
                if (sybaseKeyWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSybaseKeyword(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            if (isSybaseKeyword(keyword)){
                return "\\\"";
            }
            return getRProtectedChar();
        }  
        protected String setNullable(boolean nullable) {
            if(!nullable) {
                return " not null ";
            } else {
                return " null ";
            }
        }        
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }        

        /**
         * This method is added for differences between sybase and common databases on BigDecimal.
         * Reference issue is TDI-7505.
         * */
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType, String dynamic) {
            
            if(dynamic==null) {
                dynamic="";
            } else {
                dynamic+=cid;
            }
            
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.ARRAY);\r\n");                
                }
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(column.column != null && ("BINARY".equals(column.column.getType()) || "VARBINARY".equals(column.column.getType()))) {
                    setStmt.append(prefix + cid + ".setBytes(" + index + dynamic + ", null);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.OTHER);\r\n");                
                }               
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + dynamic + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + dynamic + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + dynamic + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if(typeToGenerate.equals("BigDecimal")){
                if(column.getColumn().getPrecision()!=null && column.getColumn().getLength()!=null){
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                    setStmt.append("((com.sybase.jdbc3.jdbc.SybPreparedStatement)"+prefix + cid + ").set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() +","+column.getColumn().getLength() +","+column.getColumn().getPrecision()+ ");\r\n");
                    setStmt.append("} else {\r\n");
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                    setStmt.append("}\r\n");
                }else{
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                }
                
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + dynamic + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
    }
    
    public class TeradataManager extends Manager {
        public TeradataManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return TERADATA;
        }
        protected String getLProtectedChar() {
            return "\\\"";
        }
        protected String getRProtectedChar() {
            return "\\\"";
        } 
                
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            String dbType = column.getColumn().getType();
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BINARY);\r\n");                
                }
            } else if(typeToGenerate.equals("Byte")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TINYINT);\r\n");                
            } else if(typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.SMALLINT);\r\n");                
            } else if(typeToGenerate.equals("Long")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BIGINT);\r\n");                
            } else if(typeToGenerate.equals("Integer")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if(dbType != null && dbType.equals("CLOB")) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");                    
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
                }
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                if("BLOB".equals(dbType)) {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BLOB);\r\n");
                } else if("CLOB".equals(dbType)){
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CLOB);\r\n");
                } else {
                    setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                    
                }
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else if ((typeToGenerate.equals("String")) && (dbType != null && dbType.equals("CLOB"))) {
                setStmt.append(prefix + cid + ".setAsciiStream(" + index + ", new java.io.ByteArrayInputStream(" + incomingConnName + "." + column.getName() + ".toString().getBytes()), (" + incomingConnName + "." + column.getName() + ".toString().getBytes()).length);\r\n");                
            } else if ((typeToGenerate.equals("Bytes")) && (dbType != null && dbType.equals("BLOB"))) {
                setStmt.append(prefix + cid + ".setBinaryStream(" + index + ", new java.io.ByteArrayInputStream((byte[])" + incomingConnName + "." + column.getName() + "), ((byte[])" + incomingConnName + "." + column.getName() + ").length);\r\n");    
            } else if(typeToGenerate.equals("Geometry")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                // Load geometry
                setStmt.append(
                                prefix +
                                cid +
                                ".setString(" + 
                                    index +
                                    ", ((org.talend.sdi.geometry.Geometry)(" +
                                    incomingConnName + "." + column.getName() + ")).toString()" +
                                    ");\r\n");
                // TODO : should use forceCoordinate first, then getSRID method or -1 if it's null.
                setStmt.append(
                                prefix +
                                cid +
                                ".setInt(" + 
                                    index + 
                                    " + 1, ((org.talend.sdi.geometry.Geometry)(" + 
                                    incomingConnName + "." + column.getName() + ")).getSRID()" +
                                    ");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + " + 1 , java.sql.Types.INTEGER);\r\n");
                setStmt.append("}\r\n");    
            } else {
                setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            
            String tableType = ElementParameterParser.getValue(node, "__CREATE_TABLE_TYPE__");
            
            createSQL.append("CREATE " + tableType + " TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if ((MYSQL.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
    }
    
    public class VerticaManager extends Manager {
        public VerticaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return VERTICA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        public String getUpdateBulkSQL(List<IMetadataColumn> columnList) {
            StringBuilder updateBulkSQL = new StringBuilder();
            StringBuilder updateSetStmt = new StringBuilder();
            StringBuilder updateWhereStmt = new StringBuilder();
            updateBulkSQL.append("UPDATE " + getLProtectedChar() + "\" +  tableName_" + cid + " + \"" + getRProtectedChar());
            boolean firstKeyColumn = true;
            boolean firstUpdateColumn = true;
            String keySeparator = null;
            String updateSeparator = null;
            for(IMetadataColumn column : columnList) {
                if(column.isKey()) {
                    if(firstKeyColumn) {
                        keySeparator = "";
                        firstKeyColumn = false;
                        updateWhereStmt.append(" FROM " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + " WHERE \" + \"");
                    } else {
                        keySeparator = " AND ";
                    }
                    updateWhereStmt.append(keySeparator);                    
                    updateWhereStmt.append(getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                } else {
                    if(firstUpdateColumn) {
                        updateSeparator = "";
                        firstUpdateColumn = false;
                        updateSetStmt.append(" SET \" + \"");
                    } else {
                        updateSeparator = ", ";
                    }
                    updateSetStmt.append(updateSeparator);
                    updateSetStmt.append(getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar() + " = " + getLProtectedChar() + "\" + tmpTableName_" + cid + " + \"" + getRProtectedChar() + "." + getLProtectedChar() + "\" + \"" + column.getOriginalDbColumnName()  + "\" + \"" + getRProtectedChar());
                }
            }
            return updateBulkSQL.toString() + updateSetStmt.toString() + updateWhereStmt.toString();            
        }
        public String generateSetStmt(String typeToGenerate, Column column, int index, 
                String incomingConnName, String cid, int actionType) {
            boolean isObject = false;
            String prefix = null;
            if(actionType == NORMAL_TYPE) {
                prefix = "pstmt_";
            } else if(actionType == INSERT_TYPE) {
                prefix = "pstmtInsert_";
            } else if(actionType == UPDATE_TYPE) {
                prefix = "pstmtUpdate_";
            }
            StringBuilder setStmt = new StringBuilder();
            if(typeToGenerate.equals("Character")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");                
            } else if(typeToGenerate.equals("Date")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DATE);\r\n");                
            } else if(typeToGenerate.equals("byte[]")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.ARRAY);\r\n");                
            } else if(typeToGenerate.equals("Long") || typeToGenerate.equals("Byte") || typeToGenerate.equals("Integer") || typeToGenerate.equals("Short")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.INTEGER);\r\n");                
            } else if(typeToGenerate.equals("String")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.VARCHAR);\r\n");                
            } else if(typeToGenerate.equals("Object")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.OTHER);\r\n");                
            } else if(typeToGenerate.equals("Boolean")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.BOOLEAN);\r\n");                
            } else if(typeToGenerate.equals("Double")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.DOUBLE);\r\n");                
            } else if(typeToGenerate.equals("Float")) {
                isObject = true;
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.FLOAT);\r\n");                
            }
            if(isObject) {
                setStmt.append("} else {");
            }
            typeToGenerate = getGenerateType(typeToGenerate);
            if(typeToGenerate.equals("Char") || typeToGenerate.equals("Character")) {
                if(isObject) {
                    setStmt.append("if(" + incomingConnName + "." + column.getName() + " == null) {\r\n"); 
                } else {
                    setStmt.append("if(String.valueOf(" + incomingConnName + "." + column.getName() + ").toLowerCase().equals(\"null\")) {\r\n");
                }
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.CHAR);\r\n");
                setStmt.append("} else if(" + incomingConnName + "." + column.getName() + " == '\0'){\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", \"\");\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setString(" + index + ", String.valueOf(" + incomingConnName + "." + column.getName() + "));\r\n");
                setStmt.append("}");
            } else if(typeToGenerate.equals("Date")) {
                setStmt.append("if(" + incomingConnName + "." + column.getName() + " != null) {\r\n");
                setStmt.append(prefix + cid + ".setTimestamp(" + index + ", new java.sql.Timestamp(" + incomingConnName + "." + column.getName() + ".getTime()));\r\n");
                setStmt.append("} else {\r\n");
                setStmt.append(prefix + cid + ".setNull(" + index + ", java.sql.Types.TIMESTAMP);\r\n");
                setStmt.append("}\r\n");
            } else {
                if(typeToGenerate.equals("Int")) {
                    setStmt.append(prefix + cid + ".setLong(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");
                } else {
                    setStmt.append(prefix + cid + ".set" + typeToGenerate + "(" + index + ", " + incomingConnName + "." + column.getName() + ");\r\n");                 
                }
            }
            if(isObject) {
                setStmt.append("}\r\n");
            }
            return setStmt.toString();
        }  
        public String getCreateTableSQL(List<Column> columnList){

            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";

                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + length);
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + length);                                    
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                    createSQL.append(suffix);
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }

                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        
        }
        
    }
    
    public class ODBCManager extends Manager {
        public ODBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return ODBC;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }        
    }
    
    public class JDBCManager extends Manager {
        String lChar = "";
        String rChar = "";
        public JDBCManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return JDBC;
        }
        protected String getLProtectedChar() {
            return lChar;
        }
        protected String getRProtectedChar() {
            return rChar;
        }        
        public void setLProtectedChar(String lChar){
            this.lChar = lChar;
        }
        public void setRProtectedChar(String rChar){
            this.rChar = rChar;
        }
    }    
    public class SAPHanaManager extends Manager {

        private String[] sapHanaReservedWords = { "ALL", "ALTER", "AS", "BEFORE", "BEGIN", "BOTH", "CASE", "CHAR", "CONDITION",
                "CONNECT", "CROSS", "CUBE", "CURRENT_CONNECTION", "CURRENT_DATE", "CURRENT_SCHEMA", "CURRENT_TIME",
                "CURRENT_TIMESTAMP", "CURRENT_USER", "CURRENT_UTCDATE", "CURRENT_UTCTIME", "CURRENT_UTCTIMESTAMP", "CURRVAL",
                "CURSOR", "DECLARE", "DISTINCT", "ELSE", "ELSEIF", "ELSIF", "END", "EXCEPT", "EXCEPTION", "EXEC", "FOR", "FROM",
                "FULL", "GROUP", "HAVING", "IF", "IN", "INNER", "INOUT", "INTERSECT", "INTO", "IS", "JOIN", "LEADING", "LEFT",
                "LIMIT", "LOOP", "MINUS", "NATURAL", "NEXTVAL", "NULL", "ON", "ORDER", "OUT", "PRIOR", "RETURN", "RETURNS",
                "REVERSE", "RIGHT", "ROLLUP", "ROWID", "SELECT", "SET", "SQL", "START", "SYSDATE", "SYSTIME", "SYSTIMESTAMP",
                "SYSUUID", "TOP", "TRAILING", "UNION", "USING", "UTCDATE", "UTCTIME", "UTCTIMESTAMP", "VALUES", "WHEN", "WHERE",
                "WHILE", "WITH" };

        public SAPHanaManager(String cid) {
            super(cid);
        }
        protected String getDBMSId() {
            return SAPHANA;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }   
        protected boolean isSapHanaReservedWords (String keyword) {
            for (int i=0 ; i < sapHanaReservedWords.length ; i++){
                if (sapHanaReservedWords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }
        protected String getLProtectedChar(String keyword) {
            if (isSapHanaReservedWords(keyword) || contaionsSpaces(keyword)){
                return "\\\"";
            }
            return getLProtectedChar();
        }
        protected String getRProtectedChar(String keyword) {
            return getLProtectedChar(keyword);
        }    
        protected String getTableName4Search(boolean useExistingConnection, String connection) {
            return "\""+getLProtectedChar()+ "\" + ((String)" + ElementParameterParser.getValue(node,"__TABLE__") + ")" +" + \"" + getRProtectedChar() + "\""; 
        }
        
        protected String getUserName4Search(boolean useExistingConnection, String connection) {
            if (useExistingConnection) {
                return "((String)globalMap.get(\"username_" + connection + "\")).toUpperCase()";
            } else {
                return "((String)" + ElementParameterParser.getValue(node,"__USER__") + ").toUpperCase()";
            }    
        }

        protected String getShemaName4Search(boolean useExistingConnection, String connection) {
            return "dbschema_" + cid + ".toUpperCase()"; 
        }   
        
        protected boolean hasSchema() {
            return true;
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            String table_type = ElementParameterParser.getValue(node,"__TABLE_TYPE__");
            createSQL.append("CREATE "+table_type+" TABLE " + getLProtectedChar() + "\" + tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        createSQL.append(dataType);
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                            if (!precisionIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + precision);
                            }
                            if (!lengthIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (precisionIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + length);
                            }
                            createSQL.append(suffix);
                        } else {
                            if (!lengthIgnored) {
                                prefix = "(";
                                suffix = ") ";
                                createSQL.append(prefix + length);                                    
                            }
                            if (!precisionIgnored) {
                                prefix = (prefix.equals("") ? "(" : prefix);
                                suffix = (suffix.equals("") ? ") " : suffix);
                                if (lengthIgnored) {
                                    createSQL.append(prefix);
                                    comma = "";
                                } else {
                                    comma = ",";
                                }
                                createSQL.append(comma + precision);
                            }
                            createSQL.append(suffix);
                        }                            
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }

    }    
    
    public class ExasolManager extends Manager{
    
		private String[] keywords = { "ABS", "ACOS", "ADD_DAYS", "ADD_HOURS",
				"ADD_MINUTES", "ADD_MONTHS", "ADD_SECONDS", "ADD_WEEKS",
				"ADD_YEARS", "ADMIN", "ALIGN", "ALWAYS", "ANALYZE", "ANSI",
				"ASCII", "ASIN", "ASSIGNMENT", "ASYMMETRIC", "ATAN", "ATAN2",
				"ATOMIC", "AUDIT", "AUTHENTICATED", "AUTO", "AVG", "BACKUP",
				"BERNOULLI", "BIT_AND", "BIT_CHECK", "BIT_LENGTH", "BIT_NOT",
				"BIT_OR", "BIT_SET", "BIT_TO_NUM", "BIT_XOR", "BREADTH",
				"CEIL", "CEILING", "CHANGE", "CHARACTERS", "CHARACTER_LENGTH",
				"CHR", "CLEAR", "COBOL", "COLOGNE_PHONETIC", "COMMENT",
				"COMMENTS", "COMMITTED", "CONCAT", "CONNECT", "CONVERT_TZ",
				"CORR", "COS", "COSH", "COT", "COUNT", "COVAR_POP",
				"COVAR_SAMP", "CREATED", "CROSS", "CURDATE", "DATABASE",
				"DATE_TRUNC", "DAYS_BETWEEN", "DECODE", "DEFAULTS", "DEGREES",
				"DELIMIT", "DELIMITER", "DENSE_RANK", "DEPTH", "DIAGNOSTICS",
				"DICTIONARY", "DISTRIBUTE", "DISTRIBUTION", "DIV", "DOWN",
				"DUMP", "EDIT_DISTANCE", "EMITS", "ENCODING", "ESTIMATE",
				"EVALUATE", "EXA", "EXCLUDE", "EXCLUDING", "EXP", "EXPRESSION",
				"FIRST_VALUE", "FLOOR", "FLUSH", "FOREIGN", "FORTRAN",
				"FROM_POSIX_TIME", "GREATEST", "GROUPING_ID", "HANDLER", "HAS",
				"HASH", "HASH_MD5", "HASH_SHA", "HASH_SHA1", "HASH_TIGER",
				"HIERARCHY", "HOURS_BETWEEN", "IDENTIFIED", "IGNORE",
				"INCLUDING", "INITIALLY", "INSTR", "INVALID", "ISOLATION",
				"IS_BOOLEAN", "IS_DATE", "IS_DSINTERVAL", "IS_NUMBER",
				"IS_TIMESTAMP", "IS_YMINTERVAL", "JAVA", "JAVASCRIPT", "KEEP",
				"KEY", "KEYS", "KILL", "LAG", "LANGUAGE", "LAST_VALUE",
				"LCASE", "LEAD", "LEAST", "LENGTH", "LINK", "LN", "LOCATE",
				"LOCK", "LOG10", "LOG2", "LOGS", "LONG", "LOWER", "LPAD",
				"LTRIM", "LUA", "MAX", "MAXIMAL", "MEDIAN", "MID", "MIN",
				"MINUTES_BETWEEN", "MONTHS_BETWEEN", "MUMPS", "NEVER", "NICE",
				"NORMALIZED", "NOW", "NULLIFZERO", "NULLS", "NUMTODSINTERVAL",
				"NUMTOYMINTERVAL", "NVL", "OCTETS", "OCTET_LENGTH", "OFFSET",
				"OPTIMIZE", "ORA", "OWNER", "PADDING", "PARTITION", "PASCAL",
				"PERCENTILE_CONT", "PERCENTILE_DISC", "PI", "PLI",
				"POSIX_TIME", "POWER", "PRECISION", "PRELOAD", "PRIMARY",
				"PRIORITY", "PRIVILEGE", "PYTHON", "QUERY_CACHE",
				"QUERY_TIMEOUT", "R", "RADIANS", "RAND", "RANK",
				"RATIO_TO_REPORT", "RECOMPRESS", "RECORD", "REGEXP_INSTR",
				"REGEXP_REPLACE", "REGEXP_SUBSTR", "REGR_AVGX", "REGR_AVGY",
				"REGR_COUNT", "REGR_INTERCEPT", "REGR_R2", "REGR_SLOPE",
				"REGR_SXX", "REGR_SXY", "REGR_SYY", "REJECT", "REORGANIZE",
				"REPEATABLE", "REVERSE", "ROLE", "ROUND", "ROWID",
				"ROW_NUMBER", "RPAD", "RTRIM", "SCALAR", "SCHEMAS", "SCHEME",
				"SECONDS_BETWEEN", "SECURE", "SERIALIZABLE", "SHUT", "SIGN",
				"SIMPLE", "SIN", "SINH", "SIZE", "SKIP", "SOUNDEX", "SQRT",
				"STATISTICS", "STDDEV", "STDDEV_POP", "STDDEV_SAMP", "ST_AREA",
				"ST_BOUNDARY", "ST_BUFFER", "ST_CENTROID", "ST_CONTAINS",
				"ST_CONVEXHULL", "ST_CROSSES", "ST_DIFFERENCE", "ST_DIMENSION",
				"ST_DISJOINT", "ST_DISTANCE", "ST_ENDPOINT", "ST_ENVELOPE",
				"ST_EQUALS", "ST_EXTERIORRING", "ST_FORCE2D", "ST_GEOMETRYN",
				"ST_GEOMETRYTYPE", "ST_INTERIORRINGN", "ST_INTERSECTION",
				"ST_INTERSECTS", "ST_ISCLOSED", "ST_ISEMPTY", "ST_ISRING",
				"ST_ISSIMPLE", "ST_LENGTH", "ST_NUMGEOMETRIES",
				"ST_NUMINTERIORRINGS", "ST_NUMPOINTS", "ST_OVERLAPS",
				"ST_POINTN", "ST_SETSRID", "ST_STARTPOINT", "ST_SYMDIFFERENCE",
				"ST_TOUCHES", "ST_TRANSFORM", "ST_UNION", "ST_WITHIN", "ST_X",
				"ST_Y", "SUBSTR", "SUM", "SYMMETRIC", "SYS_CONNECT_BY_PATH",
				"SYS_GUID", "TABLES", "TABLESAMPLE", "TAN", "TANH", "TASKS",
				"TIES", "TIME_ZONE", "TIME_ZONE_BEHAVIOR", "TO_CHAR",
				"TO_DATE", "TO_DSINTERVAL", "TO_NUMBER", "TO_TIMESTAMP",
				"TO_YMINTERVAL", "TRANSLATE", "TRUNC", "TYPE", "UCASE",
				"UNBOUNDED", "UNCOMMITTED", "UNDO", "UNICODE", "UNICODECHR",
				"UNLIMITED", "UPPER", "UTF8", "VARIANCE", "VARYING", "VAR_POP",
				"VAR_SAMP", "WEEK", "WRITE", "YEARS_BETWEEN", "ZEROIFNULL" };
				
        public ExasolManager(String cid) {
            super(cid);
        }

        protected boolean isReservedWord(String keyword) {
            for (int i=0 ; i < keywords.length ; i++){
                if (keywords[i].equalsIgnoreCase(keyword)) {
                    return true;
                }
            }
            return false;
        }

        protected String getDBMSId() {
            return EXASOL;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
        protected String getLProtectedChar(String name) {
        	if (contaionsSpaces(name) || isReservedWord(name)) {
	            return "\\\"";
        	} else {
        		return "";
        	}
        }
        protected String getRProtectedChar(String name) {
        	if (contaionsSpaces(name) || isReservedWord(name)) {
	            return "\\\"";
        	} else {
        		return "";
        	}
        }  
    }
    
    public class SQLDWHManager extends MSSQLManager{
        
        public SQLDWHManager(String cid) {
            super(cid);
        }
        
        public String getDropTableSQL() {
            StringBuilder dropTableSQL = new StringBuilder();
            dropTableSQL.append("DROP EXTERNAL TABLE " + getLProtectedChar() + "\" + ext_tableName_" + cid + " + \"" + getRProtectedChar());
            return dropTableSQL.toString();
        }
        
        public String getCreateTableSQL(List<Column> columnList) {
            MappingTypeRetriever mappingType = MetadataTalendType.getMappingTypeRetriever(getDBMSId());
            StringBuilder createSQL = new StringBuilder();
            createSQL.append("CREATE EXTERNAL TABLE " + getLProtectedChar() + "\" + ext_tableName_" + cid + " + \"" + getRProtectedChar() + "(");
            List<String> pkList = new ArrayList<String>();
            int count = 0;
            String ending = ",";
            
            for (Column column : columnList) {
                if (column.isReplaced()) {
                    List<Column> replacedColumns = column.getReplacement();
                    if (column.isKey()) {
                        for (Column replacedColumn : replacedColumns) {
                            pkList.add(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()));
                        }
                    }
                    int replacedCount = 0;
                    for (Column replacedColumn : replacedColumns) {
                        if (count == columnList.size() - 1 && replacedCount == replacedColumns.size() - 1) {
                            ending = "";
                        }
                        createSQL.append(getLProtectedChar(replacedColumn.getColumnName()) + replacedColumn.getColumnName() + getRProtectedChar(replacedColumn.getColumnName()) + " ");
                        createSQL.append(replacedColumn.getDataType() + ending);
                        replacedCount++;
                    }
                } else {
                    if (count == columnList.size() - 1) {
                        ending = "";
                    }
                    
                    if (column.isAddCol()) {
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        createSQL.append(column.getDataType() + ending);
                    } else if(column.isDynamic()) {
                        createSQL.append(" {TALEND_DYNAMIC_COLUMN} ").append(ending);
                    } else {
                        if (column.isKey()) {
                            pkList.add(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ));
                        }
                        createSQL.append(getLProtectedChar( column.getColumnName() ) + column.getColumnName() + getRProtectedChar( column.getColumnName() ) + " ");
                        String dataType = null;
                        if (column.getColumn().getType() == null || column.getColumn().getType().trim().equals("")) {
                            dataType = mappingType.getDefaultSelectedDbType(column.getColumn().getTalendType());
                        } else {
                            dataType = column.getColumn().getType();
                        }
                        if (MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {                            
                            createSQL.append(dataType.substring(0,dataType.indexOf("UNSIGNED"))) ;                            
                        }else {                            
                            createSQL.append(dataType);
                        }
                        Integer length = column.getColumn().getLength() == null ? 0 : column.getColumn().getLength();
                        Integer precision = column.getColumn().getPrecision() == null ? 0 : column.getColumn().getPrecision();
                        boolean lengthIgnored = mappingType.isLengthIgnored(getDBMSId(), dataType);
                        boolean precisionIgnored = mappingType.isPrecisionIgnored(getDBMSId(), dataType);
                        String prefix = "";
                        String suffix = "";
                        String comma = "";
                        
                        //bug 0016707 fixed:when set INT IDENTITY in schema and use "Specify identity field". the INT IDENTITY in schema by ignored  
                        if(column.isAutoIncrement()) {
                            length = column.getStartValue();
                            precision =  column.getStep();
                            if ("INT IDENTITY".equals(column.column.getType())) {
                                column.setAutoIncrement(false);
                            } 
                        }
                        // end bug0016707
                        
                        if ( (ORACLE.equalsIgnoreCase(getDBMSId()))
                                && (("NUMBER".equalsIgnoreCase(dataType)) || ("CHAR".equalsIgnoreCase(dataType)) || ("NCHAR".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ){} 
                        else if ((MYSQL.equalsIgnoreCase(getDBMSId()))
                                && (("DECIMAL".equalsIgnoreCase(dataType)) || ("NUMERIC".equalsIgnoreCase(dataType))||(("FLOAT".equalsIgnoreCase(dataType)))||("DOUBLE".equalsIgnoreCase(dataType)))
                                && (column.getColumn().getLength() == null || 0 == column.getColumn().getLength())
                                && (column.getColumn().getPrecision() == null || 0 == column.getColumn().getPrecision())
                        ) {}
                        else {
                            if (mappingType.isPreBeforeLength(getDBMSId(), dataType)) {
                                if (!precisionIgnored) {
                                    prefix = "(";
                                    suffix = ") ";
                                    createSQL.append(prefix + precision);
                                }
                                if (!lengthIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (precisionIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + getLengthStringRepresentation(dataType, length));
                                }
                                createSQL.append(suffix);
                            } else {
                                if (!lengthIgnored) {
                                    if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                    
                                    } else { 
                                        prefix = "(";
                                        suffix = ") ";
                                        createSQL.append(prefix + getLengthStringRepresentation(dataType, length));
                                    }
                                }
                                if (!precisionIgnored) {
                                    prefix = (prefix.equals("") ? "(" : prefix);
                                    suffix = (suffix.equals("") ? ") " : suffix);
                                    if (lengthIgnored) {
                                        createSQL.append(prefix);
                                        comma = "";
                                    } else {
                                        comma = ",";
                                    }
                                    createSQL.append(comma + precision);
                                }
                                if ((POSTGRESQL.equalsIgnoreCase(getDBMSId()) || POSTGREPLUS.equalsIgnoreCase(getDBMSId()) ) && column.getColumn().getLength() == null) {                                
                                } else {
                                    createSQL.append(suffix);
                                }
                                if(MYSQL.equalsIgnoreCase(getDBMSId()) && dataType.endsWith("UNSIGNED")) {
                                    createSQL.append("UNSIGNED");
                                }
                            }                            
                            
                        }
                        if(column.isAutoIncrement()) {
                            createSQL.append(getAutoIncrement(column.getStartValue(), column.getStep()));
                        } else {
                            createSQL.append(setDefaultValue(column.getColumn().getDefault(), dataType));
                            createSQL.append(setNullable(column.getColumn().isNullable()));
                        }
                        
                        createSQL.append(ending);
                    }
                }
                count++;
            }
            
            if (pkList.size() > 0) {
                createSQL.append(",primary key(");
                int i = 0;
                for (String pk : pkList) {
                    createSQL.append(pk);
                    if (i != pkList.size() - 1) {
                        createSQL.append(",");
                    }
                    i++;
                }
                createSQL.append(")");
            }
            return createSQL.toString();
        }
        
    }
    
    public class UnDefinedManager extends Manager{
        
        private String dbmsId = "";
        
        public UnDefinedManager(String cid) {
            super(cid);
        }
        public void setDBMSId(String dbmsId){
            this.dbmsId = dbmsId;
        }
        protected String getDBMSId() {
            return this.dbmsId;
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////////
    //the managers which only work for tELTJDBCOutput component, we add it to ignore the text quote which wrap the schema, table or column name.
    
    public class AS400ELTManager extends AS400Manager {
        public AS400ELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class AccessELTManager extends AccessManager {
        public AccessELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class DB2ELTManager extends DB2Manager {
        public DB2ELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class FirebirdELTManager extends FirebirdManager {
        public FirebirdELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class HSQLDBELTManager extends HSQLDBManager {
        public HSQLDBELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class HiveELTManager extends HiveManager {
        public HiveELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class InformixELTManager extends InformixManager {
        public InformixELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class IngresELTManager extends IngresManager {
        public IngresELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class VectorWiseELTManager extends VectorWiseManager {
        public VectorWiseELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class InterbaseELTManager extends InterbaseManager {
        public InterbaseELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class JavaDBELTManager extends JavaDBManager {
        public JavaDBELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MaxDBELTManager extends MaxDBManager {
        public MaxDBELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MSSQLELTManager extends MSSQLManager {
        public MSSQLELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class MysqlELTManager extends MysqlManager {
        public MysqlELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class NetezzaELTManager extends NetezzaManager {
        public NetezzaELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class OracleELTManager extends OracleManager {
        public OracleELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class PostgrePlusELTManager extends PostgrePlusManager {
        public PostgrePlusELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class GreenplumELTManager extends GreenplumManager {
        public GreenplumELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class PostgreELTManager extends PostgreManager {
        public PostgreELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class RedshiftELTManager extends RedshiftManager {
        public RedshiftELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class SQLiteELTManager extends SQLiteManager {
        public SQLiteELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class SybaseELTManager extends SybaseManager {
        public SybaseELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class TeradataELTManager extends TeradataManager {
        public TeradataELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class VerticaELTManager extends VerticaManager {
        public VerticaELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class ExasolELTManager extends ExasolManager {
        public ExasolELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public class SAPHanaELTManager extends SAPHanaManager {
        public SAPHanaELTManager(String cid) {
            super(cid);
        }
        protected String getLProtectedChar() {
            return "";
        }
        protected String getRProtectedChar() {
            return "";
        }
    }
    
    public Manager getELTManager(String dbmsId, String cid) {
        Manager manager = managerMap.get(dbmsId + cid);
        if(manager == null) {
            if(dbmsId.equalsIgnoreCase(AS400)) {
                manager = new AS400ELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ACCESS)) {
                manager = new AccessELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(DB2)) {
                manager = new DB2ELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(FIREBIRD)) {
                manager = new FirebirdELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HSQLDB)) {
                manager = new HSQLDBELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HIVE)) {
                manager = new HiveELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INFORMIX)) {
                manager = new InformixELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INGRES)) {
                manager = new IngresELTManager(cid);         
            } else if(dbmsId.equalsIgnoreCase(VECTORWISE)) {
                manager = new VectorWiseELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INTERBASE)) {
                manager = new InterbaseELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JAVADB)) {
                manager = new JavaDBELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MAXDB)) {
                manager = new MaxDBELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MSSQL)) {
                manager = new MSSQLELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MYSQL)) {
                manager = new MysqlELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(NETEZZA)) {
                manager = new NetezzaELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ORACLE)) {
                manager = new OracleELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGREPLUS)) {
                manager = new PostgrePlusELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(GREENPLUM)) {
                manager = new GreenplumELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGRESQL)) {
                manager = new PostgreELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(REDSHIFT)) {
                manager = new RedshiftELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SQLITE)) {
                manager = new SQLiteELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SYBASE)) {
                manager = new SybaseELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(TERADATA)) {
                manager = new TeradataELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(VERTICA)) {
                manager = new VerticaELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(EXASOL)) {
                manager = new ExasolELTManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SAPHANA)) {
                manager = new SAPHanaELTManager(cid);
            } else {
                manager = new UnDefinedManager(cid);
                ((UnDefinedManager)manager).setDBMSId(dbmsId);
            }
        }
        managerMap.put(dbmsId + cid, manager);
        return manager;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    //ELT part end
    
    public Manager getManager(String dbmsId, String cid) {
        Manager manager = managerMap.get(dbmsId + cid);
        if(manager == null) {
            if(dbmsId.equalsIgnoreCase(AS400)) {
                manager = new AS400Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(ACCESS)) {
                manager = new AccessManager(cid);
            } else if(dbmsId.equalsIgnoreCase(DB2)) {
                manager = new DB2Manager(cid);
            } else if(dbmsId.equalsIgnoreCase(FIREBIRD)) {
                manager = new FirebirdManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HSQLDB)) {
                manager = new HSQLDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(HIVE)) {
                manager = new HiveManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INFORMIX)) {
                manager = new InformixManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INGRES)) {
                manager = new IngresManager(cid);         
            } else if(dbmsId.equalsIgnoreCase(VECTORWISE)) {
                manager = new VectorWiseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(INTERBASE)) {
                manager = new InterbaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JAVADB)) {
                manager = new JavaDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MAXDB)) {
                manager = new MaxDBManager(cid);
            } else if(dbmsId.equalsIgnoreCase(MSSQL)) {
                if(cid != null && cid.indexOf("DWHBulkExec") > -1){
                    manager = new SQLDWHManager(cid);
                }else{
                    manager = new MSSQLManager(cid); 
                }
            } else if(dbmsId.equalsIgnoreCase(MYSQL)) {
                manager = new MysqlManager(cid);
            } else if(dbmsId.equalsIgnoreCase(NETEZZA)) {
                manager = new NetezzaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ORACLE)) {
                manager = new OracleManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGREPLUS)) {
                manager = new PostgrePlusManager(cid);
            } else if(dbmsId.equalsIgnoreCase(GREENPLUM)) {
                manager = new GreenplumManager(cid);
            } else if(dbmsId.equalsIgnoreCase(POSTGRESQL)) {
                manager = new PostgreManager(cid);
            } else if(dbmsId.equalsIgnoreCase(REDSHIFT)) {
                manager = new RedshiftManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SQLITE)) {
                manager = new SQLiteManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SYBASE)) {
                manager = new SybaseManager(cid);
            } else if(dbmsId.equalsIgnoreCase(TERADATA)) {
                manager = new TeradataManager(cid);
            } else if(dbmsId.equalsIgnoreCase(VERTICA)) {
                manager = new VerticaManager(cid);
            } else if(dbmsId.equalsIgnoreCase(ODBC)) {
                manager = new ODBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(JDBC)) {
                manager = new JDBCManager(cid);
            } else if(dbmsId.equalsIgnoreCase(EXASOL)) {
                manager = new ExasolManager(cid);
            } else if(dbmsId.equalsIgnoreCase(SAPHANA)) {
                manager = new SAPHanaManager(cid);
            } else {
                manager = new UnDefinedManager(cid);
                ((UnDefinedManager)manager).setDBMSId(dbmsId);
            }
        }
        managerMap.put(dbmsId + cid, manager);
        return manager;
    }
    
    
    public Manager getManager(String dbmsId, String cid, INode node) {
        Manager manager = getManager(dbmsId, cid);
        manager.setNode(node);
        return manager;
    }
    
    public Manager getELTManager(String dbmsId, String cid, INode node) {
        Manager manager = getELTManager(dbmsId, cid);
        manager.setNode(node);
        return manager;
    }    
    
    public List<IMetadataColumn> getColumnList(INode node) {
        List<IMetadataColumn> columnList = null;
        List<IMetadataTable> metadatas = node.getMetadataList();
        if(metadatas != null && metadatas.size() > 0) {
            IMetadataTable metadata = metadatas.get(0);
            if(metadata != null) {
                columnList = metadata.getListColumns();
                if(metadata.isDynamicSchema() && columnList!=null) {
                    for(int i=columnList.size()-1; i>-1; i--) {
                        IMetadataColumn column = columnList.get(i);
                        if("id_Dynamic".equals(column.getTalendType())){
                            talendDynamicColumn = column;
                            break;
                        }
                    }
                }
            }
        }
        return columnList;
    }
    
    private IMetadataColumn talendDynamicColumn = null;
    
    public IMetadataColumn getDynamicColumn() {
        return talendDynamicColumn;
    }
    
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
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
            
    stringBuffer.append(TEXT_3);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_4);
    
            }
            
    stringBuffer.append(TEXT_5);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_7);
    for(String message : messages){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
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
        
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_15);
    
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
                            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_19);
    
                        }else{
                            String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                            if(value.length()>10000){
                            value = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(value);
                            }
                            
    stringBuffer.append(TEXT_20);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_23);
    
                        }   
                        
    stringBuffer.append(TEXT_24);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_25);
    
                    }
                    debug(var("log4jParamters")); 
                    
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
        } 
        
    
    } 
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_28);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_29);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_30);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_33);
    
                }else{
                
    stringBuffer.append(TEXT_34);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_42);
    
                }
                
    stringBuffer.append(TEXT_43);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_44);
    
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

    stringBuffer.append(TEXT_45);
    
class DBConnLogUtil extends BasicLogUtil{
	
	private DBConnLogUtil(){}
	
	protected DBConnLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logJDBCDriver(String driverClass){
		debug(str("Driver ClassName: "), driverClass, str("."));
	}
	
	public void connTry(String url, String dbUser){
		if(dbUser != null){
			debug(str("Connection attempts to '"), url, str("' with the username '"), dbUser, str("'."));
		}else{
			debug(str("Connection attempts to '"), url, str("'."));
		}
	}
	
	public void connDone(String url){
		debug(str("Connection to '"), url, str("' has succeeded."));
	}
	
	public void useExistConn(String url, String dbUser){
		if(dbUser != null){
			debug(str("Uses an existing connection with username '"), dbUser, str("'. Connection URL: "), url, str("."));
		}else{
			debug(str("Uses an existing connection. Connection URL: "), url, str("."));
		}
	}
	
	public void closeTry(String connCompID){
		if(connCompID == null){
			debug(str("Closing the connection to the database."));
		}else{
			debug(str("Closing the connection "), connCompID, str(" to the database."));
		}
	}
	
	public void closeDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection to the database has closed."));	
		}else{
			debug(str("Connection "), connCompID, str(" to the database has closed."));
		}
	}
}

class DBTableActionLogUtil extends BasicLogUtil{
	private DBTableActionLogUtil(){}
	
	protected DBTableActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void dropTry(String tableName){
		tableActionTry(tableName, str("Dropping"));
	}
	
	public void dropDone(String tableName){
		tableActionDone(tableName, str("Drop"));
	}
	
	public void createTry(String tableName){
		tableActionTry(tableName, str("Creating"));
	}
	
	public void createDone(String tableName){
		tableActionDone(tableName, str("Create"));
	}
	
	public void clearTry(String tableName){
		tableActionTry(tableName, str("Clearing"));
	}
	
	public void clearDone(String tableName){
		tableActionDone(tableName, str("Clear"));
	}
	
	public void truncateTry(String tableName){
		tableActionTry(tableName, str("Truncating"));
	}
	
	public void truncateDone(String tableName){
		tableActionDone(tableName, str("Truncate"));
	}
	
	public void truncateReuseStorageTry(String tableName){
		tableActionTry(tableName, str("Truncating reuse storage"));
	}
	
	public void truncateReuseStorageDone(String tableName){
		tableActionDone(tableName, str("Truncate reuse stroage"));
	}
	
	private void tableActionTry(String tableName, String action){
		debug(action, str(" table '"), tableName, str("'."));
	}
	
	private void tableActionDone(String tableName, String action){
		debug(action, str(" table '"), tableName, str("' has succeeded."));
	}
}

class DBCommitLogUtil extends BasicLogUtil{
	private DBCommitLogUtil(){}
	
	protected DBCommitLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logAutoCommit(String autoCommit){
		debug(str("Connection is set auto commit to '"), autoCommit, str("'."));
	}

	public void commitTry(String connCompID, String commitCount){
		if(commitCount == null && connCompID == null){
			debug(str("Connection starting to commit."));
		}else if(commitCount == null){
			debug(str("Connection "), connCompID, str(" starting to commit."));	
		}else if(connCompID == null){
			debug(str("Connection starting to commit "), commitCount, str(" record(s)."));
		}else{
			debug(str("Connection "), connCompID, str(" starting to commit "), commitCount, str(" record(s)."));
		}
	}
	
	public void commitDone(String connCompID){
		if(connCompID == null){
			debug(str("Connection commit has succeeded."));
		}else{
			debug(str("Connection "), connCompID, (" commit has succeeded."));
		}
	}
}

class DBBatchLogUtil extends BasicLogUtil{
	private DBBatchLogUtil(){}
	
	protected DBBatchLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void executeTry(String action){
		debug(str("Executing the "), action, str(" batch."));
	}
	
	public void executeDone(String action){
		debug(str("The "), action, str(" batch execution has succeeded."));
	}
}

class DBDataActionLogUtil extends BasicLogUtil{
	private DBDataActionLogUtil(){}
	
	protected DBDataActionLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void inserting(String nbline){
		sqlAction(nbline, str("Inserting"));
	}
	
	public void deleting(String nbline){
		sqlAction(nbline, str("Deleting"));
	}
	
	public void updating(String nbline){
		sqlAction(nbline, str("Updating"));
	}
	
	public void replacing(String nbline){
		sqlAction(nbline, str("Replacing"));
	}
	
	public void insertingOnDuplicateKeyUpdating(String nbline){
		sqlAction(nbline, str("Inserting on duplicate key updating"));
	}
	
	public void insertingIgnore(String nbline){
		sqlAction(nbline, str("Inserting ignore"));
	}
	
	private void sqlAction(String nbline, String action){
		if(nbline == null){
			debug(action, str(" the record."));
		}else{
			debug(action, str(" the record "), nbline, str("."));
		}
	}
	
	public void sqlExecuteTry(String sql){
		debug(str("Executing '"), sql, str("'."));
	}
	
	public void sqlExecuteDone(String sql){
		debug(str("Execute '"), sql, str("' has succeeded."));
	}

	public void addingToBatch(String nbline, String batchAction){
		debug(str("Adding the record "), nbline, str(" to the "), batchAction, str(" batch."));
	}
}

class DBStateLogUtil extends BasicLogUtil{
	private DBStateLogUtil(){}
	
	protected DBStateLogUtil(org.talend.core.model.process.INode node){
		super(node);
	}
	
	public void logInsertedLines(String nbline){
		logFinishedLines(nbline, str("inserted"));
	}
	
	public void logUpdatedLines(String nbline){
		logFinishedLines(nbline, str("updated"));
	}
	
	public void logDeletedLines(String nbline){
		logFinishedLines(nbline, str("deleted"));
	}
	
	public void logRejectedLines(String nbline){
		logFinishedLines(nbline, str("rejected"));
	}
	
	private void logFinishedLines(String nbline, String action){
		debug(str("Has "), action, str(" "), nbline, str(" record(s)."));
	}
}	
class DBLogUtil extends LogUtil{
	DBConnLogUtil conn = null;
	DBTableActionLogUtil table = null;
	DBCommitLogUtil commit = null;
	DBBatchLogUtil batch = null;
	DBDataActionLogUtil data = null;
	DBStateLogUtil state = null;
	private DBLogUtil(){}
	
	protected DBLogUtil(org.talend.core.model.process.INode node){
		super(node);
		conn = new DBConnLogUtil(node);
    	table = new DBTableActionLogUtil(node);
    	commit = new DBCommitLogUtil(node);
    	batch = new DBBatchLogUtil(node);
    	data = new DBDataActionLogUtil(node);
    	state = new DBStateLogUtil(node);
	}
	
	public DBConnLogUtil conn(){
		return conn;
	}
	
	public DBTableActionLogUtil table(){
		return table;
	}
	
	public DBCommitLogUtil commit(){
		return commit;
	}
	
	public DBBatchLogUtil batch(){
		return batch;
	}
	
	public DBDataActionLogUtil data(){
		return data;
	}
	
	public DBStateLogUtil state(){
		return state;
	}
}
DBLogUtil dbLog = null;

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<IMetadataColumn> columnList = getColumnList(node);

if(columnList == null || columnList.isEmpty()) {
	return "";
}

dbLog = new DBLogUtil(node);

//some global var
boolean isEnableDebug = ("true").equals(ElementParameterParser.getValue(node, "__DEBUG__"));
String dbmsId = ElementParameterParser.getValue(node,"__MAPPING__");

//get or create db connection statement generation
String useExistingConnection = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
if (("true").equals(useExistingConnection)) {
    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
    String connectionName = "conn_" + connection;
    String username = "username_" + connection;
    
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_50);
    
} else {
	String driverClass = ElementParameterParser.getValue(node, "__DRIVER_CLASS__");
	String jdbcURL = ElementParameterParser.getValue(node, "__URL__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
    
    stringBuffer.append(TEXT_51);
    stringBuffer.append(driverClass);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(jdbcURL );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_56);
    
    String passwordFieldName = "__PASS__";
    
    stringBuffer.append(TEXT_57);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_60);
    } else {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
}

    stringBuffer.append(TEXT_71);
    
Manager manager = getManager(dbmsId, cid, node);

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SCHEMA_DB__"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TABLE_SRC__"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TABLE__"));
    stringBuffer.append(TEXT_78);
    if("redshift_id".equals(dbmsId)) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(manager.getRProtectedChar());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(manager.getLProtectedChar());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    if("redshift_id".equals(dbmsId)) {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    }
    stringBuffer.append(TEXT_99);
    
//table action statement generation
String tableAction = ElementParameterParser.getValue(node, "__TABLE_ACTION__");
String table = ElementParameterParser.getValue(node, "__TABLE__");

String surrogateKey = ElementParameterParser.getValue(node,"__SURROGATE_KEY__");

String surrogateKeyType = ElementParameterParser.getValue(node,"__SK_CREATION__");
boolean autoIncrease = "AUTO_INCREMENT".equals(surrogateKeyType)&&surrogateKey!=null;

List<Column> stmtStructure = null;
if(autoIncrease) {
	stmtStructure = getManager(dbmsId, cid).createColumnList(columnList, false, null, null, true, surrogateKey, 1, 1);
} else {
	stmtStructure = getManager(dbmsId, cid).createColumnList(columnList, false, null, null);
}

boolean isDynamic = false;

    stringBuffer.append(TEXT_100);
    if("TRUNCATE".equals(tableAction)) {

    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    
}
    stringBuffer.append(TEXT_103);
    
//issue 0010346 Parallelization crash with "Drop table if exists and create"
Boolean isParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
boolean convertToUppercase_tableAction = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONVERT_COLUMN_TABLE_TO_UPPERCASE__"));
if (!isParallelize) {
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    manager = getManager(dbmsId, cid);
    
    String ending="";
    
    //TODO need to remove it as it seems not useful now
    if("VECTORWISE".equalsIgnoreCase(dbmsId)) {
        ending="WITH STRUCTURE = VECTORWISE";
    }

    boolean useCascade = "true".equals(ElementParameterParser.getValue(node,"__USE_CASCADE__"));
    
    //bugfix: TDI-31650
    boolean setQueryTimeOut = false;
    String queryTimeOutInSeconds = null;
    if(SYBASE.equalsIgnoreCase(dbmsId)){
        setQueryTimeOut = "true".equals(ElementParameterParser.getValue(node,"__SET_QUERY_TIMEOUT__"));
        queryTimeOutInSeconds = ElementParameterParser.getValue(node,"__QUERY_TIMEOUT_IN_SECONDS__");
    }

    if(!("NONE").equals(tableAction)) {
        if(("DROP_CREATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_109);
    
               }
             
    dbLog.table().dropTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_112);
    stringBuffer.append((useCascade ? " + \" cascade\"" : ""));
    stringBuffer.append(TEXT_113);
    dbLog.table().dropDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_114);
    
                if (TERADATA.equalsIgnoreCase(dbmsId)) {
            
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
                }
            
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_122);
    
               }
             
    dbLog.table().createTry(dbLog.var("tableName"));
    
                if(isDynamic) {
                List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                    if(conns_dynamic!=null && conns_dynamic.size()>0){
                        String query=manager.getCreateTableSQL(stmtStructure);
                    
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_128);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_131);
    
                    }
                } else {
            
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_134);
    
            }
            
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_135);
    
        } else if(("CREATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_141);
    
               }
             
    dbLog.table().createTry(dbLog.var("tableName"));
    
            if(isDynamic) {
                List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                if(conns_dynamic!=null && conns_dynamic.size()>0){
                    String query=manager.getCreateTableSQL(stmtStructure);
                    
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_147);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_148);
    }
    stringBuffer.append(TEXT_149);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_150);
    
                }
            } else {
            
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_153);
    
            }
            
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_154);
    
        } else if(("CREATE_IF_NOT_EXISTS").equals(tableAction) || ("DROP_IF_EXISTS_AND_CREATE").equals(tableAction)) {
            boolean tableNameCaseSensitive=false;
            if(DB2.equalsIgnoreCase(dbmsId)||POSTGRESQL.equalsIgnoreCase(dbmsId)||GREENPLUM.equalsIgnoreCase(dbmsId)||POSTGREPLUS.equalsIgnoreCase(dbmsId)){
                tableNameCaseSensitive=true;
            }
            
    
            //to fixed: bug8422
            if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
            
    stringBuffer.append(TEXT_155);
    //bug22719: informix use independent connection, should remove this code after use shared connection
                if(INFORMIX.equalsIgnoreCase(dbmsId)){
                    String dbnameKey = ElementParameterParser.getValue(node, "__DBNAME__");
                    String dbserverKey = ElementParameterParser.getValue(node, "__DBSERVER__");
                    String dbhostKey = ElementParameterParser.getValue(node, "__HOST__");
                    String dbportKey = ElementParameterParser.getValue(node, "__PORT__");
                    String tableSchemaKey = ElementParameterParser.getValue(node,"__SCHEMA_DB__");
                    
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(dbhostKey);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(dbportKey);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(dbnameKey);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(dbserverKey);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(tableSchemaKey);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_163);
    }else{
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_167);
    }
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    
            }
            
    
                            /*
                            case multi connection access the same db, that maybe have a locked in System table(e.g mssql).
                            so in mssql use "Select" checked the table whether exist.
                            */
                            //TODO we will use like "select" sql intead of use system table to checked table?
                            if(MSSQL.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    
                            } else if (ORACLE.equalsIgnoreCase(dbmsId) || SAPHANA.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_180);
    stringBuffer.append(manager.generateCode4TabelExist());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    
                            } else if ( SYBASE.equalsIgnoreCase(dbmsId)
                                        || INFORMIX.equalsIgnoreCase(dbmsId) ) {
                            
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_208);
    }
    stringBuffer.append(TEXT_209);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_212);
    }
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    
                            } else if( DB2.equalsIgnoreCase(dbmsId) || TERADATA.equalsIgnoreCase(dbmsId)){
                            
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_229);
    }
    stringBuffer.append(TEXT_230);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_231);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_232);
    }
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_235);
    }
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    
                            } else if (GREENPLUM.equalsIgnoreCase(dbmsId) || POSTGRESQL.equalsIgnoreCase(dbmsId) || POSTGREPLUS.equalsIgnoreCase(dbmsId) || VERTICA.equalsIgnoreCase(dbmsId)) {
                            
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_264);
    }
    stringBuffer.append(TEXT_265);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_268);
    }
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    if(!tableNameCaseSensitive){
    stringBuffer.append(TEXT_274);
    }
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    
                            } else if(EXASOL.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    
                            } else if(REDSHIFT.equalsIgnoreCase(dbmsId)) {
                            
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    
                            } else {
                            
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    
                            }
                            
    
                            if(("CREATE_IF_NOT_EXISTS").equals(tableAction)) {
                            
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    
                                       if(setQueryTimeOut){
                                            
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_327);
    
                                       }
                                     
    dbLog.table().createTry(dbLog.var("tableName"));
    
                                    if(isDynamic) {
                                        List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                                        if(conns_dynamic!=null && conns_dynamic.size()>0){
                                            String query=manager.getCreateTableSQL(stmtStructure);
                                            
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_331);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_332);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_333);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_334);
    }
    stringBuffer.append(TEXT_335);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_336);
    
                                        }
                                    } else {
                                    
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_339);
    
                                    }
                                    
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_340);
    
                            } else {
                            
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    
                                           if(setQueryTimeOut){
                                                
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_347);
    
                                           }
                                     
    dbLog.table().dropTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(manager.getDropTableSQL());
    stringBuffer.append(TEXT_350);
    stringBuffer.append((useCascade ? " + \" cascade\"" : ""));
    stringBuffer.append(TEXT_351);
    dbLog.table().dropDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_352);
    
                                        if (TERADATA.equalsIgnoreCase(dbmsId)) {
                                    
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    
                                        }
                                    
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    
                                       if(setQueryTimeOut){
                                        
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_360);
    
                                   }
                                 
    dbLog.table().createTry(dbLog.var("tableName"));
    
                                if(isDynamic) {
                                    List<? extends IConnection> conns_dynamic = node.getIncomingConnections();
                                    if(conns_dynamic!=null && conns_dynamic.size()>0){
                                        String query=manager.getCreateTableSQL(stmtStructure);
                                        
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(conns_dynamic.get(0).getName());
    stringBuffer.append(TEXT_364);
    stringBuffer.append(getDynamicColumn());
    stringBuffer.append(TEXT_365);
    stringBuffer.append(dbms==null?"":dbms.toLowerCase());
    stringBuffer.append(TEXT_366);
    if(convertToUppercase_tableAction){
    stringBuffer.append(TEXT_367);
    }
    stringBuffer.append(TEXT_368);
    stringBuffer.append(ending);
    stringBuffer.append(TEXT_369);
    
                                    }
                                } else {
                                
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(manager.getCreateTableSQL(stmtStructure));
    stringBuffer.append(TEXT_372);
    
                                }
                                
    dbLog.table().createDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_373);
    
                            }
                            
    
            //to fixed: bug8422
            if((cid.equals("talendLogs_DB") || cid.equals("talendStats_DB") || cid.equals("talendMeter_DB"))){
            
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    
            }
            
    
        } else if(("CLEAR").equals(tableAction)) {
        
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_381);
    
               }
             
    dbLog.table().clearTry(dbLog.var("tableName"));
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(manager.getDeleteTableSQL());
    stringBuffer.append(TEXT_384);
    dbLog.table().clearDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_385);
    
        }else if(("TRUNCATE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_392);
    
               }
             
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    
               if(setQueryTimeOut){
                    
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_403);
    stringBuffer.append( queryTimeOutInSeconds );
    stringBuffer.append(TEXT_404);
    
               }
             
    dbLog.table().truncateTry(dbLog.var("tableName"));
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    }
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(manager.getTruncateTableSQL());
    stringBuffer.append(TEXT_409);
    if(INFORMIX.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_410);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    }
    dbLog.table().truncateDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    
        } else if(("TRUNCATE_REUSE_STORAGE").equals(tableAction)) {
        
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(manager.getSelectionSQL());
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    dbLog.table().truncateReuseStorageTry(dbLog.var("tableName"));
    if(DB2.equalsIgnoreCase(dbmsId)){
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    }
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(manager.getTruncateReuseStroageTableSQL());
    stringBuffer.append(TEXT_428);
    dbLog.table().truncateReuseStorageDone(dbLog.var("tableName"));
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    
        }
    }
//issue 0010346 Parallelization crash with "Drop table if exists and create"
}
//end issue 0010346 Parallelization crash with "Drop table if exists and create"

    stringBuffer.append(TEXT_433);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(tableAction);
    stringBuffer.append(TEXT_436);
    
}

    stringBuffer.append(TEXT_437);
    
class TextUtil {
	Manager manager;
	
	TextUtil(Manager manager) {
		this.manager = manager;
	}
	
	String wrap(String objectName) {
		return manager.getLProtectedChar() + objectName + manager.getRProtectedChar();
	}
	
	String wrap(String var, String cid) {
		return manager.getLProtectedChar() + "\" + " + var + "_" + cid + " + \"" + manager.getRProtectedChar();
	}
}

TextUtil text_util = new TextUtil(manager);

    stringBuffer.append(TEXT_438);
    if("DB_SEQUENCE".equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__"));
    stringBuffer.append(TEXT_441);
    if("snowflake_id".equals(dbmsId)) {
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    }else{
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(text_util.wrap("sequence", cid));
    stringBuffer.append(TEXT_453);
    }
    }
    stringBuffer.append(TEXT_454);
    if("mysql_id".equals(dbmsId)) {
    stringBuffer.append(TEXT_455);
    stringBuffer.append(TEXT_456);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + StringUtils.getMysqlProtectedColumnName(sk.get("NAME")) + " = t." + StringUtils.getMysqlProtectedColumnName(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getMysqlProtectedColumnName(sk.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getMysqlProtectedColumnName(sk.get("NAME")));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
    	strFieldName = StringUtils.getMysqlProtectedColumnName(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(" d." + strFieldName + " = t." + strFieldName);
        if(isFieldValueIncNull){
            whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
       	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    
    }
}

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        strFieldName = StringUtils.getMysqlProtectedColumnName(type2Attribute.get("NAME"));
    	if(isFieldValueIncNull){
        	whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
     	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_474);
    if(isEnableDebug){
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    
    for(IMetadataColumn column:columnList){
    	if(startDateField.equals(column.getLabel())){
	
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(column.getType());
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(column.getPattern()==""?"\"\"":column.getPattern());
    stringBuffer.append(TEXT_486);
    
    	}else if(endDateField.equals(column.getLabel())){
    
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(dbmsId);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(column.getType());
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_492);
    stringBuffer.append(column.getPattern()==""?"\"\"":column.getPattern());
    stringBuffer.append(TEXT_493);
    
        	}
        }
	}

    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    if (isEnableActive) {
    stringBuffer.append(TEXT_500);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_501);
    }
    stringBuffer.append(TEXT_502);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    if (isEnableActive) {
    stringBuffer.append(TEXT_517);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_518);
    }
    stringBuffer.append(TEXT_519);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_520);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getMysqlProtectedColumnName(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getMysqlProtectedColumnName(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(StringUtils.getMysqlProtectedColumnName(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(StringUtils.getMysqlProtectedColumnName(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(StringUtils.getMysqlProtectedColumnName(startDateField));
    columnNames.add(StringUtils.getMysqlProtectedColumnName(endDateField));
    if(isEnableActive) {
        columnNames.add(StringUtils.getMysqlProtectedColumnName(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(StringUtils.getMysqlProtectedColumnName(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    if(isEnableActive) {
    stringBuffer.append(TEXT_531);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_532);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_533);
    }
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_538);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_549);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    if(isEnableActive) {
    stringBuffer.append(TEXT_552);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_553);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_554);
    }
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_558);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_563);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + StringUtils.getMysqlProtectedColumnName(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_568);
    if(isEnableType2) {
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    }
    stringBuffer.append(TEXT_571);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_572);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_573);
    }
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(outerWhereClauseString);
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
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_587);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_588);
    if(isEnableType2) {
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    }
    stringBuffer.append(TEXT_591);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_592);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_593);
    }
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_600);
    
}

    stringBuffer.append(TEXT_601);
    } else if("oracle_id".equals(dbmsId)){
    stringBuffer.append(TEXT_602);
    stringBuffer.append(TEXT_603);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_610);
    
String selectColumnString = "";
String columnNameString = "";
List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + sk.get("NAME") + " = t." + sk.get("NAME"));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(sk.get("NAME"));
            }
        } else {
            columnNames.add(sk.get("NAME"));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(type1Attribute.get("NAME"));
        setColumns.add(type1Attribute.get("NAME"));
        if(isFieldValueIncNull){
            whereClause.add("( d." + type1Attribute.get("NAME") + " is null AND t." + type1Attribute.get("NAME")+" is not null )");
        	whereClause.add("( d." + type1Attribute.get("NAME") + " is not null AND t." + type1Attribute.get("NAME")+" is null )");
        }
        whereClause.add("( d." + type1Attribute.get("NAME") + " <> t." + type1Attribute.get("NAME")+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    
    }
}

String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");
String l2StartDateFieldType = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD_TYPE__");
String l2EndDateFieldType = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD_TYPE__");
String l2StartDateFieldInputFieldName =  ElementParameterParser.getValue(node,"__INPUT_FIELD_NAME__");
String l2EndDateFieldFixedYearValue = ElementParameterParser.getValue(node,"__FIXED_YEAR_VALUE__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
    	if(isFieldValueIncNull){
        	whereClause.add("( d." + type2Attribute.get("NAME") + " is null AND t." + type2Attribute.get("NAME")+" is not null )");
        	whereClause.add("( d." + type2Attribute.get("NAME") + " is not null AND t." + type2Attribute.get("NAME")+" is null )");
      	}
        whereClause.add("( d." + type2Attribute.get("NAME") + " <> t." + type2Attribute.get("NAME")+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_633);
    if ("INPUT_FIELD".equals(l2StartDateFieldType)){
    stringBuffer.append(TEXT_634);
    stringBuffer.append(l2StartDateFieldInputFieldName);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_637);
    }else{
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid );
    }
    stringBuffer.append(TEXT_639);
    if (isEnableActive) {
    stringBuffer.append(TEXT_640);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_641);
    }
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_646);
    if ("NULL".equals(l2EndDateFieldType)) {
    
    stringBuffer.append(TEXT_647);
    
    }else if ("FIXED_YEAR_VALUE".equals(l2EndDateFieldType)) {
    
    stringBuffer.append(TEXT_648);
    stringBuffer.append(l2EndDateFieldFixedYearValue);
    stringBuffer.append(TEXT_649);
    
    }
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_655);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_658);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(sourceKey.get("NAME"));
            }
        } else {
            columnNames.add(sourceKey.get("NAME"));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(type1Attribute.get("NAME"));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(type2Attribute.get("NAME"));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(startDateField);
    columnNames.add(endDateField);
    if(isEnableActive) {
        columnNames.add(activeField);
    }
    if(isEnableVersion) {
        columnNames.add(versionField);
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_661);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_662);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_663);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_664);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_665);
    }
    stringBuffer.append(TEXT_666);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_667);
    if ("JOB_START_TIME".equals(l2StartDateFieldType)) { // job start time
    
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid );
    
    }else if ("INPUT_FIELD".equals(l2StartDateFieldType)){
    
    stringBuffer.append(TEXT_669);
    stringBuffer.append(l2StartDateFieldInputFieldName);
    stringBuffer.append(TEXT_670);
    
    }
    stringBuffer.append(TEXT_671);
    if ("NULL".equals(l2EndDateFieldType)) {
     
    stringBuffer.append(TEXT_672);
    
     }else if ("FIXED_YEAR_VALUE".equals(l2EndDateFieldType)) {
     
    stringBuffer.append(TEXT_673);
    stringBuffer.append(l2EndDateFieldFixedYearValue);
    stringBuffer.append(TEXT_674);
    
     }
    stringBuffer.append(TEXT_675);
    if(isEnableActive) {
    stringBuffer.append(TEXT_676);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_677);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_678);
    }
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_684);
    if ("INPUT_FIELD".equals(l2StartDateFieldType)){
    stringBuffer.append(TEXT_685);
    stringBuffer.append(l2StartDateFieldInputFieldName);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_688);
    }else{
    stringBuffer.append(TEXT_689);
    stringBuffer.append(cid );
    }
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_695);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_698);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + sk.get("NAME") + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_702);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_703);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_704);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_705);
    }
    stringBuffer.append(TEXT_706);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_707);
    if(isEnableType2) {
    stringBuffer.append(TEXT_708);
    if ("JOB_START_TIME".equals(l2StartDateFieldType)) {
	
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_710);
    
	}else if ("INPUT_FIELD".equals(l2StartDateFieldType)){
	
    stringBuffer.append(TEXT_711);
    stringBuffer.append(l2StartDateFieldInputFieldName);
    stringBuffer.append(TEXT_712);
    
	}
    stringBuffer.append(TEXT_713);
    if ("NULL".equals(l2EndDateFieldType)) {
	
    stringBuffer.append(TEXT_714);
    
	}else if ("FIXED_YEAR_VALUE".equals(l2EndDateFieldType)) {
	
    stringBuffer.append(TEXT_715);
    stringBuffer.append(l2EndDateFieldFixedYearValue);
    stringBuffer.append(TEXT_716);
    
	}
    stringBuffer.append(TEXT_717);
    }
    stringBuffer.append(TEXT_718);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_719);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_720);
    }
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_724);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_728);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_730);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_733);
    
}

    stringBuffer.append(TEXT_734);
    } else if("teradata_id".equals(dbmsId)){
    stringBuffer.append(TEXT_735);
    stringBuffer.append(TEXT_736);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

String selectColumnString = "";
String columnNameString = "";
List<String> joinClause = new ArrayList<String>();
List<String> updateJoinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + sk.get("NAME") + " = t." + sk.get("NAME"));
    updateJoinClause.add("\" + tableName_" + cid + " + \"." + sk.get("NAME") + " = t." + sk.get("NAME"));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");
String updateJoinClauseString = StringUtils.join(updateJoinClause.toArray(), " AND ");

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(sk.get("NAME"));
            }
        } else {
            columnNames.add(sk.get("NAME"));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(type1Attribute.get("NAME"));
        setColumns.add(type1Attribute.get("NAME") + " = t." + type1Attribute.get("NAME"));
        if(isFieldValueIncNull){
            whereClause.add("(\" + tableName_" + cid + " + \"." + type1Attribute.get("NAME") + " is null AND t." + type1Attribute.get("NAME")+" is not null )");
            whereClause.add("(\" + tableName_" + cid + " + \"." + type1Attribute.get("NAME") + " is not null AND t." + type1Attribute.get("NAME")+" is null )");
        }
        whereClause.add("(\" + tableName_" + cid + " + \"." + type1Attribute.get("NAME") + " <> t." + type1Attribute.get("NAME")+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_740);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_741);
    stringBuffer.append(updateJoinClauseString);
    stringBuffer.append(TEXT_742);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_743);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_745);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_747);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_748);
    
}

String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = "true".equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = "true".equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");
if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    List<String> updateWhereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        if(isFieldValueIncNull){
            whereClause.add("(d." + type2Attribute.get("NAME") + " is null AND t." + type2Attribute.get("NAME")+" is not null )");
            whereClause.add("(d." + type2Attribute.get("NAME") + " is not null AND t." + type2Attribute.get("NAME")+" is null )");
            updateWhereClause.add("(\" + tableName_" + cid + " + \"." + type2Attribute.get("NAME") + " is null AND t." + type2Attribute.get("NAME")+" is not null )");
            updateWhereClause.add("(\" + tableName_" + cid + " + \"." + type2Attribute.get("NAME") + " is not null AND t." + type2Attribute.get("NAME")+" is null )");
        }
        whereClause.add("(d." + type2Attribute.get("NAME") + " <> t." + type2Attribute.get("NAME")+")");
        updateWhereClause.add("(\" + tableName_" + cid + " + \"." + type2Attribute.get("NAME") + " <> t." + type2Attribute.get("NAME")+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    String updateWhereClauseString = StringUtils.join(updateWhereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_749);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_750);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_752);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_754);
    if(isEnableActive) {
    stringBuffer.append(TEXT_755);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_756);
    }
    stringBuffer.append(TEXT_757);
    stringBuffer.append(updateJoinClauseString);
    stringBuffer.append(TEXT_758);
    stringBuffer.append(updateWhereClauseString);
    stringBuffer.append(TEXT_759);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_760);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_761);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_762);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_763);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_764);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_765);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_766);
    
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(sourceKey.get("NAME"));
            }
        } else {
            columnNames.add(sourceKey.get("NAME"));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(type1Attribute.get("NAME"));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(type2Attribute.get("NAME"));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(startDateField);
    columnNames.add(endDateField);
    if(isEnableActive) {
        columnNames.add(activeField);
    }
    if(isEnableVersion) {
        columnNames.add(versionField);
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_767);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_768);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_769);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_770);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_771);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_772);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_773);
    }
    stringBuffer.append(TEXT_774);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_776);
    if(isEnableActive) {
    stringBuffer.append(TEXT_777);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_778);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_779);
    }
    stringBuffer.append(TEXT_780);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_781);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_782);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_783);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_784);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_786);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_787);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_788);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_789);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_790);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_791);
    
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + sk.get("NAME") + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_794);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_795);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_796);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_797);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_798);
    }
    stringBuffer.append(TEXT_799);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_800);
    if(isEnableType2) {
    stringBuffer.append(TEXT_801);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_802);
    }
    stringBuffer.append(TEXT_803);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_804);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_805);
    }
    stringBuffer.append(TEXT_806);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_807);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_808);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_809);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_810);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_811);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_812);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_814);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_815);
    

    stringBuffer.append(TEXT_816);
    } else if("postgresplus_id".equals(dbmsId)){
    stringBuffer.append(TEXT_817);
    stringBuffer.append(TEXT_818);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

String selectColumnString = "";
String columnNameString = "";

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")) +
            " = t." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();        
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")));
        setColumns.add(StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")) + 
                " = t." + StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")));
        whereClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")) + 
                " <> t." + StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")));            
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");    
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");    
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_819);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_820);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_821);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_822);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_823);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_824);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_825);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_826);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_827);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_828);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_829);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_830);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_831);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_832);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_833);
    
    }
}

String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");    
if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        whereClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME")) + 
                " <> t." + StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME")));
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_834);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_835);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_836);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_837);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_838);
    if(isEnableActive) {
    stringBuffer.append(TEXT_839);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_840);
    }
    stringBuffer.append(TEXT_841);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_842);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_843);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_844);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_845);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_846);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_847);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_848);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_849);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_850);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_851);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_852);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_853);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(StringUtils.getPostgresqlProtectedColumnName(startDateField));
    columnNames.add(StringUtils.getPostgresqlProtectedColumnName(endDateField));
    if(isEnableActive) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_854);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_855);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_856);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_857);
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_858);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_859);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_860);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_861);
    }
    stringBuffer.append(TEXT_862);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_863);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_864);
    if(isEnableActive) {
    stringBuffer.append(TEXT_865);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_866);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_867);
    }
    stringBuffer.append(TEXT_868);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_869);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_870);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_871);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_872);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_873);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_874);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_875);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_876);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_877);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_878);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_879);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_880);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_881);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_882);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_883);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_884);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_885);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_886);
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_887);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_888);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_889);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_890);
    }
    stringBuffer.append(TEXT_891);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_892);
    if(isEnableType2) {
    stringBuffer.append(TEXT_893);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_894);
    }
    stringBuffer.append(TEXT_895);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_896);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_897);
    }
    stringBuffer.append(TEXT_898);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_899);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_900);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_901);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_902);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_903);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_904);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_905);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_906);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_907);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_908);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_909);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_910);
    
}

    stringBuffer.append(TEXT_911);
    } else if("ibmdb2_id".equals(dbmsId)){
    stringBuffer.append(TEXT_912);
    stringBuffer.append(TEXT_913);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")) +
            " = t." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
    	strFieldName = StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(strFieldName);
        if(isFieldValueIncNull){
            whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
       	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");    
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_914);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_915);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_916);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_917);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_918);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_919);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_920);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_921);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_922);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_923);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_924);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_925);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_926);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_927);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_928);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_929);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_930);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_931);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_932);
    
    }
}

String endDateFieldType="DATE";
String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
    	strFieldName = StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME"));
    	if(isFieldValueIncNull){
        	whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
     	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    for(IMetadataColumn column : columnList) {
    	if(endDateField!=null && endDateField.equals(column.getLabel())){
    		endDateFieldType=column.getType();
    		break;
    	}
    }
    
    stringBuffer.append(TEXT_933);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_934);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_935);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_936);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_937);
    if (isEnableActive) {
    stringBuffer.append(TEXT_938);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_939);
    }
    stringBuffer.append(TEXT_940);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_941);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_942);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_943);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_944);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_945);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_946);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_947);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_948);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_949);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_950);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_951);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_952);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(StringUtils.getPostgresqlProtectedColumnName(startDateField));
    columnNames.add(StringUtils.getPostgresqlProtectedColumnName(endDateField));
    if(isEnableActive) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_953);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_954);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_955);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_956);
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_957);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_958);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_959);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_960);
    }
    stringBuffer.append(TEXT_961);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_962);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_963);
    stringBuffer.append(endDateFieldType);
    stringBuffer.append(TEXT_964);
    if(isEnableActive) {
    stringBuffer.append(TEXT_965);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_966);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_967);
    }
    stringBuffer.append(TEXT_968);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_969);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_970);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_971);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_972);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_973);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_974);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_975);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_976);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_977);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_978);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_979);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_980);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_981);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_982);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_983);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_984);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_985);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_986);
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_987);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_988);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_989);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_990);
    }
    stringBuffer.append(TEXT_991);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_992);
    if(isEnableType2) {
    stringBuffer.append(TEXT_993);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_994);
    stringBuffer.append(endDateFieldType);
    stringBuffer.append(TEXT_995);
    }
    stringBuffer.append(TEXT_996);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_997);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_998);
    }
    stringBuffer.append(TEXT_999);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1008);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1011);
    
}

    stringBuffer.append(TEXT_1012);
    } else if("postgres_id".equals(dbmsId)){
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(TEXT_1014);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")) +
            " = t." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")));                
        }
    }
    
    for(Map<String, String> type1Attribute : type1Attributes) {
        strFieldName = StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(strFieldName +  " = t." + strFieldName);                    
        whereClause.add(" COALESCE(d." + strFieldName + "<> t."+ strFieldName + ", (d." + strFieldName + " is null and not t." + strFieldName + " is null) or (not d." + strFieldName + " is null and t." + strFieldName + " is null))");                   
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");    
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");    
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1026);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1029);
    
    }
}

String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        strFieldName = StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME"));            
        whereClause.add(" COALESCE(d." + strFieldName + "<> t."+ strFieldName + ", (d." + strFieldName + " is null and not t." + strFieldName + " is null) or (not d." + strFieldName + " is null and t." + strFieldName + " is null))");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1034);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_1036);
    }
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1046);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1049);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(StringUtils.getPostgresqlProtectedColumnName(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(StringUtils.getPostgresqlProtectedColumnName(startDateField));
    columnNames.add(StringUtils.getPostgresqlProtectedColumnName(endDateField));
    if(isEnableActive) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(StringUtils.getPostgresqlProtectedColumnName(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1052);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_1054);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1055);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_1057);
    }
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1060);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1061);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_1063);
    }
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1075);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1077);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1078);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + StringUtils.getPostgresqlProtectedColumnName(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_1079);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1080);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1081);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_1083);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1084);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_1085);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_1086);
    }
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1088);
    if(isEnableType2) {
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1090);
    }
    stringBuffer.append(TEXT_1091);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_1092);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_1093);
    }
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1103);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1106);
    
}

    stringBuffer.append(TEXT_1107);
    } else if("sybase_id".equals(dbmsId)){
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(TEXT_1109);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

String selectColumnString = "";
String columnNameString = "";

List<String> joinClause = new ArrayList<String>();
List<String> updateJoinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + sk.get("NAME") + " = t." + sk.get("NAME"));
    updateJoinClause.add("\" + tableName_" + cid + " + \"." + sk.get("NAME") + " = t." + sk.get("NAME"));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");
String updateJoinClauseString = StringUtils.join(updateJoinClause.toArray(), " AND ");

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();        
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(sk.get("NAME"));
            }
        } else {
            columnNames.add(sk.get("NAME"));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(type1Attribute.get("NAME"));
        setColumns.add(type1Attribute.get("NAME") + " = t." + type1Attribute.get("NAME"));
        if(isFieldValueIncNull){
            whereClause.add("(\" + tableName_" + cid + " + \"." + type1Attribute.get("NAME") + " is null AND t." + type1Attribute.get("NAME")+" is not null )");
        	whereClause.add("(\" + tableName_" + cid + " + \"." + type1Attribute.get("NAME") + " is not null AND t." + type1Attribute.get("NAME")+" is null )");
        }
        whereClause.add("(\" + tableName_" + cid + " + \"." + type1Attribute.get("NAME") + " <> t." + type1Attribute.get("NAME")+")");            
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");    
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1112);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(updateJoinClauseString);
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1121);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1124);
    
    }
}

String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    List<String> updateWhereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
    	if(isFieldValueIncNull){
       		whereClause.add("(d." + type2Attribute.get("NAME") + " is null AND t." + type2Attribute.get("NAME")+" is not null )");
        	whereClause.add("(d." + type2Attribute.get("NAME") + " is not null AND t." + type2Attribute.get("NAME")+" is null )");
        	updateWhereClause.add("(\" + tableName_" + cid + " + \"." + type2Attribute.get("NAME") + " is null AND t." + type2Attribute.get("NAME")+" is not null )");
        	updateWhereClause.add("(\" + tableName_" + cid + " + \"." + type2Attribute.get("NAME") + " is not null AND t." + type2Attribute.get("NAME")+" is null )");
        }
        whereClause.add("(d." + type2Attribute.get("NAME") + " <> t." + type2Attribute.get("NAME")+")");
        updateWhereClause.add("(\" + tableName_" + cid + " + \"." + type2Attribute.get("NAME") + " <> t." + type2Attribute.get("NAME")+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    String updateWhereClauseString = StringUtils.join(updateWhereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_1128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1129);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1130);
    stringBuffer.append(activeField);
    stringBuffer.append(TEXT_1131);
    }
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1133);
    stringBuffer.append(updateJoinClauseString);
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(updateWhereClauseString);
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1136);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1142);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1145);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(sourceKey.get("NAME"));
            }
        } else {
            columnNames.add(sourceKey.get("NAME"));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(type1Attribute.get("NAME"));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(type2Attribute.get("NAME"));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(startDateField);
    columnNames.add(endDateField);
    if(isEnableActive) {
        columnNames.add(activeField);
    }
    if(isEnableVersion) {
        columnNames.add(versionField);
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1148);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_1149);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1150);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_1152);
    }
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1155);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1156);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(versionField);
    stringBuffer.append(TEXT_1158);
    }
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(endDateField);
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1170);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1173);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + sk.get("NAME") + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_1174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1176);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(surrogateKey);
    stringBuffer.append(TEXT_1177);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1178);
    if(("DB_SEQUENCE").equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_1179);
    stringBuffer.append(sequenceName);
    stringBuffer.append(TEXT_1180);
    }
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1182);
    if(isEnableType2) {
    stringBuffer.append(TEXT_1183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1184);
    }
    stringBuffer.append(TEXT_1185);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_1186);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_1187);
    }
    stringBuffer.append(TEXT_1188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1190);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1197);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1200);
    
}

    stringBuffer.append(TEXT_1201);
    } else if("redshift_id".equals(dbmsId)){
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(TEXT_1203);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + text_util.wrap(sk.get("NAME")) + " = t." + text_util.wrap(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sk.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sk.get("NAME")));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
    	strFieldName = text_util.wrap(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(" " + strFieldName + " = t." + strFieldName);
        if(isFieldValueIncNull){
            whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
       	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1216);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1219);
    
    }
}

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

boolean useSequence = "DB_SEQUENCE".equals(surrogateKeyType);
String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        strFieldName = text_util.wrap(type2Attribute.get("NAME"));
    	if(isFieldValueIncNull){
        	whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
     	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1226);
    if (isEnableActive) {
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(text_util.wrap(activeField));
    stringBuffer.append(TEXT_1228);
    }
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1239);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1242);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(text_util.wrap(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(text_util.wrap(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(text_util.wrap(startDateField));
    columnNames.add(text_util.wrap(endDateField));
    if(isEnableActive) {
        columnNames.add(text_util.wrap(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(text_util.wrap(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1245);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1246);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1247);
    if(useSequence) {
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1249);
    }
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1252);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1253);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_1254);
    stringBuffer.append(text_util.wrap(versionField));
    stringBuffer.append(TEXT_1255);
    }
    stringBuffer.append(TEXT_1256);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1257);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1259);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1267);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1270);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + text_util.wrap(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_1271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1273);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1274);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1275);
    if(useSequence) {
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1277);
    }
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1279);
    if(isEnableType2) {
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1281);
    }
    stringBuffer.append(TEXT_1282);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_1283);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_1284);
    }
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1294);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1297);
    
}

    } else if("netezza_id".equals(dbmsId)||"snowflake_id".equals(dbmsId)){
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(TEXT_1299);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + text_util.wrap(sk.get("NAME")) + " = t." + text_util.wrap(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sk.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sk.get("NAME")));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
    	strFieldName = text_util.wrap(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(" " + strFieldName + " = t." + strFieldName);
        if(isFieldValueIncNull){
            whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
       	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1311);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1314);
    
    }
}

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

boolean useSequence = "DB_SEQUENCE".equals(surrogateKeyType);
String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        strFieldName = text_util.wrap(type2Attribute.get("NAME"));
    	if(isFieldValueIncNull){
        	whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
     	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1318);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1321);
    if (isEnableActive) {
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(text_util.wrap(activeField));
    stringBuffer.append(TEXT_1323);
    }
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1333);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1336);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(text_util.wrap(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(text_util.wrap(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(text_util.wrap(startDateField));
    columnNames.add(text_util.wrap(endDateField));
    if(isEnableActive) {
        columnNames.add(text_util.wrap(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(text_util.wrap(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1339);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1340);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1341);
    if(useSequence) {
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1343);
    }
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1346);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1347);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(text_util.wrap(versionField));
    stringBuffer.append(TEXT_1349);
    }
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1361);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1364);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + text_util.wrap(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_1365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1367);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1368);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1369);
    if(useSequence) {
    stringBuffer.append(TEXT_1370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1371);
    }
    stringBuffer.append(TEXT_1372);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1373);
    if(isEnableType2) {
    stringBuffer.append(TEXT_1374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1375);
    }
    stringBuffer.append(TEXT_1376);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_1377);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_1378);
    }
    stringBuffer.append(TEXT_1379);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1380);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1381);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1382);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1388);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1391);
    
}

    } else if("vertica_id".equals(dbmsId)){
    stringBuffer.append(TEXT_1392);
    stringBuffer.append(TEXT_1393);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" \"+tableName_"+cid+"+\"." + text_util.wrap(sk.get("NAME")) + " = t." + text_util.wrap(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

if("DB_SEQUENCE".equals(surrogateKeyType)) {
    stringBuffer.append(TEXT_1394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1396);
    }

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sk.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sk.get("NAME")));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
    	strFieldName = text_util.wrap(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(" " + strFieldName + " = t." + strFieldName);
        if(isFieldValueIncNull){
            whereClause.add("( \"+tableName_"+cid+"+\"." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( \"+tableName_"+cid+"+\"." + strFieldName + " is not null AND t." + strFieldName + " is null )");
       	}
        whereClause.add("( \"+tableName_"+cid+"+\"." + strFieldName + " <> t." + strFieldName+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1398);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1399);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_1400);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1401);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1402);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1408);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1411);
    
    }
}

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

boolean useSequence = "DB_SEQUENCE".equals(surrogateKeyType);
String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        strFieldName = text_util.wrap(type2Attribute.get("NAME"));
    	if(isFieldValueIncNull){
        	whereClause.add("( \"+tableName_"+cid+"+\"." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( \"+tableName_"+cid+"+\"." + strFieldName + " is not null AND t." + strFieldName + " is null )");
     	}
        whereClause.add("( \"+tableName_"+cid+"+\"." + strFieldName + " <> t." + strFieldName+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1413);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1414);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1415);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1416);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1417);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1418);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1420);
    if (isEnableActive) {
    stringBuffer.append(TEXT_1421);
    stringBuffer.append(text_util.wrap(activeField));
    stringBuffer.append(TEXT_1422);
    }
    stringBuffer.append(TEXT_1423);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1424);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1425);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1426);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1427);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1433);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1436);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(text_util.wrap(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(text_util.wrap(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(text_util.wrap(startDateField));
    columnNames.add(text_util.wrap(endDateField));
    if(isEnableActive) {
        columnNames.add(text_util.wrap(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(text_util.wrap(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_1437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1438);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1439);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1440);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1441);
    if(useSequence) {
    stringBuffer.append(TEXT_1442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1443);
    }
    stringBuffer.append(TEXT_1444);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1446);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1447);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_1448);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1449);
    stringBuffer.append(text_util.wrap(versionField));
    stringBuffer.append(TEXT_1450);
    }
    stringBuffer.append(TEXT_1451);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1452);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1453);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1454);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1455);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1456);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1463);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1465);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1466);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" \"+tableName_"+cid+"+\"." + text_util.wrap(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_1467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1468);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1469);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1470);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1471);
    if(useSequence) {
    stringBuffer.append(TEXT_1472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1473);
    }
    stringBuffer.append(TEXT_1474);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1475);
    if(isEnableType2) {
    stringBuffer.append(TEXT_1476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1477);
    }
    stringBuffer.append(TEXT_1478);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_1479);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_1480);
    }
    stringBuffer.append(TEXT_1481);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1482);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1483);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1484);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1490);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1493);
    
}

    } else if("saphana_id".equals(dbmsId)){
    stringBuffer.append(TEXT_1494);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + text_util.wrap(sk.get("NAME")) + " = t." + text_util.wrap(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sk.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sk.get("NAME")));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
    	strFieldName = text_util.wrap(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(" " + strFieldName + " = t." + strFieldName);
        if(isFieldValueIncNull){
            whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
       	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1496);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1497);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_1498);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1499);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1500);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1501);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1507);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1510);
    
    }
}

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

boolean useSequence = "DB_SEQUENCE".equals(surrogateKeyType);
String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        strFieldName = text_util.wrap(type2Attribute.get("NAME"));
    	if(isFieldValueIncNull){
        	whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
     	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1512);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1513);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1514);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1515);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1517);
    if (isEnableActive) {
    stringBuffer.append(TEXT_1518);
    stringBuffer.append(text_util.wrap(activeField));
    stringBuffer.append(TEXT_1519);
    }
    stringBuffer.append(TEXT_1520);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1521);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1522);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1523);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1524);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1530);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1533);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(text_util.wrap(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(text_util.wrap(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(text_util.wrap(startDateField));
    columnNames.add(text_util.wrap(endDateField));
    if(isEnableActive) {
        columnNames.add(text_util.wrap(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(text_util.wrap(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_1534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1535);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1536);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1537);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1538);
    if(useSequence) {
    stringBuffer.append(TEXT_1539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1540);
    }
    stringBuffer.append(TEXT_1541);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1542);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1543);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1544);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_1545);
    stringBuffer.append(text_util.wrap(versionField));
    stringBuffer.append(TEXT_1546);
    }
    stringBuffer.append(TEXT_1547);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1548);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1549);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1550);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1551);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1553);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1554);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1558);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1560);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1561);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + text_util.wrap(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_1562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1563);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1564);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1565);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1566);
    if(useSequence) {
    stringBuffer.append(TEXT_1567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1568);
    }
    stringBuffer.append(TEXT_1569);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1570);
    if(isEnableType2) {
    stringBuffer.append(TEXT_1571);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1572);
    }
    stringBuffer.append(TEXT_1573);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_1574);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_1575);
    }
    stringBuffer.append(TEXT_1576);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1577);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1578);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1579);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1581);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1585);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1586);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1587);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1588);
    
}

    } else {
    stringBuffer.append(TEXT_1589);
    stringBuffer.append(TEXT_1590);
    
boolean isEnableType1 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L1__"));
List<Map<String, String>> type1Attributes = new ArrayList<Map<String, String>>();
if(isEnableType1) {
    type1Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L1_FIELDS__");
}

boolean isEnableType2 = ("true").equals(ElementParameterParser.getValue(node, "__USE_L2__"));
List<Map<String, String>> type2Attributes = new ArrayList<Map<String, String>>();
if(isEnableType2) {
    type2Attributes = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__L2_FIELDS__");
}

List<Map<String, String>> sourceKeys = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__SOURCE_KEYS__");

boolean isEqualWithSK = false;
for(Map<String, String> sk : sourceKeys) {
    if(surrogateKey.equals(sk.get("NAME"))) {
        isEqualWithSK = true;
        break;
    }
}

boolean isFieldValueIncNull = ("true").equals(ElementParameterParser.getValue(node, "__FIELD_VALUE_INC_NULL__"));

List<String> joinClause = new ArrayList<String>();
for(Map<String, String> sk : sourceKeys) {
    joinClause.add(" d." + text_util.wrap(sk.get("NAME")) + " = t." + text_util.wrap(sk.get("NAME")));
}
String joinClauseString = StringUtils.join(joinClause.toArray(), " AND ");

String strFieldName = "";
String selectColumnString = "";
String columnNameString = "";

if(isEnableType1) {
    List<String> columnNames = new ArrayList<String>();
    List<String> setColumns = new ArrayList<String>();
    List<String> whereClause = new ArrayList<String>();
    for(Map<String, String> sk : sourceKeys) {
        if(isEqualWithSK) {
            if(!sk.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sk.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sk.get("NAME")));
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
    	strFieldName = text_util.wrap(type1Attribute.get("NAME"));
        columnNames.add(strFieldName);
        setColumns.add(" " + strFieldName + " = t." + strFieldName);
        if(isFieldValueIncNull){
            whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
       	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    String setColumnsString = StringUtils.join(setColumns.toArray(), ", ");
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1592);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1593);
    stringBuffer.append(setColumnsString);
    stringBuffer.append(TEXT_1594);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1595);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1596);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1597);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1599);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1600);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1603);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1606);
    
    }
}

String startDateField = ElementParameterParser.getValue(node,"__L2_STARTDATE_FIELD__");
String endDateField = ElementParameterParser.getValue(node,"__L2_ENDDATE_FIELD__");
boolean isEnableActive = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_ACTIVE__"));
String activeField = ElementParameterParser.getValue(node,"__L2_ACTIVE_FIELD__");
boolean isEnableVersion = ("true").equals(ElementParameterParser.getValue(node,"__USE_L2_VERSION__"));
String versionField = ElementParameterParser.getValue(node,"__L2_VERSION_FIELD__");

boolean useSequence = "DB_SEQUENCE".equals(surrogateKeyType);
String sequenceName = ElementParameterParser.getValue(node,"__SK_DB_SEQUENCE__");

if(isEnableType2) {
    List<String> whereClause = new ArrayList<String>();
    for (Map<String, String> type2Attribute : type2Attributes) {
        strFieldName = text_util.wrap(type2Attribute.get("NAME"));
    	if(isFieldValueIncNull){
        	whereClause.add("( d." + strFieldName + " is null AND t." + strFieldName + " is not null )");
        	whereClause.add("( d." + strFieldName + " is not null AND t." + strFieldName + " is null )");
     	}
        whereClause.add("( d." + strFieldName + " <> t." + strFieldName+")");
    }
    String whereClauseString = StringUtils.join(whereClause.toArray(), " OR ");
    
    stringBuffer.append(TEXT_1607);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1608);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1609);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1610);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1611);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1613);
    if (isEnableActive) {
    stringBuffer.append(TEXT_1614);
    stringBuffer.append(text_util.wrap(activeField));
    stringBuffer.append(TEXT_1615);
    }
    stringBuffer.append(TEXT_1616);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1617);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1618);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1619);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1620);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1622);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1626);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1629);
    
    }
    List<String> columnNames = new ArrayList<String>();
    for(Map<String, String> sourceKey : sourceKeys) {
        if(isEqualWithSK) {
            if(!sourceKey.get("NAME").equals(surrogateKey)) {
                columnNames.add(text_util.wrap(sourceKey.get("NAME")));
            }
        } else {
            columnNames.add(text_util.wrap(sourceKey.get("NAME")));                
        }
    }
    for(Map<String, String> type1Attribute : type1Attributes) {
        columnNames.add(text_util.wrap(type1Attribute.get("NAME")));
    }
    for(Map<String, String> type2Attribute : type2Attributes) {
        columnNames.add(text_util.wrap(type2Attribute.get("NAME")));
    }
    selectColumnString = StringUtils.join(columnNames.toArray(), ", t.");
    columnNames.add(text_util.wrap(startDateField));
    columnNames.add(text_util.wrap(endDateField));
    if(isEnableActive) {
        columnNames.add(text_util.wrap(activeField));
    }
    if(isEnableVersion) {
        columnNames.add(text_util.wrap(versionField));
    }
    columnNameString = StringUtils.join(columnNames.toArray(), ", ");
    
    stringBuffer.append(TEXT_1630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1631);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1632);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1633);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1634);
    if(useSequence) {
    stringBuffer.append(TEXT_1635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1636);
    }
    stringBuffer.append(TEXT_1637);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1638);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1639);
    if(isEnableActive) {
    stringBuffer.append(TEXT_1640);
    }
    if(isEnableVersion) {
    stringBuffer.append(TEXT_1641);
    stringBuffer.append(text_util.wrap(versionField));
    stringBuffer.append(TEXT_1642);
    }
    stringBuffer.append(TEXT_1643);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1644);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1645);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1646);
    stringBuffer.append(whereClauseString);
    stringBuffer.append(TEXT_1647);
    stringBuffer.append(text_util.wrap(endDateField));
    stringBuffer.append(TEXT_1648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1654);
    
    if(isEnableDebug) {
        
    stringBuffer.append(TEXT_1655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1656);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1657);
    
    }
}

List<String> outerWhereClause = new ArrayList<String>();
for (Map<String, String> sk : sourceKeys) {
    outerWhereClause.add(" d." + text_util.wrap(sk.get("NAME")) + " IS NULL");
}
String outerWhereClauseString = StringUtils.join(outerWhereClause.toArray(), " AND ");

    stringBuffer.append(TEXT_1658);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1659);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1660);
    if(useSequence) {
    stringBuffer.append(text_util.wrap(surrogateKey));
    stringBuffer.append(TEXT_1661);
    }
    stringBuffer.append(columnNameString);
    stringBuffer.append(TEXT_1662);
    if(useSequence) {
    stringBuffer.append(TEXT_1663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1664);
    }
    stringBuffer.append(TEXT_1665);
    stringBuffer.append(selectColumnString);
    stringBuffer.append(TEXT_1666);
    if(isEnableType2) {
    stringBuffer.append(TEXT_1667);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1668);
    }
    stringBuffer.append(TEXT_1669);
    if(isEnableType2 && isEnableActive) {
    stringBuffer.append(TEXT_1670);
    }
    if(isEnableType2 && isEnableVersion) {
    stringBuffer.append(TEXT_1671);
    }
    stringBuffer.append(TEXT_1672);
    stringBuffer.append(text_util.wrap("sourceTable", cid));
    stringBuffer.append(TEXT_1673);
    stringBuffer.append(text_util.wrap("tableName", cid));
    stringBuffer.append(TEXT_1674);
    stringBuffer.append(joinClauseString);
    stringBuffer.append(TEXT_1675);
    stringBuffer.append(outerWhereClauseString);
    stringBuffer.append(TEXT_1676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1677);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1679);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1681);
    
if(isEnableDebug) {
    
    stringBuffer.append(TEXT_1682);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1683);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1684);
    
}

    }
    return stringBuffer.toString();
  }
}
