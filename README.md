## What is the aim of the project?
The main purpose of our program is to calculate how long it takes for different algorithms to find the kth element from an unordered list with n elements.
<hr/>

### The construction phase
First, we did research on sorting algorithms and learned about their basic operation, pseudocode, and time complexity. We converted the algorithms into code with the pseudocodes we obtained. In order to make comparisons, we realized that we need many factors with the result of our research, and we generated 3 different types (sorted, reverse sorted, random) arrays to create the appropriate test environment. We printed the values in the array, the length of the array, the type of the array, the speed in the sort algorithms and the number of times that algorithm repeats as a txt about the array we randomly generate. We made comparisons between algorithms by processing the data in this txt we received into excel.
<hr/>
### Conclusion 
As a result, when we examine all algorithms, we can see that each algorithm has some special aspects of its own. To consider the algorithms one by one:

#### 1.	Insertion Sort: 
In small arrays, it consumes less memory and can be used in simple tasks since its algorithm can be written very easily.

#### 2.	Merge Sort: 
Shows high performance even in larger arrays, can be used to combine 2 different arrays with a few changes
#### 3.	Quick Sort: 
One of the fastest algorithms, but the biggest weakness of sorted or very close to sorted arrays. Since the program will give an error and close when such arrays arrive, it should be ensured that such an array will not appear while using it.

#### 4.	Partial Selection Sort: 
It has a simple algorithm like Insertion Sort, but it should not be used as the k value increases. If you want to find the smallest first few values of a data set, it's definitely fast but incredibly slow as k increases.

#### 5.	Partial Heap Sort:
An algorithm that can show high performance in large arrays such as merge sort, but because it is partial and is used on max-heap, it starts to give faster results as the k value increases. That is, it is more suitable to be used in large arrays and if the k value is large.


#### 6.	Quick Select: 
Quick Select algorithm has exactly the same character as quicksort. If the array is sorted or very close to being sorted, the program will throw an error. It should be kept in mind that select algorithms are not sorting algorithms, if there is only one kth smallest element to be found in that array, it would be more appropriate to find it with it. If it is to be found more than once, it will take longer to run this algorithm many times in the long run than to run the others all at once, as this algorithm does not sort the array.


#### 7.	Quick Select (Median-of-Three): 
It is the best algorithm according to all other (in the report) algorithms. However, as explained above, if it will be found only once, it is more logical to use it. Unlike normal quick select, it is unaffected by an array that is sorted or very close to sorted. All types work at the same speed.
