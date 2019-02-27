# BellatrixTest
BellatrixTest is a project where we have to refactor a code with best practices 


If you were to review the following code, what feedback would you give? Please be specific and indicate any errors that would occur as well as other best practices and code refactoring that should be done. 

1. We will get a SQLException, because java class won't find a suitable driver.
2. According to SOLID, Single responsibility, we have just one class with all the methods, so we have to uncouple the code into classes that cover all the funtionalities.
3. The code params that must be into a property o yaml file, and then be called from them.
4. The code use many types of store data and many types of logs message, so we should create a Type that contains all that information, LogMessageType(warning, message, error) and LogStoreType(Database, console, file).
5. The code repeat many times portion of codes, so we should creat an interface with that method, and then implement it on each class that will be call to use that method.
6. On line 23, the code contains variables that are never used, we should delete this unused code.
7. On line 40 we firts trim a String object and then look if it is null or not, that's wrong. We should validate first if it is null or not before trim the String object.
8. One of the good practises says, when we have many if statements related to a particular object, we should abstract this functionality on an interface and then implement it on the necessary classes.
9. On line 74, the code assigne a null value to l variable, but then on line 84, 88 and 92 it is assigned with a String, so it is unnecessary to assigne null value at the very beggining.