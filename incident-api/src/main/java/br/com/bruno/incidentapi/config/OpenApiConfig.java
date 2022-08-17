package br.com.bruno.incidentapi.config;

import io.micrometer.core.instrument.util.IOUtils;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
public class OpenApiConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("INCIDENT API").description(
                        "INCIDENT QUERY API"));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**/*.html")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
                .resourceChain(false)
                .addResolver(new WebJarsResourceResolver())
                .addResolver(new PathResourceResolver())
                .addTransformer(new IndexPageTransformer());
    }

    public static class IndexPageTransformer implements ResourceTransformer {

        private String overwriteDefaultUrl(String html) {
            return html.replace("https://petstore.swagger.io/v2/swagger.json",
                    "/api/v1/api-docs");
        }

        @Override
        public Resource transform(HttpServletRequest httpServletRequest, Resource resource, ResourceTransformerChain resourceTransformerChain) throws IOException {
            if (resource.getURL().toString().endsWith("/index.html")) {
                String html = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
                html = overwriteDefaultUrl(html);
                return new TransformedResource(resource, html.getBytes());
            } else {
                return resource;
            }
        }
    }
}

