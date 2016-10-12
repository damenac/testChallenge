#!/bin/sh

# Variable with the input file
file=$1

echo "Counting the words existing in the file:" $file
echo "Number of words: `wc -w $file`"