package Task4;

public class Main {

    public static void main(String[] args) {


        Integer[] arr = new Integer[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = 10 - i;
        }
        Integer[] arr2 = {1, 2, 3, 4, 5, 10, 9, 8, 7, 6};
        for (Integer i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();


        boolean[] boolArr = {true, true, true, true, false, false, false, false, true, true};
        boolean[] boolArr2 = {true, false, true, true, false, false, false, false, true, true};
        boolean[] boolArr3 = {false, false, false, false, false, false, false, false, false, false,};
        boolean[] boolArr4 = {false, false, false, false, true, false, false, false, false, false,};
        boolean[] boolArr5 = {true, true, true, true, false, false, false, false, false, false};


        sort(arr2, boolArr2);
        for (Integer i : arr2) {
            System.out.print(i + " ");
        }
    }

    public static <T extends Comparable<T>> void sort(T[] data, boolean[] fixed) {
        boolean isSorted = false;
        T temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < data.length - 1; i++) {

                int counter = 0;
                while (!fixed[i + counter + 1]) {
                    if (i + counter + 1 >= fixed.length - 1) {
                        counter = -1;
                        break;              //как марио перепрыгиваем игнорируемые элементы
                    }                       // -1 если счетчик не может найти нормальный элемент
                    counter++;
                }

                if (counter == -1) {
                    continue;           //если -1 скипаем итерацию цикла
                }


                if (data[i].compareTo(data[i + 1 + counter]) > 0 && fixed[i]) {


                    isSorted = false;

                    temp = data[i];
                    data[i] = data[i + 1 + counter];
                    data[i + 1 + counter] = temp;
                }


            }
        }
    }
}
