def repeat(num):
    str_num = str(num)
    list_num = list(str_num) #를 리스트로 변환

    repeat_num = 0

    for i in range(len(list_num)): # 리스트 안 중복 요소 검사
      for j in range(i + 1, len(list_num)):
            if list_num[i] == list_num[j] :
              repeat_num = 1
              break
    return repeat_num


def no_repeat_maker(N, M): # 숫자가 중복된 번호 개수 뽑아내기
    c = 0
    for num in range(N, M + 1):
        repeat(num)
        if repeat(num) == 1 :
          c = c + 1
    return c


while True:
    try:
        N, M = map(int, input().split())
        result = no_repeat_maker(N, M)
        print(M - N  + 1 - result) #두 번호 사이의 번호의 갯수 - 중복되는 번호의 갯수
    except EOFError:
        break