def dfs(graph, node, visited):

    visited[node] = True
    count = 1  # 현재 컴퓨터는 걸렸으므로 1부터

    for i in graph[node]:
        if not visited[i]:
            count = count + dfs(graph, i, visited)

    return count

com_num = int(input())  # 컴퓨터의 수
connect_com_num = int(input())  # 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

graph = []
for _ in range(com_num + 1):
    graph.append([])

for _ in range(connect_com_num): # 연결된 쌍 입력받기
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

visited = [False for _ in range(com_num + 1)]

result = dfs(graph, 1, visited)

print(result + (- 1))  # 1번 컴퓨터는 이미 걸렸기에 빼주기