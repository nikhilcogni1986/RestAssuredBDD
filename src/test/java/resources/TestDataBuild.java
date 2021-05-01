package resources;

import Pojo.AddPlace;
import Pojo.location;

import java.util.ArrayList;

public class TestDataBuild
{
    public AddPlace addPlaceData(String name, String address, String language)
    {
        AddPlace AP = new AddPlace();

        AP.setAccuracy(50);
        AP.setAddress(address);
        AP.setLanguage(language);
        AP.setName(name);
        AP.setPhone_number("(+91) 983 893 3937");

        // set types
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Shoe Park");
        myList.add("shop");
        AP.setTypes(myList);

        location l1 = new location();
        l1.setLat(-38.383494);
        l1.setLng(33.427362);
        AP.setLocation(l1);
        return AP;
    }
}
