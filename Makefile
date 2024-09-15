build:
	@javac Main.java 
	@echo "Compiled project"

run: clean build
	@java Main

clean:
	@rm -f *.class
	@rm -f model/*.class
	@rm -f view/*.class
	@rm -f controller/*.class
	@rm -f route.txt
	@rm -rf out/
	@echo "cleaned"
