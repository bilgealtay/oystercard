package com.ravensoftware.oystercard.service;

import com.ravensoftware.oystercard.model.Station;
import com.ravensoftware.oystercard.model.TransportType;
import com.ravensoftware.oystercard.model.Zone;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bilga on 08-03-2021
 */
@Service
public class AmountService {

    public BigDecimal calculateFare(Station startPoint, Station endPoint, TransportType transportType){

        if (TransportType.BUS.equals(transportType)){
            return fareForZone(6);
        } else {
            List<Zone> startPointZones = Arrays.asList(startPoint.getValues());
            List<Zone> endPointZones = Arrays.asList(endPoint.getValues());

            // start and end point include zone1
            if (startPointZones.contains(Zone.ONE) && endPointZones.contains(Zone.ONE)){
                return fareForZone(1);
            } else if (startPointZones.containsAll(endPointZones)){
                // start and end point exclude zone1, include same zones
                return fareForZone(2);
            } else if (!startPointZones.contains(Zone.ONE) && !endPointZones.contains(Zone.ONE)
                    && !startPointZones.containsAll(endPointZones)){
                // start and end point exclude zone1, not include same zones
                return fareForZone(4);
            } else if ((startPointZones.contains(Zone.ONE) || endPointZones.contains(Zone.ONE))
                    && !startPointZones.containsAll(endPointZones)){
                // Any two zones including zone 1
                return fareForZone(3);
            }
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal fareForZone(int zone){
        switch (zone){
            // for zone 1
            case 1:
                return BigDecimal.valueOf(2.5);
            // Any one zone outside zone 1
            case 2:
                return BigDecimal.valueOf(2);
            // Any two zones including zone 1
            case 3:
                return BigDecimal.valueOf(3);
            // Any two zones excluding zone 1
            case 4:
                return BigDecimal.valueOf(2.25);
            // Any three zones
            case 5:
                return BigDecimal.valueOf(3.20);
            // for bus
            case 6:
                return BigDecimal.valueOf(1.80);
            default:
                return BigDecimal.ZERO;
        }
    }

}
