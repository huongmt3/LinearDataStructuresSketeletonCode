package implementations;

// Java implementation of recursive Binary Search
public class SearchingAlgorithm {
    public static int lastElementFound(int arr[], int key){
        int n = arr.length;
        int index =-1;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == key)
                index = i;
        }
        return index;
    }
    public static int firstElementFound(int arr[], int key){
            int n = arr.length;
            for (int i = n-1; i >=0; i--)
            {
                if (arr[i] == key)
                    return i;
            }
            return -1;
    }

    public static int binarySearch(int arr[], int start, int end, int key) /*end = r, l = start, x = key*/
    {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] > key)
                return binarySearch(arr, start, mid - 1, key);
            return binarySearch(arr, mid + 1, end, key);
        }
        return -1;
    }
    /**static int binarySearch(int[] ar,int key, int start, int end)
    {
        while (end >= start)
        {
            int mid = (start + end)/2;
            if (ar[mid] < key) start = mid + 1;
            else if (ar[mid] > key) end = mid - 1;
	else return mid;
        }
        return -1;
    }*/

}
