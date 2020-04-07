package CodeChef.CodeChefDecemberLongChalleneg2019;

import java.io.*;
import java.util.HashMap;

public class temp {
    public static void main(String args[]) throws IOException {
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
//        int t=Integer.parseInt(br.readLine());
//
//        while(t-->0){
//
//            String A=br.readLine();
//            String B=br.readLine();
//            int i;
//
//
//            if(B.equals("0")){
//                bw.write(0+"\n");
//                continue;
//            }
//
//            if(A.equals("0")){
//                bw.write(1+"\n");
//                continue;
//            }
//
//		    /*int diff=A.length()-B.length();
//		    if(diff>0){
//		        for(i=0;i<diff;i++)
//		            B="0"+B;
//		    }
//		    else{
//		         for(i=0;i<(-diff);i++)
//		            A="0"+A;
//		    }*/
//
//            char ch1[]=A.toCharArray();
//            char ch2[]=B.toCharArray();
//            int carry=0;
//            int c=0,count=1;
//            int max=0;
//            int len1=ch1.length;
//            int len2=ch2.length;
//            int maxlen=Math.max(len1,len2);
//            len1--;
//            len2--;
//
//            for(i=maxlen-1;i>=0;i--){
//                c=0;
//                try{
//                    if(ch1[len1]=='1')
//                        c++;
//                }
//
//                catch(Exception e){
//
//                }
//
//                try{
//                    if(ch2[len2]=='1')
//                        c++;
//                }
//
//                catch(Exception e){
//
//                }
//
//                if(carry==1)
//                    c++;
//
//                if(c==3){
//                    carry=1;
//                    max=Math.max(count,max);
//
//                    System.out.println("Max is "+max+" i is"+i);
//                    count=2;
//                }
//                else if(c==2){
//                    carry=1;
//                    count++;
//
//                    System.out.println("Max is "+max+" i is"+i);
//                }
//                else if(c==1){
//                    carry=0;
//                    max=Math.max(max,count);
//                    System.out.println("Max is "+max+" i is"+i);
//                    count=1;
//                }
//                len1--;
//                len2--;
//            }
//            max=Math.max(max,count);
//            bw.write(max+"\n");
//        }
//        bw.flush();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0 ; i<13;i++){
            map.put(1,1);
            System.out.println(map.size());
        }
    }
}
