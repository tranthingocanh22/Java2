import java.util.ArrayList;
import java.util.List;

public class RemoveElementsFromArrayListExample {
    public static void main(String[] args) {
        List<String> programmingLanguages = new ArrayList<>();
        programmingLanguages.add("C");
        programmingLanguages.add("C++");
        programmingLanguages.add("Java");
        programmingLanguages.add("Kotlin");
        programmingLanguages.add("Python");
        programmingLanguages.add("Rerl");
        programmingLanguages.add("Ruby");

        System.out.println("Initial List: " + programmingLanguages);

        programmingLanguages.remove(5);
        System.out.println("After remove(5): " + programmingLanguages);

        boolean isRemoved = programmingLanguages.remove("Kotlin");
        System.out.println("After remove (\"Kotlin\"): " + programmingLanguages);

        List<String> sciptingLanguages = new ArrayList<>();
        sciptingLanguages.add("Python");
        sciptingLanguages.add("Ruby");
        sciptingLanguages.add("Perl");

        programmingLanguages.removeAll(sciptingLanguages);
        System.out.println("After removeAll(scriptingLanguages): "+ programmingLanguages);

        programmingLanguages.removeIf(n -> (n.charAt(0) == 'T'));

        programmingLanguages.removeIf(s -> s.startsWith("C"));
        System.out.println("After Removing all elements that start with \"C\": " + programmingLanguages);

        programmingLanguages.clear();
        System.out.println("After clear(): " + programmingLanguages);
    }
}
