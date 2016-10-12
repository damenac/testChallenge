#!/bin/sh

# Variable with the input file
file=$1

current_value=`tr "[:lower:]" "[:upper:]" < $file`
echo $current_value >> results/output.txt