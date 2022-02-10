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
        boolean flagRecord = false;
        List<Integer> ll = new ArrayList<>(); //вспомагательный лист для сортировки и удаления дубликатов чисел из листа со строками.
        List<String> numS = new ArrayList<>();//лист с числами переводим в строки
        list.stream().filter(this::isNumber).forEach(e -> ll.add(Integer.parseInt(e)));
        ll.stream().sorted().distinct().forEach(e -> {
            numS.add(e.toString());
        });
        List<String> even = evenList(numS);
        List<String> odd = oddList(numS);
        List<String> numberWithChar = list.stream().filter(e -> (!isNumber(e))).toList();
        if (even.size() >= 2) {
            String evenString = makeStringFromNumber(even);
            sb.append(evenString);
            sb.append("; ");
        } else {
            if (even.size() == 1) {
                sb.append(even.get(0));
                sb.append("; ");
                flagRecord = true;
            }
        }
        if (odd.size() >= 2) {
            String oddString = makeStringFromNumber(odd);
            sb.append(oddString);
            sb.append("; ");
        } else {
            if (odd.size() == 1) {
                sb.append(odd.get(0));
                sb.append("; ");
                flagRecord = true;
            }
        }
        if (list.size() == 1 && !flagRecord) {
            numberWithChar = list;
        }
        numberWithChar.forEach(e -> sb.append(e + "; "));
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