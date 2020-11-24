cost = c(50, 175, 90, 10, 150)
class(cost)
food = c("pizza", "burgers", "salads", "cheese", "pasta")
names(cost) = food
cost
length(cost)
class(cost)




c1 = c("1", "2", "hello")
c2 = as.numeric(c1)
c2
c3 = c(1, 2, NA)
c3

is.numeric(c3)

c4 = data.frame(c2, c3)
class(c4)
