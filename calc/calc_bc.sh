#!/bin/bash
#!/bin/bash
i=0
while [ $i -lt $1 ]
do 
i=$(echo  $i+1|bc)
done
echo $i
