#!/bin/bash -x
# @ production environment, remove -x option
# beschreibung
# (c) Oct 2019 oliver

# you can use this function for debug messages
# usage: command: "debug File Is Open" --(gives oputput)--> "At 11:44:00 File Is Open"
function debug()
{
  if [ "${DEBUG_IS_ON}" = "yes" ]
  then
    NOW=$(date +"%T")
    echo "At $NOW Debug: ${*}" >&2
  fi
}

function exampleDebug(){

	debug funtionnamen 'parameter'
}

function start(){
	JAVA_HOME=/c/Portable/JDKs/jdk1.8.0_212/
	
	echo $JAVA_HOME
	mvn package	

	run
}

function run(){
	/c/Portable/JDKs/jdk1.8.0_212/bin/java -version


	/c/Portable/JDKs/jdk1.8.0_212/bin/java -jar  ./target/database-1.0.0-SNAPSHOT.jar
}

start