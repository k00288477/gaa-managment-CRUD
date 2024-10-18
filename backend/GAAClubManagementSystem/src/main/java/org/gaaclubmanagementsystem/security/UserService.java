//package org.gaaclubmanagementsystem.security;
//
//import org.gaaclubmanagementsystem.repository.StaffRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService implements UserDetailsService {
//
//    @Autowired
//    private PasswordEncoder encoder;
//
//    @Autowired
//    private StaffRepository staffRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        return (UserDetails) staffRepository.findByEmail(username);
//    }
//
//}
