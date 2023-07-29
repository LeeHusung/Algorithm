import java.util.*;
class Solution {
    public double[] solution(int[] fees, String[] records) {

        Map<String, Long> map = new HashMap<>();
        Map<String, Long> car_time = new TreeMap<>(); //차량번호:주차시간 * TreeMap으로해야 정렬됨
        
        for (int i = 0; i<records.length; i++) {
            String[] rSplit = records[i].split(" ");
        
            String[] time = rSplit[0].split(":");
            long hour = Integer.parseInt(time[0]) * 60;
            long minute = Integer.parseInt(time[1]);
            long sumTime = hour + minute;
        
                if (rSplit[2].equals("IN")) {
                    map.put(rSplit[1], sumTime);
                } else { //"OUT"
                    if (map.containsKey(rSplit[1])) {
                        long parkTime = sumTime - map.get(rSplit[1]); //주차한 시간
                        car_time.put(rSplit[1], car_time.getOrDefault(rSplit[1], 0L) + parkTime);
                        map.remove(rSplit[1]);
                    }
                }
            }
        
        for (String carNum : map.keySet()) {
            long noOut = 1439 - map.get(carNum);
            car_time.put(carNum, car_time.getOrDefault(carNum, 0L) + noOut);
        }
            System.out.println(car_time.values());
        List<Double> list = new ArrayList<>();
        
        for (String carNum : car_time.keySet()) {
            double totalTime = car_time.get(carNum);
            if (totalTime >= fees[0]) {
                double l = Math.ceil((totalTime - fees[0]) / fees[2]) * fees[3];
                list.add(l+fees[1]);
            } else {
                // double l = Math.ceil((totalTime - fees[0]) / fees[2]) * fees[3];
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