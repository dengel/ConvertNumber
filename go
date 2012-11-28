set -x

rm -f *.class *.jar

javac ConvertNumber.java 

jar cvf0m ConvertNumber.jar manifest.txt *.class

java -jar ConvertNumber.jar $RANDOM

java -jar ConvertNumber.jar 
