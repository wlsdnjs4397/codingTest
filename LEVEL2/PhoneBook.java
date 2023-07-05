/*
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 
어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
*/

import java.util.HashMap;

class PhoneBook {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        for(int i=0; i<phone_book.length; i++){ 
            hm.put(phone_book[i], 0);    
        }
        
        for(int i=0; i<phone_book.length; i++){   
            for(int j=0; j<phone_book[i].length(); j++){
                if(hm.containsKey(phone_book[i].substring(0,j))){  //마지막 숫자는 비교 x (자기자신 방지)
                    return false;
                }
            }
        }
        
        return true;
    }
}
