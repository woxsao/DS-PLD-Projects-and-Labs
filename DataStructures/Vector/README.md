# vector-mchan2021
vector-mchan2021 created by GitHub Classroom

1. Why can you not have an array of type E?

You can not instantiate an array with type E, only declare with type E. This is because Java needs to know the type of the array by runtime and if it is instantiated as a generic array then Java will not know whether it is a String array, an Integer array, etc. by runtime. 

2. Explain the difference between Errors and Exceptions. 

Errors are things that the programmer should not have to prepare the code for, whereas Exceptions are things that the programmers should
account for when writing code. There are checked exceptions and unchecked exceptions; checked exceptions are told to the user at compile time, whereas unchecked are at runtime. However, Errors are not considered exceptions at all since a coder can not really account for them in 
the program. 

3. What’s the value of having a copy constructor?

The value of having a copy constructor is that if a constructor of the object has multiple fields, it is easier sometimes just to use 
the copy constructor rather than copying all of the parameters. Such a deep copy would allow us to modify the copy object and keep the
original object in its original form, rather than just setting the copy object to the original object's memory address. 

4. What would the run-times of your various methods be? How does initial capacity impact run time?

I put all the runtimes in the javadoc header of each method. In the functions where we use the capacity of the vector as a condition for a for loop,the bigger the capacity, the longer the runtime since the computer will have to filter through more items. 
