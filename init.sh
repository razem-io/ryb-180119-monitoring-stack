#!/bin/sh

echo
echo                                                                     
echo "RRRRRRRRRRRRRRRRR   YYYYYYY       YYYYYYYBBBBBBBBBBBBBBBBB   "
echo "R::::::::::::::::R  Y:::::Y       Y:::::YB::::::::::::::::B  "
echo "R::::::RRRRRR:::::R Y:::::Y       Y:::::YB::::::BBBBBB:::::B "
echo "RR:::::R     R:::::RY::::::Y     Y::::::YBB:::::B     B:::::B"
echo "  R::::R     R:::::RYYY:::::Y   Y:::::YYY  B::::B     B:::::B"
echo "  R::::R     R:::::R   Y:::::Y Y:::::Y     B::::B     B:::::B"
echo "  R::::RRRRRR:::::R     Y:::::Y:::::Y      B::::BBBBBB:::::B "
echo "  R:::::::::::::RR       Y:::::::::Y       B:::::::::::::BB  "
echo "  R::::RRRRRR:::::R       Y:::::::Y        B::::BBBBBB:::::B "
echo "  R::::R     R:::::R       Y:::::Y         B::::B     B:::::B"
echo "  R::::R     R:::::R       Y:::::Y         B::::B     B:::::B"
echo "  R::::R     R:::::R       Y:::::Y         B::::B     B:::::B"
echo "RR:::::R     R:::::R       Y:::::Y       BB:::::BBBBBB::::::B"
echo "R::::::R     R:::::R    YYYY:::::YYYY    B:::::::::::::::::B "
echo "R::::::R     R:::::R    Y:::::::::::Y    B::::::::::::::::B  "
echo "RRRRRRRR     RRRRRRR    YYYYYYYYYYYYY    BBBBBBBBBBBBBBBBB   "
echo
echo

mkdir -p ./data/influxdb/data
mkdir -p ./data/jenkins/data
mkdir -p ./data/grafana/data
mkdir -p ./data/telegraf/conf
touch ./data/telegraf/conf/telegraf.conf

branch=$(git symbolic-ref --short -q HEAD)
echo Init of $branch done! 
echo
echo
