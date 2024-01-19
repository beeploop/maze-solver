build:
	javac Runner.java

run: build
	java Runner 

clean:
	rm *.class
