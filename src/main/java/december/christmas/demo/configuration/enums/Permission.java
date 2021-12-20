package december.christmas.demo.configuration.enums;

public enum Permission {
  READ("buyer:read"),
  WRITE("buyer:write");

  private final String permission;

  Permission(String permission) {
    this.permission = permission;
  }

  public String getPermission() {
    return permission;
  }
}
