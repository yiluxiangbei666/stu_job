package test.service.impl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import test.service.userservice;

@Service
public class userserviceimpl implements userservice {
    @Override
    public String getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object myUser = (auth != null) ? auth.getName() : null;
        return (String)myUser;
    }
}
