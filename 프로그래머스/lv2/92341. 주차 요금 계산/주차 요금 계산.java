import java.util.*;
class Solution {
    public double[] solution(int[] fees, String[] records) {

        Map<String, Long> map = new HashMap<>(); //차번호:입차시간
        Map<String, Long> car_time = new TreeMap<>(); //차번호:주차시간, 정렬위해 TreeMap사용
        
        for (int i = 0; i<records.length; i++) {
            String[] rSplit = records[i].split(" ");
            String[] time = rSplit[0].split(":");
            long hour = Long.parseLong(time[0]) * 60;
            long min = Long.parseLong(time[1]);
            long sum = hour + min;
            
            if (rSplit[2].equals("IN")){
                map.put(rSplit[1], sum);
            } else { //OUT
                if (map.containsKey(rSplit[1])) {
                    long sumTime = sum - map.get(rSplit[1]);
                    car_time.put(rSplit[1], car_time.getOrDefault(rSplit[1], 0L) + sumTime);
                    map.remove(rSplit[1]);
                }
            }
        }
        
        //out이 없는 경우 -> map에만 IN 시간 담겨있음.
        for (String carNum : map.keySet()) {
            long noOut = 1439 - map.get(carNum);
            car_time.put(carNum, car_time.getOrDefault(carNum, 0L) + noOut);
        }
        
        List<Double> list = new ArrayList<>(); //요금 담을 배열
        
        for (String carNum : car_time.keySet()) {
            double realTime = car_time.get(carNum);
            if (realTime >= fees[0]) {
                double d = Math.ceil((realTime - fees[0]) / fees[2]) * fees[3];
                list.add((double)fees[1] + d);
            } else {
                list.add((double)fees[1]);
            }
        }
        
        double[] answer = new double[list.size()];
        
        for (int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}
