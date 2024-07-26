import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        // 정답
        List<Integer> answer = new ArrayList<>();
        
        // map으로 장르의 총 합 기록하기
        Map<String, Integer> sum = new HashMap<>();
        Map<String, List<int[]>> songs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
            if (!songs.containsKey(genres[i])) songs.put(genres[i], new ArrayList<>());
            songs.get(genres[i]).add(new int[]{plays[i], i});
        }
        
        System.out.println(songs);
        
        // 재생 순으로 내림차순 정렬
        List<String> keySet = new ArrayList<>(sum.keySet());
        
        // 곡 재생 순 내림차순 정렬
        
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(sum.get(s2), sum.get(s1));
            }
        });
        
        // 두개 씩 선택하여 저장
        for (String g : keySet) {
            List<int[]> song = songs.get(g);
            song.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] i1, int[] i2) {
                    return Integer.compare(i2[0], i1[0]);
                }
            });
            
            answer.add(song.get(0)[1]);
            if (song.size() >= 2)
                answer.add(song.get(1)[1]);
        }
        return answer;
    }
}