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
hash(s) = (s[0]*d^(m-1) + s[1]*d^(m-2) + ... + s[m-1]) % q

d: base (like 256 for ASCII)
q: large prime
m: pattern length