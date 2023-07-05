/*
문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현

예를 들어, "ababcdcdababcdcd"의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 2개 단위로 잘라서 압축한다면 "2ab2cd2ab2cd"로 표현할 수 있습니다. 
다른 방법으로 8개 단위로 잘라서 압축한다면 "2ababcdcd"로 표현할 수 있으며, 이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.

다른 예로, "abcabcdede"와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 "abcabc2de"가 되지만, 
3개 단위로 자른다면 "2abcdede"가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다. 이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.

압축할 문자열 s가 매개변수로 주어질 때, 
위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.
*/

class StringPressure {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1; i<=s.length()/2; i++){
            int level = 1;
            String standard = s.substring(0,i);  //기준문자
            String temp = "";
            
            for(int j=i; j<=s.length(); j+=i){  //i이후 문자부터 j+i번째 문자까지 비교
                String nextStr = s.substring(j, j+i > s.length() ? s.length() : j+i);  //비교문자
                if(standard.equals(nextStr)){
                    level++;
                }else{
                    temp += (level == 1 ? "" : level) + standard;
                    standard=nextStr;
                    level=1;
                } 
            }
            temp += standard;
            answer = answer > temp.length() ? temp.length() : answer;
        }
        
        
        return answer;
    }
}
