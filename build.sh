#!/bin/sh

export PROJECT_NAME=GarisKuKer
export PACKAGE_NAME=${PROJECT_NAME}.jar
export PACKAGE_PATH=$PWD/dist/
export OUTPUT_PATH=$PWD/bin

## *** Check java binaries ***
if [ -z "$JAVA_HOME" ] ; then
  JAVAC=javac
  JAR=jar
else
  JAVAC=$JAVA_HOME/bin/javac
  JAR=$JAVA_HOME/bin/jar
fi
if [ ! -d "$JAVAC" ] ; then
  JAVAC=/usr/bin/javac
  JAR=jar
fi

## *** Prepare a java sources list
echo "SIAPKAN SOURCE: DONE"
SOURCE_FILES=`find $PWD -name '*.java'`
export SOURCE_FILES

## *** Prepare output directories ***
echo "SIAPKAN OUTPUT: DONE"
rm -rf $OUTPUT_PATH
mkdir -p $OUTPUT_PATH

## *** Compile classes ***
$JAVAC -nowarn -d $OUTPUT_PATH $SOURCE_FILES

if [ $? -ne 0 ]; then
	echo "Gagal failed."
	exit 1
fi

## *** Copy all package sources except *.java
cd src
cp -rf . $OUTPUT_PATH
find $OUTPUT_PATH -name '*.java' -exec rm -f {} \;
cd ..

## *** Make a package ***
$JAR -cmvf manifest.mf $PACKAGE_PATH${PACKAGE_NAME} -C $OUTPUT_PATH .
