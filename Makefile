#!/bin/bash
build:
	javac Algoritmi/*.java
	mkdir heapOut AVLOut

run:
	java Algoritmi.Test

clean:
	rm -rf Algoritmi/*.class AVLOut/* heapOut/*
	rmdir heapOut AVLOut