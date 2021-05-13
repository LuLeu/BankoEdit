package de.luleu.bankoedit.sessions;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

public class SessionManager {

    private final Map<UUID, SessionHolder> sessions;

    /**
     * Create a new session manager.
     */
    public SessionManager() {
        this.sessions = new HashMap<>();
    }

    /**
     * Get whether a session exists for the given holder.
     *
     * @param holder the holder
     * @return true if a session exists
     */
    public boolean contains(@NotNull SessionHolder holder) {
        checkNotNull(holder);
        return sessions.containsKey(holder.getPlayer().getUniqueId());
    }

    /**
     * Returns weather a session exists for the given player.
     *
     * @param holder the holder
     * @return true if a session exists
     */
    public boolean contains(@NotNull Player holder) {
        checkNotNull(holder);

        return sessions.containsKey(holder.getUniqueId());
    }

    public SessionHolder add(@NotNull Player player) {
        checkNotNull(player);
        SessionHolder sessionHolder = new SessionHolder(new SessionImpl(player), player);
        this.sessions.put(player.getUniqueId(), sessionHolder);

        return sessionHolder;
    }

    public SessionHolder getIfPresent(@NotNull UUID uuid) {
        checkNotNull(uuid);
        return this.sessions.get(uuid);
    }

    public SessionHolder getIfPresent(@NotNull Player player) {
        checkNotNull(player);
        return this.sessions.get(player.getUniqueId());
    }

    /**
     * Stores the owner of a session, the session, and the last active time.
     */
    public static class SessionHolder {
        private final Session session;
        private final Player player;

        private SessionHolder(Session session, Player player) {
            this.session = session;
            this.player = player;
        }

        public Session getSession() {
            return session;
        }

        public Player getPlayer() {
            return player;
        }
    }
}
