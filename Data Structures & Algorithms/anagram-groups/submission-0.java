class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // each input string will go to a function. 
        // outout will be a uniqe id for anagram group.
        // return a list of all the groups. 

        // Map< <string, count> -> List<str> >
        Map< Map<Character, Integer>, List<String> > groups = new HashMap<>();
        for(var str: strs) {
            mapToAnagramGroups(str, groups);
        }

        for(var pair : groups.entrySet()) {
            System.out.println("Key: " + pair.getKey() + " Value: " + pair.getValue());
        }
        List<List<String>> result = new ArrayList<>();
        for(var entry : groups.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public void mapToAnagramGroups(String str, Map< Map<Character, Integer>, List<String>> groups) {
        Map<Character, Integer> localMap = new HashMap<>();
        for(var c: str.toCharArray()) {
            localMap.put(c, localMap.getOrDefault(c,0) + 1);
        }
        if(groups.containsKey(localMap)) {
            groups.get(localMap).add(str);
        } else {
            List<String> newList = new ArrayList<>();
            newList.add(str);
            groups.put(localMap, newList);
        }
    }
}
