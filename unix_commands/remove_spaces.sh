#!/bin/sh

# Checking if the folder exists. If don't, then create it.
if [ ! -d "results" ]; then
    mkdir results
fi

# Variable with the input file
file=$1

sed 's/[[:space:]]//g' <$file > results/petit_prince_reloaded.txt

# Note: The 'g' at the end of the sed patterns is to indicate that the command should be applied globally and not only in the first occurence of each line. 