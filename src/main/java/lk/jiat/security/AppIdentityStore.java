package lk.jiat.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import jakarta.security.enterprise.identitystore.IdentityStoreHandler;
import lk.jiat.model.User;
import lk.jiat.service.LoginService;

import java.util.Set;

@ApplicationScoped
public class AppIdentityStore implements IdentityStore {


    @Inject
    private LoginService loginService;

    @Override
    public CredentialValidationResult validate(Credential credential) {
        System.out.println("AppIdentityStore:validate");

        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upc = (UsernamePasswordCredential) credential;


            if (loginService.validate(upc.getCaller(), upc.getPasswordAsString())) {
                Set<String> roles = loginService.getRoles(upc.getCaller());
                return new CredentialValidationResult(upc.getCaller(), roles);
            }


        }

        return CredentialValidationResult.INVALID_RESULT;
    }
}
