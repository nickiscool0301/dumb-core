# Rabin Carp
- String matching/searching algo
- Find pattern using hashing

## Goal
- Find all occurances of pattern P in text T

## Idea
- Instead of comparing characters one by one -> compute hash of pattern and compare it with rolling hashes of subtrings of text

## Step
- Precompute hash of pattern
- Compute hash of first window of text, that has same length of pattern
- Slide window one character at a time
- If hash matches, check substring directly

## Hash Formula
hash(s) = (s[0]*p^(n-1) + s[1]*p^(n-2) + ... + s[n-1]*p^0) mod m

p: small prime (31,33)
m: large prime modules: 1e9 + 9

hash_next = ((hash_curr - s[i]*p^(m-1)) * p + s[i+m]) mod m
