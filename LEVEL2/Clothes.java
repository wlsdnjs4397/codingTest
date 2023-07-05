/*
코니가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다.
착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산
코니는 하루에 최소 한 개의 의상은 입습니다.
*/

import java.util.HashMap;
class Clothes {
    public int solution(String[][] clothes) {
        int answer = 0;
      
        HashMap<String, Integer> count = new HashMap<String, Integer>();  //key : 옷의 종류 . value : 옷의 종류 개수
        for(int i=0; i<clothes.length; i++){
            String kind = clothes[i][1];
            if(null != count.get(kind)){
                count.put(kind , (count.get(kind) + 1) );    
            }else{
                count.put(kind , 1);    
            }
        }
                          
        for(String i : count.keySet()){ 
            // 옷의 종류 개수 + (옷의 종류 개수 * 현재까지 결과값)
            answer += count.get(i) + (count.get(i)*answer);
        }   
                          
    return answer;
    }
}
