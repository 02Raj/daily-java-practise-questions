package java14daychallenge.day02.builder;

public final class DatabaseConfig {

    // All fields are final for immutability
    private final String url;
    private final String username;
    private final String password;
    private final int maxConnections;
    private final int timeoutMs;

    // Private constructor: forcing creation through Builder only
    private DatabaseConfig(Builder builder) {
        this.url = builder.url;
        this.username = builder.username;
        this.password = builder.password;
        this.maxConnections = builder.maxConnections;
        this.timeoutMs = builder.timeoutMs;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return "******"; // Masking sensitive credential in logs/getters
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public int getTimeoutMs() {
        return timeoutMs;
    }

    @Override
    public String toString() {
        return "DatabaseConfig{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", maxConnections=" + maxConnections +
                ", timeoutMs=" + timeoutMs +
                '}';
    }

    // Static Nested Class: Can be instantiated without existing DatabaseConfig object!
    public static class Builder {
        // Mandatory fields
        private final String url;
        private final String username;
        private final String password;

        // Optional fields with sensible defaults
        private int maxConnections = 10;
        private int timeoutMs = 5000;

        public Builder(String url, String username, String password) {
            this.url = url;
            this.username = username;
            this.password = password;
        }

        public Builder maxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this; // fluent chaining
        }

        public Builder timeoutMs(int timeoutMs) {
            this.timeoutMs = timeoutMs;
            return this;
        }

        public DatabaseConfig build() {
            // Validation step before object creation (fail-fast)
            if (url == null || url.trim().isEmpty()) {
                throw new IllegalArgumentException("Database URL must not be null or empty");
            }
            if (username == null || username.trim().isEmpty()) {
                throw new IllegalArgumentException("Username must not be null or empty");
            }
            if (maxConnections <= 0) {
                throw new IllegalArgumentException("maxConnections must be greater than zero");
            }
            return new DatabaseConfig(this);
        }
    }
}
