%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=%cd%/../lib -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/dom4j-1.6.1.jar;../lib/gt-xsd-core-8.5.jar;../lib/jaxen-1.1.1.jar;../lib/jts-1.12.jar;../lib/log4j-1.2.17.jar;../lib/ojdbc7.jar;../lib/org.talend.sdi.jar;../lib/postgresql-8.4-703.jdbc4.jar;../lib/sdoapi.jar;../lib/sdoutil.jar;../lib/talend-oracle-timestamptz.jar;notas_0_1.jar; dmindicadores.notas_0_1.notas  %*