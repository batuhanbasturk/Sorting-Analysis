import java.util.*;

public class TestArea{
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = null;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of Tests: ");
        int count = scanner.nextInt();
        int error = 0;


        while (count-- > 0) {
            System.out.println(count + " arrays left");
            int length = random.nextInt(90000) + 10000;
            System.out.println("Length of the array: " + length);
            int k = random.nextInt(length);
            System.out.println("k: " + k);

            switch (random.nextInt(3) + 1) {
                case 1:
                    array = createRandomArray(length);
                    System.out.println("Random Array Selected");
                    break;
                case 2:
                    array = createSortedArray(length);
                    System.out.println("Sorted Array Selected");
                    break;
                case 3:
                    array = createReverselySortedArray(length);
                    System.out.println("Reversely Sorted Array Selected");
                    break;
            }

            SortingAlgorithms sa = new SortingAlgorithms(array);
            Arrays.sort(sa.getTempArray());
            int realAns = sa.getTempArray()[k];
            sa.reset();

            sa.insertionSortTime(sa.getTempArray());
            System.out.println("Insertion Sort = " + sa.getTime() + "ms" + " --> arr[k] = " + sa.getTempArray()[k] + " --> Total Count = " + sa.getCount());
            if (sa.getTempArray()[k] != realAns) {
                error++;
                sa.printArray(sa.getTempArray());
            }
            sa.reset();

            sa.mergeSortTime(sa.getTempArray(),0, sa.getTempArray().length - 1);
            System.out.println("Merge Sort = " + sa.getTime() + "ms" + " --> arr[k] = " + sa.getTempArray()[k] + " --> Total Count = " + sa.getCount());
            if (sa.getTempArray()[k] != realAns) {
                error++;
                sa.printArray(sa.getTempArray());
            }
            sa.reset();

            sa.quickSortTime(sa.getTempArray(), 0, array.length - 1);
            System.out.println("Quick Sort = " + sa.getTime() + "ms" + " --> arr[k] = " + sa.getTempArray()[k] + " --> Total Count = " + sa.getCount());
            if (sa.getTempArray()[k] != realAns) {
                error++;
                sa.printArray(sa.getTempArray());
            }
            sa.reset();

            sa.partialSelectionSortTime(sa.getTempArray(), k);
            System.out.println("Partial Selection Sort = " + sa.getTime() + "ms" + " --> arr[k] = " + sa.getTempArray()[k] + " --> Total Count = " + sa.getCount());
            if (sa.getTempArray()[k] != realAns) {
                error++;
                sa.printArray(sa.getTempArray());
            }
            sa.reset();

            sa.heapSortTime(sa.getTempArray(), k);
            System.out.println("Partial Heap Sort = " + sa.getTime() + "ms" + " --> kth smallest element = " + sa.getTempArray()[0] + " --> Total Count = " + sa.getCount());
            if (sa.getTempArray()[0] != realAns) {
                error++;
                sa.printArray(sa.getArrayNotSorted());
            }
            sa.reset();

            sa.quickSelectTime(sa.getTempArray(), 0, sa.getTempArray().length - 1, k + 1);
            System.out.println("Quick Select = " + sa.getTime() + "ms" + " --> kth smallest element = " + sa.getSelected() + " --> Total Count = " + sa.getCount());
            if (sa.getSelected() != realAns) {
                error++;
                sa.printArray(sa.getTempArray());
            }
            sa.reset();

            sa.MedQuickSelectTime(sa.getTempArray(), 0, sa.getTempArray().length - 1, k + 1);
            System.out.println("Med Quick Select = " + sa.getTime() + "ms" + " --> kth smallest element = " + sa.getSelected() + " --> Total Count = " + sa.getCount());
            if (sa.getSelected() != realAns) {
                error++;
                sa.printArray(sa.getTempArray());
            }
            sa.reset();
        }
        System.out.println("Total error found = " + error);
    }

    public static int[] createRandomArray(int length) {
        Random random = new Random();
        int[] arr = new int[length];

        for(int i = 0; i < length; i++) {
            arr[i] = random.nextInt(length * 10);
        }

        return arr;
    }

    public static int[] createSortedArray(int length) {
        int[] arr = createRandomArray(length);
        Arrays.sort(arr);
        return arr;
    }

    public static int[] createReverselySortedArray(int length) {
        int[] arr = createRandomArray(length);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : arr) pq.add(num);

        for(int i = 0; i < pq.size(); i++) arr[i] = pq.poll();

        return arr;
    }
}