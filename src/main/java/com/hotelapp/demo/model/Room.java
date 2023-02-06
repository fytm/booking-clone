package com.hotelapp.demo.model;

import com.hotelapp.demo.enums.RoomStatus;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    @Column(name = "number", nullable = false)
    String number;
    @Column(name = "floor", nullable = false)
    int floor;
    @Column(name = "capacity", nullable = false)
    int capacity;
    @NonNull
    @Column(name = "status", nullable = false)
    RoomStatus status;
    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //    @JsonIgnore
    Hotel hotel;


}
