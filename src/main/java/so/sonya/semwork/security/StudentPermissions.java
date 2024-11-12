package so.sonya.semwork.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class StudentPermissions {
    public static Set<GrantedAuthority> studentPermissions() {
        return Set.of();
    }

    public static Set<GrantedAuthority> blockLeaderPermissions(Integer block) {
        Set<GrantedAuthority> permissions = new HashSet<>(studentPermissions());

        permissions.add(new SimpleGrantedAuthority("Student:read"));

        int firstRoomInBlock = (block - 1) * 10 + 1;
        int lastRoomInBlock = firstRoomInBlock + 10;

        IntStream
            .range(firstRoomInBlock, lastRoomInBlock)
            .boxed()
            .map(roomId -> new SimpleGrantedAuthority("RoomInspection#%d:write".formatted(roomId)))
            .map(simpleGrantedAuthority -> (GrantedAuthority) simpleGrantedAuthority)
            .forEach(permissions::add);

        return permissions;
    }

    public static Set<GrantedAuthority> councilMemberPermissions() {
        Set<GrantedAuthority> permissions = new HashSet<>(studentPermissions());

        permissions.add(new SimpleGrantedAuthority("Student:read"));
        permissions.add(new SimpleGrantedAuthority("Event:write"));

        return permissions;
    }

    public static Set<GrantedAuthority> councilChairPermissions() {
        Set<GrantedAuthority> permissions = new HashSet<>();

        permissions.addAll(studentPermissions());
        permissions.addAll(blockLeaderPermissions(11));
        permissions.addAll(blockLeaderPermissions(21));
        permissions.addAll(blockLeaderPermissions(22));
        permissions.addAll(blockLeaderPermissions(31));
        permissions.addAll(blockLeaderPermissions(32));
        permissions.addAll(blockLeaderPermissions(41));
        permissions.addAll(blockLeaderPermissions(42));
        permissions.addAll(blockLeaderPermissions(51));
        permissions.addAll(blockLeaderPermissions(52));
        permissions.addAll(councilMemberPermissions());
        permissions.add(new SimpleGrantedAuthority("Student:read"));
        permissions.add(new SimpleGrantedAuthority("Announcement:write"));

        return permissions;
    }
}
