BUILD_DIR = build
SRC_DIR = src
TST_DIR = tst

SIMPLE = Simple
PACKAGE = tec
TEST_EXEC = $$(find ${BUILD_DIR} -name 'Test*.class' | cut -d. -f1 | cut -d/ -f3)

all : simple

simple : 
	javac -d ${BUILD_DIR} ${SRC_DIR}/*.java 	
	java -cp ${BUILD_DIR} ${SIMPLE}

tests :
	javac -d ${BUILD_DIR} ${SRC_DIR}/*.java
	javac -d ${BUILD_DIR} -cp ${BUILD_DIR}/ ${TST_DIR}/*.java
	for e in ${TEST_EXEC} ; do\
		java -ea -cp ${BUILD_DIR} ${PACKAGE}.$$e ; \
	done

clean : 
	rm -rf ${BUILD_DIR}/*
