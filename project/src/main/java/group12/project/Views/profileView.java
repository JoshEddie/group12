package group12.project.Views;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.*;

//for when we connect database
//@Document(collection = "sales")
@Data
//re-impliment and remove constructor when we add database
//@AllArgsConstructor
//@NoArgsConstructor
public class profileView {
    //@Id
    public profileView(){}
    
    public profileView(
    String id,
    String fullName,
    String address1,
    String address2,
    String city,
    String state,
    String zipcode)
    {
        this.id = id;
        this.fullName = fullName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    private String id;
    private String fullName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
}
