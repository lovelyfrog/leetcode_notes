import java.util.*;
public class Main {

    public class MinHeap {
        int cap;
        int[] array;
        int next_pos;
        public MinHeap(int cap) {
            this.cap = cap;
            this.array = new int[cap];
        }

        public MinHeap(int[] array) {
            this.cap = array.length;
            this.next_pos = array.length;
            this.array = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                this.array[i] = array[i];
                upShift(i);
            }

        }

        public void upShift(int i) {
            if (i == 0) return;
            int p = parent(i);
            if (this.array[p] > this.array[i]) {
                swap(p, i);
                upShift(p);
            }
            return;
        }

        public void downShift(int i) {
            if (i >= next_pos) return;
            int isLeft = 0;
            int isRight = 0;
            if (left(i) < next_pos &&  this.array[left(i)] < this.array[i]) {
                swap(left(i), i);
                isLeft = 1;
            }
            if (right(i) < next_pos &&  this.array[right(i)] < this.array[i]) {
                swap(right(i), i);
                isRight = 1;
            }

            if (isLeft + isRight == 1) {
                if (isLeft == 1) {
                    downShift(left(i));
                } else {
                    downShift(right(i));
                }
            } else if (isLeft + isRight == 2) {
                downShift(right(i));
            }

            return;    

        }

        public void swap(int i, int j) {
            int tmp = this.array[i];
            this.array[i] = this.array[j];
            this.array[j] = tmp;
        }

        public int parent(int i) {
            return (i - 1) >> 1;
        }

        public int left(int i) {
            return (i << 1) + 1;
        }

        public int right(int i) {
            return (i << 1) + 2;
        }

        public int getMin() {
            return this.array[0];
        }

        public int delMin() {
            int x = getMin();
            swap(--next_pos, 0);
            downShift(0);
            return x;
        }

    }

    public void test() {
        int[] nums = {7, 5, 4, 8, 2, 1, 9, 10};
        MinHeap heap = new MinHeap(nums);
        
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", heap.delMin());
            // heap.delMin();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main mm = new Main();
        mm.test();
    }
}
