package pe.upc.trackmyroute.iam.infrastructure.hashing.bcrypt.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.upc.trackmyroute.iam.infrastructure.hashing.bcrypt.BCryptHashingService;

@Service
public class HashingServiceImpl implements BCryptHashingService {
    private final BCryptPasswordEncoder passwordEncoder;

    public HashingServiceImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return this.passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public String encode(CharSequence rawPassword) {

        return this.passwordEncoder.encode(rawPassword);
    }
}
