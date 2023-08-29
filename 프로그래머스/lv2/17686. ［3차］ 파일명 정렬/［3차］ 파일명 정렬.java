import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        // 하나씩 짤라서 다 정렬한다는건 매우 비효율적이고 바보같은 생각임. 짤라서 정렬한다고 해도 다시 어떻게 원래 입력값이랑 매칭할건데 ? 불가능한 방법으로 풀지말고 자바에서 제공해주는 라이브러리 효율적으로 쓰자.
        Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				
				String h1 = o1.split("[0-9]")[0];
				String h2 = o2.split("[0-9]")[0];
				
				int result = h1.toLowerCase().compareTo(h2.toLowerCase());

				if ( result == 0 ) {					
					// 문자열이 같은 경우 숫자를 비교한다.
					result = findNum(o1,h1)-findNum(o2,h2);
				}
				return result;
			}
		});		
		return files;	
  }
    
 private int findNum( String s, String h ) {		
		s = s.replace(h, "");		
		String result ="";		
		for( char c : s.toCharArray()) {
			if( Character.isDigit(c) && result.length() < 5 ) {
				result+=c;
			}else
				break;
		}
		return Integer.valueOf(result);
	}   
} 
        
        
//         String[] answer = new String[files.length];
        
//         Arrays.sort(files);
//         for (int i = 0; i<files.length; i++) {
//             answer[i] = files[i];
//         }
//         // 숫자만 따로 뽑아서 정렬해야함
//         // 숫자 전까지 문자 뽑아서 먼저 정렬하고 == 6라인 한줄로 정리가능하네..
//         //     문자가 같다면 숫자 정렬해서 나열
//         //     tail은 신경 안써도 됨.
        
//         for(int i = 0; i<files.length; i++) {
//             files[i] = files[i].toUpperCase();
//         }
        
//         String[] sarr = new String[files.length];
//         for (int i = 0; i<files.length; i++) {
//         StringBuilder sb = new StringBuilder();
//             for (int j = 0; j<files[i].length(); j++) {
//                 if (files[i].charAt(j) >=48 && files[i].charAt(j) <= 57) {
//                     sb.append(files[i].charAt(j));
//                     if(sb.substring(0,1).equals("0")) {
//                         sb.deleteCharAt(0);
//                     }
//                 } else {continue;}
//             }
//             sarr[i] = String.valueOf(sb);
//                 System.out.println(sb);
//         }
//         Arrays.sort(sarr);
//         System.out.println(sarr[3]);
        
        
        
//         return answer;
//     }
// }