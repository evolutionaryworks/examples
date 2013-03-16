#!/bin/sh
java -classpath memoryleak.jar -XX:+PrintClassHistogram -Dcom.sun.management.jmxremote -Xms100M -Xmx100M -XX:MaxPermSize=32M -XX:PermSize=32M com.evolutionaryworks.training.whitebox.MemoryLeakTest
