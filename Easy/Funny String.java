 for(int i=0;i<s.length()/2;i++){
            int a = s.charAt(i);
            int b = s.charAt(i+1);
            int c = s.charAt(s.length()-1-i);
            int d = s.charAt(s.length()-2-i);
            if(Math.abs(a-b)!=Math.abs(c-d))return "Not Funny";   
        }
        return "Funny";
