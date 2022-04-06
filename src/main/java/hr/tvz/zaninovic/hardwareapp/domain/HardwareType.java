package hr.tvz.zaninovic.hardwareapp.domain;

public enum HardwareType {
    CPU("CPU"), GPU("GPU"), MBO("MBO"), RAM("RAM"), STORAGE("STORAGE"), OTHER("OTHER");

    private final String hardwareType;

    HardwareType(String hardwareType) {
        this.hardwareType = hardwareType;
    }

    public String getHardwareType() {
        return hardwareType;
    }
}
