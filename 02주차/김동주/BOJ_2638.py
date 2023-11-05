import sys

class Cell:
    WARM_AIR = '!' # 문제에서 사용하지 않는 값으로 아무거나 사용
    COLD_AIR = '0'
    CHEESE = '1'


DY = (-1, 1, 0, 0)
DX = (0, 0, -1, 1)

MAX_N = 100

sys.setrecursionlimit(2*(MAX_N**2))


def solve():
    HEIGHT, WIDTH = map(int, sys.stdin.readline().split())
    grid = [sys.stdin.readline().split() for _ in range(HEIGHT)]


    def is_in_grid(y: int, x: int) -> bool:
        return x >= 0 and y >= 0 and x < WIDTH and y < HEIGHT

    def calc_warmness(y: int, x: int) -> int:
        # 지정한 공간 주변의 상하좌우로 실내온도인 칸이 몇 개인지 셈
        warmness = 0
        for dy, dx in zip(DY, DX):
            if is_in_grid(y+dy, x+dx) and grid[y+dy][x+dx] == Cell.WARM_AIR:
                warmness += 1
        return warmness

    def warm_propagation(y: int, x: int, warmed_cheese: set[tuple[int,int]]):
        # 실내온도를 전파시킨다.
        # 새로 따뜻해진 곳 주변에 곧 녹게 될 치즈가 있다면 warmed_cheese에 추가한다.
        # DFS 방식으로 실내온도를 전파하는데, 방문 검사는 그냥 찬 공기면 방문하는 것으로 대체한다.
        # 이 동작은 치즈를 녹이지는 않는다.
        if grid[y][x] == Cell.COLD_AIR:
            grid[y][x] = Cell.WARM_AIR
            for dy, dx in zip(DY, DX):
                if is_in_grid(y+dy, x+dx):
                    warm_propagation(y+dy, x+dx, warmed_cheese)
        elif grid[y][x] == Cell.CHEESE and calc_warmness(y, x) >= 2:
            warmed_cheese.add((y, x))


    # BFS를 응용하여 풀이
    warmed_cheese = set()
    hours = 0

    # 모눈종이의 가장자리는 실내온도(치즈를 녹일 수 있는 WARM_AIR)에 속하므로,
    # 해당 내용을 반영할 겸, 실내온도와 맞닿은 치즈를 checklist에 추가한다.
    warm_propagation(0, 0, warmed_cheese)

    while len(warmed_cheese) > 0:
        # 매 시간마다 녹을 치즈를 녹이고, 실내온도를 전파해보자.
        hours += 1

        # 하단의 warm_propagation 과정에서 새로운 치즈들이 검사대상으로 추가 될 것이다.
        # 지금 검사하고 있는 치즈의 목록과 다음에 검사할 치즈의 목록을 분리하여,
        # BFS에 몇 주기가 걸렸는지 셀 수 있다. (1주기 = 문제에서의 1시간)
        newly_warmed_cheese = set()
        for y, x in warmed_cheese:
            grid[y][x] = Cell.COLD_AIR # 치즈가 녹아서 공기가 되었다...! (충격)
        for y, x in warmed_cheese:
            warm_propagation(y, x, newly_warmed_cheese) # 새로 생긴 공간으로 온기가 전파되어간다...

        warmed_cheese = newly_warmed_cheese

    # 문제의 정답을 출력 (모든 치즈가 녹는데 걸린 시간)
    print(hours)


solve()
