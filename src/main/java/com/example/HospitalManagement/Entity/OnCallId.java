package com.example.HospitalManagement.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OnCallId implements Serializable {
    private Integer nurse;
    private Integer blockFloor;
    private Integer blockCode;
    private Date onCallStart;
    private Date onCallEnd;
}
