package java14daychallenge.day02.immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutableProfileDemo {

    public static void main(String[] args) {
        List<String> rawRoles = new ArrayList<>();
        rawRoles.add("ROLE_USER");

        TrulyImmutableUser user = new TrulyImmutableUser("divyansh", rawRoles);

        System.out.println("Initial roles: " + user.getRoles());

        rawRoles.add("ROLE_ADMIN");
        System.out.println("After mutating original list: " + user.getRoles());

        try {
            user.getRoles().add("ROLE_SUPERADMIN");
        } catch (UnsupportedOperationException e) {
            System.out.println("Modification via getter blocked: " + e.getClass().getSimpleName());
        }
    }
}

final class TrulyImmutableUser {
    private final String username;
    private final List<String> roles;

    public TrulyImmutableUser(String username, List<String> roles) {
        this.username = username;
        if (roles == null) {
            this.roles = Collections.emptyList();
        } else {
            this.roles = new ArrayList<>(roles);
        }
    }

    public String getUsername() {
        return username;
    }

    public List<String> getRoles() {
        return Collections.unmodifiableList(roles);
    }
}
