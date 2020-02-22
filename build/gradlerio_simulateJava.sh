#!/bin/bash

export HALSIM_EXTENSIONS=/home/obsoletek/Documents/Robotics/2020-Code/build/tmp/expandedArchives/halsim_gui-2020.2.2-linuxx86-64.zip_610e45e91d03ab83a3bbd8869a141bce/linux/x86-64/shared/libhalsim_gui.so
export LD_LIBRARY_PATH=/home/obsoletek/Documents/Robotics/2020-Code/build/tmp/jniExtractDir
export DYLD_FALLBACK_LIBRARY_PATH=/home/obsoletek/Documents/Robotics/2020-Code/build/tmp/jniExtractDir
"/usr/lib/jvm/java-11-openjdk-amd64/bin/java" -Djava.library.path="/home/obsoletek/Documents/Robotics/2020-Code/build/tmp/jniExtractDir" -jar "/home/obsoletek/Documents/Robotics/2020-Code/build/libs/2020-Code.jar"
