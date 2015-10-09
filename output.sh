#!/bin/bash

shopt -s extglob
cd "${0%/*}"

ASSIGNMENT=assignment${1}

OUTFILE=completed/$ASSIGNMENT.txt

FILES=$(ls $ASSIGNMENT/*.java | grep -v 'Main.java')

printf "******************************************\n" > $OUTFILE
echo $ASSIGNMENT/Main.java >> $OUTFILE
printf "******************************************\n" >> $OUTFILE
cat $ASSIGNMENT/Main.java >> $OUTFILE

for file in $FILES
do
  printf "\n\n******************************************\n" >> $OUTFILE
  echo $file >> $OUTFILE
  printf "******************************************\n" >> $OUTFILE
  cat $file >> $OUTFILE
done

printf "\n\n******************************************\nCONSOLE OUTPUT" >> $OUTFILE
printf "\n******************************************\n" >> $OUTFILE

./exec.sh $1 >> $OUTFILE
