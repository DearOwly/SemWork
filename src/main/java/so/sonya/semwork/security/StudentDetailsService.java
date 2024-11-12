package so.sonya.semwork.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import so.sonya.semwork.repository.StudentRepository;

@RequiredArgsConstructor
@Service
public class StudentDetailsService implements UserDetailsService {
    private final StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return studentRepository
            .findByUsername(username)
            .map(StudentDetails::new)
            .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
