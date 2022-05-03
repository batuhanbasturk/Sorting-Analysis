public class TestArea {
    public static void main(String[] args) {
        int[] array = new int[10000];

        for(int i = 10000; i > 0; i--) {
            array[10000 - i] = i;
        }

        SortingAlgorithms sa = new SortingAlgorithms(array);

        sa.insertionSortTime(sa.getTempArray());
        System.out.println(sa.getTime() + "ms");
        sa.copyArray();

        sa.mergeSortTime(sa.getTempArray(),0, sa.getTempArray().length - 1);
        System.out.println(sa.getTime() + "ms");
        sa.copyArray();
    }
}
