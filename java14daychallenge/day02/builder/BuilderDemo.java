package java14daychallenge.day02.builder;

public class BuilderDemo {

    public static void main(String[] args) {
        // Fluent creation using static nested builder
        DatabaseConfig config = new DatabaseConfig.Builder(
                "jdbc:postgresql://localhost:5432/orders_db",
                "admin_user",
                "superSecretPass123"
        )
        .maxConnections(50)
        .timeoutMs(8000)
        .build();

        System.out.println("Config created successfully: " + config);

        // Validation test: invalid max connections
        try {
            new DatabaseConfig.Builder("jdbc:mysql://localhost:3306/db", "root", "pass")
                    .maxConnections(-5)
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation caught invalid input: " + e.getMessage());
        }
    }
}
