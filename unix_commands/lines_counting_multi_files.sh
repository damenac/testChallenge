#!/bin/sh

# Validating if the size of list of parameters ($#) is less than (-lt) 1.
if [ $# -lt 1 ]
then
  echo "ERROR: We need, at least, one file in the parameter"
  exit 1
fi

# A loop on the list of parameters
echo "Computing amount of lines in the files: "
for file_name in $*
do
   echo "  -$file_name"
done

# Loop couting the lines
let count=0

for f in $*
do
    # Pointing the standard input to the current file
    exec 10<&0
    exec < $f
    
    while read LINE
    do 
        ((count++))
    done
    
    # Restoring the standard input
    exec 0<&10 10<&-
done

echo "  * Amount of lines in the input files: $count"

# Be careful with the variables of the loop. We cannot use the same!

# Checking the answer with the wc command
oracle=0
for file_ref in $*
do
    current_value=`wc -l $file_ref | sed 's/^\([0-9]*\).*$/\1/' | sed 's/[[:space:]]//g'`
    #current_value=1
    #Look at this way of increasing the variables!
    oracle=$[ $oracle + $current_value ]
done

echo "  * The value should be: $oracle"