package utils;

public class NullChecker {

    public static boolean isNull(Object obj) {
        return obj == null || obj.hashCode() == "".hashCode();
    }

    public static boolean isNull(Object... objects) {
        for (Object obj : objects) {
            if (obj == null || obj.hashCode() == "".hashCode()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNull(Iterable<?> iterable) {
        for (Object obj : iterable) {
            if (obj == null || obj.hashCode() == "".hashCode()) {
                return true;
            }
        }
        return false;
    }
}
