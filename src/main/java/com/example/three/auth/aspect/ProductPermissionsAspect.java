package com.example.three.auth.aspect;

import com.example.three.auth.anno.Logical;
import com.example.three.auth.anno.ProductPermissions;
import com.example.three.auth.cache.ProductPermissionsCache;
import com.example.three.exception.UnauthorizedException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.assertj.core.util.Strings;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class ProductPermissionsAspect {

    @Resource
    private ProductPermissionsCache cache;

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Pointcut("@annotation(com.example.three.auth.anno.ProductPermissions)")
    public void productPermissionsCut() {

    }

    @Around("productPermissionsCut() && @annotation(productPermissions)")
    public Object around(ProceedingJoinPoint point, ProductPermissions productPermissions) throws Throwable {

        assertAuthorized(productPermissions);

        return point.proceed();
    }

    public void assertAuthorized(ProductPermissions rpAnnotation) throws UnauthorizedException {

        Date now = new Date();

        String[] perms = rpAnnotation.value();

        if (perms.length == 1) {
            Boolean ver = checkPermission(cache, now, perms[0]);
            if (!ver) {
                throw new UnauthorizedException("Subject does not have permission [" + perms[0] + "]");
            }
        } else if (Logical.AND.equals(rpAnnotation.logical())) {
            Arrays.stream(perms).forEach(x -> {
                if (!checkPermission(cache, now, x)) {
                    throw new UnauthorizedException("Subject does not have permission [" + x + "]");
                }
            });
        } else {
            if (Logical.OR.equals(rpAnnotation.logical())) {
                boolean hasAtLeastOnePermission = false;
                String[] var6 = perms;
                int var7 = perms.length;

                for (int var8 = 0; var8 < var7; ++var8) {
                    String permission = var6[var8];
                    if (checkPermission(cache, now, permission)) {
                        hasAtLeastOnePermission = true;
                    }
                }

                if (!hasAtLeastOnePermission) {
                    throw new UnauthorizedException("Subject does not have permission [" + perms.toString() + "]");
                }
            }
        }
    }

    public boolean checkPermission(ProductPermissionsCache cache, Date time, String permission) {
        String timeStr = cache.get(permission);

        if (Strings.isNullOrEmpty(timeStr)) {
            return false;
        }

        Date endTime = null;
        try {
            endTime = format.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (endTime.compareTo(time) >= 0) {
            return true;
        } else {
            return false;
        }
    }

}
