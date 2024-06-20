import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Bai1 {

    // Cách 1: dùng 2 vòng lặp for
    public static String firstNonRepeatCharacterByLoop(String input){
        // for 1: duyệt ký tự đầu tiên đến ký tự cuối của String.
        for(int i = 0; i < input.length(); i++){
            // đặt biến cờ là true
            boolean flag = true;
            // for 2: duyệt ký tự tiếp theo của input[i] đến cuối chuỗi
            for(int j = i + 1; j < input.length(); j++){
                // so sánh 2 ký tự liền kề nhau, nếu giống nhau thì có trùng lặp va thoát khỏi vòng lặp này
                // và tiếp tục duyệt ký tự tiếp theo.
                if(input.charAt(i) == input.charAt(j)){
                    flag = false;
                    break;
                }
            }
            // nếu biến flag là true tức là ko có ký tự trùng lặp thì lập tức trả về
            if(flag) return String.valueOf(input.charAt(i));
        }
        // ngược lại ko có ký tự mà ko có sự trung lặp thì trả về null.
        return null;
    }

    // cách 2: dùng HashMap
    public static String firstNonRepeatCharacterByHashMap(String input){
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put(input.charAt(0), 0);

        for(int i = 1; i < input.length(); i++){
            if(map.containsKey(input.charAt(i))){
                Integer value = map.get(input.charAt(i));
                map.replace(input.charAt(i), ++value);
            }else{
                map.put(input.charAt(i), 0);

            }
        }

        for(Character key : map.keySet()){
            if(map.get(key) == 0){
                return String.valueOf(key);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("The given string is: ");
        String input = sc.nextLine();

//        String output = firstNonRepeatCharacterByLoop(input); // cách 1
        String output = firstNonRepeatCharacterByHashMap(input); // cách 2
        if(output != null){
            System.out.println("The first none repeated character in string is: " + output);
        }else{
            System.out.println("Not found the first none repeated character in this string");
        }


    }
}
