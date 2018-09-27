#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/advancedPersistentLookupLib-1.2.jar:$ROOT_PATH/../lib/commons-collections-3.2.2.jar:$ROOT_PATH/../lib/dom4j-1.6.1.jar:$ROOT_PATH/../lib/gt-xsd-core-8.5.jar:$ROOT_PATH/../lib/jaxen-1.1.1.jar:$ROOT_PATH/../lib/jboss-serialization.jar:$ROOT_PATH/../lib/jts-1.12.jar:$ROOT_PATH/../lib/log4j-1.2.17.jar:$ROOT_PATH/../lib/ojdbc7.jar:$ROOT_PATH/../lib/org.talend.sdi.jar:$ROOT_PATH/../lib/postgresql-8.4-703.jdbc4.jar:$ROOT_PATH/../lib/sdoapi.jar:$ROOT_PATH/../lib/sdoutil.jar:$ROOT_PATH/../lib/talend-oracle-timestamptz.jar:$ROOT_PATH/../lib/trove.jar:$ROOT_PATH/evaluacion_docente_inscritos_0_1.jar: dmindicadores.evaluacion_docente_inscritos_0_1.evaluacion_docente_inscritos  "$@"