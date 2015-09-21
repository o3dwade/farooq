#!/bin/sh
# Tell Skype to dial a number

if [ -z "$1" ]
      then
            echo "usage: skypecall PHONE_NUMBER"
            exit 65
fi
until [ -z "$1" ]

do
    osascript -l AppleScript -e "tell application \"Skype\" to get URL \"callto://$1\""
    shift
done &
sleep 59
killall -m "Skype"
exit 0
