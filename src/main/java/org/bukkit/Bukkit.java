package org.bukkit;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.Warning.WarningState;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.Recipe;
import org.bukkit.map.MapView;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import com.avaje.ebean.config.ServerConfig;
import org.bukkit.inventory.ItemFactory;

/**
 * Represents the Bukkit core, for version and Server singleton handling
 */
public final class Bukkit {
    private static Server server;

    /**
     * Static class cannot be initialized.
     */
    private Bukkit() {}

    /**
     * Gets the current {@link Server} singleton
     *
     * @return Server instance being ran
     */
    public static Server getServer() {
        return server;
    }

    /**
     * Attempts to set the {@link Server} singleton.
     * <p>
     * This cannot be done if the Server is already set.
     *
     * @param server Server instance
     */
    public static void setServer(Server server) {
        if (Bukkit.server != null) {
            throw new UnsupportedOperationException("Cannot redefine singleton Server");
        }

        Bukkit.server = server;
        server.getLogger().info("This server is running " + getName() + " version " + getVersion() + " (Implementing API version " + getBukkitVersion() + ")");
    }

    /**
     * @return {@link Server#getName() delegates}
     * @see Server#getName()
     */
    public static String getName() {
        return server.getName();
    }

    /**
     * @return {@link Server#getVersion() delegates}
     * @see Server#getVersion()
     */
    public static String getVersion() {
        return server.getVersion();
    }

    /**
     * @return {@link Server#getBukkitVersion() delegates}
     * @see Server#getBukkitVersion()
     */
    public static String getBukkitVersion() {
        return server.getBukkitVersion();
    }

    /**
     * @return {@link Server#getOnlinePlayers() delegates}
     * @see Server#getOnlinePlayers()
     */
    public static Player[] getOnlinePlayers() {
        return server.getOnlinePlayers();
    }

    /**
     * @return {@link Server#getMaxPlayers() delegates}
     * @see Server#getMaxPlayers()
     */
    public static int getMaxPlayers() {
        return server.getMaxPlayers();
    }

    /**
     * @return {@link Server#getPort() delegates}
     * @see Server#getPort()
     */
    public static int getPort() {
        return server.getPort();
    }

    /**
     * @return {@link Server#getViewDistance() delegates}
     * @see Server#getViewDistance()
     */
    public static int getViewDistance() {
        return server.getViewDistance();
    }

    /**
     * @return {@link Server#getIp() delegates}
     * @see Server#getIp()
     */
    public static String getIp() {
        return server.getIp();
    }

    /**
     * @return {@link Server#getServerName() delegates}
     * @see Server#getServerName()
     */
    public static String getServerName() {
        return server.getServerName();
    }

    /**
     * @return {@link Server#getServerId() delegates}
     * @see Server#getServerId()
     */
    public static String getServerId() {
        return server.getServerId();
    }

    /**
     * @return {@link Server#getWorldType() delegates}
     * @see Server#getWorldType()
     */
    public static String getWorldType() {
        return server.getWorldType();
    }

    /**
     * @return {@link Server#getGenerateStructures() delegates}
     * @see Server#getGenerateStructures()
     */
    public static boolean getGenerateStructures() {
        return server.getGenerateStructures();
    }

    /**
     * @return {@link Server#getAllowNether() delegates}
     * @see Server#getAllowNether()
     */
    public static boolean getAllowNether() {
        return server.getAllowNether();
    }

    /**
     * @return {@link Server#hasWhitelist() delegates}
     * @see Server#hasWhitelist()
     */
    public static boolean hasWhitelist() {
        return server.hasWhitelist();
    }

    /**
     * @param message {@link Server#broadcastMessage(String message) delegates}
     * @return {@link Server#broadcastMessage(String message) delegates}
     * @see Server#broadcastMessage(String message)
     */
    public static int broadcastMessage(String message) {
        return server.broadcastMessage(message);
    }

    /**
     * @return {@link Server#getUpdateFolder() delegates}
     * @see Server#getUpdateFolder()
     */
    public static String getUpdateFolder() {
        return server.getUpdateFolder();
    }

    /**
     * @param name {@link Server#getPlayer(String name) delegates}
     * @return {@link Server#getPlayer(String name) delegates}
     * @see Server#getPlayer(String name)
     */
    public static Player getPlayer(String name) {
        return server.getPlayer(name);
    }

    /**
     * @param name {@link Server#matchPlayer(String name) delegates}
     * @return {@link Server#matchPlayer(String name) delegates}
     * @see Server#matchPlayer(String name)
     */
    public static List<Player> matchPlayer(String name) {
        return server.matchPlayer(name);
    }

