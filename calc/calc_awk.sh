#!/bin/bash

i=0
while [ $i -lt $1 ]
do 
i=$(echo "$i 1" | awk '{printf $1+$2}')
done
echo $i
