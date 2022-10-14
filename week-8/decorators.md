## Decorator Exercises/Tests
1. @Component - Take a look at any component that we made and notice the @Component decorator. Try to reason what each field represents (selector, templateURL, etc.). Try changing these fields and see how it affects the program.
2. @Input - Using our demo from class, try to make a component that takes in an object as input and displays that object's data on the page (ex: Person). Then, instantiate that component somewhere and pass in some data.
3. @Output - Similarly, use the @Output decorator to pass data/trigger an event from the child component to parent. Use [this](https://angular.io/guide/inputs-outputs) guide for help on input and output.
4. @Pipe - Create your own pipe and examine the Pipe decorator. See what happens when you change the field inside and how that affects your ability to use that pipe elsewhere in the program.
5. @Injectable - Create a service in your program and noticed the Injectable decorator. Try deleting the Injectable decorator and observe how this affects your ability to use this service in one of your components.
6. @NgModule - Read this article on modules: https://angular.io/guide/ngmodules. Inspect your app.module.ts and observe the different components of the @NgModule. 

Read about Decorators here: https://www.javatpoint.com/typescript-decorators. 