    /**
     * @return {@link Server#getPluginManager() delegates}
     * @see Server#getPluginManager()
     */
    public static PluginManager getPluginManager() {
        return server.getPluginManager();
    }

    /**
     * @return {@link Server#getScheduler() delegates}
     * @see Server#getScheduler()
     */
    public static BukkitScheduler getScheduler() {
        return server.getScheduler();
    }

    /**
     * @return {@link Server#getServicesManager() delegates}
     * @see Server#getServicesManager()
     */
    public static ServicesManager getServicesManager() {
        return server.getServicesManager();
    }

    /**
     * @return {@link Server#getWorlds() delegates}
     * @see Server#getWorlds()
     */
    public static List<World> getWorlds() {
        return server.getWorlds();
    }

    /**
     * @param options {@link Server#createWorld(WorldCreator options) delegates}
     * @return {@link Server#createWorld(WorldCreator options) delegates}
     * @see Server#createWorld(WorldCreator options)
     */
    public static World createWorld(WorldCreator options) {
        return server.createWorld(options);
    }

    /**
     * @param name {@link Server#unloadWorld(String name, boolean save)
     *     delegates}
     * @param save {@link Server#unloadWorld(String name, boolean save)
     *     delegates}
     * @return {@link Server#unloadWorld(String name, boolean save) delegates}
     * @see Server#unloadWorld(String name, boolean save)
     */
    public static boolean unloadWorld(String name, boolean save) {
        return server.unloadWorld(name, save);
    }

    /**
     * @param world {@link Server#unloadWorld(World world, boolean save)
     *     delegates}
     * @param save {@link Server#unloadWorld(World world, boolean save)
     *     delegates}
     * @return {@link Server#unloadWorld(World world, boolean save) delegates}
     * @see Server#unloadWorld(World world, boolean save)
     */
    public static boolean unloadWorld(World world, boolean save) {
        return server.unloadWorld(world, save);
    }

    /**
     * @param name {@link Server#getWorld(String name) delegates}
     * @return {@link Server#getWorld(String name) delegates}
     * @see Server#getWorld(String name)
     */
    public static World getWorld(String name) {
        return server.getWorld(name);
    }

    /**
     * @param uid {@link Server#getWorld(UUID uid) delegates}
     * @return {@link Server#getWorld(UUID uid) delegates}
     * @see Server#getWorld(UUID uid)
     */
    public static World getWorld(UUID uid) {
        return server.getWorld(uid);
    }

    /**
     * @param id {@link Server#getMap(short id) delegates}
     * @return {@link Server#getMap(short id) delegates}
     * @see Server#getMap(short id)
     * @deprecated Magic value
     */
    @Deprecated
    public static MapView getMap(short id) {
        return server.getMap(id);
    }

    /**
     * @param world {@link Server#createMap(World world) delegates}
     * @return {@link Server#createMap(World world) delegates}
     * @see Server#createMap(World world)
     */
    public static MapView createMap(World world) {
        return server.createMap(world);
    }

    /**
     * @see Server#reload()
     */
    public static void reload() {
        server.reload();
    }

    /**
     * @return {@link Server#getLogger() delegates}
     * @see Server#getLogger()
     */
    public static Logger getLogger() {
        return server.getLogger();
    }

    /**
     * @param name {@link Server#getPluginCommand(String name) delegates}
     * @return {@link Server#getPluginCommand(String name) delegates}
     * @see Server#getPluginCommand(String name)
     */
    public static PluginCommand getPluginCommand(String name) {
        return server.getPluginCommand(name);
    }

    /**
     * @see Server#savePlayers()
     */
    public static void savePlayers() {
        server.savePlayers();
    }

    /**
     * @param sender {@link Server#dispatchCommand(CommandSender sender, String
     *     commandLine) delegates}
     * @param commandLine {@link Server#dispatchCommand(CommandSender sender,
     *     String commandLine) delegates}
     * @return {@link Server#dispatchCommand(CommandSender sender, String
     *     commandLine) delegates}
     * @see Server#dispatchCommand(CommandSender sender, String commandLine)
     */
    public static boolean dispatchCommand(CommandSender sender, String commandLine) {
        return server.dispatchCommand(sender, commandLine);
    }

    /**
     * @param config {@link Server#configureDbConfig(ServerConfig config)
     *     delegates}
     * @see Server#configureDbConfig(ServerConfig config)
     */
    public static void configureDbConfig(ServerConfig config) {
        server.configureDbConfig(config);
    }

