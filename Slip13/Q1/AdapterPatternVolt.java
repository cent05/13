class Volt {
    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }
}

// Socket class producing constant volts of 120V
class Socket {
    public Volt getVolts() {
        return new Volt(120);
    }
}

// Adapter interface
interface MobileChargerAdapter {
    Volt get3Volts();
    Volt get12Volts();
    Volt getDefaultVolts();
}

// Class Adapter implementing the Adapter interface
class MobileChargerClassAdapter extends Socket implements MobileChargerAdapter {
    @Override
    public Volt get3Volts() {
        Volt volts = getVolts();
        return convertVolts(volts, 3);
    }

    @Override
    public Volt get12Volts() {
        Volt volts = getVolts();
        return convertVolts(volts, 12);
    }

    @Override
    public Volt getDefaultVolts() {
        return getVolts();
    }

    private Volt convertVolts(Volt volts, int targetVolts) {
        int convertedVolts = volts.getVolts() / (120 / targetVolts);
        return new Volt(convertedVolts);
    }
}

// Main class to test the Adapter pattern
public class AdapterPatternVolt {
    public static void main(String[] args) {
        MobileChargerAdapter adapter = new MobileChargerClassAdapter();

        Volt volts3 = adapter.get3Volts();
        System.out.println("3 Volts: " + volts3.getVolts());

        Volt volts12 = adapter.get12Volts();
        System.out.println("12 Volts: " + volts12.getVolts());

        Volt defaultVolts = adapter.getDefaultVolts();
        System.out.println("Default Volts: " + defaultVolts.getVolts());
    }
}