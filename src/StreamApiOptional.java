import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiOptional {
    public static void main(String[] args) {
        System.out.println("Задача №1");
        Stream<Integer> stream = Stream.of(5,7,6,8,2,3,1,0,9);

        findMinMax(stream, Comparator.naturalOrder(),
                (x, y) -> System.out.println("Мин: "+ x + " Макс: "+ y));

        stream.close();

        System.out.println("============================");
        System.out.println("Задача №1");
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));

        System.out.println("Количество четных чисел: " + evenNumber(list));
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static int evenNumber(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(s -> s % 2 == 0).count();
    }
}