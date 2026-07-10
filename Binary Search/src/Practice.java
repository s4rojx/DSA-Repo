import java.util.*;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SortedMap<Integer, String> map = new TreeMap<>();
        map.put( 91,"Vivek");
        map.put(99,"Shubham");
        map.put(78,"Mohit");
        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.headMap(91));
        System.out.println(map.tailMap(91));

    }
}