food(durian, yuck).
food(cake, yum).
food(oyster, yuck).
food(lobster, yum).
food(oranges, yum).

buy(FoodName) :- food(FoodName, yum).
discard(FoodName) :- food(FoodName, yuck).
