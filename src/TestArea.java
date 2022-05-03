import java.util.*;

public class TestArea {
    public static void main(String[] args) {
        int[] array = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Length of the array: ");
            int length = scanner.nextInt();
            System.out.print("k: ");
            int k = scanner.nextInt();

            System.out.println("1- Random Array\n2- Sorted Random Array\n3- Reversely Sorted Random Array");
            switch (scanner.nextInt()) {
                case 1: array = createRandomArray(length); break;
                case 2: array = createSortedArray(length); break;
                case 3: array = createReverselySortedArray(length); break;
            }

            SortingAlgorithms sa = new SortingAlgorithms(array);

            sa.insertionSortTime(sa.getTempArray());
            System.out.println("Insertion Sort = " + sa.getTime() + "ms" + " --> arr[k] = " + sa.getTempArray()[k]);
            sa.copyArray();

            sa.mergeSortTime(sa.getTempArray(),0, sa.getTempArray().length - 1);
            System.out.println("Merge Sort = " + sa.getTime() + "ms" + " --> arr[k] = " + sa.getTempArray()[k]);
            sa.copyArray();

            sa.quickSortTime(sa.getTempArray(), 0, array.length - 1);
            System.out.println("Quick Sort = " + sa.getTime() + "ms" + " --> arr[k] = " + sa.getTempArray()[k]);
            sa.copyArray();

            sa.partialSelectionSortTime(array, k);
            System.out.println("Partial Selection Sort = " + sa.getTime() + "ms" + " --> arr[k] = " + sa.getTempArray()[k]);
            sa.copyArray();
        }
    }

    public static int[] createRandomArray(int length) {
        Random random = new Random();
        return random.ints(length, 1,length).toArray();
    }

    public static int[] createSortedArray(int length) {
        Random random = new Random();
        int[] arr = random.ints(length, 1, length).toArray();
        Arrays.sort(arr);
        return arr;
    }

    public static int[] createReverselySortedArray(int length) {
        Random random = new Random();
        int[] arr = random.ints(length, 1, length).toArray();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : arr) pq.add(num);

        for(int i = 0; i < length; i++) arr[i] = pq.poll();

        return arr;
    }

}
