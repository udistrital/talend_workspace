%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=%cd%/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/dom4j-1.6.1.jar;../lib/gt-xsd-core-8.5.jar;../lib/jts-1.12.jar;../lib/log4j-1.2.17.jar;../lib/org.talend.sdi.jar;../lib/postgresql-8.4-703.jdbc4.jar;../lib/postgresql-9.4-1201.jdbc41.jar;../lib/talend_file_enhanced_20070724.jar;../lib/talendcsv.jar;snies_0_1.jar; co_udistrital_temporal.snies_0_1.snies  %*