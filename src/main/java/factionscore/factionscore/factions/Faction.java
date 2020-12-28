package factionscore.factionscore.factions;

import factionscore.factionscore.KeyContainer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Faction {
    public void setFactionName (String factionName) {
        this.name = factionName;
    }

    public String getFactionName () {
        return name;
    }

    public void setLeader (UUID playerUUID) {
        if (Bukkit.getPlayer(this.leader) != null) {
            Bukkit.getPlayer(this.leader).getPersistentDataContainer().set(KeyContainer.getPlayerTypeKey(), PersistentDataType.STRING, "Member");
        }
        Bukkit.getPlayer(playerUUID).getPersistentDataContainer().set(KeyContainer.getPlayerTypeKey(), PersistentDataType.STRING, "Owner");
        this.leader = playerUUID;
    }

    public UUID getLeader () {
        return leader;
    }

    public void setAggression (int value) {
        this.aggression = value;
    }

    public int getAggression () {
        return aggression;
    }

    public void setTrustworthy (int value) {
        this.trustworthy = value;
    }

    public int getTrustworthy () {
        return trustworthy;
    }

    public void setLoyalty (int value) {
        this.loyalty = value;
    }

    public int getLoyalty () {
        return loyalty;
    }

    public void setTreasury (int value) {
        this.treasury = value;
    }

    public int getTreasury () {
        return treasury;
    }

    public void addRequest (UUID playerUUID) {
        requestList.add(playerUUID);
    }

    public boolean hasRequest (UUID playerUUID) {
        return requestList.contains(playerUUID);
    }

    public void setRequests (List<UUID> requests) {
        this.requestList = requests;
    }

    public List<UUID> getRequests () {
        return requestList;
    }

    public void removeRequest (UUID playerUUID) {
        requestList.remove(playerUUID);
    }

    public void addProposal (UUID playerUUID, String text) {
        proposalList.put(playerUUID, text);
    }

    public boolean hasProposal (UUID playerUUID) {
        return proposalList.get(playerUUID) != null;
    }

    public String getProposal (UUID playerUUID) {
        return proposalList.get(playerUUID);
    }

    public HashMap<UUID, String> getProposals () {
        return proposalList;
    }

    public void setProposals (HashMap<UUID, String> proposals) {
        this.proposalList = proposals;
    }

    public void removeProposal (UUID playerUUID) {
        proposalList.remove(playerUUID);
    }

    public void addMember (UUID playerUUID) {
        Player player = Bukkit.getPlayer(playerUUID);
        if (player == null) {
            Bukkit.getLogger().info("Could not find player with UUID: " + playerUUID + "to add to faction!");
            return;
        }
        if (KeyContainer.getFactionKey() == null) {
            Bukkit.getLogger().info("Key is null! Critical error!");
            return;
        }
        player.getPersistentDataContainer().set(KeyContainer.getFactionKey(), PersistentDataType.STRING, name);
        player.getPersistentDataContainer().set(KeyContainer.getPlayerTypeKey(), PersistentDataType.STRING, "Member");
        memberList.add(playerUUID);
    }

    public boolean hasMember (UUID playerUUID) {
        return memberList.contains(playerUUID);
    }

    public List<UUID> getMembers () {
        return memberList;
    }

    public void setMembers (List<UUID> members) {
        this.memberList = members;
    }

    public void removeMember (UUID memberUUID) {
        Player player = Bukkit.getPlayer(memberUUID);
        if (player == null) {
            Bukkit.getLogger().info("Could not find player with UUID: " + memberUUID + "to remove from a faction!");
            return;
        }
        player.getPersistentDataContainer().set(KeyContainer.getFactionKey(), PersistentDataType.STRING, "");
        player.getPersistentDataContainer().set(KeyContainer.getPlayerTypeKey(), PersistentDataType.STRING, "Player");
        this.memberList.remove(memberUUID);
    }

    public void addTradeRequest (String tradeName) {

    }

    public List<String> getPendingTrades () {
        return pendingTrades;
    }

    public void setPendingTrades (List<String> names) {
        this.pendingTrades = names;
    }

    public boolean removeTradeRequest (String tradeName) {
        return pendingTrades.removeIf(s -> s.equals(tradeName));
    }

    private String name;

    private UUID leader;
    private int trustworthy;
    private int aggression;
    private int loyalty;
    private int treasury;

    private List<UUID> memberList = new ArrayList<>();
    private List<UUID> requestList = new ArrayList<>();
    private List<String> pendingTrades = new ArrayList<>();

    private HashMap<UUID, String> proposalList = new HashMap<>();
}
