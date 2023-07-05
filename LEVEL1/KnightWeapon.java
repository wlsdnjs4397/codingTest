/*
기사단원의 수를 나타내는 정수 number와 
이웃나라와 협약으로 정해진 공격력의 제한수치를 나타내는 정수 limit와 
제한수치를 초과한 기사가 사용할 무기의 공격력을 나타내는 정수 power가 주어졌을 때,
무기점의 주인이 무기를 모두 만들기 위해 필요한 철의 무게를 return 하는 solution 함수를 완성하시오.

각 기사에게는 1번부터 number까지 번호가 지정
각 기사는 자신의 기사 번호의 약수 개수에 해당하는 공격력을 가진 무기를 구매
제한수치보다 큰 공격력을 가진 무기를 구매해야 하는 기사는 협약기관에서 정한 공격력을 가지는 무기를 구매
*/
import java.util.*;

class KnightWeapon {
    public int solution(int number, int limit, int power) {
        int answer = 0;  //철의 무게 결과
      
        for(int i=1; i<=number; i++){
            int cnt = 0;                     //약수의 개수
            int sqrt = (int)Math.sqrt(i);    //기사 번호의 제곱근
            for(int j =1; j <= sqrt; j++){
                if(i % j ==0){                   //기준값(i)을 제곱근 이하의 숫자(j)와 나눴을 때 나머지가 0이면 j는 i의 약수이다.
                    cnt ++;
                    if(Math.pow(j, 2) != i) {    //i를 j로 나눈 값도 i의 약수이다. (i값 중복 제외 => j=1일때, j=sqrt일때 i값이 중복)
                        cnt ++;
                    }
                }
            }
            answer += cnt > limit ? power : cnt;  // 제한수치 검사
        }
        return answer;
    }
}
