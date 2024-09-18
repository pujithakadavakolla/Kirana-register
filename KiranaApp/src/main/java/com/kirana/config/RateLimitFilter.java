package com.kirana.config;

import com.github.bucket4j.Bucket;
import com.github.bucket4j.Bucket4j;
import com.github.bucket4j.ConsumptionProbe;
import com.github.bucket4j.TimeMeter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RateLimitFilter extends OncePerRequestFilter {
    private final Bucket bucket;

    public RateLimitFilter() {
        this.bucket = Bucket4j.builder()
                .addLimit(Bucket4j.builder()
                        .setKeyResolver((key) -> "transaction_api")
                        .setCapacity(10) // Limit
                        .setDuration(Duration.ofMinutes(1))
                        .setRefillInterval(Duration.ofMinutes(1))
                        .setRefillTokens(10) // Refill rate
                        .build())
                .build();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ConsumptionProbe probe = bucket.tryConsume(1);
        if (probe.isConsumed()) {
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(429); // Too Many Requests
        }
    }
}
