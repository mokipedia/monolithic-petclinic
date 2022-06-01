package org.springframework.samples.petclinic.revenue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.revenues.RevenueService;
import org.springframework.samples.petclinic.revenues.YearlyRevenue;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RevenueServiceTests {
    @Autowired
    RevenueService service;

    @Test
    void shouldListYearlyRevenue() {
        List<YearlyRevenue> yearlyRevenues = service.listYearlyRevenue();

        assertThat(yearlyRevenues).hasSize(1);
        assertThat(yearlyRevenues.get(0).getTotal()).isEqualTo(800L);
    }
}
