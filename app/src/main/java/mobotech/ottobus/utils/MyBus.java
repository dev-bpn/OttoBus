package mobotech.ottobus.utils;

import com.squareup.otto.Bus;

public class MyBus {

    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }

}
