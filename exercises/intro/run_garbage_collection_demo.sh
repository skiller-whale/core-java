#!/bin/bash

java -Xlog:gc -Xms8m -Xmx8m src/main/java/com/skillerwhale/GarbageCollectionDemo.java 2>&1 | awk '/^0$/ { found=1 } found { print; fflush()}'
