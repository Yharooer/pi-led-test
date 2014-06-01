Charlieplexing Test Program for Raspberry Pi
===========
A program which tests Charlieplexing with the Raspberry Pi with 4 Pins. It asks the user which LED it should turn on and turns it on.
  
## Setup ##
There should be two circuits which look like this:  
<img xlink:href="http://bentleycarr.com/res_local/tech/clock_charlieplexing.svg" src="http://bentleycarr.com/res_local/tech/clock_charlieplexing.svg" />  
where each of the four parts at the bottom correspond to `GPIO0`-`GPIO7` on the following diagram:
<img src="http://pi4j.com/images/p1header.png" />  
Image from <a href="http://pi4j.com/usage#Pin_Numbering">pi4j.com</a>.  
  
Then execute:

    wget https://pi4j.googlecode.com/files/pi4j-1.0-SNAPSHOT.deb
    sudo dpkg -i pi4j-1.0-SNAPSHOT.deb
    wget https://github.com/Yharooer/Pi-LED-Test/blob/master/bin/PiLEDTest.jar
    
## Usage ##
    java -jar PiLEDTest.jar
