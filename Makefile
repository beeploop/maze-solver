build:
	javac Runner.java

run: clean build
	java Runner 

clean:
	rm *.class
