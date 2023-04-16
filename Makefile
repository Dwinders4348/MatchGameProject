
GridTest: bin/Grid.class bin/GridTest.class
	java -jar lib/junit-platform-console-standalone-1.6.2.jar -cp bin -c GridTest

bin/Grid.class: src/Grid.java
	javac -d bin -cp bin src/Grid.java

bin/GridTest.class: bin/Grid.class test/GridTest.java
	javac -d bin -cp "bin;lib/*" test/GridTest.java

	



DeckTest: bin/Deck.class bin/DeckTest.class
	java -jar lib/junit-platform-console-standalone-1.6.2.jar -cp bin -c DeckTest

bin/Deck.class: src/Deck.java
	javac -d bin -cp bin src/Deck.java

bin/DeckTest.class: bin/Deck.class test/DeckTest.java
	javac -d bin -cp bin src/Deck.java
	
	
CardTest: bin/Card.class bin/CardTest.class
	java -jar lib/junit-platform-console-standalone-1.6.2.jar -cp bin -c CardTest 

bin/Card.class: src/Card.java
	javac -d bin -cp bin src/Card.java

bin/CardTest.class: bin/Card.class test/CardTest.java
	javac -d bin -cp "bin;lib/*" test/CardTest.java