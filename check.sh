#!/bin/bash

if [ -z "$1" ]
then
    echo "Problem name is required as the first argument."
    echo "eg: ./check.sh Helloworld"
    exit 0
    
fi
problem="$1"    #problem name as first variable

#compiling .java file
if ! javac $problem.java;
then
    echo "Compilation Failed"
    exit 0;
else
    echo "Compiled $problem.java successfully"
fi

#enumerate all .in files in the same directory
for i in *.in
do
    java $problem < $i > ${i/.in/.o}
    results=$( diff ${i/.in/.o} ${i/.in/.out} > ${i/.in/.diff})
    if [ $? -eq 0 ]     #check if there is a difference between the two files
    then
        echo ${i/.in}": Correct"
        rm ${i/.in/.o} ${i/.in/.diff}
    else
        echo ${i/.in}": Incorrect"
        echo "Output in ${i/.in/.o}, diff in ${i/.in/.diff} (< your output | > official output)"
    fi
done