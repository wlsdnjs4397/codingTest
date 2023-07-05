/*
공원을 나타내는 문자열 배열 park, 
로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes가 매개변수로 주어질 때, 
로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.

가로 길이가 W, 세로 길이가 H라고 할 때, 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 
*/

public class ParkWalk {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0,0};  //최종 좌표
        int w=0, h=0;

        //시작위치 찾기
        for(int i=0; i<park.length; i++){
            if(0 < park[i].indexOf("S")){
                w = park[i].indexOf("S");
                h = i;
                break;
            }
        }
        
        for(String r : routes){
            String op = r.substring(0,1);                         //방향
            int n = Integer.parseInt(r.substring(2,r.length()));  //이동횟수
            boolean flag = true;                                  //이동가능 여부
            int t_w=w;
            int t_h=h;
            String cal = "";
          
            //이동 가능 경로 검사
            try{
                for(int i=1; i<=n; i++){
                    String route ="";
                    if(op.equals("N")){
                        t_h = h-n;
                        route = park[h-i].substring(w,w+1);
                    }else if(op.equals("S")){  
                        t_h = h+n;
                        route = park[h+i].substring(w,w+1);
                    }else if(op.equals("W")){
                        t_w = w-n;
                        route = park[h].substring(w-i,(w-i)+1);
                    }else if(op.equals("E")){
                        route = park[h].substring(w+i,w+i+1);
                        t_w = w+n;
                    }
                    if(route.equals("X")){flag=false;}
                }

                //가능 시 이동
                if(flag){
                    w=t_w;
                    h=t_h;
                }
            }catch(IndexOutOfBoundsException e){}
        }
        
        answer[0]=h;
        answer[1]=w;
        return answer;
    }
}
