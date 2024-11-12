package so.sonya.semwork.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import so.sonya.semwork.entity.Student;

import java.util.Collection;
import java.util.UUID;

import static so.sonya.semwork.security.StudentPermissions.*;

@RequiredArgsConstructor
public class StudentDetails implements UserDetails {
    private final Student student;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return switch (student.getType()) {
            case STUDENT -> studentPermissions();
            case BLOCK_11_LEADER -> blockLeaderPermissions(11);
            case BLOCK_21_LEADER -> blockLeaderPermissions(21);
            case BLOCK_22_LEADER -> blockLeaderPermissions(22);
            case BLOCK_31_LEADER -> blockLeaderPermissions(31);
            case BLOCK_32_LEADER -> blockLeaderPermissions(32);
            case BLOCK_41_LEADER -> blockLeaderPermissions(41);
            case BLOCK_42_LEADER -> blockLeaderPermissions(42);
            case BLOCK_51_LEADER -> blockLeaderPermissions(51);
            case BLOCK_52_LEADER -> blockLeaderPermissions(52);
            case COUNCIL_MEMBER -> councilMemberPermissions();
            case COUNCIL_CHAIR -> councilChairPermissions();
        };
    }

    public UUID getId() {
        return student.getId();
    }

    @Override
    public String getPassword() {
        return student.getPassword();
    }

    @Override
    public String getUsername() {
        return student.getUsername();
    }
}
