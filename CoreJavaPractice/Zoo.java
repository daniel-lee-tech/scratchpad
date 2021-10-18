public class Zoo {
    public static void main(String... args) {
        System.out.println(args.length);
        for (var item: args) {
            System.out.println(item);
        }
    }
}