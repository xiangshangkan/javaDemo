import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>(10);
        list.add(3);
        System.out.print(list.size());
        list.set(0,1);
    }
}