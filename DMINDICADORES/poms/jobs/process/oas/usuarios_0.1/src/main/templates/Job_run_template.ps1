$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' '-Dfile.encoding=UTF-8' -cp '.;../lib/routines.jar;../lib/dom4j-1.6.1.jar;../lib/gt-xsd-core-8.5.jar;../lib/jts-1.12.jar;../lib/log4j-1.2.17.jar;../lib/org.talend.sdi.jar;../lib/postgresql-8.4-703.jdbc4.jar;usuarios_0_1.jar;' dmindicadores.usuarios_0_1.usuarios  %*