class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(var str: strs) {
            sb.append(str.length()).append('#').append(str);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            System.out.println("i="+ i + " j="+j);
            int len = Integer.parseInt(str.substring(i,j));
            System.out.println("len=" + len);
            String s = str.substring(j+1, j+len+1);
            System.out.println("s=" + s);
            res.add(s);
            i = j+len+1;
        }
        return res;
    }
}
