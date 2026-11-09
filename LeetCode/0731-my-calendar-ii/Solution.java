class MyCalendarTwo {
    List<int[]> bookings;
    List<int[]> overlaps;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    public boolean book(int start, int end) {
        for (int[] interval : overlaps) {
            if (start < interval[1] && end > interval[0]) {
                return false;
            }
        }
        for (int[] interval : bookings) {
            int s = Math.max(start, interval[0]);
            int e = Math.min(end, interval[1]);
            if (s < e) {
                overlaps.add(new int[]{s, e});
            }
        }
        bookings.add(new int[]{start, end});
        return true;
    }
}
/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */