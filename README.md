# Clean Architecture Starter Kit
We wanted to provide a very straightforward Java API starter kit. We also implemented the Clean Architecture since we are strong advocates of this ideology.

## Things to mention
1. Entities in the domain's layer (or business logic's layer) are **abstract**. The persistence data are held in the implementation.
  1. The drawback is that the entity needs to use an abstract getter instead of using the private field directly.
  1. The huge advantage is that we don't pollute our domain with persistence-specific info, such as *auto-incremented ids*. Hence, there is no way we bind ourselves to the database or any persistence of any kind. The domain is clearly expressed as it should be.
2. Contract's classes, such as Repositories and Factories, have a base test class. 
 2. It helps us to test the API of the classes, without any workaround.
 2. We don't duplicate any tests.
 2. We reduce the number of tests to write, so it speeds up the process when you add a new implementation.
 2. The starter kit contains two implementations as examples: *JSON* and *InMemory*.
3. We test our repositories by adding a `clear()` method in it. We assume the persistence is ready to go, but we clear up the data after each test.
4. Dependencies injection is done initially in the `ca.nexapp.starterkit.rest.contexts` package thanks to Hk2 jersey's feature.

## Roadmap
* Add integration tests on REST layer.

## Contact
Feel free to share or contribute to this project. You can contact us directly at contact@nexapp.ca
