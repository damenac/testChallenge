#!/bin/sh

# Variable with the input file
file=$1

# The file is not modified. We need an indirection to create a new file with the content. 
tr -s " " < $file > results/petit_prince.txt