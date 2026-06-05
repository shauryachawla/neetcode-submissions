class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for(var str: strs) {
            sizes.add(str.length());
        }
        for(var size: sizes) {
            sb.append(size).append(",");
        }
        sb.append("#");
        for(var str: strs) {
            sb.append(str);
        }
        System.out.println("Encoded String: " + sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 1) return List.of();
        List<String> hashSplit = Arrays.asList(str.split("#", 2));
        
        List<Integer> sizes = Stream.of(hashSplit.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
        
        System.out.print("Sizes: ");
        for(var size: sizes) {
            System.out.print(size + " ");
        }

        if(hashSplit.size() == 1) return List.of("");

        String encodedStr = hashSplit.get(1);
        List<String> og = new ArrayList<>();
        
        int newWordStart = 0;
        for(var size: sizes) {
            System.out.println("newWordStart: "+ newWordStart);
            System.out.println("newWordStart + size: "+ (newWordStart + size));
            System.out.println("Substring: " + encodedStr.substring(newWordStart, newWordStart+size));
            og.add(encodedStr.substring(newWordStart, newWordStart + size));
            newWordStart += size;
        }

        return og;
    }
}