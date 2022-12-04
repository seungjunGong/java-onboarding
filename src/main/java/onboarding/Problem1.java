package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        if (checkWrongInput(pobi) || checkWrongInput(crong)) {
            answer = -1;
            return answer;
        }

        int max_pobi = pageComparison(pobi.get(0), pobi.get(1));
        int max_crong = pageComparison(crong.get(0), crong.get(1));

        answer = gameResult(max_pobi, max_crong);
        return answer;
    }

    private static int gameResult (int pobi, int crong) {
        if (pobi > crong){
            return 1;
        } else if (pobi == crong) {
            return 0;
        }
        return 2;
    }


    private static int pageComparison(int leftPage, int rightPage) {
        int max_add = Math.max(addNumber(leftPage), addNumber(rightPage));
        int max_multiple = Math.max(multipleNumber(leftPage), multipleNumber(rightPage));

        return Math.max(max_add, max_multiple);
    }

    private static int multipleNumber(int page) {
        int sum = 1;

        while (page != 0) {
            sum *= page % 10;
            page /= 10;
        }

        return sum;
    }

    private static int addNumber(int page) {
        int sum = 0;

        while (page != 0) {
            sum += page % 10;
            page /= 10;
        }

        return sum;
    }

    private static Boolean checkWrongInput(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        // 시작 페이지 확인
        if (checkWrongStartPage(leftPage, rightPage)) return true;
        // 연속되는 페이지 확인
        return checkNonContinuousPage(leftPage, rightPage);
    }

    private static Boolean checkWrongStartPage(int leftPage, int rightPage) {
        // 상수로 변경
        if (leftPage < 2) return true;
        return rightPage > 399;
    }

    private static Boolean checkNonContinuousPage(int leftPage, int rightPage) {
        return leftPage + 1 != rightPage;
    }
}