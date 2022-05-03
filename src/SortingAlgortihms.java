public class SortingAlgortihms {
    private int time;
    private int count;
    private int[] arrayNotSorted;
    private int[] tempArray;

    public SortingAlgortihms(int[] array) {
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
        long timeStart = System.currentTimeMillis();

        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        long timeEnd = System.currentTimeMillis();
        this.time = (int)(timeEnd - timeStart);
    }

    public void merge(int arr[], int l, int m, int r) {
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
    public void mergeSort(int arr[], int l, int r) {
        long timeStart = System.currentTimeMillis();

        if (l < r) {
            int m =l+ (r-l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }

        long timeEnd = System.currentTimeMillis();

        this.time = (int)(timeEnd - timeStart);
    }

    int partition (int a[], int start, int end)
    {
        int pivot = a[end]; // pivot element
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++)
        {
            // If current element is smaller than the pivot
            if (a[j] < pivot)
            {
                i++; // increment index of smaller element
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i+1];
        a[i+1] = a[end];
        a[end] = t;
        return (i + 1);
    }

    void quickSort(int a[], int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */
    {
        long timeStart = System.currentTimeMillis();

        if (start < end)
        {
            int p = partition(a, start, end);  //p is partitioning index
            quickSort(a, start, p - 1);
            quickSort(a, p + 1, end);
        }

        long timeEnd = System.currentTimeMillis();
        this.time = (int)(timeEnd - timeStart);
    }

    void partialSelectionSort(int a[] , int k){
        long timeStart = System.currentTimeMillis();

        int n = a.length;
        for(int i = 0; i < k; i++){
            int minIndex = i;
            int minValue = a[i];
            for(int j = i+1; j < n; j++){
                if(a[j] < minValue) {
                    minIndex = j;
                }
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }

        long timeEnd = System.currentTimeMillis();
        this.time = (int)(timeEnd - timeStart);
    }

    public int getTime() {
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
