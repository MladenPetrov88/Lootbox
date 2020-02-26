import java.util.*;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondBox = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        List<Integer> claimedItems = new ArrayList<>();


        for (Integer box : firstBox) {
            queue.offer(box);
        }

        for (Integer box : secondBox) {
            stack.push(box);
        }

        while (!queue.isEmpty() && !stack.isEmpty()) {
            int firstItem = queue.peek();
            int lastItem = stack.peek();
            int sum = firstItem + lastItem;

            if (sum % 2 == 0) {
                claimedItems.add(sum);
                queue.poll();
                stack.pop();
            } else {
                Integer integer = stack.removeFirst();
                queue.addLast(integer);
            }

        }

        if (queue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }

        if (stack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        int sum = 0;

        for (int i = 0; i < claimedItems.size(); i++) {
            sum += claimedItems.get(i);
        }

        if (sum >= 100) {
            System.out.println("Your loot was epic! Value: " + sum);
        } else {
            System.out.println("Your loot was poor... Value: " + sum);
        }

    }
}
