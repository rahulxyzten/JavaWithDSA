package KunalKushwaha.CP4Arrays.Leetcode.Easy;

/*
Input: s = "string"
Output: "rtsng"
https://leetcode.com/problems/faulty-keyboard/
Input: s = "poiinter"
Output: "ponter"
*/

public class P1FaultyKeyboard {
    public static <auto> void main(String[] args) {
        String s = "String";
        StringBuilder nm=new StringBuilder();

        /*Type Best T(C) = O(N) & S(C) = O(N) */
        for(char c:s.toCharArray())
        {
            if(c=='i')
            {
                nm.reverse();
            }
            else
            {
                nm.append(c);
            }
        }
        System.out.println(nm);

        /* Type 1 */
//        String str = "String";
//        ArrayList<Character> st = new ArrayList<>();
//        Scanner s = new Scanner(System.in);
//        str = s.next();
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == 'i') {
//                int left = 0;
//                int right = st.size() - 1;
//
//                while (left < right) {
//                    char temp = st.get(left);
//                    st.set(left, st.get(right));
//                    st.set(right, temp);
//
//                    left++;
//                    right--;
//
//            }
//            }else {
//               st.add(str.charAt(i));
//            }
//        }
//        char[] result = new char[st.size()];
//        for (int i = 0; i < st.size(); i++) {
//            result[i] = st.get(i);
//        }
//
//        System.out.println(new String(result));


    }
}

