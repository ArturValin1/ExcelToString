import java.util.List;

public class MakeStringFromList {
    public boolean comparePlusTwo(int a, int b) {
        boolean result = false;
        if (a + 2 == b)
            result = true;
        return result;
    }

    public List<Integer> oddList(List<Integer> list) {
        return list.stream().filter(x -> (x & 1) != 0).distinct().toList();
    }

    public List<Integer> evenList(List<Integer> list) {
        return list.stream().filter(x -> (x & 1) == 0).distinct().toList();
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

    public String resultString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        List<Integer> even = evenList(list);
        List<Integer> odd = oddList(list);
        String evenString = makeStringFromNumber(even);
        String oddString = makeStringFromNumber(odd);
        sb.append(oddString);
        sb.append("; ");
        sb.append(evenString);
        sb.append(";");
        return sb.toString();
    }
}