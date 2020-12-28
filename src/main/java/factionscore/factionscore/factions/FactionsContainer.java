package factionscore.factionscore.factions;

import com.google.gson.Gson;
import org.bukkit.Bukkit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FactionsContainer {
    public static List<Faction> getFactions() {
        return serverFactions;
    }

    public static void loadFactions() {
        File factionFolder = new File("factions/");
        File[] filesInDir = factionFolder.listFiles();
        List<String> factionPaths = new ArrayList<>();

        /* Iterate through faction dir content, remove subdirs and file endings. */
        if (filesInDir == null) {
            Bukkit.getLogger().info("No factions to load found.");
            return;
        }
        for (File file : filesInDir) {
            if (file.isFile()) {
                String fileName = file.getName();
                Bukkit.getLogger().info("Faction file name: " + file.getName());
                String[] splitFileName = fileName.split("\\.");
                if (splitFileName[1].equalsIgnoreCase("json")) {
                    Bukkit.getLogger().info("Resolved faction file name: " + file.getName());
                    factionPaths.add(fileName);
                } else {
                    Bukkit.getLogger().info("splitFileName[0]: " + splitFileName[0]);
                    Bukkit.getLogger().info("splitFileName[0]: " + splitFileName[1]);
                }
            }
        }

        BufferedReader reader;
        Gson gsonInstance = new Gson();
        for (String s : factionPaths) {
            try {
                reader = new BufferedReader(new FileReader("factions/" + s));
            } catch (FileNotFoundException e) {
                Bukkit.getLogger().info("Could not open faction file: " + s);
                return;
            }
            Faction f = gsonInstance.fromJson(reader, Faction.class);
            Bukkit.getLogger().info("Registered faction: " + f.getFactionName());
            serverFactions.add(f);
        }
    }

    public static void unloadFactions() {
        Gson gsonInstance = new Gson();
        FileWriter writer;
        String filePath = "";

        /* Check if directory exists, if not create it. */
        String directoryName = "factions/";
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }

        /* Convert Faction Instances to a JSON string and save them. */
        for (Faction f : serverFactions) {
            String factionAsJsonString = gsonInstance.toJson(f);
            try {
                filePath = "factions/" + f.getFactionName() + ".json";
                writer = new FileWriter(filePath);
            } catch (IOException e) {
                Bukkit.getLogger().info("Could not save faction: " + f.getFactionName());
                Bukkit.getLogger().info("There was an I/O Exception opening: " + filePath);
                return;
            }
            try {
                writer.write(factionAsJsonString);
            } catch (IOException e) {
                Bukkit.getLogger().info("Could not save faction: " + f.getFactionName());
                Bukkit.getLogger().info("There was an I/O Exception writing: " + filePath);
                return;
            }
            try {
                writer.close();
            } catch (IOException e) {
                Bukkit.getLogger().info("Could not save faction: " + f.getFactionName());
                Bukkit.getLogger().info("There was an I/O Exception closing: " + filePath);
                return;
            }
        }
    }

    public static List<Faction> serverFactions = new ArrayList<>();
}
