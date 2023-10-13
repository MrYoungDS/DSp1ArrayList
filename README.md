# <code>DSp1ArrayList</code> Array List Project

For this assignment you will implement an array list of integers.

As our first data structure (with arrays counting as our zero-th data structure), we will implement a (slightly
simplified) list interface using an array implementation. There are a few ways to do this with arrays, but the standard
approach is to keep the data together at the beginning of the array. This makes the add and remove methods "costly" at
times, while get and set are "cheap".

We will consider other implementations of lists in future projects, with additional features. Each element of our array
list will be a little-i <code>int</code> (as opposed to a big-I <code>Integer</code>), and our MyArrayList will have
the core functionality (but not all the bells and whistles) from <code>java.util.ArrayList</code>.

A skeleton is provided for you, and you will need to adhere to the public interface given there. In particular, note 
that an array of <code>int</code>s initializes every entry to zero, and that is a possible value in the list, so you
will likely want to add an instance field to keep track of the size of the list, depending on how you manage the array.
Also, you probably do not want to create a new array every time an element is added or deleted, right?
