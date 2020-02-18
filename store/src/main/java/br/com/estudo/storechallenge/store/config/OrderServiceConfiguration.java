package br.com.estudo.storechallenge.store.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class OrderServiceConfiguration {

    @Autowired
    private IClientConfig config;

    @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new PingUrl(); // NoOpPing(), DummyPing()
        // ping the server to get some results, then run rules through the results (ribbonRule)
    }

    @Bean
    public IRule ribbonRule() {
        return new WeightedResponseTimeRule(); // AvailabilityFilteringRule(), BestAvailableRule(), RandomRule(), RetryRule(), RoundRobinRule(), ZoneAvoidanceRule()
        // Measure the response time, select the one with smaller response time.
    }
}
