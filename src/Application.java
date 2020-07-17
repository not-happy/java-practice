import java.util.Arrays;

/**
 * @author xuyong
 * @since 2020/7/9 15:34
 **/
public class Application {

    /**
     * 返回数组arr中第k小的奇数,不存在则返回0
     * 时间复杂度:O(n + k*logk)
     * 空间复杂度:O(logk)
     *
     * @param arr 要查找数组
     * @param k   目标位置
     * @return arr中第k小的奇数
     */
    public int findKth(int[] arr, int k) {
        int[] sortArr = new int[arr.length];
        int sortCur = 0;
        for (int val : arr) {
            if (val % 2 != 0) {
                sortArr[sortCur++] = val;
            }
        }
        sort(0, sortArr.length - 1, sortArr);
        return k > sortArr.length ? 0 : sortArr[k];
    }

    /**
     * 快速排序
     *
     * @param begin 起始下标
     * @param end   结束下标
     * @param arr   要排序的数组
     */
    private void sort(int begin, int end, int[] arr) {
        if (begin > end) {
            return;
        }
        int l = begin;
        int r = end;
        int x = arr[begin];
        while (l < r) {
            while (arr[r] >= x && l < r) {
                r--;
            }
            while (arr[l] <= x && l < r) {
                l++;
            }
            if (arr[r] < x && arr[l] > x) {
                int temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
        }
        arr[begin] = arr[l];
        arr[l] = x;

        // 分别对左右进行排序
        sort(begin, l - 1, arr);
        sort(l + 1, end, arr);
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        Application application = new Application();
        application.sort(0, arr.length - 1, arr);


        System.out.println(Arrays.toString(arr));

    }

}
