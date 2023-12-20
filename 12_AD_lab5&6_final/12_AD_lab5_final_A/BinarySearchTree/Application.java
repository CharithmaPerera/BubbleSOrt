import java.util.Iterator;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.TreeMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();
        
        //String text = "A confrontation between Robert Jordan and Pablo ensues later that night, when Pablo announces that he won't let Robert Jordan blow up the bridge because he wants to play it safe. Unfortunately for Pablo, however, Pilar has other ideas, and when she declares that she's for the operation, everyone else falls in with her. Pablo's no longer in charge. Later that night, Robert Jordan, who's sleeping outside, is awakened by Maria. They sleep together.";
        String filepath = "read.txt";
String text = "";

        try {
            text = new String(Files.readAllBytes(Paths.get(filepath)));
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        String[] words = text.toLowerCase().replaceAll("\\p{Punct}", "").split("\\s+");

        for (String word : words) {
            if (bst.get(word) == null) {
                bst.put(word, 1);
            } else {
                int frequency = bst.get(word);
                bst.put(word, frequency + 1);
            }
        }
    try (FileWriter writer = new FileWriter("Index.txt")){
            Iterator<String> iterator = bst.iterator();
            writer.write("Word    |    Frequency |    Depth \n");
            writer.write("----------------------------------\n");
            while (iterator.hasNext()) {
                String word = iterator.next();
                int frequency = bst.get(word);
                //bst.depth = depth;
                int depth = bst.getNodeDepth(word);
                
                writer.write(String.format("%-20s| %-10s |%-10s%n", word, frequency,depth));
            }
             TreeMap<Integer, Integer> histogram = bst.depthHistogram();
            writer.write("\nNode Depth Histogram:\n");
            writer.write("Depth |  Count |     \n");
            writer.write("---------------\n");
            for (Map.Entry<Integer, Integer> entry : histogram.entrySet()) {     
            writer.write(String.format("  %-2s------>  %-5s%n",entry.getKey(),entry.getValue()));
                //writer.write("Depth: " + entry.getKey() + ", : " + entry.getValue() + "\n");
            }
        }catch (IOException e) {
            System.out.println("Erro");
        }
}
}