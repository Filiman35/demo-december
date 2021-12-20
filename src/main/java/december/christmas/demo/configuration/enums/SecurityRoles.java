package december.christmas.demo.configuration.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum SecurityRoles {

  ADMIN(Set.of(Permission.WRITE, Permission.READ)),
  MANAGER(Set.of(Permission.READ)),
  USER(Set.of(Permission.READ));

  private final Set<Permission> permissions;

  SecurityRoles(Set<Permission> permissions) {
    this.permissions = permissions;
  }

  public Set<Permission> getPermissions() {
    return permissions;
  }

  public Set<SimpleGrantedAuthority> getAuthorities() {
    return getPermissions().stream()
        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
        .collect(Collectors.toSet());
  }
}
