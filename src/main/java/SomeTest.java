import java.util.*;

public class SomeTest {
    public void printList(List<Address> address) {
        MakeStringFromList mstr = new MakeStringFromList();
        Map<String, Map<String, List<String>>> map = new HashMap<>();
        int i = 0;
        for (Address a : address) {
            if (map.keySet().contains(a.getTown())) {
                if (map.get(a.getTown()).keySet().contains(a.getStreet())) {
                    map.get(a.getTown()).get(a.getStreet()).add(a.getHome());
                } else {
                    map.get(a.getTown()).put(a.getStreet(), new ArrayList<>());
                    map.get(a.getTown()).get(a.getStreet()).add(a.getHome());
                }
                System.out.println(String.format("i = %s, %s", i++, a));
            } else {
                map.put(a.getTown(), new HashMap<>());
                map.get(a.getTown()).put(a.getStreet(), new ArrayList<>());
                map.get(a.getTown()).get(a.getStreet()).add(a.getHome());
                System.out.println(String.format("i = %s, %s", i++, a));
            }
        }
        for (String s : map.keySet()) {
            for (String a : map.get(s).keySet()) {
                System.out.println(String.format("town = %s, street = %s," +
                        " sizeHome = %s, number %s", s, a, map.get(s).get(a).size(), mstr.resultString(map.get(s).get(a))));
            }
        }
//        System.out.println("=================");
//        System.out.println(map.get("пгт Архара").get("Калинина").get(0));
//        System.out.println("=================");
    }
}