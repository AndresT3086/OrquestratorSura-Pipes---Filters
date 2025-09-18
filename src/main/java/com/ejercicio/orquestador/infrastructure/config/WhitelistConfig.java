package com.ejercicio.orquestador.infrastructure.config;

import com.ejercicio.orquestador.domain.ports.WhitelistPort;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "app.mail")
class WhitelistProps {
    private List<String> allowedRecipients;
    public List<String> getAllowedRecipients() { return allowedRecipients; }
    public void setAllowedRecipients(List<String> allowedRecipients) { this.allowedRecipients = allowedRecipients; }
}

@Component
public class WhitelistConfig implements WhitelistPort {

    private final WhitelistProps props;
    public WhitelistConfig(WhitelistProps props) { this.props = props; }

    @Override
    public boolean isAllowed(String email) {
        return props.getAllowedRecipients()!=null && props.getAllowedRecipients().stream()
                .anyMatch(e -> e.equalsIgnoreCase(email));
    }
}
