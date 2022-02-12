import java.util.*;

public class SomeTest {
    public Map<String, Map<String, List<String>>> createOffHomeFromAddress(List<Address> address) {
        Map<String, Map<String, List<String>>> map = new HashMap<>();
        for (Address a : address) {
            if (map.keySet().contains(a.getTown())) {
                if (map.get(a.getTown()).keySet().contains(a.getStreet())) {
                    map.get(a.getTown()).get(a.getStreet()).add(a.getHome());
                } else {
                    map.get(a.getTown()).put(a.getStreet(), new ArrayList<>());
                    map.get(a.getTown()).get(a.getStreet()).add(a.getHome());
                }
            } else {
                map.put(a.getTown(), new HashMap<>());
                map.get(a.getTown()).put(a.getStreet(), new ArrayList<>());
                map.get(a.getTown()).get(a.getStreet()).add(a.getHome());
            }
        }
        return map;
    }

    public void printMap(Map<String, Map<String, List<String>>> map) {
        MakeStringFromList mstr = new MakeStringFromList();
        for (String s : map.keySet()) {
            for (String a : map.get(s).keySet()) {
                System.out.println(String.format("town = %s, street = %s," +
                        " sizeHome = %s, number %s", s, a, map.get(s).get(a).size(), mstr.resultString(map.get(s).get(a))));
            }
        }
    }
}