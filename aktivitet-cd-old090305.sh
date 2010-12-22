#!/bin/sh

echo "1"
eject -t /dev/scd0
sleep 3s
echo "2"
eject -t /dev/scd0
echo "3"
mount /dev/scd0
echo "4"
sleep 5s
umount /dev/scd0
echo "5"
sleep 10s

echo "6"
eject -T /dev/scd0


umount /dev/scd0
