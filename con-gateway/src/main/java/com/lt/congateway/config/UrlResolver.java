package com.lt.congateway.config;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.List;

/**
 * @author tong.luo
 * @description UrlResolver
 * url匹配工具
 * @date 2020/4/19 15:51
 */
public class UrlResolver {
    private final static PathMatcher MATCHER = new AntPathMatcher();

    /**
     * 验证url是否匹配,支持精确匹配和模糊匹配
     *
     * @param patternPaths
     * @param requestPath
     * @return
     */
    public static boolean check(List<String> patternPaths, String requestPath) {
        for (String i : patternPaths) {
            if (i.endsWith("*")) {
                i = i.substring(0, i.length() - 1);
                if (MATCHER.matchStart(requestPath, i)) {
                    return true;
                }
            }
            if (MATCHER.match(i, requestPath)) {
                return true;
            }
        }
        return false;
    }

}
