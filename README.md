# Clean Architecture Starter Kit
We wanted to provide a very straightforward Java API starter kit. We also implemented the Clean Architecture since we are strong advocates of this ideology.

## Things to mention
- Using Dropwizard for all its awesomeness and Guice for its dependency injector
- Contract's classes, such as Repositories and Factories, have a base test class. ([example here](./src/test/java/ca/nexapp/starterkit/domain/recipes/RecipeRepositoryTest.java)) . 
    - It helps us to test the API of the classes, without any workaround.
    - We don't duplicate any tests.
    - We reduce the number of tests to write, so it speeds up the process when you add a new implementation.

## How to run the app
Run `mvn package; java -jar target/clean-architecture-0.0.1.jar server config.yml` 

## How to run tests
Run `mvn test` 

## Contact
Feel free to share or contribute to this project. You can contact us directly at contact@nexapp.ca
