package mergesort;
import java.util.Arrays;
public class MergeSort {
        static void MergeSort(int [] arr, int left, int right){
          if (left >= right) return;
          int mid = (left + right) / 2;
            MergeSort(arr, left, mid);
            MergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
        
        static void merge(int[] arr, int left, int mid, int right){
            int[] tmp = new int[right - left + 1];
            int i = left, j = mid + 1, k = 0;
            while (i <= mid && j <= right){
                tmp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            }
            while (i <= mid) tmp[k++] = arr[i++];
            while (j <= right) tmp[k++] = arr[j++];
            System.arraycopy(tmp, 0, arr, left, tmp.length);
        }
        public static void main(String[] args){
            int[] arr = {38, 27, 43, 3, 9, 82, 10};
            System.out.println("Antes: " + Arrays.toString(arr));
            MergeSort(arr, 0, arr.length - 1);
            System.out.println("Despues: " + Arrays.toString(arr));
        }
    }
    

