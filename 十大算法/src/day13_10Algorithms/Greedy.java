package day13_10Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Yemeng
 * @create 2021-01-07-18:39
 */
public class Greedy {

    public static void greedy(HashMap<String, HashSet<String>> broadcasts) {
        //存放未被覆盖的城市
        HashSet<String> areas = new HashSet<String>();
        //取并集
        for(Map.Entry<String, HashSet<String>> entry : broadcasts.entrySet()) {
            areas.addAll(entry.getValue());
        }
        //存放选择的基站
        ArrayList<String> list = new ArrayList<String>();
        //记录可以覆盖城市的最大值
        int count;
        HashSet<String> tempSet = new HashSet<>();
        String maxKey = "";
        //每次都选取最优结果
        while(areas.size() != 0) {
            count = 0;
            for(Map.Entry<String, HashSet<String>> entry : broadcasts.entrySet()) {
                tempSet = entry.getValue();
                tempSet.retainAll(areas);
                if(tempSet.size() > count) {
                    count = tempSet.size();
                    maxKey = entry.getKey();
                }
            }
            list.add(maxKey);
            areas.removeAll(broadcasts.get(maxKey));
        }
        System.out.println(list);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        HashSet<String> hashset1 = new HashSet<String>();
        hashset1.add("北京");
        hashset1.add("上海");
        hashset1.add("天津");
        HashSet<String> hashset2 = new HashSet<String>();
        hashset2.add("广州");
        hashset2.add("北京");
        hashset2.add("深圳");
        HashSet<String> hashset3 = new HashSet<String>();
        hashset3.add("成都");
        hashset3.add("上海");
        hashset3.add("杭州");
        HashSet<String> hashset4 = new HashSet<String>();
        hashset4.add("上海");
        hashset4.add("天津");
        HashSet<String> hashset5 = new HashSet<String>();
        hashset5.add("杭州");
        hashset5.add("大连");
        broadcasts.put("K1", hashset1);
        broadcasts.put("K2", hashset2);
        broadcasts.put("K3", hashset3);
        broadcasts.put("K4", hashset4);
        broadcasts.put("K5", hashset5);
        System.out.println(broadcasts);
//        greedy(broadcasts);
    }
}