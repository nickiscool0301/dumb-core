https://leetcode.com/problems/time-based-key-value-store/description/

# Thought process

- Use hashmap with key is String, value is List<Element>, where:
  - Element is object with String value, int timestamp
- For put operation:
  - just need to check if hm contains key. If not, create a new List of Element
  - add new entry of Element to the list
- For get operation:
  - check if key is existed, if not return empty string
  - otherwise, get the list of Element, then do binary search to find THE FIRST SMALLER than the provided timestamp

```java
class TimeMap {
    class Element {
        String value;
        int timestamp;
        Element(int t, String value) {
            this.value = value;
            this.timestamp = t;
        }
    }

    private Map<String, List<Element>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)) {
            hm.put(key, new ArrayList<>());
        }
        hm.get(key).add(new Element(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        var list = hm.get(key);
        var idx = search(list, timestamp);
        if(idx == -1) return "";
        return list.get(idx).value;
    }

    private int search(List<Element> list, int timestamp) {
        var len = list.size();
        int l = 0, r = len - 1;
        int res = -1;
        while(l <= r) {
            var m = (l + r)/2;
            if(list.get(m).timestamp <= timestamp) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
```
