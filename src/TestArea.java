import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestArea {
    public static void main(String[] args) throws InterruptedException, IOException{
        Random random = new Random();
        int[] array = null;

        File arrayfile = new File("arrayValues.txt");
        File arrayLengths = new File("arrayLengths.txt");
        File kValues = new File("kValues.txt");
        File arrayTypes = new File("arrayTypes.txt");

        File isSpeeds = new File("insertionSortSpeeds.txt");
        File msSpeeds = new File("mergeSortSpeeds.txt");
        File qsSpeeds = new File("quickSortSpeeds.txt");
        File pssSpeeds = new File("partialSelectionSortSpeeds.txt");
        File phsSpeeds = new File("partialHeapSortSpeeds.txt");
        File qseSpeeds = new File("quickSelectSpeeds.txt");
        File mqseSpeeds = new File("medianQuickSelectSpeeds.txt");

        File isCounts = new File("insertionSortCount.txt");
        File msCounts = new File("mergeSortCounts.txt");
        File qsCounts = new File("quickSortCounts.txt");
        File pssCounts = new File("partialSelectionSortCounts.txt");
        File phsCounts = new File("partialHeapSortCounts.txt");
        File qseCounts = new File("quickSelectCounts.txt");
        File mqseCounts = new File("medianQuickSelectCounts.txt");



        BufferedWriter fw = new BufferedWriter(new FileWriter(arrayfile));
        BufferedWriter arrlength = new BufferedWriter(new FileWriter(arrayLengths));
        BufferedWriter kvalue = new BufferedWriter(new FileWriter(kValues));
        BufferedWriter arraytype = new BufferedWriter(new FileWriter(arrayTypes));

        BufferedWriter iss = new BufferedWriter(new FileWriter(isSpeeds));
        BufferedWriter mss = new BufferedWriter(new FileWriter(msSpeeds));
        BufferedWriter qss = new BufferedWriter(new FileWriter(qsSpeeds));
        BufferedWriter psss = new BufferedWriter(new FileWriter(pssSpeeds));
        BufferedWriter phs = new BufferedWriter(new FileWriter(phsSpeeds));
        BufferedWriter qses = new BufferedWriter(new FileWriter(qseSpeeds));
        BufferedWriter mqses = new BufferedWriter(new FileWriter(mqseSpeeds));

        BufferedWriter isc = new BufferedWriter(new FileWriter(isCounts));
        BufferedWriter msc = new BufferedWriter(new FileWriter(msCounts));
        BufferedWriter qsc = new BufferedWriter(new FileWriter(qsCounts));
        BufferedWriter pssc = new BufferedWriter(new FileWriter(pssCounts));
        BufferedWriter phsc = new BufferedWriter(new FileWriter(phsCounts));
        BufferedWriter qsec = new BufferedWriter(new FileWriter(qseCounts));
        BufferedWriter mqsec = new BufferedWriter(new FileWriter(mqseCounts));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of Tests: ");
        int count = scanner.nextInt();
        int error = 0;

        while (count-- >= 0) {
            System.out.println(count + " arrays left");

            int length = random.nextInt(10000) + 10000;
            String s = String.valueOf(length);
            arrlength.write(s);
            arrlength.newLine();

            int k = random.nextInt(length - 1);
            s = String.valueOf(k);
            kvalue.write(s);
            kvalue.newLine();

            switch (random.nextInt(3) + 1) {
                case 1:
                    array = createRandomArray(length);
                    arraytype.write("Random Array");
                    arraytype.newLine();
                    break;
                case 2:
                    array = createSortedArray(length);
                    arraytype.write("Sorted Array");
                    arraytype.newLine();
                    break;
                case 3:
                    array = createReverselySortedArray(length);
                    arraytype.write("Reversely Sorted Array");
                    arraytype.newLine();
                    break;
            }

            SortingAlgorithms sa = new SortingAlgorithms(array);
            Arrays.sort(sa.getTempArray());
            int realAns = sa.getTempArray()[k];
            sa.reset();

            fw.write(sa.printArray(array));
            fw.newLine();

            sa.insertionSortTime(sa.getTempArray());
            s = String.valueOf(sa.getTime());
            iss.write(s);
            iss.newLine();
            s = String.valueOf(sa.getCount());
            isc.write(s);
            isc.newLine();
            if (sa.getTempArray()[k] != realAns) {
                error++;
                sa.printArray(sa.getTempArray());
            }
            sa.reset();

            sa.mergeSortTime(sa.getTempArray(),0, sa.getTempArray().length - 1);
            s = String.valueOf(sa.getTime());
            mss.write(s);
            mss.newLine();
            s = String.valueOf(sa.getCount());
            msc.write(s);
            msc.newLine();
            if (sa.getTempArray()[k] != realAns) {
                error++;
                sa.printArray(sa.getTempArray());
            }
            sa.reset();

            sa.quickSortTime(sa.getTempArray(), 0, array.length - 1);
            s = String.valueOf(sa.getTime());
            qss.write(s);
            qss.newLine();
            s = String.valueOf(sa.getCount());
            qsc.write(s);
            qsc.newLine();
            if (sa.getTempArray()[k] != realAns) {
                error++;
                sa.printArray(sa.getTempArray());
            }
            sa.reset();

            sa.partialSelectionSortTime(sa.getTempArray(), k);
            s = String.valueOf(sa.getTime());
            psss.write(s);
            psss.newLine();
            s = String.valueOf(sa.getCount());
            pssc.write(s);
            pssc.newLine();
            if (sa.getTempArray()[k] != realAns) {
                error++;
                sa.printArray(sa.getTempArray());
            }
            sa.reset();

            sa.heapSortTime(sa.getTempArray(), k);
            s = String.valueOf(sa.getTime());
            phs.write(s);
            phs.newLine();
            s = String.valueOf(sa.getCount());
            phsc.write(s);
            phsc.newLine();
            if (sa.getTempArray()[0] != realAns) {
                error++;
                sa.printArray(sa.getArrayNotSorted());
            }
            sa.reset();

            sa.quickSelectTime(sa.getTempArray(), 0, sa.getTempArray().length - 1, k + 1);
            s = String.valueOf(sa.getTime());
            qses.write(s);
            qses.newLine();
            s = String.valueOf(sa.getCount());
            qsec.write(s);
            qsec.newLine();
            if (sa.getSelected() != realAns) {
                error++;
                sa.printArray(sa.getTempArray());
            }
            sa.reset();

            sa.MedQuickSelectTime(sa.getTempArray(), 0, sa.getTempArray().length - 1, k + 1);
            s = String.valueOf(sa.getTime());
            mqses.write(s);
            mqses.newLine();
            s = String.valueOf(sa.getCount());
            mqsec.write(s);
            mqsec.newLine();
            if (sa.getSelected() != realAns) {
                error++;
                sa.printArray(sa.getTempArray());
            }
            sa.reset();
        }
        System.out.println("Total error found = " + error);

        fw.close();arrlength.close();kvalue.close();arraytype.close();iss.close();
        mss.close();qss.close();psss.close();phs.close();qses.close();mqses.close();
        isc.close();msc.close();qsc.close();pssc.close();phsc.close();qsec.close();mqsec.close();

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