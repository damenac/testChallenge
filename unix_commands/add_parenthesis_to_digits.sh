#!/bin/sh

# Checking if the folder exists. If don't, then create it.
if [ ! -d "results" ]; then
    mkdir results
fi

# Variable with the input file
file=$1

sed 's/[[:digit:]]/(&)/g' <$file > results/output.txt

# Note: The 'g' at the end of the sed patterns is to indicate that the command should be applied globally and not only in the first occurence of each line. 