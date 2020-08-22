package org.monan.h3;

import com.uber.h3core.H3Core;

import java.io.IOException;

public class H3 {

    public static void main(String[] args) throws IOException {
        H3Core h3 = H3Core.newInstance();

        double lat = 37.775938728915946;
        double lng = -122.41795063018799;
        int res = 9;

        String hexAddr = h3.geoToH3Address(lat, lng, res);
        Long h3no = h3.geoToH3(lat,lng,res) ;

        //8928308280fffff
        System.out.println(hexAddr) ;

        //617700169958293503
        System.out.println(h3no) ;

    }
}
