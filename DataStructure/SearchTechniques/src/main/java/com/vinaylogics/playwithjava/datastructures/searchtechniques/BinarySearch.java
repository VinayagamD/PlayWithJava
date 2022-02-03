package com.vinaylogics.playwithjava.datastructures.searchtechniques;

public class BinarySearch {

    public static void main(String[] args) {

    }

    // return the index
    // return -1 if it does not exists
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length -1;
        while (start <= end){
            // find the middle element
            // int mid = (start+end) /2; // might be possible that (start+end) exceeds the range of integer
            int mid = start +(end-start)/2;

            if(target < arr[mid]){
                end = mid - 1;
            } else if(target > arr[mid]){
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }

        }

        return -1;
    }
}
