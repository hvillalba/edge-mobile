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
public class User implements Serializable {


    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;
    
    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String email;
    
    @Getter
    @Setter
    private Addres addres;
    
    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private String website;   
    @Getter
    @Setter
    private Company company;
    
    
}
