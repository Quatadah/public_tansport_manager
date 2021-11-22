BUILD_DIR = build
SRC_DIR = src
TST_DIR = tst

SIMPLE = Simple
PACKAGE = tec
all : simple

simple : 
	javac -d ${BUILD_DIR} ${SRC_DIR}/*.java 	
	java -cp ${BUILD_DIR} ${SIMPLE}

clean : 
	rm ${BUILD_DIR}/Simple.class ${BUILD_DIR}/${PACKAGE}/*.class