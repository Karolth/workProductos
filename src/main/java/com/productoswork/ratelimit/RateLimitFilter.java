package com.productoswork.ratelimit;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Filtro para limitar el número de peticiones por IP.
 * Sin dependencias externas (Bucket4j no requerido).
 */
@Component
public class RateLimitFilter implements Filter {

    private static final int MAX_REQUESTS = 5;       // Máximo 5 peticiones
    private static final long TIME_WINDOW_MS = 60_000; // Por minuto (60,000 ms)

    private final Map<String, RequestInfo> requests = new ConcurrentHashMap<>();

    private static class RequestInfo {
        long windowStart;
        int count;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String clientIp = req.getRemoteAddr();
        long now = Instant.now().toEpochMilli();

        requests.compute(clientIp, (ip, info) -> {
            if (info == null || now - info.windowStart > TIME_WINDOW_MS) {
                info = new RequestInfo();
                info.windowStart = now;
                info.count = 1;
            } else {
                info.count++;
            }
            return info;
        });

        RequestInfo info = requests.get(clientIp);

        if (info.count > MAX_REQUESTS) {
            res.setStatus(429); // Too Many Requests
            res.getWriter().write("❌ Límite de solicitudes alcanzado. Intenta de nuevo en 1 minuto.");
            return;
        }

        chain.doFilter(request, response);
    }
}