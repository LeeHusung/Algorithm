class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        String today2 = today.replace(".","");
        
        int year = Integer.parseInt(today2.substring(0,4));
        int month = Integer.parseInt(today2.substring(4,6));
        int day = Integer.parseInt(today2.substring(6,8));
        int count = (year*12*28) + (month*28) + day;
        
         int[] answer = new int[privacies.length];
        for (int i = 0; i < privacies.length; i++) {
            String[] pArr = privacies[i].split(" ");
            
            int num = 0; //약관달
            for (int j = 0; j < terms.length; j++) {
                String[] tArr = terms[j].split(" ");
                
                if (pArr[1].equals(tArr[0])) {
                    num = Integer.parseInt(tArr[1]);
                    break;
                }
            }
            
            String[] pSplit = pArr[0].split("\\.");
            int pyear = Integer.parseInt(pSplit[0]);
            int pmonth = Integer.parseInt(pSplit[1]);
            int pday = Integer.parseInt(pSplit[2]);
            
            int empiredYear = pyear;
            int empiredMonth = pmonth + num;
            
            while (empiredMonth > 12) {
                pyear++;
                empiredMonth -= 12;
            }
            
            int count2 = (pyear*12*28) + (empiredMonth*28) + pday - 1;
            
           
            if (count > count2) {
                answer[i] = i+1;
            }
        }
        
        int a = 0;
        for(int i = 0; i<answer.length; i++) {
            if(answer[i] > 0){
                a++;
            }
        }
        int[] arr= new int[a];
        int index = 0;
        for(int i = 0; i<answer.length; i++) {
            if(answer[i] >0){
                arr[index] = answer[i];
                index++;
            }
        }
        
        
        
        return arr;
    }
}