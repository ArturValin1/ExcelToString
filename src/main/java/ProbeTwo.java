import java.util.*;

public class ProbeTwo {

    public static void main(String[] args) {
        MakeStringFromList mstr = new MakeStringFromList();
        List<Address> address = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            address.add(new Address("arh", "east", i));
            address.add(new Address("arh", "west", i));
            address.add(new Address("arh", "south", i));
            address.add(new Address("otv", "zar", i));
            address.add(new Address("otv", "centr", i));
            address.add(new Address("otv", "zapad", i));
        }
        address.add(new Address("otv", "zapad", 21));
        Map<String, Map<String, List<Integer>>> map = new HashMap<>();
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
        for (String s : map.keySet()) {
            for (String a : map.get(s).keySet()) {
                System.out.println(String.format("town = %s, street = %s," +
                        " sizeHome = %s, number %s", s, a, map.get(s).get(a).size(), mstr.resultString(map.get(s).get(a))));
            }
        }
    }
}