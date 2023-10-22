//한수가 집까지 도착하는 경우 중 거리가 k인 가짓수를 구하는 것
// . 과 T 로 지도가 표현되면 T는 가지 못하는 곳
// 출발지점은 왼쪽 아래, 도착 지점은 오른쪽 위
package org.example;


import java.io.*;
import java.util.StringTokenizer;

// 풀이 -> 출발지점이 왼쪽 아래니까 (r,1)을 시작점으로 하고 도착지점이 오른쪽 위기 때문에 (1,c)
// T에 가는길을 제외하고 (r,1)부터 (1,c)까지 가는 경로를 다 탐색하는데 거리가 K일 때만 카운트
public class BaekJoon1189 {
    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};	//상우하좌
    static int[] dc = {0, 1, 0, -1};
    static int res = 0;

    // dfs 구현
    static void dfs(int r, int c, int depth) {
        if(r==1 && c==C) {
            // 도착지점을 방문했을때 리턴 -> 거리가 k일 경우 전체 카운트++
            if(depth==K) res++;
            return;
        }
        // 2차원 좌표 상을 이동 (상우하좌)
        for(int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            // R&C 맵이니까 범위
            if(1<=nr && nr<=R && 1<=nc && nc <=C) {
                // 방문한 좌표면 반복문 점프!
                if(visited[nr][nc]) continue;
                // 안했을 시 방문 처리
                visited[nr][nc] = true;
                map[nr][nc] = '-';
                // 재귀함수를 이용한 dfs
                dfs(nr, nc, depth+1);
                //범위 벗어났을 때
                visited[nr][nc] = false;
                map[nr][nc] = '.';
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R+1][C+1];
        visited = new boolean[R+1][C+1];

        for(int i=1; i<=R; i++) {			//맵 입력
            String input = br.readLine();
            for(int j=1; j<=C; j++) {
                char c = input.charAt(j-1);
                map[i][j] = c;
                //T일 경우 이미 방문처리를 해두면 방문하지 않음
                if(c=='T')
                    visited[i][j] = true;
            }
        }
        //(R,1) 방문처리 후 시작!
        visited[R][1] = true;
        dfs(R, 1, 1);

        bw.write(res + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

