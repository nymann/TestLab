COMPONENT=Asteroids
JAVA_FILES=$(shell find ${COMPOENT} -type f -name "*.java")
POM_FILES=$(shell find ${COMPOENT} -type f -name "pom.xml")
PACKAGE=bin/TestLab.jar

default all:run 

test: ${JAVA_FILES}
	mvn test -f ${COMPONENT}/pom.xml

${PACKAGE}: ${JAVA_FILES} ${POM_FILES}
	mvn install -f ${COMPONENT}/pom.xml
	mvn package -f ${COMPONENT}/Core/pom.xml

package: ${PACKAGE}

run: ${PACKAGE}
	java -jar ${PACKAGE}
