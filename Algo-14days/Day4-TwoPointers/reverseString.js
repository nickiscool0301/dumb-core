var reverseString = function (s) {
  let begin = 0;
  let end = s.length - 1;
  while (begin < end) {
    [s[begin], s[end]] = [s[end], s[begin]];
    begin++;
    end--;
  }
};

let arr = ["h", "e", "l", "l", "o"];
reverseString(arr);
console.log(arr);
