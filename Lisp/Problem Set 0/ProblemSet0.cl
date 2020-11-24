;;; Problem Set 0 by Monica Chan

;;; This function uses recursion to print x number of stars
(defun printStarsRecursive (x)
  (if (> x 0) ;if x > 1
    (progn (printStarsRecursive (- x 1)) (format t "*"))))

;;; This function uses a for loop to print x number of stars
(defun printStarsIterative (x)
  (loop for a from 1 to x
    do(format t "*")))

;;; This function counts the number of 'a's in a list of characters using recursion.
(defun countA (l)
  (if (null l) ;if list is empty
    0
  (if (eq (car l) #\a )
    (+ 1 (countA(cdr l)))
  (countA(cdr l)))))

;;; This function takes the sum of an integer and all of the positive numbers smaller than it.
(defun sumNumbers (x)
  (if (eq x 0)
    0
  (+ x (sumNumbers(- x 1)))))

;;; This function takes the sum of all the numbers in a list.
(defun sumList (l)
  (if (null l)
    0
  (+ (car l) (sumList(cdr l)))))

;;; This function tests countA
(defun testCountA ()
  (and
    (= (countA '(#\a #\c #\a )) 2)
    (= (countA '(#\b #\z #\d )) 0)
    (= (countA '()) 0)))

;;; This function tets sumNumbers
(defun testSumNumbers ()
  (and
    (= (sumNumbers 5) 15)
    (= (sumNumbers 3) 6)
    (= (sumNumbers 4) 10)
    (= (sumNumbers 0) 0)))

;;; This function tests sumList
(defun testSumList ()
  (and
    (= (sumList '(1 2 3 4 5)) 15)
    (= (sumList '(15 20 25)) 60)
    (= (sumList '(40 20)) 60)))

(print (printStarsRecursive 4))
(print (printStarsRecursive 0))
(print (printStarsIterative 4))
(print (printStarsIterative 0))


(print(testCountA))
(print(testSumNumbers))
(print(testSumList))
