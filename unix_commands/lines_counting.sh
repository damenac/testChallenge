#!/bin/sh

# Variable with the input file
file=$1

echo "Counting the lines existing in the file:" $file

# Establish a link to the stardard input
exec 10<&0
exec < $file

# Loop couting the lines
let count=0

while read LINE
do 
    ((count++))
done

echo "Number of lines: $count"
echo "Expected number of lines: `wc -l $file`"

# Restore stdin
exec 0<&10 10<&-