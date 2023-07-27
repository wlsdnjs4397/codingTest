/*
어떤 수열의 연속 부분 수열에 같은 길이의 펄스 수열을 각 원소끼리 곱하여 연속 펄스 부분 수열을 만들려 합니다.
펄스 수열이란 [1, -1, 1, -1 …] 또는 [-1, 1, -1, 1 …] 과 같이 1 또는 -1로 시작하면서 1과 -1이 번갈아 나오는 수열입니다
정수 수열 sequence가 매개변수로 주어질 때, 연속 펄스 부분 수열의 합 중 가장 큰 것을 return 하도록 solution 함수를 완성해주세요.
*/
import java.util.*;

class ContinuousSequence {
    public long solution(int[] sequence) {
        long answer = 0;

        //펄스수열 경우의 수 = 시작이 1 또는 -1 두가지 배열.
        int[] aArr = new int[sequence.length];
        int[] bArr = new int[sequence.length];
        int temp = 1;
        for(int i=0; i<sequence.length; i++){
            aArr[i] = sequence[i] * temp;
            temp *= -1;
            bArr[i] = sequence[i] * temp;
        }
        
        long[] a = new long[sequence.length]; 
        long[] b = new long[sequence.length];
        a[0] = aArr[0];
        b[0] = bArr[0];
        answer = Math.max(a[0], b[0]);
        
        for(int i=1; i<sequence.length; i++){
            // 이전 계산 값이 도움 안되면 버리고 새로시작, 도움되면 더해서 가져간다.
            a[i] = Math.max(a[i-1] + aArr[i], aArr[i]);  
            b[i] = Math.max(b[i-1] + bArr[i], bArr[i]); 
            
            long m = Math.max(a[i], b[i]); 
            answer = Math.max(answer, m);
        }
        return answer;
    }
}
