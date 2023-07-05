/*
먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 
각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 
각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
*/

import java.util.*;

public class SkillDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int count=1;  //각 배포되는 기능 수
        int temp=(int)Math.ceil((double)(100-progresses[0])/speeds[0]);  //이전 작업 남은 일수

        for(int i=1; i<progresses.length; i++){
            int program = progresses[i];
            int speed = speeds[i];
            int remain= (int)Math.ceil((double)(100-program)/speed);  //현재 작업 남은 일수
            
            if(remain <= temp){  //현재작업이 이전 작업보다 일찍 끝나면 배포되는 기능 수 증가
                count++;
            }else{               //현재작업이 이전 작업보다 늦게 끝나면 이전 작업까지 배포
                answer.add(count);
                count=1;
                temp=remain;
            }      
            
            if(i == progresses.length -1){
                answer.add(count);
            }
        }
        
        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            result[i] = answer.get(i);
        }
        
        return result;
    }
}
