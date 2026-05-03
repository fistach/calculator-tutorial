# calculator-tutorial
This project aims to learn how to implement a calculator basing on the 
io.github.fistach.archetypes:java-cli-clean-architecture-archetype

Implementation history:
First commits were done in the service module. They added the core logic of this 
application - performing math operations on numbers. It was created by writing
the tests first, so test coverage is 100%.

Next commits added the controller logic - receiving the input in raw form
and converting it to the model that service requires.

Next, the main Application class was implemented. Main module is 
responsible for handling the CLI, so the interaction with the user.

