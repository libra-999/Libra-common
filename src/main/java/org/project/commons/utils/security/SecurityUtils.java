package org.project.commons.utils.security;

import java.util.Collection;

import org.project.commons.constant.Constants;
import org.project.commons.exception.user.UserException;
import org.project.commons.utils.string.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.PatternMatchUtils;


public class SecurityUtils {

//    public static Long getUserId() {
//        try {
//            return getLoginUser().getUserId();
//        } catch (Exception e) {
//            throw new UserException("user", HttpStatus.UNAUTHORIZED, "Get user ID exception");
//        }
//    }
//
//    public static Long getDeptId() {
//        try {
//            return getLoginUser().getDeptId();
//        } catch (Exception e) {
//            throw new UserException("user", HttpStatus.UNAUTHORIZED, "Abnormal in obtaining department ID");
//        }
//    }
//
//    public static String getUsername() {
//        try {
//            return getLoginUser().getUsername();
//        } catch (Exception e) {
//            throw new UserException("user", HttpStatus.UNAUTHORIZED, "Abnormal access to user account");
//        }
//    }
//
//    public static LoginUser getLoginUser() {
//        try {
//            return (LoginUser) getAuthentication().getPrincipal();
//        } catch (Exception e) {
//            throw new UserException("user", HttpStatus.UNAUTHORIZED, "Abnormal access to user information");
//        }
//    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }

//    public static boolean hasPermission(String permission) {
//        return hasPermission(getLoginUser().getPermissions(), permission);
//    }

    public static boolean hasPermission(Collection<String> authorities, String permission) {
        return authorities.stream().filter(StringUtils::hasText)
            .anyMatch(x -> Constants.ALL_PERMISSION.equals(x) || PatternMatchUtils.simpleMatch(x, permission));
    }

    public static boolean hasRole(Collection<String> roles, String role) {
        return roles.stream().filter(StringUtils::hasText)
            .anyMatch(x -> Constants.SUPER_ADMIN.equals(x) || PatternMatchUtils.simpleMatch(x, role));
    }

}
