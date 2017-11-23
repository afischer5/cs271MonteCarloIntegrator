# COMP 271 002 F17 Lab 9 (Week 11)

# Q1
All of the word counts are the same (makes sense as all of these implement map).
The fastest is the default hashmap, then myHashMap, then treeMap.

# Q2
the modulus operator is not the same as remainder for negative numbers while floorMod
is the same as remainder for negative numbers. Becasue of this, floormod is more efficent to
compute hashtable indecies because it will work even with negative values.

# Q3
MyHashMap.size() is O(n * i) where n is the length of each bucket and i the size of the table
 or O(n^2) assuming i and n are equals. This could be much shorter if we keep track of the size and 
 incriment it every time we add an entry.
 
# Q4
This one relies on the java library provided linked list. The major difference is 
that we dont implemnet the linked list in this case. Our implementation of linked list
is slightly less reliable even if it is totally correct. This is much easier to implement as the
previous assignments required us to create several new classes. Performance in theory should be the same
however with every work around used by the individual implementor we lose some reliability and time saving techniques.

