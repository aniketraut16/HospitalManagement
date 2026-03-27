package com.example.HospitalManagement.Entity;
import jakarta.persistence.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "On_Call")
@IdClass(OnCallId.class)
public class OnCall {

    @Id
    @Column(name = "Nurse")
    private Integer nurse;

    @Id
    @Column(name = "BlockFloor")
    private Integer blockFloor;

    @Id
    @Column(name = "BlockCode")
    private Integer blockCode;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OnCallStart")
    private Date onCallStart;

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OnCallEnd")
    private Date onCallEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Nurse", referencedColumnName = "EmployeeID", insertable = false, updatable = false)
    private Nurse nurseEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "BlockFloor", referencedColumnName = "BlockFloor", insertable = false, updatable = false),
            @JoinColumn(name = "BlockCode", referencedColumnName = "BlockCode", insertable = false, updatable = false)
    })
    private Block block;
}

