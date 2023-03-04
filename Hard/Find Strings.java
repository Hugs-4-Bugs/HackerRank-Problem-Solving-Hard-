
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution 
{
    static int sa[],rank[],lcp[];
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String s=null;
        while(n-->0)
        {
        String temp=br.readLine();
        if(s==null)
            s=temp;
        else
            s=s+"?"+temp;
        }
        int q=Integer.parseInt(br.readLine());
        sa=new int[s.length()];
        rank=new int[s.length()];
        lcp=new int[s.length()];
        int index[]=new int[s.length()];
        int store[]=new int[s.length()];
        suffixArray(s);
        lcp(s);
        int cnt=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='?')
            {
                index[cnt]=i;
    //            System.out.println(cnt+" rtrge "+index[cnt]);
                cnt++;
            }
        }
        int curr=0;
    //    System.out.println(s);
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='?')
            {
    //            System.out.println("rgrtgt");
                curr++;
            }
            else
            {
                store[i]=index[curr];
    //            System.out.println(i+" dbr "+store[i]+" "+curr+" "+index[curr]);
            }
        }
        for(int i=0;i<s.length();i++)
        {
            if(store[i]==0)
                store[i]=s.length();
    //        System.out.println(i+" "+store[i]);
        }
    //    for(int i=0;i<s.length();i++)
    //        System.out.println(i+" "+sa[i]+" "+lcp[i]);
        
        while(q-->0)
        {
            long k=Long.parseLong(br.readLine());
            int got=0;
            long start=store[sa[cnt]]-sa[cnt];
            if(k<=start)
            {
                System.out.println(s.substring(sa[cnt],sa[cnt]+(int)k));
                continue;
            }
            for(int i=cnt+1;i<s.length();i++)
            {
                k-=start;
                start=store[sa[i]]-sa[i]-lcp[i-1];
        //        System.out.println(i+" "+"  dvev  "+k+" "+start);
                if(k<=start)
                {
        //            System.out.println(s.substring(sa[i],store[sa[i]]));
        //            System.out.println(s.substring(sa[i],sa[i]+(int)k));
        //            System.out.println(s.substring(sa[i],sa[i]+(int)start+(int)k));
                    System.out.println(s.substring(sa[i],sa[i]+lcp[i-1]+(int)k));
                    got=1;
                    break;
                }
            }
            if(got==1)
                continue;
        if(got==0)
            System.out.println("INVALID");
        }
    }
    
    public static void suffixArray(final CharSequence str)
    {
            int n = str.length();
            Integer[] order = new Integer[n];
            for (int i = 0; i < n; i++)
                order[i] = n - 1 - i;
            Arrays.sort(order, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Character.compare(str.charAt(o1), str.charAt(o2));
                }
            });
            for (int i = 0; i < n; i++) {
                sa[i] = order[i];
                rank[i] = str.charAt(i);
            }
            for (int len = 1; len < n; len *= 2) {
                int[] r = rank.clone();
                for (int i = 0; i < n; i++) {
                    rank[sa[i]] = i > 0 && r[sa[i - 1]] == r[sa[i]] && sa[i - 1] + len < n && r[sa[i - 1] + len / 2] == r[sa[i] + len / 2] ? rank[sa[i - 1]] : i;
                }
                
                int[] cnt = new int[n];
                for (int i = 0; i < n; i++)
                    cnt[i] = i;
                int[] s = sa.clone();
                for (int i = 0; i < n; i++) {
                    
                    int s1 = s[i] - len;
                    if (s1 >= 0)
                        sa[cnt[rank[s1]]++] = s1;
                }
            }
        }
    
    public static void lcp(CharSequence s) {
        int n = sa.length;
        for (int i = 0; i < n; i++)
            rank[sa[i]] = i;
        for (int i = 0, h = 0; i < n; i++) {
            if (rank[i] < n - 1) {
                int j = sa[rank[i] + 1];
                while (Math.max(i, j) + h < s.length() && s.charAt(i + h) == s.charAt(j + h) && s.charAt(i+h)!='?') {
                    ++h;
                }
                lcp[rank[i]] = h;
         //       System.out.println(rank[i]+" "+lcp[rank[i]]);
                if (h > 0)
                    --h;
            }
        }
    }

}
