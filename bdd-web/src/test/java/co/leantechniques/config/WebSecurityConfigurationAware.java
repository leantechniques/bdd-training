package co.leantechniques.config;

import org.junit.Before;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.web.FilterChainProxy;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

public abstract class WebSecurityConfigurationAware extends WebAppConfigurationAware {

    @Inject
    private FilterChainProxy springSecurityFilterChain;

    @Before
    public void before() {
        this.mockMvc = webAppContextSetup(this.wac)
                .addFilters(this.springSecurityFilterChain).build();
    }

  protected MockHttpSession getAuthenticatedMockSession(String username, String password) throws Exception {
    return (MockHttpSession) mockMvc.perform(post("/j_spring_security_check").param("j_username", username).param("j_password", password))
              .andExpect(status().is(HttpStatus.FOUND.value()))
              .andExpect(redirectedUrl("/"))
              .andReturn()
              .getRequest()
              .getSession();
  }
}
