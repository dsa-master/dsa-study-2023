MAX_NUM = 1000


def solve(N: int, A: list[int]):
    counter = [0] * (MAX_NUM+1)
    for a in A:
        counter[a] += 1
    build(N, counter)


def build(N: int, counter: list[int], stack: list[int] = []):
    if len(stack) == N:
        print(' '.join(map(str, stack)))
        exit()
    for n in generate_possible_numbers(counter, stack):
        stack.append(n)
        counter[n] -= 1
        build(N, counter, stack)
        counter[n] += 1
        stack.pop()


def generate_possible_numbers(counter: list[int], stack: list[int]):
    for i in range(MAX_NUM+1):
        if counter[i] > 0 and (not stack or i != stack[-1]+1):
            yield i


if __name__ == "__main__":
    N = int(input())
    A = list(map(int, input().split()))
    solve(N, A)