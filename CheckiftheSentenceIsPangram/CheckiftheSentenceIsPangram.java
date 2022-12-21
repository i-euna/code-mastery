class Solution {
    public boolean checkIfPangram(String sentence) {
         HashSet<Character> charSet = new HashSet<>();
        for(int i = 0; i < sentence.length(); i++) {
            
                charSet.add(Character.toLowerCase(sentence.charAt(i)));
        }
        if(charSet.size() < 26)
            return false;
        else return true;
    }
}