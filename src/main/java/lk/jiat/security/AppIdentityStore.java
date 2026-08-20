package lk.jiat.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import lk.jiat.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ApplicationScoped
public class AppIdentityStore implements IdentityStore {

    private static final Map<String, User> USERS = new HashMap<>();

    static {
        USERS.put("lakshan",new User("lakshan","1234", Set.of("ADMIN","USER")));
        USERS.put("lakshan",new User("amal","1234", Set.of("USER")));
    }

    @Override
    public CredentialValidationResult validate(Credential credential) {
        System.out.println("AppIdentityStore:validate");

        if (credential instanceof UsernamePasswordCredential){
            UsernamePasswordCredential upc = (UsernamePasswordCredential) credential;

            User user = USERS.get(upc.getCaller());

            if (user == null && user.getPassword().equals(upc.getPasswordAsString())){
                return new CredentialValidationResult(upc.getCaller(),user.getRoles());
            }
        }

        return CredentialValidationResult.INVALID_RESULT;
    }
}
