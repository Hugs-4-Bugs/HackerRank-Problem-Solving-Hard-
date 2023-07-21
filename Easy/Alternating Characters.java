if(s.length()==1) return 0;
char prev = s.charAt(0);
int deletions = 0; 
for(int i = 1; i < s.length(); i++){
    if(s.charAt(i)==prev){
        deletions++;
    }
    prev = s.charAt(i);
}
return deletions; 
}
