package co.leantechniques.portfolio;

import java.security.Principal;

public class FakePrincipal implements Principal {
  @Override
  public String getName() {
    return "tgifford@gmail.com";
  }
}
