%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=%cd%/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/advancedPersistentLookupLib-1.2.jar;../lib/commons-collections-3.2.2.jar;../lib/dom4j-1.6.1.jar;../lib/gt-xsd-core-8.5.jar;../lib/jboss-serialization.jar;../lib/jts-1.12.jar;../lib/log4j-1.2.17.jar;../lib/org.talend.sdi.jar;../lib/postgresql-8.4-703.jdbc4.jar;../lib/trove.jar;evaluacion_docente_observaciones_0_1.jar; dmindicadores.evaluacion_docente_observaciones_0_1.evaluacion_docente_observaciones  %*