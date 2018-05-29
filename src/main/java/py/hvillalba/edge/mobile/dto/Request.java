/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.hvillalba.edge.mobile.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hectorvillalba
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Request<T> {
    
    @Getter
    @Setter
    private String type;
    
    @Getter
    @Setter
    private T data;
}
