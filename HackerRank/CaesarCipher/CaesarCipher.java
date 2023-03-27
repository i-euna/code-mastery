class Result {

    public static String caesarCipher(String s, int k) {
        StringBuilder encrypted = new StringBuilder();
        k = k % 26;
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if((c >= 65 && c <= 90)) {
                c = (c + k);
                if(c > 90)
                    c = c % 90 + 64;
                encrypted.append((char)c);
            } else if((c >= 97 && c <= 122)) {
                c = (c + k);
                if(c > 122)
                    c = c % 122 + 96;
                encrypted.append((char)c);
            } else
                encrypted.append(s.charAt(i)); 
        }
        return encrypted.toString();
    }

}