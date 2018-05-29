/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.hvillalba.edge.mobile.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hectorvillalba
 */
@XmlRootElement
class Addres implements Serializable {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String street;
     
    @Getter
    @Setter
    private String suite;
     
    @Getter
    @Setter
    private String city;
    
    @Getter
    @Setter
    private String zipcode;
    
    @Getter
    @Setter
    private Geo geo;


    
    
}
