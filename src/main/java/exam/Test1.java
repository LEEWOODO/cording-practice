package exam;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(solution("123-123-123"));
    }

    private static boolean solution(String S) {
        // 길이가 11이 아니면 무조건 false
        if(S.length() != 11) return false;

        // "-" 기준으로 나누기
        String[] parts = S.split("-");

        // 정확히 세 파트가 있어야 함
        if (parts.length != 3) return false;

        for (String part : parts) {
            // 각 파트는 길이 3이어야 하고 숫자만 포함해야 함
            if (part.length() != 3 || !part.matches("\\d{3}")) {
                return false;
            }
        }

        return true;
    }
}
