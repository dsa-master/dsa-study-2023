import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class num6118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //헛간 개수
        int m = Integer.parseInt(st.nextToken()); //연결된 헛간 개수
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int[] visit; //방문 여부를 담는 배열

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>(); //각 노드마다 연결된 노드들을 담을 배열 생성
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        //1번 헛간에서 다른 헛간까지의 거리 계산
        int startNode = 1;
        // BFS를 이용한 거리 계산
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visit = new int[n + 1];
        visit[startNode] = 1; // 시작 노드를 방문했다고 표시
        int[] distance = new int[n + 1]; //각 헛간까지의 거리. 인덱스를 1부터 시작하기 위하여 배열을 하나 더 늘림
        while (!queue.isEmpty()) {
            int node = queue.poll(); //큐에서 노드를 꺼냄 -> 꺼낸 노드로부터 다른 연결된 노드까지의 작업 수행
            for (int neighbor : graph[node]) { //현재 노드와 연결된 모든 이웃 노드에 대해 반복
                if (visit[neighbor] == 0) { //방문한 노드가 아닐 경우
                    visit[neighbor] = 1; // 방문 표시
                    distance[neighbor] = distance[node] + 1; //이웃 노드까지의 거리 계산(현재 노드 +1)
                    queue.add(neighbor); //이웃 노드를 큐에 추가
                }
            }
        }
        int farNode = 1; //가장 먼 헛간의 idx
        int maxDistance = 0; //가장 먼 헛간까지의 거리

        for (int i = 1; i <= n; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                farNode = i;
            }
        }
        System.out.println(farNode + " " + maxDistance + " " + countMaxDistanceNodes(distance, maxDistance));
        br.close();
    }

    private static int countMaxDistanceNodes(int[] distance, int maxDistance) {
        int count = 0;
        for (int dist : distance) {
            if (dist == maxDistance) {
                count++;
            }
        }
        return count;
    }
}
