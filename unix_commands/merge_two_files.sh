#!/bin/sh

# Variable with the input file
left_file=$1
right_file=$2

# Validating if the size of list of parameters ($#) is equals to 2.
if [ $# -ne 2 ]
then
  echo "ERROR: We need two parameters"
  exit 1
fi

merged_content=`cat $left_file`
merged_content="$merged_content `cat $right_file`"
echo $merged_content > results/output.txt