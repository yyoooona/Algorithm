package programmers;

import java.util.*;
   
class Solution {
    static class Truck{
        int w, time;
           
        public Truck(int w, int time){
            this.w = w;
            this.time = time;
        }
    }
       
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalTime = 1; // 경과 시간
        int curBWeight = 0; // 현재 다리의 무게
        int truckIdx = 0; 
        Queue<Truck> q = new LinkedList<Truck>();
           
        while(true){
            if(truckIdx>=1 && (totalTime-bridge_length)==q.peek().time){
                    curBWeight -=q.peek().w;
                    q.poll();
                   
                    // 기저조건
                    if(truckIdx == truck_weights.length && q.isEmpty()) break;
                }
               
            if(truckIdx < truck_weights.length && curBWeight+truck_weights[truckIdx] <= weight) {
                q.add(new Truck(truck_weights[truckIdx], totalTime));
                curBWeight +=truck_weights[truckIdx];
                truckIdx++;
            }
               
            totalTime++;
        }
                  
        return totalTime;
    }
}