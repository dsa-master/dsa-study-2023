import java.io.*;
import java.util.*;

/***
 * 백준 1931번
 * 회의실 배정
 * 2023-10-09
 */

public class Main {

    static class Meeting implements Comparable<Meeting> {
        private int start;
        private int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            // 회의 끝 (오름차순 정렬)
            if (this.end > o.end) {
                return 1;
            } else if(this.end < o.end) {
                return - 1;
            } else
                // 회의 끝 시간 같을 시, 회의 시작 (오름차순 정렬)
                return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Meeting> meetings = new ArrayList<>();

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(s, e));
        }

        // 회의 끝을 오름차순으로 정렬
        Collections.sort(meetings);


        int end = 0;
        int answer = 0;

        // 정렬된 회의에서 가장 빨리 끝나는 회의와 겹치지 않는 것을 카운팅하고, 가장 빨리 끝나는 회의 갱신
        for (Meeting meeting : meetings) {
            if (meeting.start >= end) {
                end = meeting.end;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
