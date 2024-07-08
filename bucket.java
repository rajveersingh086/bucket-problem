/*Bucket Sort(A[])
1.  Let B[0....n-1] be a new array
2.  n=length[A]
3.  for i=0 to n-1
4.  make B[i] an empty list
5.  for i=1 to n
6.  do insert A[i] into list B[n a[i]]
7.  for i=0 to n-1
8.  do sort list B[i] with insertion-sort
9.  Concatenate lists B[0], B[1],........, B[n-1] together in order
End*/
// rajveer singh
import java.util.ArrayList;
import java.util.List;

public class bucket {
    public static void insertionSort(List<Float> bucket) {
        for (int i = 1; i < bucket.size(); ++i) {
            float key = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int bi = (int) (n * arr[i]);
            buckets[bi].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
    public static void main(String[] args) {
        float[] arr = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
        bucketSort(arr);

        System.out.println("Sorted array is:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}

