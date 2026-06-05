class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        while(!str.equals("")) {
            String[] maamla = str.split("#", 2);
            int len = Integer.valueOf(maamla[0]);
            String s = maamla[1].substring(0, len);
            result.add(s);
            System.out.println("String before slicing: " + str);
            str = str.substring(maamla[0].length() + 1 + s.length(), str.length());
            System.out.println("String after slicing: " + str);
        }
        return result;
        // }
    }
}
