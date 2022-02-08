import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProbeOne {
    public static void main(String[] args) {
        ProbeOne probeOne = new ProbeOne();
        List<StreetHome> list = new ArrayList<>();
        String street = "Архаринская";
        for (int i = 10; i < 21; i++) {
            list.add(new StreetHome(street, i));
        }
        List<StreetHome> even = new ArrayList<>(list.stream().filter(x -> (x.getHome() & 1) == 0).toList());
        List<StreetHome> odd = new ArrayList<>(list.stream().filter(x -> (x.getHome() & 1) != 0).toList());
        odd.add(new StreetHome(street, 3));
        odd.add(new StreetHome(street, 33));
        odd.add(new StreetHome(street, 35));
        odd.add(new StreetHome(street, 43));
        odd.add(new StreetHome(street, 45));
        odd.add(new StreetHome(street, 5));
        odd.add(new StreetHome(street, 55));
        List<StreetHome> sortedListEven = new ArrayList<>(even.stream().sorted(Comparator.comparingInt(StreetHome::getHome)).toList());
        List<StreetHome> sortListOdd = new ArrayList<>(odd.stream().distinct().sorted(Comparator.comparingInt(StreetHome::getHome)).toList());
        sortListOdd.forEach(e->{
            System.out.print(e.getHome()+" ");
        });
        System.out.println();
        sortedListEven.forEach(e->{
            System.out.print(e.getHome()+" ");
        });
        System.out.println("\n==================");
        System.out.println(probeOne.resultString(sortListOdd));
        System.out.println(probeOne.resultString(sortedListEven));
    }

    public boolean comparePlusTwo(int a, int b) {    //сравниваем что второе число на два больше чем первое
        boolean result = false;
        if (a + 2 == b)
            result = true;
        return result;
    }

    public String resultString(List<StreetHome> list) {
        StringBuilder sb = new StringBuilder();
        boolean flagRecord = false;

        for (int i = 0; i < list.size() - 1; i++) {
            if (comparePlusTwo(list.get(i).getHome(), list.get(i + 1).getHome())) {
                if (flagRecord) {
                    sb.append("-");
                } else {
                    sb.append(list.get(i).getHome());
                    sb.append("-");
                    flagRecord = true;
                }
            } else {
                sb.append(list.get(i).getHome());
                sb.append(", ");
                flagRecord = false;
            }
            if (i == list.size() - 2) {
                sb.append(list.get(i + 1).getHome());
            }
        }
        String result = sb.toString();
        int length = result.length();
        for (int i = 0; i < result.length(); i++) {
            result = result.replace("--", "-");
            if (length == result.length())
                break;
            else
                length = result.length();
        }
        return result;
    }
}