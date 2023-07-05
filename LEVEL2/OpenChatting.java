/*
채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 
모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.

채팅방은 중복 닉네임을 허용
[유저 아이디] 사용자가 [닉네임]으로 채팅방에 입장 - "Enter [유저 아이디] [닉네임]" (ex. "Enter uid1234 Muzi")
[유저 아이디] 사용자가 채팅방에서 퇴장 - "Leave [유저 아이디]" (ex. "Leave uid1234")
[유저 아이디] 사용자가 닉네임을 [닉네임]으로 변경 - "Change [유저 아이디] [닉네임]" (ex. "Change uid1234 Muzi")
*/

import java.util.*;

class OpenChatting {
    public String[] solution(String[] record) {
       HashMap<String, String> member = new HashMap();    //key : userid , value : nickname
       ArrayList<String> list = new ArrayList<String>();
        
        for(int i=0; i<record.length; i++){
            String[] arr = record[i].split(" ");
            if(!arr[0].equals("Change")){
                if(arr[0].equals("Enter")){
                    member.put(arr[1], arr[2]);    
                }
                String str = arr[1]+"님이 " + (arr[0].equals("Enter") ? "들어왔습니다." : "나갔습니다.");  //일단 아이디로 문자열 작성
                list.add(str);
            }else{ 
                // 해당 아이디값 닉네임 변경
                member.put(arr[1], arr[2]);
            }
        }
        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            String str = list.get(i);
            String mem = str.split("님이")[0];
            
            str = str.replace(mem, member.get(mem));  //아이디를 최종 닉네임으로 변경
            answer[i] = str;
        }
        
        return answer;
    }
}
