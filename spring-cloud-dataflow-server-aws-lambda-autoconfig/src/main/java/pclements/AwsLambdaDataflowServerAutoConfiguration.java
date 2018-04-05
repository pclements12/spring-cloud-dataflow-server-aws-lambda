package pclements;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cloud.deployer.resource.docker.DockerResourceLoader;
import org.springframework.cloud.deployer.resource.maven.MavenProperties;
import org.springframework.cloud.deployer.resource.maven.MavenResourceLoader;
import org.springframework.cloud.deployer.resource.support.DelegatingResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.ResourceLoader;

@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
public class AwsLambdaDataflowServerAutoConfiguration {

    @Bean
    public DelegatingResourceLoader delegatingResourceLoader(MavenProperties mavenProperties) {
        DockerResourceLoader dockerLoader = new DockerResourceLoader();
        MavenResourceLoader mavenLoader = new MavenResourceLoader(mavenProperties);
        Map<String, ResourceLoader> loaders = new HashMap<>();
        loaders.put("docker", dockerLoader);
        loaders.put("maven", mavenLoader);
        return new DelegatingResourceLoader(loaders);
    }
}