    /**
     * @param recipe {@link Server#addRecipe(Recipe recipe) delegates}
     * @return {@link Server#addRecipe(Recipe recipe) delegates}
     * @see Server#addRecipe(Recipe recipe)
     */
    public static boolean addRecipe(Recipe recipe) {
        return server.addRecipe(recipe);
    }

    /**
     * @param result {@link Server#getRecipesFor(ItemStack result) delegates}
     * @return {@link Server#getRecipesFor(ItemStack result) delegates}
     * @see Server#getRecipesFor(ItemStack result)
     */
    public static List<Recipe> getRecipesFor(ItemStack result) {
        return server.getRecipesFor(result);
    }

    /**
     * @return {@link Server#recipeIterator() delegates}
     * @see Server#recipeIterator()
     */
    public static Iterator<Recipe> recipeIterator() {
        return server.recipeIterator();
    }

    /**
     * @see Server#clearRecipes()
     */
    public static void clearRecipes() {
        server.clearRecipes();
    }

    /**
     * @see Server#resetRecipes()
     */
    public static void resetRecipes() {
        server.resetRecipes();
    }

    /**
     * @return {@link Server#getCommandAliases() delegates}
     * @see Server#getCommandAliases()
     */
    public static Map<String, String[]> getCommandAliases() {
        return server.getCommandAliases();
    }

    /**
     * @return {@link Server#getSpawnRadius() delegates}
     * @see Server#getSpawnRadius()
     */
    public static int getSpawnRadius() {
        return server.getSpawnRadius();
    }

    /**
     * @param value {@link Server#setSpawnRadius(int value) delegates}
     * @see Server#setSpawnRadius(int value)
     */
    public static void setSpawnRadius(int value) {
        server.setSpawnRadius(value);
    }

    /**
     * @return {@link Server#getOnlineMode() delegates}
     * @see Server#getOnlineMode()
     */
    public static boolean getOnlineMode() {
        return server.getOnlineMode();
    }

    /**
     * @return {@link Server#getAllowFlight() delegates}
     * @see Server#getAllowFlight()
     */
    public static boolean getAllowFlight() {
        return server.getAllowFlight();
    }

    /**
     * @return {@link Server#isHardcore() delegates}
     * @see Server#isHardcore()
     */
    public static boolean isHardcore() {
        return server.isHardcore();
    }

    /**
     * @see Server#shutdown()
     */
    public static void shutdown() {
        server.shutdown();
    }

    /**
     * @param message {@link Server#broadcast(String message, String permission)
     *     delegates}
     * @param permission {@link Server#broadcast(String message, String
     *     permission) delegates}
     * @return {@link Server#broadcast(String message, String permission)
     *     delegates}
     * @see Server#broadcast(String message, String permission)
     */
    public static int broadcast(String message, String permission) {
        return server.broadcast(message, permission);
    }

    /**
     * @param name {@link Server#getOfflinePlayer(String name) delegates}
     * @return {@link Server#getOfflinePlayer(String name) delegates}
     * @see Server#getOfflinePlayer(String name)
     */
    public static OfflinePlayer getOfflinePlayer(String name) {
        return server.getOfflinePlayer(name);
    }

    /**
     * @param name {@link Server#getPlayerExact(String name) delegates}
     * @return {@link Server#getPlayerExact(String name) delegates}
     * @see Server#getPlayerExact(String name)
     */
    public static Player getPlayerExact(String name) {
        return server.getPlayerExact(name);
    }

    /**
     * @return {@link Server#getIPBans() delegates}
     * @see Server#getIPBans()
     */
    public static Set<String> getIPBans() {
        return server.getIPBans();
    }

    /**
     * @param address {@link Server#banIP(String address) delegates}
     * @see Server#banIP(String address)
     */
    public static void banIP(String address) {
        server.banIP(address);
    }

    /**
     * @param address {@link Server#unbanIP(String address) delegates}
     * @see Server#unbanIP(String address)
     */
    public static void unbanIP(String address) {
        server.unbanIP(address);
    }

    /**
     * @return {@link Server#getBannedPlayers() delegates}
     * @see Server#getBannedPlayers()
     */
    public static Set<OfflinePlayer> getBannedPlayers() {
        return server.getBannedPlayers();
    }

    /**
     * @param type {@link Server#getBanList(BanList.Type) delegates}
     * @return {@link Server#getBanList(BanList.Type) delegates}
     * @see Server#getBanList(BanList.Type)
     */
    public static BanList getBanList(BanList.Type type){
        return server.getBanList(type);
    }

