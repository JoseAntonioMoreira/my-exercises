public class Main {
    public static void main(String[] args) {
        Machine<Integer> machineInt = new Machine<>();

        System.out.println(machineInt.execute((n1) -> n1 + 2, 10));

        System.out.println(machineInt.execute((n1, n2) -> n1 + n2, 10, 20));

        Machine<String> machineString = new Machine<>();

        System.out.println(machineString.execute((n1) -> n1 + 2, "10"));

        System.out.println(machineString.execute((n1, n2) -> n1 + n2, "Hell", "o"));

    }
}
