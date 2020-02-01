package Collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SolutionOne {
    public static void main(String[] args) {
        String text = "Ночь улица фонарь, аптека,\n" +
                "Бессмысленный и тусклый свет.\n" +
                "Живи еще хоть четверть века -\n" +
                "Все будет так. Исхода нет.\n" +
                "\n" +
                "Умрешь - начнешь опять сначала\n" +
                "И повторится все, как встарь:\n" +
                "Ночь, ледяная рябь канала,\n" +
                "Аптека, улица, фонарь.";
        HashSet<String> set = new HashSet<>();
        HashMap<Integer, String> map = new HashMap<>();
        int key = 0;
        for(String s : text.toLowerCase().split("[ .,-:\n]+")){
            set.add(s);
            map.put(key, s);
            key++;
        }
        //список слов, из которых состоит текст (дубликаты не считать)
        set.forEach(s -> System.out.println(s));
        System.out.println();
        for (int i = 0; i < map.size(); i++) {
            int countValue = 1;
            for (int j = i + 1; j < map.size(); j++) {
                if(map.get(i).equals(map.get(j))){
                    countValue++;
                    map.replace(j, "0");
                }
            }
            if(!map.get(i).equals("0")) {
                map.replace(i, map.get(i) + " встречается " + countValue + " раз");
                System.out.println(map.get(i));
            }
        }
    }
}
