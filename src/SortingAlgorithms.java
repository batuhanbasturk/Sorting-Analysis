public class SortingAlgorithms {
    private long time;
    private int count;
    private int[] arrayNotSorted;
    private int[] tempArray;

    public SortingAlgorithms(int[] array) {
        this.arrayNotSorted = array;
        this.tempArray = new int[array.length];
        System.arraycopy(array, 0, tempArray, 0, array.length);
        this.time = 0;
        this.count = 0;
    }

    public void copyArray() {
        System.arraycopy(this.arrayNotSorted, 0, this.tempArray, 0, this.arrayNotSorted.length);
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public void insertionSortTime(int[] arr) {
        startTimer();
        insertionSort(arr);
        stopTimer();
    }

    public void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int[] arr, int l, int r) {

        if (l < r) {
            int m =l+ (r-l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public void mergeSortTime(int[] arr, int l, int r) {
        startTimer();
        mergeSort(arr, l, r);
        stopTimer();
    }

    int partition (int[] a, int start, int end) {
        int pivot = a[end]; // pivot element
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++)
        {
            // If current element is smaller than the pivot
            if (a[j] < pivot)
            {
                i++; // increment index of smaller element
                swap(a, i, j);
            }
        }
        swap(a,i+1, end);
        return (i + 1);
    }
    public static int rand(int min, int max)
    {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }
        return new Random().nextInt(max - min + 1) + min;
    }
    int quickselectpartition(int[] a, int start, int end, int pIndex){
        int pivot = nums[pIndex];

        // Move pivot to end
        swap(nums, pIndex, right);

        pIndex = left;

        for (int i = left; i < right; i++)
        {
            if (nums[i] <= pivot)
            {
                swap(nums, i, pIndex);
                pIndex++;
            }
        }

        // move pivot to its final place
        swap(nums, pIndex, right);

        // return `pIndex` (index of the pivot element)
        return pIndex;
    }
    public static int quickSelect(int[] nums, int left, int right, int k)
    {
        // If the array contains only one element, return that element
        if (left == right) {
            return nums[left];
        }

        // select a `pIndex` between left and right
        int pIndex = rand(left, right);

        pIndex = quickselectpartition(nums, left, right, pIndex);

        // The pivot is in its final sorted position
        if (k == pIndex) {
            return nums[k];
        }

        // if `k` is less than the pivot index
        else if (k < pIndex) {
            return quickselectpartition(nums, left, pIndex - 1, k);
        }

        // if `k` is more than the pivot index
        else {
            return quickselectpartition(nums, pIndex + 1, right, k);
        }
    }

    public void quickSelectTime(int[] nums, int left, int right, int k){
    startTimer();
    quickSelect(a, 0, nums.length - 1, k - 1);
    stopTimer();
//
    }

    void quickSort(int[] a, int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */ {
        if (start < end) {
            int p = partition(a, start, end);  //p is partitioning index
            quickSort(a, start, p - 1);
            quickSort(a, p + 1, end);
        }
    }

    public void quickSortTime(int[] a, int start, int end) {
        startTimer();
        quickSort(a, start, end);
        stopTimer();
    }

    void partialSelectionSort(int[] a, int k){
        int n = a.length;
        for(int i = 0; i < k; i++){
            int minIndex = i;
            int minValue = a[i];
            for(int j = i+1; j < n; j++){
                if(a[j] < minValue) {
                    minIndex = j;
                    swap(a, minIndex, i);
                }
            }

        }
    }

    public void partialSelectionSortTime(int[] a, int k) {
        startTimer();
        partialSelectionSort(a, k);
        stopTimer();
    }

    void partialHeapSort(int arr[], int k) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Heap sort
        for (int i = n - k; i >= 0; i--) {
            swap(arr,0, i);
            // Heapify root element
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            swap(arr,i,largest);
            heapify(arr, n, largest);
        }
    }

    public void partialHeapSortTime(int arr[], int k){
        startTimer();
        partialHeapSort(a, k);
        stopTimer();
    }

    public static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void startTimer() {
        this.time = System.currentTimeMillis();
    }

    public void stopTimer() {
        this.time = System.currentTimeMillis() - this.time;
    }

    public void printArray(int[] arr) {
        for(int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    public long getTime() {
        return time;
    }

    public int getCount() {
        return count;
    }

    public int[] getArrayNotSorted() {
        return arrayNotSorted;
    }

    public int[] getTempArray() {
        return tempArray;
    }
}