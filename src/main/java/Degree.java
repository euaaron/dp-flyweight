public enum Degree {
    BOOTCAMP,
    BASIC,
    PROFESSIONAL,
    MEDIUM,
    TECHNICIAN,
    GRADUATION,
    BACHELOR,
    MASTER,
    DOCTORATE;

    public static Degree fromString(String value) throws IllegalArgumentException {
        for (Degree degree : Degree.values()) {
            if (degree.name().equalsIgnoreCase(value)) {
                return degree;
            }
        }
        throw new IllegalArgumentException("Invalid degree: " + value);
    }

    @Override
    public String toString() {
        return this.name().substring(0,1).toUpperCase() + this.name().substring(1).toLowerCase();
    }
}
