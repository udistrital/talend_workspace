#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Dfile.encoding=UTF-8 -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/dom4j-1.6.1.jar:$ROOT_PATH/../lib/gt-xsd-core-8.5.jar:$ROOT_PATH/../lib/jts-1.12.jar:$ROOT_PATH/../lib/log4j-1.2.17.jar:$ROOT_PATH/../lib/org.talend.sdi.jar:$ROOT_PATH/../lib/postgresql-8.4-703.jdbc4.jar:$ROOT_PATH/evaluacion_docente_parcial_total_0_1.jar: dmindicadores.evaluacion_docente_parcial_total_0_1.evaluacion_docente_parcial_total  "$@"