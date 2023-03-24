class Result {

    public static String pangrams(String s) {
        Set<Character> set = new HashSet<> ();
        s = s.toLowerCase().replaceAll(" ", "");
        for(int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        
        if(set.size() == 26)
            return "pangram";
        else return "not pangram";
    }

}