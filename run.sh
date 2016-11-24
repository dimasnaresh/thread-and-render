#!/bin/sh

export PACKAGE_NAME=dist/GarisKuKer.jar
export MAIN_CLASS=com.dimas.gariskuker.MyFrame

## *** Check lokasi java ***
if [ -z "$JAVA_HOME" ] ; then
  JAVA=java
else
  JAVA=/usr/bin/java
fi
  $JAVA -cp $PACKAGE_NAME:$LIB_PATH $MAIN_CLASS $1

