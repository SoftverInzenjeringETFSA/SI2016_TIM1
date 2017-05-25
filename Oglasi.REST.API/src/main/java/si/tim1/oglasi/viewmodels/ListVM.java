package si.tim1.oglasi.viewmodels;

import java.util.ArrayList;

/**
 * Created by Faruk on 25/05/2017.
 */
public class ListVM<T> {
    private ArrayList<T> array;

    public ListVM(ArrayList<T> array){
        this.array = array;
    }

    public ArrayList<T> getArray() {
        return array;
    }

    public void setArray(ArrayList<T> array) {
        this.array = array;
    }
}
