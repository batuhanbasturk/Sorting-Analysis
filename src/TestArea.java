import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestArea {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int[] array = new int[] {3, 5, 1};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of Tests: ");
        int count = scanner.nextInt();
        System.out.println("\n\n\n\n\n");
        TimeUnit.SECONDS.sleep(2);

        while (count-- >= 0) {
            int length = random.nextInt(10001);
            System.out.println("Length of the array: " + length);
            int k = random.nextInt(length - 1);
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

            sa.insertionSortTime(sa.getTempArray());
            System.out.println("Insertion Sort = " + sa.getTime() + "ms" + " --> arr[k] = " + sa.getTempArray()[k]);
            sa.copyArray();

            sa.mergeSortTime(sa.getTempArray(),0, sa.getTempArray().length - 1);
            System.out.println("Merge Sort = " + sa.getTime() + "ms" + " --> arr[k] = " + sa.getTempArray()[k]);
            sa.copyArray();

            sa.quickSortTime(sa.getTempArray(), 0, array.length - 1);
            System.out.println("Quick Sort = " + sa.getTime() + "ms" + " --> arr[k] = " + sa.getTempArray()[k]);
            sa.copyArray();

            TimeUnit.SECONDS.sleep(2);
            System.out.println("\n\n\n\n\n");
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
