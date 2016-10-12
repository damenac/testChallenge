#!/bin/sh
echo "Creating a the Petit Prince history in the file ./results/petit_prince.txt"

# Checking if the folder exists. If don't, then create it.
if [ ! -d "results" ]; then
    mkdir results
fi

# Checking ig the file already exists. If don't, then create it.
cat test_data/petit_prince.txt > results/output.txt