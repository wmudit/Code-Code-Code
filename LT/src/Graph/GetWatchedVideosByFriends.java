import java.util.*;

public class GetWatchedVideosByFriends {

    static class Element {
        int freq;
        String vid;

        public Element(int f, String v) {
            this.freq = f;
            this.vid = v;
        }
    }

    static class mComparator implements Comparator<Element> {
        @Override
        public int compare(Element e1, Element e2) {
            int diff = e1.freq - e2.freq;
            if (diff == 0)
                return e1.vid.compareTo(e2.vid);
            return diff;
        }
    }

    public static List<String> processThis(Queue<Integer> q, List<List<String>> videos) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new mComparator());
        Map<String, Integer> map = new HashMap<>();
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < videos.get(temp).size(); i++) {
                map.put(videos.get(temp).get(i), map.getOrDefault(videos.get(temp).get(i), 0) + 1);
            }
        }
        for (Map.Entry<String, Integer> e : map.entrySet())
            pq.offer(new Element(e.getValue(), e.getKey()));
        List<String> result = new ArrayList<String>();
        while (!pq.isEmpty())
            result.add(pq.poll().vid);
        return result;
    }

    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        int k = 0;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(id);
        while (!q.isEmpty()) {
            if (k == level) {
                return processThis(q, watchedVideos);
            }
            k++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int curr = q.poll();
                for (int j = 0; j < friends[curr].length; j++) {
                    if(!visited.contains(friends[curr][j])) {
                        q.offer(friends[curr][j]);
                        visited.add(friends[curr][j]);
                    }
                }
            }
        }
        return new ArrayList<String>();
    }

    public static void main(String[] args) {
        String[] s1 = {"A", "B"};
        String[] s2 = {"C"};
        String[] s3 = {"C", "B"};
        String[] s4 = {"D"};
        List<List<String>> vids = new ArrayList<>();
        vids.add(Arrays.asList(s1)); vids.add(Arrays.asList(s2)); vids.add(Arrays.asList(s3)); vids.add(Arrays.asList(s4));
        int[][] friends = {{1, 2}, {0, 3}, {0, 3}, {1, 2}};
        List<String> result = watchedVideosByFriends(vids, friends, 0, 2);
        System.out.println(result);
    }

}
