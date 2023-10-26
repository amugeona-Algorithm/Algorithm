package 지환.week.w14;

import java.util.*;
import java.util.stream.Collectors;

class PRO_72411 {
    public String[] solution(String[] orders, int[] course) {
        List<Set<String>> orderList = Arrays.stream(orders)
                .map(String::chars)
                .map(charStream -> charStream.mapToObj(menu -> String.valueOf((char) menu)).collect(Collectors.toSet()))
                .collect(Collectors.toList());

        Map<Integer, List<Course>> courses = new HashMap<>();
        for (int length : course) {
            List<Course> list = new ArrayList<>();
            list.add(new Course("", 0));
            courses.put(length, list);
        }
        getCourses('A', new HashSet<>(), orderList, courses);
        return courses.values().stream()
                .filter(list -> list.get(0).occurrences > 0)
                .flatMap(List::stream)
                .map(c -> c.course)
                .sorted()
                .toArray(String[]::new);

    }

    //재
    private void getCourses(char nextMenu, Set<String> selectedMenus,
                            List<Set<String>> orderList,
                            Map<Integer, List<Course>> courses) {
        // 주문 중 현재까지 구한 메뉴 조합의 등장 횟수 확인.
        int occurrences = (int) orderList.stream()
                .filter(order -> order.containsAll(selectedMenus))
                .count();
        //등장 횟수가 2 미만인 경우 리턴
        if (occurrences < 2) return;

        int size = selectedMenus.size();

        //코스중 해당 크키만큼의 코스가 있으면
        if (courses.containsKey(size)) {
            //그 코스 꺼내서
            List<Course> courseList = courses.get(size);
            //코스 생성
            Course course = new Course(selectedMenus.stream()
                    .sorted()
                    .collect(Collectors.joining("")),
                    occurrences);

            Course original = courseList.get(0);


            // 기존 것 보다 중복 횟수가 더 많으면 초기화하고 추가
            if (original.occurrences < occurrences) {
                courseList.clear();
                courseList.add(course);
            } // 같은 경우  그냥 추가
            else if (original.occurrences == occurrences) {
                courseList.add(course);
            }
        }

        //메뉴가 10개 이상이면 끝
        if (size >= 10) return;

        for (char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
            String menu = String.valueOf(menuChar);
            selectedMenus.add(menu);
            getCourses((char) (menuChar + 1), selectedMenus, orderList, courses);
            selectedMenus.remove(menu);
        }
    }

    private static class Course {
        public final String course;
        public final int occurrences;

        public Course(String course, int occurrences) {
            this.course = course;
            this.occurrences = occurrences;
        }

    }

}