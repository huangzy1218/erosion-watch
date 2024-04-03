package cn.edu.nwafu.erosion.portal.es;

import java.util.*;

/**
 * @author Huang Z.Y.
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        Collections.sort(list);
        int num = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (num != list.get(i)) {
                System.out.println(num);
                break;
            } else {
                num++;
            }
        }

        // HashMap
        Map<Integer, Boolean> map = new HashMap<>();
        for (int number : list) {
            map.put(number, true);
        }
        num = list.get(0);
        int n = map.size();
        while (n-- > 0) {
            if (map.containsKey(num)) {
                num++;
            } else {
                break;
            }
        }
        System.out.println(num);
    }
}
    