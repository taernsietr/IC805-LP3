#!/bin/bash

# This script is meant to facilitate building java projects;
# An argument such as "Main" must be given to build the project;
# If a lib folder is present, it will be added to the classpath

CWD=$(pwd)

clear

if [[ -f $CWD/*.class ]]; then
  echo "# Class files found, purging..."
  rm -i $CWD/*.class
else
  echo "# No class files found."
fi

if [[ -d $CWD/lib ]]; then
  echo "# Directory has a lib folder, adding to classpath..."
  javac -cp ".:lib/*" $1.java
  java -cp ".:lib/*" $1
else
  javac $1.java
  java $1
fi
