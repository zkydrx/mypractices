package com.hundsun.elearning;

/**
 * 要在4G内存中去重和排序20亿个数字，我们需要使用外部排序算法，具体如下：
 *
 * 1.将20亿个数字划分成若干个小文件，每个小文件的大小不能超过内存的限制，比如每个小文件的大小为100MB，那么划分后就有20个小文件。
 *
 * 2.对每个小文件进行内部排序，可以使用快速排序等常用算法。
 *
 * 3.对每个小文件进行去重操作，可以使用哈希表等数据结构。
 *
 * 4.将去重后的小文件合并成一个大文件。
 *
 * 5.对大文件进行外部排序，可以使用归并排序等算法。
 *
 * 6.将排序后的大文件拆分成若干个小文件，每个小文件的大小不能超过内存的限制，比如每个小文件的大小为100MB，那么划分后就有20个小文件。
 *
 * 7.对每个小文件进行内部排序和去重操作。
 *
 * 8.将去重后的小文件合并成一个最终的排好序并去重后的文件。
 */
import java.io.*;
import java.util.*;

public class ExternalSort {
    private static final int MAX_MEMORY = 100000000; // 100MB
    private static final int BUFFER_SIZE = MAX_MEMORY / 2;

    public static void externalSort(File inputFile, File outputFile) throws IOException {
        List<File> sortedFiles = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        int index = 0;
        try {
            while (true) {
                List<Integer> list = new ArrayList<>();
                int currentSize = 0;

                while (currentSize < MAX_MEMORY) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    int number = Integer.parseInt(line);
                    list.add(number);
                    currentSize += line.length();
                }

                if (list.isEmpty()) {
                    break;
                }

                Collections.sort(list);
                File file = new File("sorted_file_" + index + ".dat");
                writeNumbersToFile(list, file);
                sortedFiles.add(file);
                index++;
            }

            mergeSortedFiles(sortedFiles, outputFile);
        } finally {
            reader.close();
        }
    }

    private static void mergeSortedFiles(List<File> sortedFiles, File outputFile) throws IOException {
        PriorityQueue<FileLine> priorityQueue = new PriorityQueue<>(new Comparator<FileLine>() {
            @Override
            public int compare(FileLine o1, FileLine o2) {
                return o1.value - o2.value;
            }
        });

        List<BufferedReader> readers = new ArrayList<>();
        for (File file : sortedFiles) {
            BufferedReader reader = new BufferedReader(new FileReader(file), BUFFER_SIZE);
            readers.add(reader);

            String line = reader.readLine();
            if (line != null) {
                int number = Integer.parseInt(line);
                priorityQueue.offer(new FileLine(number, reader));
            }
        }

        writeSortedNumbersToFile(priorityQueue, readers, outputFile);

        for (BufferedReader reader : readers) {
            reader.close();
        }

        for (File file : sortedFiles) {
            file.delete();
        }
    }

    private static void writeNumbersToFile(List<Integer> numbers, File outputFile) throws IOException {
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outputFile), BUFFER_SIZE));

        try {
            for (int number : numbers) {
                output.writeInt(number);
            }
        } finally {
            output.close();
        }
    }

    private static void writeSortedNumbersToFile(PriorityQueue<FileLine> priorityQueue, List<BufferedReader> readers, File outputFile) throws IOException {
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outputFile), BUFFER_SIZE));

        try {
            while (!priorityQueue.isEmpty()) {
                FileLine fileLine = priorityQueue.poll();
                output.writeInt(fileLine.value);

                String line = fileLine.reader.readLine();
                if (line != null) {
                    int number = Integer.parseInt(line);
                    priorityQueue.offer(new FileLine(number, fileLine.reader));
                }
            }
        } finally {
            output.close();
        }
    }

    private static class FileLine {
        int value;
        BufferedReader reader;

        FileLine(int value, BufferedReader reader) {
            this.value = value;
            this.reader = reader;
        }
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");
        externalSort(inputFile, outputFile);
    }
}

