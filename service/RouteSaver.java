package service;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Node;

public class RouteSaver {
    ArrayList<Node> route;

    public RouteSaver(ArrayList<Node> route) {
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

            for (int i = 0; i < route.size(); i++) {
                Node value = route.get(i);
                writer.write("(" + value.getX() + "," + value.getY() + ")\n");
            }

            writer.close();
            System.out.println("Done saving route");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
