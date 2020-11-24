#| Pancake Lab is code that interprets a text file as a pancake order and prints the price of the order. Pricing is as follows:
Blueberries: $1.00
Strawberries: $1.00
Syrup: $0.50
Caramel: $0.25
Chocolate: $1.50
Specific formatting of the order.txt is required, check rubric for details.
|#

;;; This function reads the order.txt file and puts each line into a list.
(defun read-file ()
  (with-open-file (stream "order.txt")
    (loop for l = (read-line stream nil)
          while l
          collect l)))

;;; Formats the output with the price.
(defun write-file (price)
  (format t "~%")
  (format t "Price: ")
  (terpri t)
  (format t (write-to-string price))
  (format t "~%"))

;;;  Calculates the price of the order with nested if loops. Base price of the pancake is 13
;;; Tests to see if the string is "y" or "n" or the name of the topping. If it is the name of the topping
;;; the program will skip over that line. If it's yes or no, the calculator will account for it accordingly
;;; and then remove that price from the price list.
(defun priceCalculator (l priceList)
  (if (null l)
    13
  (if (string= (car l) "y")
    (+ (car priceList) (priceCalculator (cdr l) (cdr priceList)))
  (if (string= (car l) "n")
    (+ 0 (priceCalculator (cdr l) (cdr priceList)))
  (+ 0 (priceCalculator (cdr l) priceList))))))

;;; This function runs all three functions.
(defun runner ()
  (write-file (priceCalculator (read-file) '(1.00 1.00 0.50 0.25 1.50))))

(runner)
