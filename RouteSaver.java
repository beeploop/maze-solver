import java.io.File;
import java.io.FileWriter;

public class RouteSaver {
    PosStack route = new PosStack();

    RouteSaver(PosStack route) {
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

            while (route.size > 0) {
                Node value = route.pop();
                writer.write("(" + value.xData + "," + value.yData + ")\n");
            }

            writer.close();
            System.out.println("Done saving route");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
