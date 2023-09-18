package Common;

import java.util.List;

public  class PrintUtils<T> {
    public  void printList(List<T> items){
        for(T item : items){
            System.out.println(item.toString());
        }
    }
}
