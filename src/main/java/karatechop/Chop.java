package karatechop;

public class Chop {

    public static int To(int target, int[] array){

        if (array.length == 0) return -1;
        for (int  i = 0; i < array.length; i++)
        {
            if (array[i] == target) return i;
        }

        return -1;
    }
}
