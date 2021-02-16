package day13_10Algorithms;

import javax.sound.midi.MidiChannel;

/**
 * @author Yemeng
 * @create 2021-01-06-15:05
 */
public class BinarySearch {


    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