    /**
     * @param value {@link Server#setWhitelist(boolean value) delegates}
     * @see Server#setWhitelist(boolean value)
     */
    public static void setWhitelist(boolean value) {
        server.setWhitelist(value);
    }

    /**
     * @return {@link Server#getWhitelistedPlayers() delegates}
     * @see Server#getWhitelistedPlayers()
     */
    public static Set<OfflinePlayer> getWhitelistedPlayers() {
        return server.getWhitelistedPlayers();
    }

    /**
     * @see Server#reloadWhitelist()
     */
    public static void reloadWhitelist() {
        server.reloadWhitelist();
    }

    /**
     * @return {@link Server#getConsoleSender() delegates}
     * @see Server#getConsoleSender()
     */
    public static ConsoleCommandSender getConsoleSender() {
        return server.getConsoleSender();
    }

    /**
     * @return {@link Server#getOperators() delegates}
     * @see Server#getOperators()
     */
    public static Set<OfflinePlayer> getOperators() {
        return server.getOperators();
    }

    /**
     * @return {@link Server#getWorldContainer() delegates}
     * @see Server#getWorldContainer()
     */
    public static File getWorldContainer() {
        return server.getWorldContainer();
    }

    /**
     * @return {@link Server#getMessenger() delegates}
     * @see Server#getMessenger()
     */
    public static Messenger getMessenger() {
        return server.getMessenger();
    }

    /**
     * @return {@link Server#getAllowEnd() delegates}
     * @see Server#getAllowEnd()
     */
    public static boolean getAllowEnd() {
        return server.getAllowEnd();
    }

    /**
     * @return {@link Server#getUpdateFolderFile() delegates}
     * @see Server#getUpdateFolderFile()
     */
    public static File getUpdateFolderFile() {
        return server.getUpdateFolderFile();
    }

    /**
     * @return {@link Server#getConnectionThrottle() delegates}
     * @see Server#getConnectionThrottle()
     */
    public static long getConnectionThrottle() {
        return server.getConnectionThrottle();
    }

    /**
     * @return {@link Server#getTicksPerAnimalSpawns() delegates}
     * @see Server#getTicksPerAnimalSpawns()
     */
    public static int getTicksPerAnimalSpawns() {
        return server.getTicksPerAnimalSpawns();
    }

    /**
     * @return {@link Server#getTicksPerMonsterSpawns() delegates}
     * @see Server#getTicksPerMonsterSpawns()
     */
    public static int getTicksPerMonsterSpawns() {
        return server.getTicksPerMonsterSpawns();
    }

    /**
     * @return {@link Server#useExactLoginLocation() delegates}
     * @see Server#useExactLoginLocation()
     */
    public static boolean useExactLoginLocation() {
        return server.useExactLoginLocation();
    }

    /**
     * @return {@link Server#getDefaultGameMode() delegates}
     * @see Server#getDefaultGameMode()
     */
    public static GameMode getDefaultGameMode() {
        return server.getDefaultGameMode();
    }

    /**
     * @param mode {@link Server#setDefaultGameMode(GameMode mode) delegates}
     * @see Server#setDefaultGameMode(GameMode mode)
     */
    public static void setDefaultGameMode(GameMode mode) {
        server.setDefaultGameMode(mode);
    }

    /**
     * @return {@link Server#getOfflinePlayers() delegates}
     * @see Server#getOfflinePlayers()
     */
    public static OfflinePlayer[] getOfflinePlayers() {
        return server.getOfflinePlayers();
    }

    /**
     * @param owner {@link Server#createInventory(InventoryHolder owner,
     *     InventoryType type) delegates}
     * @param type {@link Server#createInventory(InventoryHolder owner,
     *     InventoryType type) delegates}
     * @return {@link Server#createInventory(InventoryHolder owner,
     *     InventoryType type) delegates}
     * @see Server#createInventory(InventoryHolder owner, InventoryType type)
     */
    public static Inventory createInventory(InventoryHolder owner, InventoryType type) {
        return server.createInventory(owner, type);
    }

    /**
     * @param owner {@link Server#createInventory(InventoryHolder owner, int
     *     size) delegates}
     * @param size {@link Server#createInventory(InventoryHolder owner, int
     *     size) delegates}
     * @return {@link Server#createInventory(InventoryHolder owner, int size)
     *     delegates}
     * @see Server#createInventory(InventoryHolder owner, int size)
     */
    public static Inventory createInventory(InventoryHolder owner, int size) {
        return server.createInventory(owner, size);
    }

