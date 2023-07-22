import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder newId = new StringBuilder();

        // Step 1: 대문자를 소문자로 변경
        new_id = new_id.toLowerCase();

        // Step 2: 알파벳 소문자, 숫자, '-', '_', '.'를 제외한 모든 문자 제거
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (ch == '-' || ch == '_' || ch == '.' || Character.isLowerCase(ch) || Character.isDigit(ch)) {
                newId.append(ch);
            }
        }

        // Step 3: 마침표가 2번 이상 연속되면 하나의 마침표로 치환
        for (int i = 0; i < newId.length() - 1; i++) {
            if (newId.charAt(i) == '.' && newId.charAt(i + 1) == '.') {
                newId.deleteCharAt(i);
                i--; // 삭제 후 다시 전으로 돌아가서 확인해야 함.
            }
        }

        // Step 4: 마침표가 처음이나 끝에 위치하면 제거
        if (newId.length() > 0 && newId.charAt(0) == '.') {
            newId.deleteCharAt(0);
        }
        if (newId.length() > 0 && newId.charAt(newId.length() - 1) == '.') {
            newId.deleteCharAt(newId.length() - 1);
        }

        // Step 5: 빈 문자열이라면 "a"를 대입
        if (newId.length() == 0) {
            newId.append("a");
        }

        // Step 6: 길이가 16자 이상이면 첫 15개의 문자를 제외한 나머지 제거
        if (newId.length() >= 16) {
            newId.delete(15, newId.length());
        }
        // 마지막 문자가 마침표라면 제거
        if (newId.length() > 0 && newId.charAt(newId.length() - 1) == '.') {
            newId.deleteCharAt(newId.length() - 1);
        }

        // Step 7: 길이가 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반복해서 추가
        while (newId.length() <= 2) {
            char lastChar = newId.charAt(newId.length() - 1);
            newId.append(lastChar);
        }

        return newId.toString();
    }
}
