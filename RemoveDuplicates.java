public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(removeDuplicates(str));
    }
    public static String removeDuplicates(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    break;
                }
            }
            if (j == i) {
                arr[index++] = arr[i];
            }
        }
        return new String(arr, 0, index);
    }
}
