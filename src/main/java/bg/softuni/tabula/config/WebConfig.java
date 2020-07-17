package bg.softuni.tabula.config;

import bg.softuni.tabula.stats.StatsInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {

  private StatsInterceptor statsInterceptor;

  public WebConfig(StatsInterceptor statsInterceptor) {
    this.statsInterceptor = statsInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(statsInterceptor);
  }
}
