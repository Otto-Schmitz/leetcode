package tests;

public class InverterArray {
    public int[] inverter(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            int last = array[array.length - i - 1];
            array[array.length - i - 1] = array[i];
            array[i] = last;
        }

        return array;
    }
    public static void main(String[] args) {
        InverterArray inverterArray = new InverterArray();
        int[] array = {1,2,3,4,5};
        int[] reversedArray = inverterArray.inverter(array);

        for (int i = 0; i < reversedArray.length; i++){
            System.out.println(reversedArray[i]);
        }
    }
}


