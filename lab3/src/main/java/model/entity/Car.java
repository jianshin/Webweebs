/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Spondon
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {
    @Id private String license;
    private String name;
    @OneToOne private ParkingSpace parkingSpace;
    
}
