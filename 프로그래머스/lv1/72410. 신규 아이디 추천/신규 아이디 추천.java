import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        StringBuilder newId = new StringBuilder();
        new_id = new_id.toLowerCase();
        
        for(int i = 0; i<new_id.length(); i++) {
           if (new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.' || (new_id.charAt(i) >=97 && new_id.charAt(i) <=122) || (new_id.charAt(i) >=48 && new_id.charAt(i) <=57)) {
               newId.append(new_id.charAt(i));
           }
        }
       
        for(int i = 0; i<newId.length()-1; i++) {
            if (newId.charAt(i) == '.' && newId.charAt(i+1) == '.') {
                newId.deleteCharAt(i);
                i--; //삭제 후 다시 전으로 돌아가서 확인해야함.
            }
        }
         if (newId.length() > 0 &&newId.charAt(0) == '.'){
                newId.deleteCharAt(0);
            }
         if (newId.length() > 0 &&newId.charAt(newId.length()-1) == '.') {
                newId.deleteCharAt(newId.length()-1);
            }
        if (newId.length() == 0){
            newId.append("a");
        }
     
        if (newId.length() >= 16) {
            newId.delete(15, newId.length());
        }
        if (newId.charAt(newId.length()-1) == '.') {
            newId.deleteCharAt(newId.length()-1);
        }
       
          
            while (newId.length() < 3) {
                  char lastChar = newId.charAt(newId.length()-1);
                newId.append(lastChar);
              
        }
        
        
        answer = newId.toString();
        
        
        return answer;
    }
}
