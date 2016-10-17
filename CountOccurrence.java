/**
 * A class to count the number of occurrences of an element in a 2-D array
 * @author elhams
 *
 */
public class CountOccurrence {


    public static void main(String[] args) {
        int query = 20;
        int index = 3;
        int[][] test = {{15, 8, 10, 6},
                {20, 20, 20, 20},
                {20, 20, 20, 20},
                {20, 20, 20, 20}};
        System.out.println(count(test, query));
    }

    public static int count(int[][] array, int query) {
        int count = 0;
        int row_count = 0;
        boolean flag = false;

        for (int j = 0; j < array.length; j++) {

            if (binarySearch(array, query, j) != -1) {
                int row_index = binarySearch(array, query, j);
                count++;
                flag = true;

                while (row_index < array[j].length-1 && flag) {
                    if (array[row_index+1][j] == query) {
                        flag = true;
                        count++;
                        row_index++;
                    } else {
                        flag = false;
                        break;
                    }
                }
                while (row_index < array[j].length-1 && array[row_index][j] > array[0][j] && flag == true) {
                    if (array[row_index-1][j] == query) {
                        flag = true;
                        count++;
                        row_index--;
                    } else {
                        flag = false;
                        break;
                    }
                }

            }
        }
        return count;
    }



    public static int binarySearch( int[][] array, int target, int index){
            return binarySearch(array, 0, array.length - 1, target, index);
        }

    public static int binarySearch(int[][] array, int start, int end, int target, int index) {
        int middle = (start + end) / 2;
        if (end < start) {
            return -1;
        }
        if (middle > end) {
            return -1;
        }

        if (target == array[middle][index]) {
            return middle;
        } else if (target < array[middle][index]) {
            return binarySearch(array, start, middle - 1, target, index);
        } else {
            return binarySearch(array, middle + 1, end, target, index);
        }
    }
}




