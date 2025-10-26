package KunalKushwaha.CP4Arrays.Leetcode.Easy;
/*
1773. Count Items Matching a Rule

You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

The ith item is said to match the rule if one of the following is true:

ruleKey == "type" and ruleValue == typei.
ruleKey == "color" and ruleValue == colori.
ruleKey == "name" and ruleValue == namei.
Return the number of items that match the given rule.



Example 1:

Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
Output: 1
Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
Example 2:

Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
Output: 2
Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.


Constraints:

1 <= items.length <= 104
1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
ruleKey is equal to either "type", "color", or "name".
All strings consist only of lowercase letters.
 */

import java.util.List;
import java.util.ArrayList;

public class P12MatchingItems {
    public static void main(String[] args) {
        List<List<String>> nestedList = new ArrayList<>();

        // Add the elements to the existing nested list
        List<String> innerList1 = new ArrayList<>();
        innerList1.add("phone");
        innerList1.add("blue");
        innerList1.add("pixel");

        List<String> innerList2 = new ArrayList<>();
        innerList2.add("computer");
        innerList2.add("silver");
        innerList2.add("lenovo");

        List<String> innerList3 = new ArrayList<>();
        innerList3.add("phone");
        innerList3.add("gold");
        innerList3.add("iphone");

        nestedList.add(innerList1);
        nestedList.add(innerList2);
        nestedList.add(innerList3);
        String ruleKey = "color", ruleValue = "silver";
        System.out.println(countMatches(nestedList, ruleKey, ruleValue));

    }


    // T(C) = O(N) and S(C) = O(1)
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0, count = 0;
        if (ruleKey.equals("color")) index = 1;
        else if (ruleKey.equals("name")) index = 2;

        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) count++;
        }

        return count;
    }


    /* Runtime 6ms  Memory 47.3MB */
    //If rule value is present more than one time then that function gives
    //count of the rule value instate of giving the index of the rule value
//    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
//        int res = 0;
//
//        for(int i = 0 ;i<items.size();i++){
//            if(ruleKey.equals("type") && items.get(i).get(0).equals(ruleValue)) res++;
//            if(ruleKey.equals("color") && items.get(i).get(1).equals(ruleValue)) res++;
//            if(ruleKey.equals("name") && items.get(i).get(2).equals(ruleValue)) res++;
//        }
//
//        return res;
//
//    }


//    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
//        int a = 0;
//        switch (ruleKey){
//            case "type":
//                a = 0;
//                break;
//            case "color":
//                a = 1;
//                break;
//            case "name":
//                a = 2;
//                break;
//        }
//        int c = 0;
//        for (int i = 0; i < items.size() ; i++) {
//            if (Objects.equals(items.get(i).get(a), ruleValue)){
//                    c = c + 1;
//                }
//        }
//        return c;
//    }
}
