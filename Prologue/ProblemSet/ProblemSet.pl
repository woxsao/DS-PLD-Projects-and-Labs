/*
What makes Prolog different from a typical functional language?
In a typical functional language return type can be anything, it's built off of functions whereas
Prolog is built based on evaluations of things being true and false.

Compare logic programming to another paradigm of your choice. What are some of its advantages and disadvantages?
Compared to imperative programming, logic programming seems to be much more complicated to program due to the fact
you have to think about making all statements in relation to a true or false condition, whereas in imperative programming
you can change the state of the program, have return types, etc. However, sometimes we don't want the state of the machine to change,
in which case imperative languages might not be the best choice. Logical programming is also useful in that you can declare
certain rules/facts about a problem, which helps the user solve their problem. Imperative languages cannot do this as easily.

Why might a programmer want to use logic programming?
In the case we do not want to change the state of the machine, logical paradigm languages would be better to use. It would be best to use
logic programming if they are dealing with mostly mathematical operations.
*/



/* power function
Write a predicate pow(X, Y, Z), stating that the integer Z is the result of raising X to the power of Y.
(Note: you may assume Y to be at least 0.)


*/


pow(X, Y, Z) :-
  Y1 is Y - 1,
  (Y = 0 -> Z = 1;
  pow(X,Y1,Z1),
  Z is Z1*X).

/* Modulo
Write a predicate mod(X, Y, Z), stating that the integer Z is equivalent to X mod Y
*/
mod(X, Y, Z) :-
  X1 is X-Y,
  (X < Y -> Z = X; mod(X1, Y, Z)).

/* FizzBuzz

Write a predicate fizzBuzz(X) which performs the FizzBuzz problem, printing out the numbers 0 to X, where:
each multiple of 3 is replaced with “Fizz”
each multiple of 5 is replaced with “Buzz”
each multiple of 15 is replaced by “FizzBuzz”
It should complete by evaluating to True.

Not printing new line properly?
*/

fizzBuzz(X) :-
  X1 is X-1,
  (X = 0 ->
  print(0),
  nl();
  fizzBuzz(X1),
  (X mod 15 =:= 0 -> print('FizzBuzz');
    (X mod 5 =:= 0 -> print('Buzz');
      (X mod 3 =:= 0 -> print('Fizz');
        print(X))))),
  nl().

/*Primes
Write a predicate isPrime(X) that determines whether or not the integer X is prime.
(Note: you may assume X to be 2 or greater.)
*/
isPrime(X) :-
  isPrimeHelper(X, 2).

isPrimeHelper(X, Y) :-
  (Y >= X -> true;
    ((0 =:= X mod Y) -> false; isPrimeHelper(X, Y+1))).

/*Fibonaccis pt .1

Write a predicate fib(X, Y), stating that X is the Yth number in the fibonacci sequence. You may assume that the first two digits of the sequence are 0 and 1.
*/
fib(1,Y):- Y = 0, nl().
fib(2,Y):- Y = 1, nl().
fib(X,Y) :-
  (Y = 2 -> X = 1; fibHelper(0, 1, X, Y)).

fibHelper(A,B, X, Y) :-
  Y1 is Y-1,
  A1 = B,
  B1 is A + B,
  (Y = 3 -> X is A + B; fibHelper(A1, B1, X, Y1)).

/*Change

Write a predicate change(X, Y) which states that Y is the minimum number of U.S. coins (quarters, dimes, nickels, and pennies) necessary to have X cents.

(Note: you needn’t calculate the individual number of each coin, just the total number of coins).
*/

change(X,Y) :-
  T = 0,
  changeHelper(X, Y, T, [25, 10, 5, 1]).

changeHelper(X, Y, T, [CUR|REST]):-
  REMAINDER is X mod CUR,
  Q is X//CUR,
  T1 is T + Q,
  (REMAINDER =:= 0 -> Y = T1; changeHelper(REMAINDER, Y, T1, REST)).

/*List Getter

Write a predicate access(X, Y, Z) which states that Z is the element at index Y of list X.
*/

access(X,Y,Z) :-
  X = [H|T],
  Y1 is Y-1,
  (Y =:= 0 -> Z = H;
    access(T,Y1,Z)).

/*List Sum

Write a predicate listSum(X, Y) which states that Y is the sum of all elements of list X.
*/

listSum(X, Y):-
  T = 0,
  listSumHelper(X, Y, T).


listSumHelper([H|T], Y, S) :-
  S1 is S + H,
  print(S1),
  nl(),
  (T = []-> Y = S1; listSumHelper(T,Y,S1)).

/*
Fibonaccis pt. 2

Write a predicate firstNFibs(X, Y), stating that Y is the list of the first X fibonacci numbers.
*/
firstNFibs(0,[]):- true.
firstNFibs(X,Y):-
  X1 is X -1,
  firstNFibs(X1,Y1),
  fib(L, X),
  append([L], Y1, Y2),
  Y = Y2.

/*
List Reverse
Write a predicate reverse(X, Y), which states that the list Y is the reverse of list X, and vice versa.
*/


reverse(X,Y):-
  reverseHelper(X,[],Y).

reverseHelper([],Y,Y).
reverseHelper([H|T],Y,R):-
  reverseHelper(T,[H|Y],R).
