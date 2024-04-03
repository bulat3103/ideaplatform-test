package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL resource = Main.class.getResource("/tickets.json");
        Tickets tickets = mapper.readValue(
                resource,
                Tickets.class);
        Map<String, Long> minFlightTimeForCareer = getMinFlightTimeForCareer(tickets);
        System.out.println("Минимальное время полета между Владивостоком и Тель-Авивом для каждого перевозчика:");
        for (Map.Entry<String, Long> e : minFlightTimeForCareer.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue() + " минут");
        }
        System.out.println("Разницу между средней ценой и медианой для полета между городами Владивосток и Тель-Авив:");
        System.out.println(getMiddlePrice(tickets) - getMedianPrice(tickets));
    }

    private static Map<String, Long> getMinFlightTimeForCareer(Tickets tickets) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
        Map<String, Long> minFlightMap = new HashMap<>();
        for (Ticket ticket : tickets.getTickets()) {
            if (ticket.getOrigin().equals("VVO") && ticket.getDestination().equals("TLV")) {
                LocalDateTime departure = LocalDateTime.parse(ticket.getDepartureDate() + " " + ticket.getDepartureTime(), formatter);
                LocalDateTime arrival = LocalDateTime.parse(ticket.getArrivalDate() + " " + ticket.getArrivalTime(), formatter);
                long diff = ChronoUnit.MINUTES.between(departure.toLocalTime(), arrival.toLocalTime());
                if (minFlightMap.containsKey(ticket.getCarrier())) {
                    long min = Math.min(minFlightMap.get(ticket.getCarrier()), diff);
                    minFlightMap.put(ticket.getCarrier(), min);
                } else {
                    minFlightMap.put(ticket.getCarrier(), diff);
                }
            }
        }
        return minFlightMap;
    }

    private static double getMiddlePrice(Tickets tickets) {
        int price = 0;
        int count = 0;
        for (Ticket ticket : tickets.getTickets()) {
            if (ticket.getOrigin().equals("VVO") && ticket.getDestination().equals("TLV")) {
                price += ticket.getPrice();
                count += 1;
            }
        }
        return 1.0 * price / count;
    }

    private static double getMedianPrice(Tickets tickets) {
        List<Integer> prices = new ArrayList<>();
        for (Ticket ticket : tickets.getTickets()) {
            if (ticket.getOrigin().equals("VVO") && ticket.getDestination().equals("TLV")) {
                prices.add(ticket.getPrice());
            }
        }
        Collections.sort(prices);
        int length = prices.size();
        double median = 0;
        if (length % 2 == 0) {
            median = ((double) prices.get(length / 2) + (double) prices.get((length / 2) - 1)) / 2;
        }
        else {
            median = (double) prices.get(length / 2);
        }
        return median;
    }
}