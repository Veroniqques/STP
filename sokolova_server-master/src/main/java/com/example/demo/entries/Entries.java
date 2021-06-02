package com.example.demo.entries;

import com.example.demo.clients.Clients;
import com.example.demo.employees.Employees;
import com.example.demo.services.Services;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Entries {

    @Id
    @GeneratedValue
    private long id;

    private LocalDate date;
    private LocalTime time;
    private boolean confirmed;

    @ManyToOne
    @JoinColumn(name = "employees_id", referencedColumnName = "id")
    private Employees employee;

    @ManyToOne
    @JoinColumn(name = "clients_id", referencedColumnName = "id")
    private Clients client;

    @ManyToOne
    @JoinColumn(name = "services_id", referencedColumnName = "id")
    private Services service;

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Nullable
    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(@Nullable Employees employee) {
        this.employee = employee;
    }

    @Nullable
    public Clients getClient() {
        return client;
    }

    public void setClient(@Nullable Clients client) {
        this.client = client;
    }

    @Nullable
    public Services getService() {
        return service;
    }

    public void setService(@Nullable Services service) {
        this.service = service;
    }
}
