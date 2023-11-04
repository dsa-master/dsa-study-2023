N = int(input())
candy_num = list(map(int, input().split() ))

candy_max_num = sum(candy_num)

if (candy_max_num % 2 != 0):

  smallest_odd = 0

  for num in candy_num:
    if (num % 2 != 0):
      if (smallest_odd == 0) or (num < smallest_odd):
        smallest_odd = num
  print(candy_max_num - smallest_odd)

else:
  print(candy_max_num)