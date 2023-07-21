 HashSet<Character> set = new HashSet<>();
        for (Character c : arr.get(0).toCharArray()) {
            set.add(c);
        }
        List<Character> list = new ArrayList<Character>(set);
        
        for (String v : arr) {
            list.removeIf(c -> !v.contains("" + c));
        }
        
        return list.size();
