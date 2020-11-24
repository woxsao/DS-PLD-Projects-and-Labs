1. What is the optimal run-time of each of your methods?
I wrote the runtime in each of my methods; I believed I used the optimal for each method.

2. In what situations is a Linked List more efficient than a Vector? When is a Vector more efficient?
Vectors are good for deleting at the end of the vector, with an efficiency of O(1). However, removing
from the end of a linked list has an efficiency of O(n). Linked lists are more efficient than vectors
at adding items to the front or end, since adding to the front or end in a linked list has an efficiency of O(1), but
adding to the front or end of a vector has a O(n) efficiency since you need to shift everything between down or up.
While they both take O(n) time to delete/add an item from an index besides the head or the tail, vector takes O(n) just to
add the item in, whereas with linked list once you find the node, you can add or remove it with O(1) time. Of course this all of this
still holds true if you are trying to just access the value at a certain index without removing.

3. What advantage is there to making Queue and Stack be interfaces?
It is an advantage because it forces the programmer who is using them to use them properly (ie implementing correct methods),
since the specifications for what a Stack or Queue is supposed to do is defined pretty clearly.

4. How would using a doubly-linked list impact your implementation?
Doubly linked list requires three fields: the reference of the previous node, the value of the current node, and a
reference to the next node. The insertion or deletion at a known position is O(1) for doubly linked list instead of
the O(n) it takes for a singly linked list. Doubly linked lists also allow for two way traversal.

5. What is a circularly-linked list? Why might you use one?
Circularly-linked lists are linked lists where there is no defined tail, meaning there is
no reference to null at the end; the last node merely references the first one. We might use one when we want any
member to be a valid starting point, kind of like shuffling a playlist where any one song is a valid starting point
and the playlist ends once that song has been reached again. We also may use this when we need a visual representation
of something that goes in a loop (for instance a board game or something of that nature) Round robin scheduling aka
managing what's executing and where that power needs to be directed.
