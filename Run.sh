#!/bin/bash

#Simulacion/nbproject/project.properties
#https://foojay.io/

cd Proyecto1-SO/Java/
wget -c https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz -O - | tar -xz
cd ..
cd ..
ant compile
ant run

exit


