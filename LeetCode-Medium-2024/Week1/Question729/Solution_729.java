class MyCalendar {
  TreeMap<Integer, Integer> treeMap;
  public MyCalendar() {
    treeMap = new TreeMap();
  }

  public boolean book(int start, int end) {
    Integer prev = treeMap.floorKey(start);
    Integer next = treeMap.ceilingKey(start);
    if((prev == null || treeMap.get(prev) <= start) && (next == null || next >= end)) {
      treeMap.put(start,end);
      return true;
    }
    return false;
  }
}

