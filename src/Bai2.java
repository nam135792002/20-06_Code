import java.util.*;

public class Bai2 {

    public static List<String> returnLinkedListSorted(List<String> listString){
        // dùng thuật toán nổi bọt để so sánh
        for(int i = 0; i < listString.size() - 1; i++){
            for(int j = i + 1; j < listString.size(); j++){
                int value = listString.get(i).compareToIgnoreCase(listString.get(j));
                // hoán đổi 2 vi trí chuỗi cho nhau.
                if(value > 0){
                    String temp = listString.get(i);
                    listString.set(i, listString.get(j));
                    listString.set(j, temp);
                }
            }
        }
        return listString;
    }

    public static void main(String[] args) {
        // Khai báo List để chứa chuỗi
        List<String> listString = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true){
            // Nhập chuỗi cho mảng, Nhấn N hoặc n để kết thúc việc nhập
            System.out.print("Enter the string into list.(Enter \"N\" or \"n\" to stop entering): ");
            String input = sc.nextLine();

            // nếu input nhận vào là n hoặc là N thì dừng việc nhập
            if(input.equals("N") || input.equals("n")) break;

            // add chuỗi vào trong mảng
            listString.add(input);
        }

        // Cách 1: gọi hàm sort() của Collection để sắp xếp mảng chuỗi.
//        Collections.sort(listString);

        // Cách 2: tự xây dựng hàm riêng.
        List<String> outputString = returnLinkedListSorted(listString);
        // in ra các phần tử trong mảng sau khi sắp xếp
        System.out.print("List after sort: ");
        for (String s : listString){
            System.out.print(s + " ");
        }

    }
}
