package implementations;

public class SearchingAlgorithm {

    public static int linearSearch(int arr[], int x)
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
    static int lastIndexFound(int arr[], int x)
    {
        int n = arr.length;
        for (int i = n-1; i >=0; i--)
        {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
    static int lastIndexFound2(int arr[], int x)
    {
        int n = arr.length;
        int index =-1;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == x)
                index = i;
        }
        return index;
    }
    public static int binarySearch(int arr[], int key, int start, int end) {
        while (end >= start) {
            int mid = (start + end) / 2;
            if (arr[mid] < key)
                start = mid + 1;
            else if (arr[mid] > key)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }
    public static int binarySearchRecursive(int arr[], int key, int start, int end){
        if(start>end) return -1;
        int mid = (start+end)/2;
        if (arr[mid]>key) return binarySearchRecursive(arr,key,start,mid-1);
        else if(arr[mid]<key) return binarySearchRecursive(arr,key,mid+1,end);
        else return mid;
    }


}