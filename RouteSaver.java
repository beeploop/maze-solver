import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Stack;

public class RouteSaver {
    Stack<Node> route = new Stack<Node>();

    RouteSaver(Stack<Node> route) {
        this.route = route;
    }

    public void saveRoute() {
        try {
            File file = new File("route.txt");
            file.delete();
            if (!file.createNewFile()) {
                System.out.println("File already exists!");
                System.out.println("aborting...");
                return;
            }

            FileWriter writer = new FileWriter(file);

            Iterator<Node> pos = route.iterator();

            while (pos.hasNext()) {
                Node value = pos.next();

                writer.write("(" + value.xData + "," + value.yData + ")\n");
            }

            writer.close();
            System.out.println("Done saving route");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
