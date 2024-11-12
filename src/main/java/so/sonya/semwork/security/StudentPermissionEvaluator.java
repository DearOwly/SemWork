package so.sonya.semwork.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@RequiredArgsConstructor
@Component
@Slf4j
public class StudentPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (authentication == null || !(permission instanceof String permissionString)) {
            return false;
        }

        String targetType = targetDomainObject.getClass().getSimpleName();

        log.info("{}", authentication.getAuthorities());

        return authentication
            .getAuthorities()
            .stream()
            .map(GrantedAuthority::getAuthority)
            .anyMatch(authority -> authority.equals("%s:%s".formatted(targetType, permissionString)));
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        if (authentication == null || !(permission instanceof String permissionString)) {
            return false;
        }

        String id;

        if (targetId == null) {
            id = "";
        } else {
            id = "#" + targetId;
        }

        log.info("{}", authentication.getAuthorities());

        return authentication
            .getAuthorities()
            .stream()
            .map(GrantedAuthority::getAuthority)
            .anyMatch(authority -> authority.equals("%s%s:%s".formatted(targetType, id, permissionString)));
    }
}
