import java.util.*;

public class MakeStringFromList {
    public boolean comparePlusTwo(int a, int b) {
        boolean result = false;
        if (a + 2 == b)
            result = true;
        return result;
    }

    public List<String> oddList(List<String> list) {
        return list.stream().filter(x -> (Integer.parseInt(x) & 1) != 0).distinct().toList();
    }

    public List<String> evenList(List<String> list) {
        return list.stream().filter(x -> (Integer.parseInt(x) & 1) == 0).distinct().toList();
    }

    public String makeStringFromNumber(List<String> list) {
        StringBuilder sb = new StringBuilder();
        boolean flagRecord = false;
        for (int i = 0; i < list.size() - 1; i++) {
            if (comparePlusTwo(Integer.parseInt(list.get(i)), Integer.parseInt(list.get(i + 1)))) {
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

    public String resultString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        List<String> even = evenList(list.stream().filter(this::isNumber).toList());
        List<String> odd = oddList(list.stream().filter(this::isNumber).toList());
        List<String> numberWithChar = list.stream().filter(e -> (!isNumber(e))).toList();
        String evenString = makeStringFromNumber(even);
        String oddString = makeStringFromNumber(odd);
        sb.append(oddString);
        sb.append("; ");
        sb.append(evenString);
        sb.append("; ");
        numberWithChar.forEach(e-> sb.append(e+"; "));
        return sb.toString();
    }

    public boolean isNumber(String string) {
        boolean result = false;
        try {
            Integer.parseInt(string);
            result = true;
        } catch (NumberFormatException e) {

        }
        return result;
    }
}