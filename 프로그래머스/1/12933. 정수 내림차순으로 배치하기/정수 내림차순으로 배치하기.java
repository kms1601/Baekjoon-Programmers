import java.util.*;

public class Solution {
  public long solution(long n) {
    String s = Long.toString(n);

    
    char[] arr =  s.toCharArray();
    String[] str = new String[arr.length];

    for(int i=0; i< str.length; i++){
        str[i] = Character.toString(arr[i]);
    }

    Arrays.sort(str, Collections.reverseOrder());
    
    String answer = "";
    for(String s1: str) answer +=s1;
    
    return Long.parseLong(answer);
  }
}