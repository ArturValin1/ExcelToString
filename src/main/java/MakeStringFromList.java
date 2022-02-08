import java.util.ArrayList;
import java.util.List;

public class MakeStringFromList {
    public boolean comparePlusTwo(int a, int b) {    //сравниваем что второе число на два больше чем первое
        boolean result = false;
        if (a + 2 == b)
            result = true;
        return result;
    }

    public List<Integer> oddList(List<Integer> list) {
        return new ArrayList<>(list.stream().filter(x -> (x & 1) != 0).distinct().toList());
    }

    public List<Integer> evenList(List<Integer> list) {
        return new ArrayList<>(list.stream().filter(x -> (x & 1) == 0).distinct().toList());
    }

    public String makeStringFromNumber(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        boolean flagRecord = false;
        for (int i = 0; i < list.size() - 1; i++) {
            if (comparePlusTwo(list.get(i), list.get(i + 1))) {
                if (flagRecord) {
                    sb.append("-");
                } else {
                    sb.append(list.get(i));
                    sb.append("-");
                    flagRecord = true;
                }
            } else {
                sb.append(list.get(i));
                sb.append(", ");
                flagRecord = false;
            }
            if (i == list.size() - 2) {
                sb.append(list.get(i + 1));
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

    public String resultString(List<Integer> list) { //Делаем строку заменяя промужуточные значения на -, т.е. из 1 3 5 делаем 1-5
        StringBuilder sb = new StringBuilder();
        List<Integer> even = evenList(list);
        List<Integer> odd = oddList(list);
        String evenString = makeStringFromNumber(even);
        String oddString = makeStringFromNumber(odd);
        sb.append(oddString);
        sb.append("; ");
        sb.append(evenString);
        return sb.toString();
    }
}