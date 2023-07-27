import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        
        String convert = Integer.toString(n, k);
        int count = 0; //소수 개수
        String sosu = ""; //소수인지 확인해야함  
        
        //반복 돌리다가 0나오기 전까지의 숫자들더해서 소수면 ++;
        for (int i = 0; i<convert.length(); i++) {
            
            if (convert.charAt(i) != '0') {
                sosu += Character.toString(convert.charAt(i));   
            } else {
                if (!sosu.isEmpty()) {
                int sosuCount = 0;
                long a = Long.parseLong(sosu);
                long sqrtA = (long) Math.sqrt(a); // a의 제곱근 계산 
                    //기존에 제곱근 안쓰고했다가 1, 11번 시간초과나옴.
                    //제곱근 ex 1 7 49 면 7까지만 반복하고. 당연히49는 j가 1일때만 소수고 제곱근이 아니여도 소수.
                    //소수찾기
                    for (int j = 1; j <= sqrtA; j++) {
                        if (a % j == 0) {
                            sosuCount++;
                            if (j * j != a) { //a가 1이고 sqrt도 1이면 여기서 걸림.
                                sosuCount++; // 제곱근이 아니면 ++
                            }
                        }
                    }
                if (sosuCount == 2) {
                    count++;
                }
                sosu = ""; // 소수 확인 후 변수 초기화
                }
            }
        }
        if (!sosu.isEmpty()) { // 마지막0 이후 마지막 남아있는 소수도 count
                long a = Long.parseLong(sosu);
                int sosuCount = 0;
                 long sqrtA = (long) Math.sqrt(a); // a의 제곱근 계산
                    
                    for (int j = 1; j <= sqrtA; j++) {
                        if (a % j == 0) {
                            sosuCount++;
                            if (j * j != a) {
                                sosuCount++; // 제곱근 이외의 약수도 존재
                            }
                        }
                    }
                if (sosuCount == 2) {
                    count++;
                }
        }
                System.out.println(count);
      
        
        return count;
    }
}
