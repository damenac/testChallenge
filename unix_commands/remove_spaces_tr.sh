#!/bin/sh


# Variable with the input file
file=$1

# Look at the indirection! This command modifies the original file.
tr -d " " < $file