    /**
     * @param owner {@link Server#createInventory(InventoryHolder owner, int
     *     size, String title) delegates}
     * @param size {@link Server#createInventory(InventoryHolder owner, int    
     *     size, String title) delegates}
     * @param title {@link Server#createInventory(InventoryHolder owner, int
     *     size, String title) delegates}
     * @return {@link Server#createInventory(InventoryHolder owner, int size,
     *     String title) delegates}
     * @see Server#createInventory(InventoryHolder owner, int size, String
     *     title)
     */
    public static Inventory createInventory(InventoryHolder owner, int size, String title) {
        return server.createInventory(owner, size, title);
    }

    /**
     * @return {@link Server#getHelpMap() delegates}
     * @see Server#getHelpMap()
     */
    public static HelpMap getHelpMap() {
        return server.getHelpMap();
    }

    /**
     * @return {@link Server#getMonsterSpawnLimit() delegates}
     * @see Server#getMonsterSpawnLimit()
     */
    public static int getMonsterSpawnLimit() {
        return server.getMonsterSpawnLimit();
    }

    /**
     * @return {@link Server#getAnimalSpawnLimit() delegates}
     * @see Server#getAnimalSpawnLimit()
     */
    public static int getAnimalSpawnLimit() {
        return server.getAnimalSpawnLimit();
    }

    /**
     * @return {@link Server#getWaterAnimalSpawnLimit() delegates}
     * @see Server#getWaterAnimalSpawnLimit()
     */
    public static int getWaterAnimalSpawnLimit() {
        return server.getWaterAnimalSpawnLimit();
    }

    /**
     * @return {@link Server#getAmbientSpawnLimit() delegates}
     * @see Server#getAmbientSpawnLimit()
     */
    public static int getAmbientSpawnLimit() {
        return server.getAmbientSpawnLimit();
    }

    /**
     * @return {@link Server#isPrimaryThread() delegates}
     * @see Server#isPrimaryThread()
     */
    public static boolean isPrimaryThread() {
        return server.isPrimaryThread();
    }

    /**
     * @return {@link Server#getMotd() delegates}
     * @see Server#getMotd()
     */
    public static String getMotd() {
        return server.getMotd();
    }

    /**
     * @return {@link Server#getShutdownMessage() delegates}
     * @see Server#getShutdownMessage()
     */
    public static String getShutdownMessage() {
        return server.getShutdownMessage();
    }

    /**
     * @return {@link Server#getWarningState() delegates}
     * @see Server#getWarningState()
     */
    public static WarningState getWarningState() {
        return server.getWarningState();
    }

    /**
     * @return {@link Server#getItemFactory() delegates}
     * @see Server#getItemFactory()
     */
    public static ItemFactory getItemFactory() {
        return server.getItemFactory();
    }

    /**
     * @return {@link Server#getScoreboardManager() delegates}
     * @see Server#getScoreboardManager()
     */
    public static ScoreboardManager getScoreboardManager() {
        return server.getScoreboardManager();
    }

    /**
     * @return {@link Server#getServerIcon() delegates}
     * @see Server#getServerIcon()
     */
    public static CachedServerIcon getServerIcon() {
        return server.getServerIcon();
    }

    /**
     * @param file {@link Server#loadServerIcon(File) delegates}
     * @return {@link Server#loadServerIcon(File) delegates}
     * @throws Exception {@link Server#loadServerIcon(File) delegates}
     * @see Server#loadServerIcon(File)
     */
    public static CachedServerIcon loadServerIcon(File file) throws Exception {
        return server.loadServerIcon(file);
    }

    /**
     * @param image {@link Server#loadServerIcon(BufferedImage) delegates}
     * @return {@link Server#loadServerIcon(BufferedImage) delegates}
     * @throws Exception {@link Server#loadServerIcon(BufferedImage) delegates}
     * @see Server#loadServerIcon(BufferedImage)
     */
    public static CachedServerIcon loadServerIcon(BufferedImage image) throws Exception {
        return server.loadServerIcon(image);
    }

    /**
     * @param threshold {@link Server#setIdleTimeout(int) delegates}
     * @see Server#setIdleTimeout(int)
     */
    public static void setIdleTimeout(int threshold) {
        server.setIdleTimeout(threshold);
    }

    /**
     * @return {@link Server#getIdleTimeout() delegates}
     * @see Server#getIdleTimeout()
     */
    public static int getIdleTimeout() {
        return server.getIdleTimeout();
    }

    /**
     * @return {@link Server#getUnsafe() delegates}
     * @see Server#getUnsafe()
     */
    @Deprecated
    public static UnsafeValues getUnsafe() {
        return server.getUnsafe();
    }
}
