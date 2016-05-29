#!/bin/bash

i=0
while [ $i -lt $1 ]
do 
i=$(expr $i + 1)
done
echo $i
