# Serenity-restassured-bootstrap 🦾
This project is the bootstrap to start automating api testing, based on the Screenplay Pattern.

## Built with 🛠️
* JDK 1.8
* Gradle
* Serenity
* Rest Assured
* JSON Schema Validator
* Cucumber

## Configurations ⚙️
It is necessary to have installed the Java JDK and Gradle, as well as the environment variables configured in the operating system: `JAVA_HOME` and `GRADLE_HOME`.
<br>Then run the command `gradle clean install` to download all the necessary dependencies.

## Test execution 🚀
To run the automated tests, run the following command in the Terminal: `./gradlew clean test --tests [runner] -Dcucumber.options="--tags @[tag]" aggregate --info`

## Contributing ✒️
1. Clone the repository
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Run the tests or make changes
4. Commit your changes (`git add .` , `Git commit -m "Add some feature"`)
5. Push the branch (`git push origin my-new-feature`)
6. Create a new pull request

## Information sources
* [Serenity BDD book.](https://github.com/serenity-bdd)
* [Serenity BDD github repository.](https://github.com/serenity-bdd)
* [Serenity Properties and Configuration.](https://serenity-bdd.github.io/theserenitybook/latest/serenity-system-properties.html)


