function solution(sizes) {
  let maxW = 0;
  let maxH = 0;
  sizes.forEach((element) => {
      element.sort((a, b) => a - b);
      if (element[0] > maxW) maxW = element[0];
      if (element[1] > maxH) maxH = element[1];
  });
  return maxW * maxH;
}