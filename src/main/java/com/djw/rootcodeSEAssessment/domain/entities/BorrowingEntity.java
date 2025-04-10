package com.djw.rootcodeSEAssessment.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "borrowing")
public class BorrowingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID user_id;

    private UUID book_id;

    @Column(nullable = false)
    private LocalDateTime borrowed_at;

    private LocalDateTime returned_at;


    public BorrowingEntity() {
    }

    public BorrowingEntity(UUID id, UUID user_id, UUID book_id, LocalDateTime borrowed_at, LocalDateTime returned_at) {
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.borrowed_at = borrowed_at;
        this.returned_at = returned_at;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public UUID getBook_id() {
        return book_id;
    }

    public void setBook_id(UUID book_id) {
        this.book_id = book_id;
    }

    public LocalDateTime getBorrowed_at() {
        return borrowed_at;
    }

    public void setBorrowed_at(LocalDateTime borrowed_at) {
        this.borrowed_at = borrowed_at;
    }

    public LocalDateTime getReturned_at() {
        return returned_at;
    }

    public void setReturned_at(LocalDateTime returned_at) {
        this.returned_at = returned_at;
    }

    @PreUpdate
    protected void onUpdate(){
        this.borrowed_at = LocalDateTime.now();
    }
}
