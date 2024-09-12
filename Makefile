build:
	javac Runner.java

run: build
	java Runner 

clean:
	rm -f *.class
	rm route.txt
