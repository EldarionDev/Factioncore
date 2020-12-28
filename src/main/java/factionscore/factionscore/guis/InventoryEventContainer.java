package factionscore.factionscore.guis;

import java.util.ArrayList;

public class InventoryEventContainer {
    public static void registerHandler(EldarionGuiEvent eventHandler) {
        events.add(eventHandler);
    }

    public static ArrayList<EldarionGuiEvent> getHandlers() {
        return events;
    }

    private static ArrayList<EldarionGuiEvent> events = new ArrayList<EldarionGuiEvent>();
}
