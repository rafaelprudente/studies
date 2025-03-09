package pt.com;

public class Main {
    public static void main(String[] args) {
        System.out.println("Longest common prefix: " + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    private static String longestCommonPrefix(String[] strings) {
        String response = "";

        if (strings == null || strings.length == 0) {
            return response;
        }

        response = strings[0];
        for (String string : strings) {
            while (string.indexOf(response) != 0) {
                response = response.substring(0, response.length() - 1);
                if (response.isEmpty()) {
                    response = "";
                    break;
                }
            }
        }

        return response;
    }
}