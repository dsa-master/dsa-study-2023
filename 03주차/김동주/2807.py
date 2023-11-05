import collections
import itertools
import sys


ALPHABETS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
ALPHABET_LEN = len(ALPHABETS)


def countCases(adjMat: dict[str, dict[str, int]], source: str, sink: str, *routes: list[str]) -> int:
    if len(routes) < 2:
        raise ValueError()

    isPossible = True
    ans = 1

    for route in routes:
        isPossible &= adjMat[source][route] > 0
        ans *= adjMat[source][route]
        adjMat[source][route] -= 1

        isPossible &= adjMat[route][sink] > 0
        ans *= adjMat[route][sink]
        adjMat[route][sink] -= 1

    for route in routes:
        adjMat[source][route] += 1
        adjMat[route][sink] += 1

    # 두 route가 같으면 경우의 수도 두 배로...
    ans *= len(set(routes))

    return ans if isPossible else 0


def solve(N: int, words: list[str]) -> int:
    # Adjacent matrix
    adjMat = collections.defaultdict(lambda: collections.defaultdict(lambda: 0))
    answer = 0
    for w in words:
        adjMat[w[0]][w[-1]] += 1
    for i in range(ALPHABET_LEN): # i = source
        for j in range(ALPHABET_LEN): # j = sink
            for k in range(ALPHABET_LEN): # k = route1
                for l in range(k, ALPHABET_LEN): # l = route2
                    answer += countCases(adjMat, ALPHABETS[i], ALPHABETS[j], ALPHABETS[k], ALPHABETS[l])
    return answer


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    words = [sys.stdin.readline().strip() for _ in range(N)]
    sys.stdout.write(str(solve(N, words)))
