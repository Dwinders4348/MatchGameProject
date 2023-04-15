CardTest: bin/Card.class bin/CardTest.class
	java -jar lib/junit-platform-console-standalone-1.6.2.jar -cp bin -c CardTest 

bin/Card.class: src/Card.java
	javac -d bin -cp bin src/Card.java

bin/CardTest.class: bin/Card.class test/CardTest.java
	javac -d bin -cp "bin;lib/*" test/CardTest.java