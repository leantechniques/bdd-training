package co.leantechniques.config;

import co.leantechniques.version.VersionConfig;
import org.junit.Before;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@ActiveProfiles("test")
@WebAppConfiguration
@ContextConfiguration(classes = {ApplicationConfig.class, EmbeddedDataSourceConfig.class, JpaConfig.class, SecurityConfig.class, WebMvcConfig.class, VersionConfig.class})
public abstract class WebAppConfigurationAware {

    @Inject
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    @Before
    public void before() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }
}
