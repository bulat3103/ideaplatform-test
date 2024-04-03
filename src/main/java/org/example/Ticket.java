package org.example;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Ticket {
    @JsonSetter("origin")
    private String origin;
    @JsonSetter("origin_name")
    private String originName;
    @JsonSetter("destination")
    private String destination;
    @JsonSetter("destination_name")
    private String destinationName;
    @JsonSetter("departure_date")
    private String departureDate;
    @JsonSetter("departure_time")
    private String departureTime;
    @JsonSetter("arrival_date")
    private String arrivalDate;
    @JsonSetter("arrival_time")
    private String arrivalTime;
    @JsonSetter("carrier")
    private String carrier;
    @JsonSetter("stops")
    private Integer stops;
    @JsonSetter("price")
    private Integer price;

    public Ticket() {
    }

    public Ticket(String origin, String originName, String destination, String destinationName, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String carrier, Integer stops, Integer price) {
        this.origin = origin;
        this.originName = originName;
        this.destination = destination;
        this.destinationName = destinationName;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.carrier = carrier;
        this.stops = stops;
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public String getOriginName() {
        return originName;
    }

    public String getDestination() {
        return destination;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public Integer getStops() {
        return stops;
    }

    public Integer getPrice() {
        return price;
    }
}
