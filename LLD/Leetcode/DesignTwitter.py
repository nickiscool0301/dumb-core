'''
Idea:
2 Map: for user, and tweet
- user: can use set for better remove and add, avoid dup id
- tweet: normal list

get news feed:
- users/followers have their own lists of tweetId -> merge them together based on timestamp:

To track timestamp: use global self.time. Everytime, we post new tweet, self.time -= 1

Then use heap for merge


'''

class Twitter:
    def __init__(self):
        self.user_map = defaultdict(set) 
        self.tweet_map = defaultdict(list)
        self.time = 0

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweet_map[userId].append((self.time, tweetId))
        self.time -= 1

    def getNewsFeed(self, userId: int) -> List[int]:
        '''
        '''
        heap = []
        users = self.user_map[userId] | {userId}
        for user_id in users:
            if self.tweet_map[user_id]:
                last_idx = len(self.tweet_map[user_id]) - 1
                last_time, tweet_id = self.tweet_map[user_id][last_idx]
                heapq.heappush(heap, (last_time, user_id, tweet_id, last_idx))
        res = []
        while heap and len(res) < 10:
            last_time, user_id, tweet_id, last_idx = heapq.heappop(heap)
            res.append(tweet_id)
            if last_idx > 0:
                next_time, next_tweet_id = self.tweet_map[user_id][last_idx - 1]
                heapq.heappush(heap, (next_time, user_id, next_tweet_id, last_idx - 1))
        return res


    def follow(self, followerId: int, followeeId: int) -> None:
        if followeeId != followerId:
            self.user_map[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.user_map[followerId].discard(followeeId)  


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)