package com.github.jonvnieu.demo.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

/**
 * Illustrates some of the changes to interfaces.
 */
public class Interfaces {

    /**
     * A functional interface represents an interface with a single method.
     * These interfaces can be replaced by a lambda expression.
     * <p>
     * The annotation is optional.
     * If at some point an extra method is added to an (implicit) functional interface, it will not provide compile
     * errors in the interface class, but any location where a lambda expression was used will fail to compile.
     * If you use the annotation instead, then you will immediately notice the compilation error in the interface.
     */
    @FunctionalInterface
    private interface Equipment {

        /**
         * @return the type of the equipment
         */
        String getEquipmentType();

        /**
         * Interfaces can now have static methods. This can substitute companion classes (e.g. Guavas Lists).
         *
         * @param supplier supplies an equipment
         * @return the equipment that is supplied
         */
        static Equipment create(Supplier<Equipment> supplier) {
            return supplier.get();
        }

        /**
         * Default methods are not required to be implemented by a subclass.
         * <p>
         * <strong>Note: </strong> the intended use of a default method is to provide backwards compatibility
         * for larger libraries, that would otherwise break a lot of implementations (e.g. the introduction of
         * the {@link List#sort(Comparator)} method).
         * It should be avoided when possible, to maintain the interface's separation of implementation.
         *
         * @return true if the equipment already exists, false otherwise
         */
        default boolean isExisting() {
            return false;
        }

        default void print() {
            System.out.println(getEquipmentType() + " (" + isExisting() + ")");
        }
    }

    /**
     * A simple representation of a Closure.
     */
    private static class Closure implements Equipment {
        @Override
        public String getEquipmentType() {
            return "Closure";
        }
        // No need to implement Equipment#isExisting()
    }

    /**
     * A simple representation of an existing manhole.
     */
    private static class ExistingManHole implements Equipment {
        @Override
        public String getEquipmentType() {
            return "ManHole";
        }

        @Override
        public boolean isExisting() {
            return true;
        }
    }

    public static void main(String[] args) {
        List<Equipment> equipmentList = new ArrayList<>(2);
        equipmentList.add(Equipment.create(Closure::new));
        equipmentList.add(Equipment.create(ExistingManHole::new));
        equipmentList.forEach(Equipment::print);
    }
}
