# Clean results of previous build: Generate executable archive
install:
	./gradlew clean install

# Run executable file (do this after install)
run-dist:
	./build/install/app/bin/app

# Check updates for dependencies (libraries; plugins from build.gradle)
check-updates:
	./gradlew dependencyUpdates

# Compile project and run from console
run:
	./gradlew clean
	./gradlew run

# Execute install tasks + another tasks
build:
	./gradlew clean build

# Check code-style
lint:
	./gradlew checkstyleMain
	./gradlew checkstyleTest

# For Jacoco test coverage with CodeClimate in main.yml
report:
	./gradlew jacocoTestReport

.PHONY: build