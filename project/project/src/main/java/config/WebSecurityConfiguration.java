package project;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Value("${auth0.apiAudience}")
  private String audience;

  @Value("${auth0.issuer}")
  private String issuer;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    JwtWebSecurityConfigurer.forRS256(audience, issuer).configure(http).csrf()
        .disable().authorizeRequests().antMatchers("/swagger").permitAll().and().authorizeRequests()
        .anyRequest().fullyAuthenticated();
  }}
